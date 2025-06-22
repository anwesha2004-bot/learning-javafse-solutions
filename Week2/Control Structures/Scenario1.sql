SELECT * FROM Loans;
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'John Bose', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

COMMIT;
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 10000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 24));  -- Ends 2 years later

COMMIT;
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = cust.InterestRate - 1
    WHERE LoanID = cust.LoanID;

    DBMS_OUTPUT.PUT_LINE('Interest discount applied for: ' || cust.Name || 
                         ' | New Interest Rate: ' || (cust.InterestRate - 1));
  END LOOP;

  COMMIT;
END;
/
SELECT * FROM Loans WHERE CustomerID = 1;
SELECT 
  Name,
  DOB,
  TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) AS Age,
  (SELECT InterestRate FROM Loans WHERE Loans.CustomerID = Customers.CustomerID) AS InterestRate
FROM Customers
WHERE CustomerID = 1;
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (101, 'Subrata Sinha', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

COMMIT;
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (101, 101, 15000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 36));  -- 3 years loan

COMMIT;
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = cust.InterestRate - 1
    WHERE LoanID = cust.LoanID;

    DBMS_OUTPUT.PUT_LINE('Interest discount applied for: ' || cust.Name || 
                         ' | New Interest Rate: ' || (cust.InterestRate - 1));
  END LOOP;

  COMMIT;
END;
/
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (200, 'Subrata Sinha', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');

COMMIT;
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (200, 200, 10000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 24));  -- 2 years

COMMIT;
SELECT * FROM Customers WHERE CustomerID = 200;
SELECT * FROM Loans WHERE CustomerID = 200;
SET SERVEROUTPUT ON;
BEGIN
  FOR cust IN (
    SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = cust.InterestRate - 1
    WHERE LoanID = cust.LoanID;

    DBMS_OUTPUT.PUT_LINE('Interest discount applied for: ' || cust.Name || 
                         ' | New Interest Rate: ' || (cust.InterestRate - 1));
  END LOOP;

  COMMIT;
END;
/
SELECT 
  Name,
  TO_CHAR(DOB, 'DD-MON-YYYY') AS DOB,
  TRUNC(MONTHS_BETWEEN(SYSDATE, DOB)/12) AS Age
FROM Customers
WHERE CustomerID = 200;
SELECT * FROM Customers;
INSERT INTO Customers (
    CustomerID, Name, DOB, Balance, LastModified, IsVIP
)
VALUES (
    101, 'Subrata Sinha', TO_DATE('1950-01-01', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE'
);
INSERT INTO Loans (
    LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate
)
VALUES (
    101, 101, 10000, 6.5, SYSDATE, ADD_MONTHS(SYSDATE, 24)
);
COMMIT;
SELECT 
    c.CustomerID, c.Name, c.DOB,
    TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB)/12) AS Age,
    l.InterestRate
FROM Customers c
JOIN Loans l ON c.CustomerID = l.CustomerID
WHERE c.CustomerID = 101;
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
    WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = cust.InterestRate - 1
    WHERE LoanID = cust.LoanID;

    DBMS_OUTPUT.PUT_LINE(' Interest discount applied for: ' || cust.Name || 
                         ' | New Interest Rate: ' || (cust.InterestRate - 1));
  END LOOP;

  COMMIT;
END;
/




