CREATE TABLE Dealerships (
	Dealership_ID INT AUTO_INCREMENT PRIMARY KEY,
    Name varchar(50),
    Address varchar(50),
    Phone varchar (50)
);
CREATE TABLE Vehicles (
	VIN INT PRIMARY KEY,
    Year int,
	Make varchar(50),
    Model varchar(50),
    Vehicle_Type varchar(50),
    color varchar(50),
    Odometer int,
    Price double,
    Dealership_ID INT,
    FOREIGN KEY (Dealership_ID) REFERENCES Dealerships (Dealership_ID)
);

CREATE TABLE Sales_Contracts (
	Name varchar(50),
    ID INT AUTO_INCREMENT PRIMARY KEY,
    VIN INT,
    FOREIGN KEY (VIN) REFERENCES Vehicles (VIN)
);
CREATE TABLE Sales_Contracts (
	Date varchar (50),
	Name varchar(50),
	ID INT AUTO_INCREMENT PRIMARY KEY,
	VIN INT
);

CREATE USER 'root2'@'localhost' IDENTIFIED BY '2024MotherJ*';
GRANT ALL PRIVILEGES ON dealership.* TO 'root2'@'localhost';
FLUSH PRIVILEGES;


-- tentative if time allows --
CREATE TABLE Lease_Contracts(
	Date varchar(50),
	Name varchar (50),
    ID INT AUTO_INCREMENT PRIMARY KEY,
    VIN int
);

-- Dealerships info --
INSERT INTO Dealerships (name, address, phone)
VALUES ('Auto World', '456 Main Ave', '312-555-0198');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Premier Motors', '789 North Blvd', '213-654-8822');

INSERT INTO Dealerships (name, address, phone)
VALUES ('DriveTime Auto', '159 South Rd', '718-303-1111');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Luxury Rides', '88 Oak Street', '415-901-3344');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Budget Wheels', '300 Elm St', '202-498-2210');

INSERT INTO Dealerships (name, address, phone)
VALUES ('City Auto Sales', '1420 Western Dr', '602-777-5533');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Greenlight Cars', '670 Pine Ln', '404-620-9987');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Sunshine Motors', '29 Palm Way', '850-222-1477');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Fast Lane Autos', '921 Speedy Ct', '702-885-1203');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Value Auto Mart', '1100 Price Dr', '919-441-6625');

INSERT INTO Dealerships (name, address, phone)
VALUES ('Hometown Cars', '77 Country Rd', '303-301-7098');



-- Info for Vehicles --
-- Dealership 1: Auto World
INSERT INTO Vehicles (VIN, Year, Make, Model, Vehicle_Type, Color, Odometer, Price, Dealership_ID) VALUES
(200001, 2020, 'Toyota', 'Camry', 'Sedan', 'Black', 35000, 22000.00, 1),
(200002, 2019, 'Ford', 'Focus', 'Sedan', 'Blue', 42000, 18000.00, 1),
(200003, 2021, 'Nissan', 'Rogue', 'SUV', 'Silver', 20000, 26000.00, 1),
(200004, 2022, 'Chevrolet', 'Malibu', 'Sedan', 'White', 15000, 24000.00, 1),
(200005, 2018, 'Hyundai', 'Elantra', 'Sedan', 'Red', 50000, 16000.00, 1);

-- Dealership 2: Premier Motors
INSERT INTO Vehicles VALUES
(200006, 2020, 'BMW', 'X3', 'SUV', 'White', 18000, 42000.00, 2),
(200007, 2022, 'Mercedes', 'C300', 'Sedan', 'Black', 12000, 45000.00, 2),
(200008, 2021, 'Audi', 'Q5', 'SUV', 'Gray', 17000, 46000.00, 2),
(200009, 2020, 'Lexus', 'RX 350', 'SUV', 'Blue', 25000, 43000.00, 2),
(200010, 2019, 'Acura', 'TLX', 'Sedan', 'Silver', 30000, 35000.00, 2);

-- Dealership 3: DriveTime Auto
INSERT INTO Vehicles VALUES
(200011, 2017, 'Kia', 'Soul', 'Hatchback', 'Yellow', 60000, 14000.00, 3),
(200012, 2018, 'Ford', 'Escape', 'SUV', 'Gray', 55000, 19000.00, 3),
(200013, 2019, 'Toyota', 'Corolla', 'Sedan', 'White', 40000, 17000.00, 3),
(200014, 2020, 'Mazda', 'CX-5', 'SUV', 'Red', 30000, 23000.00, 3),
(200015, 2021, 'Honda', 'Civic', 'Sedan', 'Black', 22000, 21000.00, 3);

-- Dealership 4: Luxury Rides
INSERT INTO Vehicles VALUES
(200016, 2023, 'Tesla', 'Model 3', 'Sedan', 'Blue', 5000, 50000.00, 4),
(200017, 2022, 'Audi', 'A6', 'Sedan', 'Gray', 10000, 58000.00, 4),
(200018, 2021, 'BMW', '5 Series', 'Sedan', 'White', 12000, 53000.00, 4),
(200019, 2020, 'Mercedes', 'E-Class', 'Sedan', 'Black', 15000, 56000.00, 4),
(200020, 2019, 'Lexus', 'ES 350', 'Sedan', 'Silver', 22000, 45000.00, 4);

