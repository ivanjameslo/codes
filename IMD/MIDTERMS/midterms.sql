CREATE DATABASE CAR_DEALERSHIP_CS2A;

USE CAR_DEALERSHIP_CS2A;

CREATE TABLE Vehicle_Masterlist (
    Vehicle_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Brand VARCHAR(30),
    Model VARCHAR(30),
    Variant VARCHAR(50),
    Transmission VARCHAR(50),
    Color VARCHAR(30),
    Fuel_Type VARCHAR(30),
    Year_Model VARCHAR(4),
    Warranty VARCHAR(50),
    Price DECIMAL(20,2)
);

CREATE TABLE Customer_Masterlist (
    Customer_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LastName VARCHAR(30),
    FirstName VARCHAR(30),
    MiddleName VARCHAR(30),
    Street VARCHAR(30),
    City VARCHAR(30),
    Province VARCHAR(30),
    Country VARCHAR(30),
    ZIP_Code VARCHAR(4),
    Email VARCHAR(30),
    Phone_Number VARCHAR(11)
);

CREATE TABLE Employee_Masterlist (
    Employee_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    LastName VARCHAR(30),
    FirstName VARCHAR(30),
    MiddleName VARCHAR(30),
    Email VARCHAR(30),
    Phone_Number VARCHAR(11),
    Employed_Date DATE,
    Employee_Type VARCHAR(50),
    Employee_Specification VARCHAR(100),
    Salary DECIMAL(20, 2)
);

//Original variant
CREATE TABLE Parts_Masterlist (
    Parts_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Part_Name VARCHAR(50),
    Part_Description VARCHAR(100),
    Stocks INT NOT NULL,
    Price DECIMAL(20, 2) NOT NULL
);

CREATE TABLE Parts_Masterlist (
    Parts_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Part_Name VARCHAR(50),
    Stocks INT NOT NULL,
    Price DECIMAL(20, 2) NOT NULL
);

CREATE TABLE Car_Sales_Transactions (
    Transactions_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Customer_ID INT NOT NULL,
    Employee_ID INT NOT NULL,
    Vehicle_ID INT NOT NULL,
    Sale_Date DATE,
    Total_Amount DECIMAL(20, 2),
    Payment_Method VARCHAR(20),
    Payment VARCHAR(10),
    Payment_Date DATE,
    FOREIGN KEY (Customer_ID) REFERENCES Customer_Masterlist(Customer_ID),
    FOREIGN KEY (Employee_ID) REFERENCES Employee_Masterlist(Employee_ID),
    FOREIGN KEY (Vehicle_ID) REFERENCES Vehicle_Masterlist(Vehicle_ID),
    FOREIGN KEY (Parts_ID) REFERENCES Parts_Masterlist(Parts_ID)
);

insert into Vehicle_Masterlist (Vehicle_ID, Brand, Model, Variant, Transmission, Color, Fuel_Type, Year_Model, Warranty, Price)
values 
-- Vehicle ID 1
('Mitsubishi', 'Montero Sport', 'GLX 2.4 4x2 MT', 'Manual (MT)', 'Black', 'Diesel', '2023', '3 Years (100,000 km)', '1568000.00'),
-- Vehicle ID 2
('Mitsubishi', 'Montero Sport', 'GLS 2.4 4x2 AT', 'Automatic (AT)', 'Maroon', 'Diesel', '2023', '3 Years (100,000 km)', '1796000.00'),
-- Vehicle ID 3
('Mitsubishi', 'Montero Sport', '2.4 Black Series 4x2 AT (White Diamond)', 'Automatic (AT)', 'White Diamond', 'Diesel', '2023', '3 Years (100,000 km)', '2065000.00'),

-- Vehicle ID 4
('Mitsubishi', 'Strada', 'Cab and Chassis 2.5D 4x2 MT', 'Manual (MT)', 'Light Gray', 'Diesel', '2023', '3 Years (100,000 km)', '825000.00'),
-- Vehicle ID 5
('Mitsubishi', 'Strada', 'GL 4x2 MT', 'Manual (MT)', 'Light Gray', 'Diesel', '2023', '3 Years (100,000 km)', '1048000.00'),
-- Vehicle ID 6
('Mitsubishi', 'Strada', 'Athlete 4x4 AT', 'Automatic (AT)', 'Black', 'Diesel', '2023', '3 Years (100,000 km)', '1827000.00'),

