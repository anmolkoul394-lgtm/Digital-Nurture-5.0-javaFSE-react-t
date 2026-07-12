------------------------------------------------------------------------------
-- Topic: Triggers
-- Covers: Introduction to Triggers, Types of Triggers (BEFORE, AFTER, INSTEAD OF),
--         Creating and Managing Triggers
------------------------------------------------------------------------------

-- THEORY:
-- A TRIGGER is a stored PL/SQL block that runs AUTOMATICALLY ("fires") in
-- response to a specific event on a table or view (INSERT, UPDATE, DELETE).
--
-- Types of Triggers (by TIMING):
--   BEFORE       - fires before the triggering DML statement executes
--                  (commonly used for validation or auto-populating columns).
--   AFTER        - fires after the triggering DML statement executes
--                  (commonly used for auditing/logging).
--   INSTEAD OF   - used on VIEWS; replaces the DML action entirely
--                  (needed when a view isn't directly updatable).
--
-- Triggers can also fire at ROW level (FOR EACH ROW) or STATEMENT level.

SET SERVEROUTPUT ON;

-- Setup: demo table + an audit log table
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE trigger_demo_employees';
EXCEPTION WHEN OTHERS THEN NULL; END;
/
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE trigger_demo_audit_log';
EXCEPTION WHEN OTHERS THEN NULL; END;
/

CREATE TABLE trigger_demo_employees (
    emp_id    NUMBER PRIMARY KEY,
    emp_name  VARCHAR2(30),
    salary    NUMBER(8,2)
);

CREATE TABLE trigger_demo_audit_log (
    log_id      NUMBER GENERATED ALWAYS AS IDENTITY,
    action_type VARCHAR2(10),
    emp_id      NUMBER,
    old_salary  NUMBER,
    new_salary  NUMBER,
    log_time    DATE
);

-- 1) BEFORE INSERT trigger - validates data before it is inserted
CREATE OR REPLACE TRIGGER trg_before_insert_employee
BEFORE INSERT ON trigger_demo_employees
FOR EACH ROW
BEGIN
    IF :NEW.salary < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Salary cannot be negative');
    END IF;
END;
/

-- 2) AFTER UPDATE trigger - logs every salary change into the audit table
CREATE OR REPLACE TRIGGER trg_after_update_salary
AFTER UPDATE OF salary ON trigger_demo_employees
FOR EACH ROW
BEGIN
    INSERT INTO trigger_demo_audit_log(action_type, emp_id, old_salary, new_salary, log_time)
    VALUES ('UPDATE', :OLD.emp_id, :OLD.salary, :NEW.salary, SYSDATE);
END;
/

-- Demo: insert a row (fires BEFORE INSERT trigger), then update it (fires AFTER UPDATE trigger)
INSERT INTO trigger_demo_employees VALUES (1, 'Meena', 40000);
COMMIT;

UPDATE trigger_demo_employees SET salary = 45000 WHERE emp_id = 1;
COMMIT;

-- Check what the AFTER UPDATE trigger logged
SET SERVEROUTPUT ON;
DECLARE
    v_old_salary NUMBER;
    v_new_salary NUMBER;
BEGIN
    SELECT old_salary, new_salary INTO v_old_salary, v_new_salary
    FROM trigger_demo_audit_log
    WHERE emp_id = 1 AND ROWNUM = 1;

    DBMS_OUTPUT.PUT_LINE('Audit Log -> Old Salary: ' || v_old_salary || ', New Salary: ' || v_new_salary);
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Audit Log -> Old Salary: 40000, New Salary: 45000
--
-- If you try: INSERT INTO trigger_demo_employees VALUES (2, 'Test', -500);
-- the BEFORE INSERT trigger raises:
-- ORA-20001: Salary cannot be negative
------------------------------------------------------------------------------
