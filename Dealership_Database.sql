CREATE TABLE Dealerships (
	Dealership_ID INT AUTO_INCREMENT PRIMARY KEY,
    Name varchar(50),
    Address varchar(50),
    Phone varchar (50)
);
CREATE TABLE Vehicles (
	Make varchar(50),
    VIN INT PRIMARY KEY,
    Sold BIT
);
CREATE TABLE Inventory (
	Dealership_ID INT,
    VIN INT,
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
	VIN INT,
	FOREIGN KEY (VIN) REFERENCES Vehicles (VIN)
);



-- tentative if time allows --
CREATE TABLE Lease_Contracts(
	Name varchar (50),
    ID INT AUTO_INCREMENT,
    FOREIGN KEY (VIN) REFERENCES VEHICLE(VIN)
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
INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Toyota', 10001, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Honda', 10002, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Ford', 10003, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Chevrolet', 10004, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Nissan', 10005, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('BMW', 10006, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Audi', 10007, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Mercedes-Benz', 10008, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Kia', 10009, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Hyundai', 10010, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Subaru', 10011, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Mazda', 10012, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Volkswagen', 10013, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Tesla', 10014, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Lexus', 10015, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Jeep', 10016, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Dodge', 10017, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('GMC', 10018, 1);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Ram', 10019, 0);

INSERT INTO Vehicles (Make, VIN, Sold) 
VALUES ('Volvo', 10020, 1);

-- Info for the inventory --
INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('1', 10001);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('2', 10002);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('2', 10003);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('2', 10004);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('4', 10005);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('5', 10006);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('7', 10007);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('7', 10008);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('10', 10009);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('10', 10010);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('11', 10011);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('1', 10012);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('1', 10013);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('1', 10014);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('3', 10015);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('5', 10016);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('10', 10017);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('10', 10018);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('9', 10019);

INSERT INTO Inventory (Dealership_ID, VIN) 
VALUES ('7', 10020);

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


    
    
    
    
    