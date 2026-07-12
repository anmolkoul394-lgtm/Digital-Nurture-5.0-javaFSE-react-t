------------------------------------------------------------------------------
-- Topic: Variables in PL/SQL
-- Covers: Declaring Variables, Data Types in PL/SQL, Assigning Values to Variables
------------------------------------------------------------------------------

-- THEORY:
-- Variables are declared in the DECLARE section with the syntax:
--     variable_name  datatype [NOT NULL] [:= initial_value];
--
-- Common PL/SQL Data Types:
--   NUMBER          - numeric values (integers or decimals), e.g. NUMBER(6,2)
--   VARCHAR2(n)     - variable-length character string, up to n characters
--   CHAR(n)         - fixed-length character string
--   DATE            - date and time values
--   BOOLEAN         - TRUE, FALSE, or NULL (cannot be selected/printed directly)
--   %TYPE           - anchors a variable's type to a column's type (e.g. employees.salary%TYPE)

SET SERVEROUTPUT ON;

DECLARE
    v_employee_name VARCHAR2(30) := 'Anitha';   -- assigned at declaration
    v_employee_age  NUMBER(3);                  -- declared, assigned below
    v_salary        NUMBER(8,2) := 45000.50;    -- NUMBER(precision, scale)
    v_joining_date  DATE := SYSDATE;            -- current system date
    v_is_active     BOOLEAN := TRUE;            -- boolean cannot be printed directly
BEGIN
    v_employee_age := 27;                       -- assignment using :=

    DBMS_OUTPUT.PUT_LINE('Employee Name : ' || v_employee_name);
    DBMS_OUTPUT.PUT_LINE('Employee Age  : ' || v_employee_age);
    DBMS_OUTPUT.PUT_LINE('Salary        : ' || v_salary);
    DBMS_OUTPUT.PUT_LINE('Joining Date  : ' || TO_CHAR(v_joining_date, 'DD-MON-YYYY'));

    -- To display a BOOLEAN, we must convert it to a string ourselves
    IF v_is_active THEN
        DBMS_OUTPUT.PUT_LINE('Is Active     : TRUE');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Is Active     : FALSE');
    END IF;
END;
/

------------------------------------------------------------------------------
-- Expected Output (joining date will show the actual run date):
-- Employee Name : Anitha
-- Employee Age  : 27
-- Salary        : 45000.5
-- Joining Date  : 11-JUL-2026
-- Is Active     : TRUE
------------------------------------------------------------------------------
