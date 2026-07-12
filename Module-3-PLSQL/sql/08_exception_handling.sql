------------------------------------------------------------------------------
-- Topic: Exception Handling
-- Covers: Predefined Exceptions, User-Defined Exceptions, Exception Handling
------------------------------------------------------------------------------

-- THEORY:
-- An "exception" is a runtime error. PL/SQL lets you TRAP and HANDLE errors
-- gracefully in the EXCEPTION section instead of letting the program crash.
--
-- Predefined exceptions (raised automatically by Oracle):
--   ZERO_DIVIDE      - division by zero
--   NO_DATA_FOUND    - a SELECT INTO query returned no rows
--   TOO_MANY_ROWS    - a SELECT INTO query returned more than one row
--   VALUE_ERROR      - conversion/truncation/arithmetic error
--   OTHERS           - catches any exception not explicitly handled above
--
-- User-defined exceptions: declared explicitly and raised manually using RAISE.

SET SERVEROUTPUT ON;

DECLARE
    v_result        NUMBER;
    v_num1          NUMBER := 100;
    v_num2          NUMBER := 0;

    -- User-defined exception
    e_invalid_amount EXCEPTION;
    v_withdraw_amount NUMBER := -500;
BEGIN
    -- 1) Predefined exception: ZERO_DIVIDE
    BEGIN
        v_result := v_num1 / v_num2;
    EXCEPTION
        WHEN ZERO_DIVIDE THEN
            DBMS_OUTPUT.PUT_LINE('Predefined Exception Caught: Cannot divide by zero.');
    END;

    -- 2) User-defined exception
    BEGIN
        IF v_withdraw_amount < 0 THEN
            RAISE e_invalid_amount;
        END IF;
    EXCEPTION
        WHEN e_invalid_amount THEN
            DBMS_OUTPUT.PUT_LINE('User-Defined Exception Caught: Withdrawal amount cannot be negative.');
    END;

    -- 3) Generic OTHERS handler - catches anything unexpected
    BEGIN
        v_result := TO_NUMBER('not_a_number'); -- causes VALUE_ERROR
    EXCEPTION
        WHEN VALUE_ERROR THEN
            DBMS_OUTPUT.PUT_LINE('Predefined Exception Caught: Invalid number conversion.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('OTHERS handler: An unexpected error occurred - ' || SQLERRM);
    END;
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Predefined Exception Caught: Cannot divide by zero.
-- User-Defined Exception Caught: Withdrawal amount cannot be negative.
-- Predefined Exception Caught: Invalid number conversion.
------------------------------------------------------------------------------
