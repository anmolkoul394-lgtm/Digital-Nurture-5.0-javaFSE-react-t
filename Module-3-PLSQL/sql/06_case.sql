------------------------------------------------------------------------------
-- Topic: CASE Statements
-- Covers: Simple CASE, Searched CASE
------------------------------------------------------------------------------

-- THEORY:
-- CASE is an alternative to long IF-ELSIF ladders, often more readable.
--   Simple CASE   : compares one expression against several possible values.
--   Searched CASE : evaluates a list of boolean conditions (like IF-ELSIF).

SET SERVEROUTPUT ON;

DECLARE
    v_day_number NUMBER := 3;
    v_day_name   VARCHAR2(15);
    v_marks      NUMBER := 85;
    v_grade      VARCHAR2(5);
BEGIN
    -- Simple CASE: matches v_day_number against specific values
    CASE v_day_number
        WHEN 1 THEN v_day_name := 'Monday';
        WHEN 2 THEN v_day_name := 'Tuesday';
        WHEN 3 THEN v_day_name := 'Wednesday';
        WHEN 4 THEN v_day_name := 'Thursday';
        WHEN 5 THEN v_day_name := 'Friday';
        ELSE v_day_name := 'Weekend';
    END CASE;
    DBMS_OUTPUT.PUT_LINE('Day Number ' || v_day_number || ' is: ' || v_day_name);

    -- Searched CASE: evaluates conditions, similar to IF-ELSIF
    CASE
        WHEN v_marks >= 90 THEN v_grade := 'A+';
        WHEN v_marks >= 75 THEN v_grade := 'A';
        WHEN v_marks >= 60 THEN v_grade := 'B';
        ELSE v_grade := 'C';
    END CASE;
    DBMS_OUTPUT.PUT_LINE('Marks ' || v_marks || ' -> Grade: ' || v_grade);
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Day Number 3 is: Wednesday
-- Marks 85 -> Grade: A
------------------------------------------------------------------------------
