--Scenario 1
CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER);
    PROCEDURE UpdateCustomer(p_ID NUMBER, p_Name VARCHAR2, p_Balance NUMBER);
    FUNCTION GetBalance(p_ID NUMBER) RETURN NUMBER;
END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(p_ID NUMBER, p_Name VARCHAR2, p_DOB DATE, p_Balance NUMBER) IS
    BEGIN
        INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
        VALUES (p_ID, p_Name, p_DOB, p_Balance, SYSDATE);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Customer already exists.');
    END;

    PROCEDURE UpdateCustomer(p_ID NUMBER, p_Name VARCHAR2, p_Balance NUMBER) IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name, Balance = p_Balance, LastModified = SYSDATE
        WHERE CustomerID = p_ID;
    END;

    FUNCTION GetBalance(p_ID NUMBER) RETURN NUMBER IS
        v_balance NUMBER;
    BEGIN
        SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_ID;
        RETURN v_balance;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN NULL;
    END;

END CustomerManagement;
/
BEGIN
    CustomerManagement.AddCustomer(11, 'Ritika Sharma', TO_DATE('1994-10-22', 'YYYY-MM-DD'), 8500);
    DBMS_OUTPUT.PUT_LINE('Balance: ₹' || CustomerManagement.GetBalance(11));
    CustomerManagement.UpdateCustomer(11, 'Ritika S.', 9000);
    DBMS_OUTPUT.PUT_LINE('Updated Balance: ₹' || CustomerManagement.GetBalance(11));
END;
/

--Scenario 2
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    );

    PROCEDURE UpdateEmployeeDetails(
        p_ID NUMBER,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    );

    FUNCTION GetAnnualSalary(p_ID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS

    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_ID, p_Name, p_Position, p_Salary, p_Department, SYSDATE);
    END;

    PROCEDURE UpdateEmployeeDetails(
        p_ID NUMBER,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2
    ) IS
    BEGIN
        UPDATE Employees
        SET Position = p_Position,
            Salary = p_Salary,
            Department = p_Department
        WHERE EmployeeID = p_ID;
    END;

    FUNCTION GetAnnualSalary(p_ID NUMBER) RETURN NUMBER IS
        v_salary NUMBER;
    BEGIN
        SELECT Salary INTO v_salary
        FROM Employees
        WHERE EmployeeID = p_ID;

        RETURN v_salary * 12;
    END;

END EmployeeManagement;
/
BEGIN
    EmployeeManagement.HireEmployee(200, 'Sourav Dey', 'Analyst', 45000, 'Finance');
    EmployeeManagement.UpdateEmployeeDetails(201, 'Senior Analyst', 55000, 'Finance');
    DBMS_OUTPUT.PUT_LINE('Annual Salary: ₹' || EmployeeManagement.GetAnnualSalary(201));
END;
/

--Scenario 3
CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee(
        p_ID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    );
    -- other procedures/functions
END EmployeeManagement;
BEGIN
    EmployeeManagement.HireEmployee(
        203, 
        'Anirban Ghosh', 
        'Engineer', 
        48000, 
        'Tech', 
        TO_DATE('2022-11-01', 'YYYY-MM-DD')
    );
END;
SHOW ERRORS PACKAGE BODY EmployeeManagement;
BEGIN
    EmployeeManagement.HireEmployee(203, 'Riya Sen', 'HR Executive', 55000, 'HR', TO_DATE('2023-01-10', 'YYYY-MM-DD'));
END;
/
BEGIN
    EmployeeManagement.HireEmployee(203, 'Riya Sen', 'HR Executive', 55000, 'HR', TO_DATE('2023-01-10', 'YYYY-MM-DD'));
END;
/
DROP PACKAGE EmployeeManagement;
CREATE OR REPLACE PACKAGE EmployeeManagement IS
    PROCEDURE HireEmployee(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    );
    
    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID NUMBER,
        p_Salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER;
END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS

    PROCEDURE HireEmployee(
        p_EmployeeID NUMBER,
        p_Name VARCHAR2,
        p_Position VARCHAR2,
        p_Salary NUMBER,
        p_Department VARCHAR2,
        p_HireDate DATE
    ) IS
    BEGIN
        INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
        VALUES (p_EmployeeID, p_Name, p_Position, p_Salary, p_Department, p_HireDate);

        DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_Name);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee ID already exists.');
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('Unexpected error: ' || SQLERRM);
    END HireEmployee;

    PROCEDURE UpdateEmployeeDetails(
        p_EmployeeID NUMBER,
        p_Salary NUMBER
    ) IS
    BEGIN
        UPDATE Employees
        SET Salary = p_Salary
        WHERE EmployeeID = p_EmployeeID;

        IF SQL%ROWCOUNT = 0 THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee not found.');
        ELSE
            DBMS_OUTPUT.PUT_LINE('Employee salary updated.');
        END IF;
    END UpdateEmployeeDetails;

    FUNCTION CalculateAnnualSalary(p_EmployeeID NUMBER) RETURN NUMBER IS
        v_salary Employees.Salary%TYPE;
    BEGIN
        SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_EmployeeID;
        RETURN v_salary * 12;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Error: Employee not found.');
            RETURN 0;
    END CalculateAnnualSalary;

END EmployeeManagement;
/
SET SERVEROUTPUT ON;
BEGIN
    EmployeeManagement.HireEmployee(203, 'Riya Sen', 'HR Executive', 55000, 'HR', TO_DATE('2023-01-10', 'YYYY-MM-DD'));
END;
/
