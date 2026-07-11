INSERT INTO departments (name, location) VALUES ('Engineering', 'Bangalore');
INSERT INTO departments (name, location) VALUES ('IT', 'Jammu');
INSERT INTO departments (name, location) VALUES ('HR', 'Delhi');

INSERT INTO employees (name, email, salary, designation, department_id, created_date, last_modified_date, created_by, last_modified_by)
VALUES ('Anmol Koul', 'anmol@example.com', 65000, 'Software Engineer', 2, NOW(), NOW(), 'system-demo-user', 'system-demo-user');

INSERT INTO employees (name, email, salary, designation, department_id, created_date, last_modified_date, created_by, last_modified_by)
VALUES ('Riya Sharma', 'riya@example.com', 72000, 'Senior Developer', 1, NOW(), NOW(), 'system-demo-user', 'system-demo-user');

INSERT INTO employees (name, email, salary, designation, department_id, created_date, last_modified_date, created_by, last_modified_by)
VALUES ('Karan Mehta', 'karan@example.com', 48000, 'HR Executive', 3, NOW(), NOW(), 'system-demo-user', 'system-demo-user');
