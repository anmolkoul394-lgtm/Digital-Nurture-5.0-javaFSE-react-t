------------------------------------------------------------------------------
-- Topic: Cursors
-- Covers: Introduction to Cursors, Implicit vs Explicit Cursors,
--         Cursor Operations (OPEN, FETCH, CLOSE)
------------------------------------------------------------------------------

-- THEORY:
-- A CURSOR is a pointer to the private memory area (context area) that Oracle
-- uses to process a SQL statement. Cursors let you process query results ROW BY ROW.
--
-- Implicit Cursor : Oracle creates and manages it automatically for single SQL
--                    statements (INSERT/UPDATE/DELETE/single-row SELECT INTO).
--                    You access its status via attributes like SQL%ROWCOUNT, SQL%FOUND.
--
-- Explicit Cursor  : Declared and controlled manually by the programmer, needed
--                    when a query can return MULTIPLE rows. Lifecycle:
--                    DECLARE -> OPEN -> FETCH (in a loop) -> CLOSE.

SET SERVEROUTPUT ON;

-- Setup: create a small demo table (dropped first if it already exists)
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE cursor_demo_employees';
EXCEPTION
    WHEN OTHERS THEN NULL; -- ignore error if table does not exist yet
END;
/

CREATE TABLE cursor_demo_employees (
    emp_id     NUMBER PRIMARY KEY,
    emp_name   VARCHAR2(30),
    salary     NUMBER(8,2)
);

INSERT INTO cursor_demo_employees VALUES (1, 'Anitha', 45000);
INSERT INTO cursor_demo_employees VALUES (2, 'Ravi', 55000);
INSERT INTO cursor_demo_employees VALUES (3, 'Kiran', 38000);
COMMIT;

-- 1) IMPLICIT CURSOR example - a single UPDATE statement
DECLARE
BEGIN
    UPDATE cursor_demo_employees SET salary = salary + 1000 WHERE emp_id = 1;

    -- SQL%ROWCOUNT is an implicit cursor attribute: how many rows were affected.
    DBMS_OUTPUT.PUT_LINE('Implicit Cursor -> Rows updated: ' || SQL%ROWCOUNT);
END;
/

-- 2) EXPLICIT CURSOR example - process multiple rows one at a time
DECLARE
    -- Declare the cursor with its query
    CURSOR emp_cursor IS
        SELECT emp_name, salary FROM cursor_demo_employees ORDER BY emp_id;

    v_name   cursor_demo_employees.emp_name%TYPE;
    v_salary cursor_demo_employees.salary%TYPE;
BEGIN
    OPEN emp_cursor; -- open the cursor, executes the query

    LOOP
        FETCH emp_cursor INTO v_name, v_salary; -- fetch one row at a time
        EXIT WHEN emp_cursor%NOTFOUND;          -- exit loop when no more rows

        DBMS_OUTPUT.PUT_LINE('Employee: ' || v_name || ', Salary: ' || v_salary);
    END LOOP;

    CLOSE emp_cursor; -- always close the cursor to release resources
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Implicit Cursor -> Rows updated: 1
-- Employee: Anitha, Salary: 46000
-- Employee: Ravi, Salary: 55000
-- Employee: Kiran, Salary: 38000
------------------------------------------------------------------------------
