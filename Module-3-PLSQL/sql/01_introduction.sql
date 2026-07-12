------------------------------------------------------------------------------
-- Topic: Introduction to PL/SQL
-- Covers: What is PL/SQL?, Importance of PL/SQL, Differences between SQL and PL/SQL
------------------------------------------------------------------------------

-- THEORY (as comments):
-- PL/SQL (Procedural Language/SQL) is Oracle's procedural extension to standard SQL.
-- SQL is a purely declarative language: you say WHAT data you want, not HOW to get it.
-- PL/SQL adds procedural constructs (variables, loops, conditions, exception handling)
-- on top of SQL, so you can write complete programs, not just single queries.
--
-- Differences between SQL and PL/SQL:
--   SQL                                | PL/SQL
--   ------------------------------------|--------------------------------------
--   Declarative (what to do)            | Procedural (how to do it)
--   Executes one statement at a time    | Executes a whole BLOCK of statements
--   Cannot use loops/conditions          | Supports loops, IF-ELSE, CASE, etc.
--   Cannot handle errors programmatically| Has structured EXCEPTION handling
--
-- Importance of PL/SQL:
--   1. Combines the power of SQL with procedural logic.
--   2. Runs INSIDE the Oracle engine -> less network round trips, faster.
--   3. Supports reusable units: procedures, functions, packages, triggers.

SET SERVEROUTPUT ON;

-- A minimal PL/SQL "anonymous block" (no name, runs once).
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello from PL/SQL!');
    DBMS_OUTPUT.PUT_LINE('PL/SQL = Procedural Language extensions to SQL');
END;
/

------------------------------------------------------------------------------
-- Expected Output:
-- Hello from PL/SQL!
-- PL/SQL = Procedural Language extensions to SQL
------------------------------------------------------------------------------
