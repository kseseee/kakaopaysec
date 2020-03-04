CREATE TABLE BRANCH
(
    BRANCH_CODE VARCHAR(20) NOT NULL PRIMARY KEY,
    BRANCH_NAME VARCHAR(20) NOT NULL
)
AS 
SELECT * 
FROM CSVREAD('classpath:/데이터_관리점정보.csv');

CREATE TABLE ACCOUNT
(
    ACCOUNT_NUMBER NUMBER(8) NOT NULL PRIMARY KEY,
    ACCOUNT_NAME VARCHAR(20) NOT NULL,
    BRANCH_CODE VARCHAR(20) REFERENCES BRANCH(BRANCH_CODE)
)
AS 
SELECT * 
FROM CSVREAD('classpath:/데이터_계좌정보.csv');

CREATE TABLE TRADE
(
    TRADE_DATE date NOT NULL,
    ACCOUNT_NUMBER NUMBER(8) NOT NULL REFERENCES ACCOUNT(ACCOUNT_NUMBER),
    TRADE_NUMBER NUMBER(20) NOT NULL,
    TRADE_MONEY NUMBER(20) NOT NULL,
    COMMISSION NUMBER(20),
    CANCEL_YN CHAR(1) NOT NULL
)	
AS 
SELECT * 
FROM CSVREAD('classpath:/데이터_거래내역.csv');