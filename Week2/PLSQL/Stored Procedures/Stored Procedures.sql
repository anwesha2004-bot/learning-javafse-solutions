--Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    )
    LOOP
        UPDATE Accounts
        SET Balance = Balance + (acc.Balance * 0.01),
            LastModified = SYSDATE
        WHERE AccountID = acc.AccountID;

        DBMS_OUTPUT.PUT_LINE(
            ' Interest applied to Account ID ' || acc.AccountID || 
            ' | New Balance: ₹' || TO_CHAR(acc.Balance + (acc.Balance * 0.01), '99999.99')
        );
    END LOOP;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/

--Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_percent IN NUMBER
) IS
BEGIN
    FOR emp IN (
        SELECT EmployeeID, Name, Salary 
        FROM Employees 
        WHERE Department = dept_name
    )
    LOOP
        DECLARE
            old_salary NUMBER := emp.Salary;
            new_salary NUMBER := emp.Salary + (emp.Salary * bonus_percent / 100);
        BEGIN
            UPDATE Employees
            SET Salary = new_salary
            WHERE EmployeeID = emp.EmployeeID;

            DBMS_OUTPUT.PUT_LINE(
                ' Bonus applied for ' || emp.Name ||
                ' | Old Salary: ₹' || old_salary || 
                ' | New Salary: ₹' || new_salary
            );
        END;
    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(' Error: ' || SQLERRM);
END;
/
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (201, 'Ritika Das', 'Analyst', 50000, 'Finance', TO_DATE('2020-03-01', 'YYYY-MM-DD'));
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (202, 'Aditya Banerjee', 'Manager', 70000, 'Finance', TO_DATE('2019-06-15', 'YYYY-MM-DD'));
BEGIN
    UpdateEmployeeBonus('Finance', 10);
END;
/

--Scenario 3
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2001, 1, 'Savings', 5000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2002, 2, 'Savings', 3000, SYSDATE);
COMMIT;
CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAccountID IN NUMBER,
    toAccountID IN NUMBER,
    amount IN NUMBER
) AS
    fromBalance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO fromBalance
    FROM Accounts
    WHERE AccountID = fromAccountID;

    IF fromBalance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, ' Insufficient balance in source account.');
    END IF;

    -- Deduct from source
    UPDATE Accounts
    SET Balance = Balance - amount,
        LastModified = SYSDATE
    WHERE AccountID = fromAccountID;

    -- Add to destination
    UPDATE Accounts
    SET Balance = Balance + amount,
        LastModified = SYSDATE
    WHERE AccountID = toAccountID;

    DBMS_OUTPUT.PUT_LINE(' ₹' || amount || ' transferred from Account ' || fromAccountID || ' to Account ' || toAccountID);

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(' Transfer failed: ' || SQLERRM);
        ROLLBACK;
END;
/
BEGIN
    TransferFunds(2001, 2002, 1000);  -- Should work
    TransferFunds(2001, 2002, 10000); -- Should fail due to insufficient funds
END;
/
