------------------------------------------------------------------------------
-- Topic: Packages
-- Covers: Introduction to Packages, Package Specification, Package Body,
--         Benefits of Using Packages
------------------------------------------------------------------------------

-- THEORY:
-- A PACKAGE is a schema object that GROUPS related procedures, functions,
-- variables, and cursors together into one logical unit.
--
-- A package has TWO parts:
--   1. Package SPECIFICATION (the "interface") - declares WHAT is available
--      to the outside world (public procedures/functions/variables).
--   2. Package BODY (the "implementation") - contains the actual code (HOW).
--      Can also contain PRIVATE helper procedures/functions not visible outside.
--
-- Benefits of Packages:
--   1. Encapsulation - hide implementation details, expose only what's needed.
--   2. Modularity - group related functionality together logically.
--   3. Better performance - the whole package is loaded into memory once.
--   4. Overloading - allows multiple procedures/functions with the same name
--      but different parameters.

SET SERVEROUTPUT ON;

-- 1) Package SPECIFICATION - the public interface
CREATE OR REPLACE PACKAGE employee_pkg IS
    -- Public function: calculate annual salary from a monthly salary
    FUNCTION get_annual_salary(p_monthly_salary NUMBER) RETURN NUMBER;

    -- Public procedure: print a formatted employee summary
    PROCEDURE print_employee_summary(p_name VARCHAR2, p_monthly_salary NUMBER);
END employee_pkg;
/

-- 2) Package BODY - the implementation
CREATE OR REPLACE PACKAGE BODY employee_pkg IS

    -- Private helper function - NOT visible outside this package body
    FUNCTION calculate_tax(p_annual_salary NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN p_annual_salary * 0.05; -- flat 5% tax, just for demo purposes
    END calculate_tax;

    -- Public function implementation
    FUNCTION get_annual_salary(p_monthly_salary NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN p_monthly_salary * 12;
    END get_annual_salary;

    -- Public procedure implementation - uses the private helper function internally
    PROCEDURE print_employee_summary(p_name VARCHAR2, p_monthly_salary NUMBER) IS
        v_annual_salary NUMBER;
        v_tax           NUMBER;
    BEGIN
        v_annual_salary := get_annual_salary(p_monthly_salary);
        v_tax := calculate_tax(v_annual_salary); -- calling the PRIVATE function

        DBMS_OUTPUT.PUT_LINE('Employee: ' || p_name);
        DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || v_annual_salary);
        DBMS_OUTPUT.PUT_LINE('Estimated Tax: ' || v_tax);
    END print_employee_summary;

END employee_pkg;
/

-- Demo block: using the package from outside
BEGIN
    employee_pkg.print_employee_summary('Suresh', 40000);
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Employee: Suresh
-- Annual Salary: 480000
-- Estimated Tax: 24000
------------------------------------------------------------------------------
