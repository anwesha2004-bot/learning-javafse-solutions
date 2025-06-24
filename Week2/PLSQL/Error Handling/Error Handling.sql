-- Scenario 1
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

COMMIT;

-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) IS
    v_old_salary Employees.Salary%TYPE;
BEGIN
    SELECT Salary INTO v_old_salary
    FROM Employees
    WHERE EmployeeID = p_employee_id
    FOR UPDATE;

    UPDATE Employees
    SET Salary = v_old_salary + (v_old_salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    DBMS_OUTPUT.PUT_LINE(' Salary updated for Employee ID ' || p_employee_id ||
                         ' | Old Salary: ₹' || v_old_salary ||
                         ' | New Salary: ₹' || (v_old_salary + (v_old_salary * p_percentage / 100)));

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(' Error: Employee ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(' Unexpected error: ' || SQLERRM);
END;
/

-- Run test
BEGIN
    UpdateSalary(1, 10);   -- Should succeed
    UpdateSalary(999, 10); -- Should fail
END;
/
SET SERVEROUTPUT ON;

BEGIN
    UpdateSalary(101, 10);   --  Should succeed (10% raise)
    UpdateSalary(102, 10); --  Should show error (ID not found)
END;
/

--Scenario 3
SELECT * FROM Employees;
CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_CustomerID IN NUMBER,
    p_Name IN VARCHAR2,
    p_DOB IN DATE,
    p_Balance IN NUMBER
) IS
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    DBMS_OUTPUT.PUT_LINE(' Customer added successfully: ' || p_Name);
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE(' Error: Customer ID ' || p_CustomerID || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(' Unexpected Error: ' || SQLERRM);
END;
/
BEGIN
    AddNewCustomer(7, 'Priya Sen', TO_DATE('1995-08-14', 'YYYY-MM-DD'), 6000); -- New customer
END;
/





