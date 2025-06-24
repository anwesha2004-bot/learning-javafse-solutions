CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
SELECT * FROM Customers;
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 6.5, SYSDATE, SYSDATE + 20);
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 8000, 7.2, SYSDATE, SYSDATE + 45);
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 3, 10000, 5.8, SYSDATE, SYSDATE + 5);
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (4, 4, 12000, 6.0, SYSDATE - 60, SYSDATE - 10);
COMMIT;
SELECT * FROM Loans;
SET SERVEROUTPUT ON;

BEGIN
  FOR loan_rec IN (
    SELECT l.LoanID, l.CustomerID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE l.EndDate <= SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE(' Reminder: ' || loan_rec.Name || 
                         ' (Customer ID: ' || loan_rec.CustomerID || 
                         ') has a loan due on ' || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/