-- Vehicle ID 7
('Mitsubishi', 'Xpander', '1.5 GLX MT', 'Manual (MT)', 'Dove Gray', 'Gasoline', '2023', '3 Years (100,000 km)', '1068000.00'),
-- Vehicle ID 8
('Mitsubishi', 'Xpander', '1.5 GLX AT', 'Automatic (AT)', 'Black', 'Gasoline', '2023', '3 Years (100,000 km)', '1128000.00'),
-- Vehicle ID 9
('Mitsubishi', 'Xpander', '1.5 GLS AT', 'Automatic (AT)', 'Red', 'Gasoline', '2023', '3 Years (100,000 km)', '1198000.00'),

-- Vehicle ID 10
('Mitsubishi', 'Xpander Cross', '1.5 AT (Monotone)', 'Automatic (AT)', 'Black', 'Gasoline', '2023', '3 Years (100,000 km)', '1328000.00'),
-- Vehicle ID 11
('Mitsubishi', 'Xpander Cross', '1.5 AT (Two-tone)', 'Automatic (AT)', 'Quartz White Pearl', 'Gasoline', '2023', '3 Years (100,000 km)', '1353000.00'),
-- Vehicle ID 12
('Mitsubishi', 'Xpander Cross', '1.5 AT Outdoor Edition', 'Automatic (AT)', 'Storm Dust Gray', 'Gasoline', '2023', '3 Years (100,000 km)', '1363000.00'),

-- Vehicle ID 13
('Mitsubishi', 'L300', 'Cab & Chassis', 'Manual (MT)', 'White', 'Diesel', '2023', '3 Years (100,000 km)', '813000.00'),
-- Vehicle ID 14
('Mitsubishi', 'L300', 'Aluminum No AC', 'Manual (MT)', 'White', 'Diesel', '2023', '3 Years (100,000 km)', '899000.00'),
-- Vehicle ID 15
('Mitsubishi', 'L300', 'FB Body Dual AC', 'manual (MT)', 'White', 'Diesel', '2023', '3 Years (100,000 km)', '998000.00');

insert into Customer_Masterlist (Customer_ID, LastName, FirstName, MiddleName, Street, City, Province, Country, ZIP_Code, Email, Phone_Number)
values 
-- ID 1
('Vales', 'Marc Linnus', 'Amador', 'Deca Cat. G.', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'mlavales@addu.edu.ph', '09487268431'),
-- ID 2
('Megriño', 'Job Stefan', 'Paracuelles', 'Masigla Streett.', 'San Isidro', 'Davao Oriental', 'Philippines', '8209', 'jspmegrino@addu.edu.ph', '09416325789'),
-- ID 3
('Dicipulo', 'Earl Geibriel', 'Señeres', 'Magaling, Lanang', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'egsdicipulo@addu.edu.ph', '09781303459'),
-- ID 4
('Cruz', 'Erika Hannah', 'Lu', 'Masipag, Ecoland', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'ehlcruz@addu.edu.ph', '09784103655'),
-- ID 5
('Foncardaz', 'Karl Friedrich', 'Estrellada', 'Langub, Maa', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'kfefoncardaz@addu.edu.ph', '09561439807'),
-- ID 6
('Misuarez', 'Pretty Faith', 'Infante', 'Illinois Street', 'Zamboanga City', 'Zamboanga del Sur', 'Philippines', '7000', 'pfimisuarez@addu.edu.ph', '09708943158'),
-- ID 7
('Tranquilan', 'Shan Nuel', 'Sampiano', 'Ponkan Street, Bago Aplaya', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'snstranquilan@addu.edu.ph', '09128946780'),
-- ID 8
('Aliño', 'Jose Miguel', 'Tolentino', 'Sand Street, Buhangin', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'jmtalino@addu.edu.ph', '09437893421'),
-- ID 9
('Langones', 'Miguel Paolo', 'Ferraris', 'Jolly Street, Matina Crossing', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'mpflangones@addu.edu.ph', '09679471920'),
-- ID 10
('Sarillo', 'Adolfo Cedric', 'Salcedo', 'Tionko Street, Poblacion', 'Davao City', 'Davao del Sur', 'Philippines', '8000', 'adocssarillo@addu.edu.ph', '09542140134');

