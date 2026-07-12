------------------------------------------------------------------------------
-- Topic: PL/SQL Environment
-- Covers: Overview of PL/SQL Environment, Block Structure, Anonymous vs Named Blocks
------------------------------------------------------------------------------

-- THEORY:
-- Every PL/SQL program is made up of BLOCKS. A block has (up to) 3 sections:
--
--   DECLARE               -- optional: variables, constants, cursors declared here
--     <declarations>
--   BEGIN                 -- mandatory: executable statements go here
--     <executable statements>
--   EXCEPTION             -- optional: error-handling code goes here
--     <exception handlers>
--   END;                  -- mandatory: marks the end of the block
--
-- Types of blocks:
--   1. Anonymous Block  - has no name, cannot be stored in the database, runs once (this file's example).
--   2. Named Block      - Procedures, Functions, Packages, Triggers - stored in the DB, reusable.

SET SERVEROUTPUT ON;

-- Anonymous block demonstrating all 3 sections.
DECLARE
    v_message VARCHAR2(50); -- declaration section
BEGIN
    v_message := 'This is the executable section';  -- executable section
    DBMS_OUTPUT.PUT_LINE(v_message);

    -- Force a divide-by-zero error to demonstrate the exception section
    DBMS_OUTPUT.PUT_LINE(10 / 0);
EXCEPTION
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('Exception section: cannot divide by zero!');
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- This is the executable section
-- Exception section: cannot divide by zero!
------------------------------------------------------------------------------
