# Module 3 – PL/SQL Programming

PL/SQL (Procedural Language/SQL) is Oracle's procedural extension to SQL. It adds
programming constructs — variables, loops, conditionals, exception handling, and reusable
program units (procedures, functions, packages, triggers) — on top of plain SQL.

## 📁 Topics (all scripts are in `sql/`)

| # | Topic | File |
|---|---|---|
| 1 | Introduction to PL/SQL | `sql/01_introduction.sql` |
| 2 | PL/SQL Environment & Block Structure | `sql/02_plsql_environment.sql` |
| 3 | Variables & Basic Syntax | `sql/03_variables.sql` |
| 4 | Operators | `sql/04_operators.sql` |
| 5 | IF-ELSE Statements | `sql/05_if_else.sql` |
| 6 | CASE Statements | `sql/06_case.sql` |
| 7 | Loops (FOR, WHILE, basic LOOP) | `sql/07_loops.sql` |
| 8 | Exception Handling | `sql/08_exception_handling.sql` |
| 9 | Cursors (Implicit & Explicit) | `sql/09_cursors.sql` |
| 10 | Procedures & Functions | `sql/10_procedures_functions.sql` |
| 11 | Packages | `sql/11_packages.sql` |
| 12 | Triggers | `sql/12_triggers.sql` |

## ▶️ How to run

These scripts target **Oracle Database** syntax. Run with SQL*Plus or SQL Developer:

```bash
sqlplus username/password@your_db @sql/01_introduction.sql
```

Each script contains its own comments explaining every step, plus a sample of expected output
(shown as a comment block at the bottom of the file, since actual output depends on your Oracle
environment / `SERVEROUTPUT` setting).

**Tip:** run `SET SERVEROUTPUT ON;` first in your session so `DBMS_OUTPUT.PUT_LINE` messages are visible.

## 📚 References
- https://www.geeksforgeeks.org/plsql-introduction/
- https://www.educba.com/pl-sql-block-structure/
- https://www.tutorialspoint.com/plsql/plsql_basic_syntax.htm
- https://docs.oracle.com/cd/A97630_01/appdev.920/a96624/04_struc.htm
- https://docs.oracle.com/cd/B13789_01/appdev.101/b10807/07_errs.htm
- https://www.tutorialspoint.com/plsql/plsql_cursors.htm
- https://docs.oracle.com/en/database/other-databases/timesten/22.1/plsql-developer/pl-sql-procedures-and-functions.html
- https://docs.oracle.com/en/database/oracle/oracle-database/23/lnpls/plsql-packages.html
- https://docs.oracle.com/en/database/oracle/oracle-database/19/lnpls/plsql-triggers.html
