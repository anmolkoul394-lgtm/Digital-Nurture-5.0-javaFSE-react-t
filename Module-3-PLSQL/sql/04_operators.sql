------------------------------------------------------------------------------
-- Topic: Operators in PL/SQL
-- Covers: Arithmetic, Relational, Logical, and Concatenation operators
------------------------------------------------------------------------------

-- THEORY:
-- PL/SQL supports the following operator categories:
--   Arithmetic : +  -  *  /
--   Relational : =  !=  <>  <  >  <=  >=
--   Logical    : AND  OR  NOT
--   Concatenation: ||  (joins strings together)

SET SERVEROUTPUT ON;

DECLARE
    v_a NUMBER := 15;
    v_b NUMBER := 4;
BEGIN
    -- Arithmetic operators
    DBMS_OUTPUT.PUT_LINE('Addition       : ' || (v_a + v_b));
    DBMS_OUTPUT.PUT_LINE('Subtraction    : ' || (v_a - v_b));
    DBMS_OUTPUT.PUT_LINE('Multiplication : ' || (v_a * v_b));
    DBMS_OUTPUT.PUT_LINE('Division       : ' || (v_a / v_b));
    DBMS_OUTPUT.PUT_LINE('Modulus        : ' || MOD(v_a, v_b)); -- PL/SQL uses MOD() function, not %

    -- Relational operators
    DBMS_OUTPUT.PUT_LINE('Is A > B?      : ' || CASE WHEN v_a > v_b THEN 'TRUE' ELSE 'FALSE' END);
    DBMS_OUTPUT.PUT_LINE('Is A = B?      : ' || CASE WHEN v_a = v_b THEN 'TRUE' ELSE 'FALSE' END);

    -- Logical operators
    IF v_a > 10 AND v_b < 10 THEN
        DBMS_OUTPUT.PUT_LINE('Logical AND    : Both conditions are TRUE');
    END IF;

    IF v_a > 100 OR v_b < 10 THEN
        DBMS_OUTPUT.PUT_LINE('Logical OR     : At least one condition is TRUE');
    END IF;

    -- Concatenation operator
    DBMS_OUTPUT.PUT_LINE('Concatenation  : ' || 'Value of A is ' || v_a);
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Addition       : 19
-- Subtraction    : 11
-- Multiplication : 60
-- Division       : 3.75
-- Modulus        : 3
-- Is A > B?      : TRUE
-- Is A = B?      : FALSE
-- Logical AND    : Both conditions are TRUE
-- Logical OR     : At least one condition is TRUE
-- Concatenation  : Value of A is 15
------------------------------------------------------------------------------
