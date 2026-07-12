------------------------------------------------------------------------------
-- Topic: Loops in PL/SQL
-- Covers: Basic LOOP, WHILE loop, FOR loop
------------------------------------------------------------------------------

-- THEORY:
-- Basic LOOP : repeats forever until an explicit EXIT (or EXIT WHEN) is hit.
-- WHILE LOOP : repeats WHILE a condition remains TRUE (checked BEFORE each iteration).
-- FOR LOOP   : repeats a fixed number of times over a range (loop counter is automatic).

SET SERVEROUTPUT ON;

DECLARE
    v_counter NUMBER := 1;
BEGIN
    -- 1) Basic LOOP with EXIT WHEN
    DBMS_OUTPUT.PUT_LINE('--- Basic LOOP (prints 1 to 3) ---');
    LOOP
        DBMS_OUTPUT.PUT_LINE('Counter = ' || v_counter);
        v_counter := v_counter + 1;
        EXIT WHEN v_counter > 3;
    END LOOP;

    -- 2) WHILE loop
    DBMS_OUTPUT.PUT_LINE('--- WHILE loop (prints 1 to 3) ---');
    v_counter := 1;
    WHILE v_counter <= 3 LOOP
        DBMS_OUTPUT.PUT_LINE('Counter = ' || v_counter);
        v_counter := v_counter + 1;
    END LOOP;

    -- 3) FOR loop
    DBMS_OUTPUT.PUT_LINE('--- FOR loop (prints 1 to 3) ---');
    FOR i IN 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE('Counter = ' || i);
    END LOOP;

    -- 4) FOR loop in REVERSE
    DBMS_OUTPUT.PUT_LINE('--- FOR loop REVERSE (prints 3 to 1) ---');
    FOR i IN REVERSE 1..3 LOOP
        DBMS_OUTPUT.PUT_LINE('Counter = ' || i);
    END LOOP;
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- --- Basic LOOP (prints 1 to 3) ---
-- Counter = 1
-- Counter = 2
-- Counter = 3
-- --- WHILE loop (prints 1 to 3) ---
-- Counter = 1
-- Counter = 2
-- Counter = 3
-- --- FOR loop (prints 1 to 3) ---
-- Counter = 1
-- Counter = 2
-- Counter = 3
-- --- FOR loop REVERSE (prints 3 to 1) ---
-- Counter = 3
-- Counter = 2
-- Counter = 1
------------------------------------------------------------------------------
