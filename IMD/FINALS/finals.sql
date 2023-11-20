CREATE DATABASE SANSAN_LAYOUT;

USE SANSAN_LAYOUT;

CREATE TABLE Services (
    Service_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Service_Type varchar(50),
    Service_Category varchar(50)
);

CREATE TABLE Commissions_Masterlist (
    Order_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Output_Specifications_ID INT NOT NULL, 
    Customer_Details_ID INT NOT NULL,
    Payment_Details_ID INT NOT NULL,
    Invoice_ID INT NOT NULL,
    Status_ID INT NOT NULL,
    Current_Status varchar(50),
    FOREIGN KEY (Output_Specifications_ID) REFERENCES Output_Specifications(Output_Specifications_ID),
    FOREIGN KEY (CustomerDetails_ID) REFERENCES
    FOREIGN KEY (Payment_Details_ID) REFERENCES Payment_Details(Payment_Details_ID),
    FOREIGN KEY (Invoice_ID) REFERENCES 
    FOREIGN KEY (Status_ID) REFERENCES Status_Details(Status_ID)
);

CREATE TABLE Status_Details (
    Status_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    --Status_Label varchar(50),
    Order_ID INT NOT NULL,
    Status_Date DATE,
    Status_Time varchar(10),
    Employee_ID INT NOT NULL,
    FOREIGN KEY (Order_ID) REFERENCES
    FOREIGN KEY (Employee_ID) REFERENCES 
);

CREATE TABLE Output_Specifications (
    Output_Specifications_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Type_of_Output varchar(50),
    Output_Size varchar(50),
    Number_Of_Pages varchar(5),
    Order_Date DATE,
    Output_Due_Date DATE,
    Colors varchar(50),
    Theme varchar(50), 
);

CREATE TABLE Payment_Details (
    Payment_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Payment_Method varchar(50),
    Payment_Date DATE,
    Payment_Time varchar(50),
    Payment_Amount Decimal(10,2),
    Payment_Breakdown INT NOT NULL,
    Reference_ID varchar(10),
    --Employee_ID INT NOT NULL
    FOREIGN KEY
);

CREATE TABLE Payment_Breakdown (
    Payment_Breakdown_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Base_Price Decimal (10,2),
    
);

CREATE TABLE Employees (
    Employee_Name varchar(50),
    Current_Position varchar(50),
    Current_Department varchar(50),
    Employee_Phone varchar(11),
    Employee_Email varchar(50),
    Employee_Address varchar(50),
    
);

C
VAT ETAE


