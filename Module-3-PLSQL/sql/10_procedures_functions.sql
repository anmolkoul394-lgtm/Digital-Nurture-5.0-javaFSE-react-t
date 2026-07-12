------------------------------------------------------------------------------
-- Topic: Procedures and Functions
-- Covers: Creating Stored Procedures, Creating Functions,
--         Parameters (IN, OUT, IN OUT), Differences between Procedures and Functions
------------------------------------------------------------------------------

-- THEORY:
-- PROCEDURE : a named PL/SQL block that PERFORMS AN ACTION. Does not have to return a value.
-- FUNCTION  : a named PL/SQL block that MUST RETURN exactly one value (via RETURN).
--
-- Parameter modes:
--   IN     - (default) passes a value INTO the procedure/function (read-only inside).
--   OUT    - passes a value OUT of the procedure back to the caller.
--   IN OUT - passes a value in, and allows the procedure to modify and return it.
--
-- Differences:
--   Procedure                          | Function
--   ------------------------------------|-------------------------------------
--   May or may not return a value       | Must return exactly one value
--   Called as a standalone statement    | Called as part of an expression
--   Can have OUT / IN OUT parameters    | Typically only IN parameters (by convention)

SET SERVEROUTPUT ON;

-- 1) PROCEDURE with IN and OUT parameters
CREATE OR REPLACE PROCEDURE calculate_bonus (
    p_salary   IN  NUMBER,   -- input: current salary
    p_bonus    OUT NUMBER    -- output: calculated bonus
) IS
BEGIN
    p_bonus := p_salary * 0.10; -- 10% bonus
END;
/

-- 2) FUNCTION that returns a single value
CREATE OR REPLACE FUNCTION get_grade (
    p_marks IN NUMBER
) RETURN VARCHAR2 IS
    v_grade VARCHAR2(5);
BEGIN
    IF p_marks >= 90 THEN
        v_grade := 'A+';
    ELSIF p_marks >= 75 THEN
        v_grade := 'A';
    ELSIF p_marks >= 60 THEN
        v_grade := 'B';
    ELSE
        v_grade := 'C';
    END IF;
    RETURN v_grade;
END;
/

-- 3) PROCEDURE demonstrating IN OUT parameter
CREATE OR REPLACE PROCEDURE double_value (
    p_value IN OUT NUMBER
) IS
BEGIN
    p_value := p_value * 2;
END;
/

-- Demo block: calling the procedures and function above
DECLARE
    v_bonus  NUMBER;
    v_grade  VARCHAR2(5);
    v_number NUMBER := 25;
BEGIN
    -- Call the procedure; bonus is returned via the OUT parameter
    calculate_bonus(50000, v_bonus);
    DBMS_OUTPUT.PUT_LINE('Bonus for salary 50000: ' || v_bonus);

    -- Call the function directly inside an expression
    v_grade := get_grade(82);
    DBMS_OUTPUT.PUT_LINE('Grade for marks 82: ' || v_grade);

    -- Call the IN OUT procedure - v_number is modified in place
    DBMS_OUTPUT.PUT_LINE('Before doubling: ' || v_number);
    double_value(v_number);
    DBMS_OUTPUT.PUT_LINE('After doubling: ' || v_number);
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Bonus for salary 50000: 5000
-- Grade for marks 82: A
-- Before doubling: 25
-- After doubling: 50
------------------------------------------------------------------------------