-- Dealership 5: Budget Wheels
INSERT INTO Vehicles VALUES
(200021, 2016, 'Chevrolet', 'Spark', 'Hatchback', 'Green', 70000, 9000.00, 5),
(200022, 2017, 'Hyundai', 'Accent', 'Sedan', 'Blue', 65000, 10000.00, 5),
(200023, 2018, 'Ford', 'Fiesta', 'Hatchback', 'Red', 60000, 11000.00, 5),
(200024, 2019, 'Nissan', 'Versa', 'Sedan', 'Gray', 50000, 12000.00, 5),
(200025, 2020, 'Kia', 'Rio', 'Sedan', 'White', 40000, 13000.00, 5);

-- Dealership 6: City Auto Sales
INSERT INTO Vehicles VALUES
(200026, 2021, 'Toyota', 'RAV4', 'SUV', 'Silver', 15000, 28000.00, 6),
(200027, 2020, 'Honda', 'HR-V', 'SUV', 'Black', 25000, 24000.00, 6),
(200028, 2022, 'Subaru', 'Outback', 'SUV', 'Blue', 10000, 29000.00, 6),
(200029, 2019, 'Mazda', 'CX-30', 'SUV', 'Red', 35000, 21000.00, 6),
(200030, 2020, 'Chevrolet', 'Equinox', 'SUV', 'Gray', 30000, 22000.00, 6);

-- Dealership 7: Greenlight Cars
INSERT INTO Vehicles VALUES
(200031, 2018, 'Ford', 'Fusion Hybrid', 'Sedan', 'White', 45000, 19000.00, 7),
(200032, 2019, 'Toyota', 'Prius', 'Hatchback', 'Green', 40000, 20000.00, 7),
(200033, 2020, 'Hyundai', 'Ioniq', 'Hatchback', 'Gray', 30000, 21000.00, 7),
(200034, 2021, 'Kia', 'Niro', 'SUV', 'Black', 25000, 23000.00, 7),
(200035, 2022, 'Tesla', 'Model Y', 'SUV', 'Blue', 8000, 49000.00, 7);

-- Dealership 8: Sunshine Motors
INSERT INTO Vehicles VALUES
(200036, 2019, 'Chevrolet', 'Cruze', 'Sedan', 'Orange', 40000, 17000.00, 8),
(200037, 2020, 'Nissan', 'Sentra', 'Sedan', 'Yellow', 30000, 18000.00, 8),
(200038, 2021, 'Toyota', 'Yaris', 'Hatchback', 'Pink', 20000, 19000.00, 8),
(200039, 2022, 'Hyundai', 'Venue', 'SUV', 'White', 10000, 20000.00, 8),
(200040, 2023, 'Kia', 'Seltos', 'SUV', 'Blue', 5000, 25000.00, 8);

-- Dealership 9: Fast Lane Autos
INSERT INTO Vehicles VALUES
(200041, 2020, 'Dodge', 'Charger', 'Sedan', 'Red', 25000, 31000.00, 9),
(200042, 2021, 'Ford', 'Mustang', 'Coupe', 'Black', 20000, 36000.00, 9),
(200043, 2019, 'Chevrolet', 'Camaro', 'Coupe', 'Blue', 30000, 33000.00, 9),
(200044, 2022, 'Nissan', '370Z', 'Coupe', 'Gray', 15000, 34000.00, 9),
(200045, 2023, 'Toyota', 'GR86', 'Coupe', 'White', 5000, 35000.00, 9);

-- Dealership 10: Value Auto Mart
INSERT INTO Vehicles VALUES
(200046, 2017, 'Honda', 'Fit', 'Hatchback', 'Green', 60000, 12000.00, 10),
(200047, 2018, 'Toyota', 'Auris', 'Hatchback', 'Blue', 55000, 13000.00, 10),
(200048, 2019, 'Mazda', '2', 'Hatchback', 'Silver', 50000, 14000.00, 10),
(200049, 2020, 'Ford', 'Focus', 'Hatchback', 'Red', 45000, 15000.00, 10),
(200050, 2021, 'Hyundai', 'i30', 'Hatchback', 'Black', 30000, 16000.00, 10);

-- Dealership 11: Hometown Cars
INSERT INTO Vehicles VALUES
(200051, 2019, 'Chevrolet', 'Traverse', 'SUV', 'Blue', 42000, 29000.00, 11),
(200052, 2020, 'Ford', 'Explorer', 'SUV', 'Black', 35000, 32000.00, 11),
(200053, 2021, 'Jeep', 'Cherokee', 'SUV', 'Gray', 28000, 31000.00, 11),
(200054, 2022, 'Toyota', 'Highlander', 'SUV', 'White', 15000, 37000.00, 11),
(200055, 2023, 'Subaru', 'Ascent', 'SUV', 'Red', 8000, 39000.00, 11);

-- Info for sales contract --
INSERT INTO Sales_Contracts (Date, Name, VIN) 
VALUES ('2024-05-01','Alice Cooper', 10001);

INSERT INTO Sales_Contracts (Date, Name, VIN) 
VALUES ('2024-01-05','Brian Adams', 10003);

INSERT INTO Sales_Contracts (Date, Name, VIN) 
VALUES ('2024-03-11','Cynthia Lee', 10005);

INSERT INTO Sales_Contracts (Date, Name, VIN) 
VALUES ('2024-06-3','Daniel Wu', 10007);

INSERT INTO Sales_Contracts (Date, Name, VIN) 
VALUES ('2024-02-26','Elena Gomez', 10009);


    
    
    
    
    