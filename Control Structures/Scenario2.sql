CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP VARCHAR2(10)
);
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (1, 'Subrata Sinha', TO_DATE('1949-01-10', 'YYYY-MM-DD'), 8000, SYSDATE, 'FALSE');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (2, 'Priya Das', TO_DATE('1995-03-10', 'YYYY-MM-DD'), 9500, SYSDATE, 'FALSE');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (3, 'Rajan Roy', TO_DATE('1980-11-22', 'YYYY-MM-DD'), 15000, SYSDATE, 'FALSE');
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified, IsVIP)
VALUES (4, 'Sneha Paul', TO_DATE('1989-07-05', 'YYYY-MM-DD'), 18000, SYSDATE, 'FALSE');
COMMIT;
SELECT * FROM Customers;
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT CustomerID, Name, Balance
    FROM Customers
    WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE'
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE(' Promoted to VIP: ' || cust.Name || 
                         ' | Balance: $' || cust.Balance);
  END LOOP;

  COMMIT;
END;
/
SELECT Name, Balance, IsVIP FROM Customers;
SET SERVEROUTPUT ON;

BEGIN
  FOR cust IN (
    SELECT CustomerID, Name, Balance
    FROM Customers
    WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'TRUE'
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE(' Promoted to VIP: ' || cust.Name || 
                         ' | Balance: $' || cust.Balance);
  END LOOP;

  COMMIT;
END;
/
SELECT Name, Balance, IsVIP FROM Customers;