insert into Employee_Masterlist (Employee_ID, LastName, FirstName, MiddleName, Email, Phone_Number, Employed_Date, Employee_Type, Employee_Specification, Salary)
values
-- Employee ID 1
('Du', 'Ellyanna Nicole', 'Louh', 'enldu@addu.edu.ph', '09451246276', '2023-09-12', 'Sales', 'Manager', '5500.50'),
-- Employee ID 2
('Haw', 'Sarah', 'Yu', 'syhaw@addu.edu.ph', '09845137596', '2023-09-13', 'Sales', 'Cashier', '4900.90'),
-- Employee ID 3
('Mejorada', 'Arabella Grace', 'Mendoza', 'agmmejorada@addu.edu.ph', '09890547321', '2023-09-13', 'Sales', 'Accountant', '5000.95'),
-- Employee ID 4
('Magsigay', 'Mary Vee', 'Pangahin', 'mvpmagsigay@addu.edu.ph', '09658745891', '2023-09-14', 'Mechanic', 'General Automotive Mechanic', '4800.50'),
-- Employee ID 5
('Lo', 'Ivan James', 'Abadilla', 'ijalo@addu.edu.ph', '09752648923', '2023-09-15', 'Mechanic', 'Brake and Transmission Technician', '4800.50'),
-- Employee ID 6
('Aguado', 'Emmanuel', 'Diaz', 'eaguado@addu.edu.ph', '09498501280', '2023-09-15', 'Mechanic', 'Diesel Mechanic', '4800.50');

insert into Parts_Masterlist (Parts_ID, Part_Name, Stocks, Price)
values
('Front Bumper', '200', '15000.00'),
('Body Shell (Car)', '200', '50000.00'),
('Roof (Car)', '200', '25000.00'),
('Bull Bar', '200', '16000.00'),
('Windshield', '200', '3000.00'),
('Tire', '200', '6000.00'),
('Rim', '200', '16000.00'),
('Hub', '200', '3500.00'),
('Headlight Bulbs', '200', '350.00'),
('Turn Signal Bulb', '200', '200.00'),
('Headlight Lens', '200', '700.00'),
('Ring Maker Lights', '200', '2700.00'),
('Projector Lens', '200', '6350.00'),
('Reflector', '200', '1500.00');

insert into Car_Sales_Transactions (Transactions_ID, Customer_ID, Employee_ID, Vehicle_ID, Sale_Date, Total_Amount, Payment_Method, Payment, Payment_Date)
values
-- ano ba payment methods natin WAHAHAHAH
-- not sure sa payment lol what if hindi full..? partial ba or
('3','6','9','10/01/2023','1198000.00','Cash','Full','10/01/2023'),
('7','1','7','10/03/2023','1068000.00','Cash','Full','10/03/2023'),
('2','4','6','10/7/2023','1827000.00','Card','Full','10/07/2023'),
('1','2','3','10/10/2023','1328000.00','Cash','Partial','10/10/2023'),
('5','5','5','10/11/2023','1048000.00','Card','Full','10/11/2023'),
('10','3','13','10/15/2023','1328000.00','Cash','Full','10/15/2023'),
('4','1','12','10/20/2023','1363000.00','Cash','Partial','10/20/2023'),
('6','3','11','10/22/2023','1353000.00','Cash','Full','10/22/2023'),
('9','5','2','10/23/2023','1796000.00','Cash','Full','10/23/2023'),
('8','1','15','10/27/2023','998000.00','Card','Partial','10/27/2023');