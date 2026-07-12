------------------------------------------------------------------------------
-- Topic: IF-ELSE Statements
-- Covers: IF-THEN, IF-THEN-ELSE, IF-THEN-ELSIF ladder
------------------------------------------------------------------------------

-- THEORY:
-- IF-THEN            : runs a block only if the condition is TRUE.
-- IF-THEN-ELSE        : runs one block if TRUE, another if FALSE.
-- IF-THEN-ELSIF       : checks multiple conditions in order, like a ladder.

SET SERVEROUTPUT ON;

DECLARE
    v_marks NUMBER := 72;
    v_grade VARCHAR2(10);
BEGIN
    -- IF-THEN-ELSIF ladder to assign a grade based on marks
    IF v_marks >= 90 THEN
        v_grade := 'A+';
    ELSIF v_marks >= 75 THEN
        v_grade := 'A';
    ELSIF v_marks >= 60 THEN
        v_grade := 'B';
    ELSIF v_marks >= 40 THEN
        v_grade := 'C';
    ELSE
        v_grade := 'FAIL';
    END IF;

    DBMS_OUTPUT.PUT_LINE('Marks: ' || v_marks);
    DBMS_OUTPUT.PUT_LINE('Grade: ' || v_grade);

    -- Simple IF-THEN (no else)
    IF v_marks >= 40 THEN
        DBMS_OUTPUT.PUT_LINE('Result: PASS');
    END IF;
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Marks: 72
-- Grade: B
-- Result: PASS
------------------------------------------------------------------------------
