CREATE DATABASE CAR_DEALERSHIP_CS2A;

USE CAR_DEALERSHIP_CS2A;

CREATE TABLE VEHICLE_MASTERLIST (
    VEHICLE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    MODEL VARCHAR(30),
    MAKE VARCHAR(30),
    VARIANT VARCHAR(30),
    COLOR VARCHAR(30),
    TRANSMISSION VARCHAR(30),
    SEAT_CAPACITY(2),
    FUEL_TYPE VARCHAR(30),
    YEAR_MODEL VARCHAR(4),
    WARRANTY VARCHAR(30),
    PRICING VARCHAR(10)
);

CREATE TABLE CUSTOMER_MASTERLIST (
    CUSTOMER_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LASTNAME VARCHAR(30),
    FIRSTNAME VARCHAR(30),
    MIDDLENAME VARCHAR(30),
    STREET VARCHAR(30),
    CITY VARCHAR(30),
    PROVINCE VARCHAR(30),
    COUNTRY VARCHAR(30),
    ZIP_CODE VARCHAR(4),
    EMAIL VARCHAR(30),
    PHONE_NUMBER VARCHAR(11)
);

CREATE TABLE EMPLOYEE_MASTERLIST (
    EMPLOYEE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LASTNAME VARCHAR(30),
    FIRSTNAME VARCHAR(30),
    MIDDLENAME VARCHAR(30),
    EMAIL VARCHAR(30),
    PHONE_NUMBER VARCHAR(11),
    EMPLOYED_DATE DATE,
    EMPLOYEE_TYPE VARCHAR(50),
    EMPLOYEE_SPECIFICATION VARCHAR(50),
    SALARY DECIMAL(10, 2)
);

CREATE TABLE PARTS_MASTERLIST (
    PARTS_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PART_NAME VARCHAR(50),
    PART_DESCRIPTION VARCHAR(100),
    PRICE DECIMAL(10, 2) NOT NULL,
    QUANTITY INT NOT NULL
);

CREATE TABLE CAR_SALES_TRANSACTIONS (
    TRANSACTIONS_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CUSTOMER_ID INT NOT NULL,
    EMPLOYEE_ID INT NOT NULL,
    TRANSACTIONS VARCHAR(30),
    SALE_DATE DATE,
    TOTAL_AMOUNT DECIMAL(10, 2),
    PAYMENT_METHOD VARCHAR(20),
    PAYMENT VARCHAR(10),
    PAYMENT_DATE DATE,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER_MASTERLIST(CUSTOMER_ID),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE_MASTERLIST(EMPLOYEE_ID)
);



insert into customer_masterlist values ('Vales', 'Marc Linnus', 'Amador', 'Deca Cat. G.', ' Davao City', 'Davao del Sur', 'Philippines', '8000', 'mlavales@addu.edu.ph', '09487268431');
insert into customer_masterlist values ('Megriño', 'Job Stefan', 'Paracuelles', 'Masigla Streett.', 'San Isidro', 'Davao Oriental', 'Philippines', '8209', 'jspmegrino@addu.edu.ph', '09416325789');
insert into customer_masterlist values ('Dicipulo', 'Earl Geibriel', 'Señeres', 'Magaling, Lanang', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'egsdicipulo@addu.edu.ph', '09781303459');
insert into customer_masterlist values ('Cruz', 'Erika Hannah', 'Lu', 'Masipag, Ecoland', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'ehlcruz@addu.edu.ph', '0978410365');
insert into customer_masterlist values ('Foncardaz', 'Karl Friedrich', 'Estrellada', 'Langub, Maa', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'kfefoncardaz@addu.edu.ph', '09561439807');
insert into customer_masterlist values ('Misuarez', 'Pretty Faith', 'Infante', 'Illinois Street', 'Zamboanga City', 'Zamboanga del Sur', 'Philippines', '7000', 'pfimisuarez@addu.edu.ph', '09708943158');
insert into customer_masterlist values ('Tranquilan', 'Shan Nuel', 'Sampiano', 'Ponkan Street, Bago Aplaya', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'snstranquilan@addu.edu.ph', '09128946780');
insert into customer_masterlist values ('Aliño', 'Jose Miguel', 'Tolentino', 'Sand Street, Buhangin', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'jmtalino@addu.edu.ph', '09437893421');
insert into customer_masterlist values ('Langones', 'Miguel Paolo', 'Ferraris', 'Jubilee Street, Matina Crossing', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'mpflangones@addu.edu.ph', '09679471920');
insert into customer_masterlist values ('Sarillo', 'Adolfo Cedric', 'Salcedo', 'Tionko Street, Poblacion', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'adocssarillo@addu.edu.ph', '09542140134'); 

insert into employee_masterlist values ('Du', 'Ellyanna Nicole', 'Louh', 'enldu@addu.edu.ph', '09451246276', '2023-09-12', 'Sales', 'Manager', '5500.50');
insert into employee_masterlist values ('Haw', 'Sarah', 'Yu', 'syhaw@addu.edu.ph', '098451375961', '2023-09-13', 'Sales', 'Cashier', '4900.90');
insert into employee_masterlist values ('Mejorada', 'Arabella Grace', 'Mendoza', 'agmmejorada@addu.edu.ph', '09890547321', '2023-09-13', 'Sales', 'Accountant', '5000.95');
insert into employee_masterlist values ('Magsigay', 'Mary Vee', 'Pangahin', 'mvpmagsigay@addu.edu.ph', '09658745891', '2023-09-14', 'Mechanic', 'General Automotive Mechanic', '4800.50');
insert into employee_masterlist values ('Lo', 'Ivan James', 'Abadilla', 'ijalo@addu.edu.ph', '09752648923', 'Mechanic', 'Brake and Transmission Technician', '4800.50');
insert into employee_masterlist values ('Aguado', 'Emmanuel', 'Diaz', 'eaguado@addu.edu.ph', '09498501280', 'Mechanic', 'Diesel Mechanic', '4800.50');