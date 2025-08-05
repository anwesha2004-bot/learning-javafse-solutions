--Scenario 1
SET SERVEROUTPUT ON;
CREATE OR REPLACE FUNCTION CalculateAge (
    p_dob IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('Age is: ' || CalculateAge(TO_DATE('1998-07-15', 'YYYY-MM-DD')));
END;
/


--Scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_interest_rate IN NUMBER,
    p_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_interest NUMBER;
    v_months NUMBER;
    v_emi NUMBER;
BEGIN
    v_monthly_interest := p_annual_interest_rate / (12 * 100);
    v_months := p_years * 12;

    IF v_monthly_interest = 0 THEN
        v_emi := p_loan_amount / v_months;
    ELSE
        v_emi := p_loan_amount * v_monthly_interest / 
                 (1 - POWER(1 + v_monthly_interest, -v_months));
    END IF;

    RETURN ROUND(v_emi, 2);
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('Monthly Installment: ₹' || CalculateMonthlyInstallment(500000, 7.5, 10));
END;
/

--Scenario 3
-- Create the function
CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN NUMBER,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance Accounts.Balance%TYPE;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(' Error: Account ID ' || p_account_id || ' not found.');
        RETURN FALSE;
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(' Unexpected error: ' || SQLERRM);
        RETURN FALSE;
END;
/
-- Testing the function
DECLARE
    v_result BOOLEAN;
BEGIN
    v_result := HasSufficientBalance(2001, 1000);  -- Change AccountID/amount as needed
    IF v_result THEN
        DBMS_OUTPUT.PUT_LINE(' Sufficient Balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE(' Insufficient Balance');
    END IF;
END;
/
BEGIN
    IF HasSufficientBalance(2001, 1000) THEN
        DBMS_OUTPUT.PUT_LINE(' Sufficient Balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE(' Insufficient Balance');
    END IF;
END;
/
BEGIN
    IF HasSufficientBalance(2001, 1000) THEN
        DBMS_OUTPUT.PUT_LINE(' Sufficient Balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE(' Insufficient Balance');
    END IF;
END;
/




