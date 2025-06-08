-- Create test .sql scripts with the following queries to verify that your database has been --
-- created and has been populated correctly. Each of these queries should --
-- be in their own .sql file and SHOULD NOT be included in the main database script. --

-- 1. Get all dealerships --
SELECT *
FROM dealerships;

-- 2. Find all vehicles for a specific dealership --
SELECT vin, dealerships.name 
FROM inventory
JOIN dealerships ON dealerships.Dealership_ID = inventory.Dealership_ID
WHERE dealerships.Dealership_ID = 7;

-- 3. Find a car by VIN --
SELECT *
FROM vehicles
where vin = 10007;


-- 4. Find the dealership where a certain car is located, by VIN --
SELECT dealerships.name, inventory.vin
FROM inventory
JOIN dealerships ON dealerships.dealership_id = inventory.dealership_id
WHERE  vin = 10018;


-- 5. Find all Dealerships that have a certain car type (i.e. Red Ford Mustang) --
SELECT inventory.dealership_id, vehicles.make
FROM inventory
JOIN vehicles ON vehicles.vin= inventory.vin
WHERE vehicles.make = 'Lexus';


-- 6. Get all sales information for a specific dealership, for a specific date range --
SELECT *
FROM sales_contracts
JOIN inventory ON inventory.vin = sales_contracts.vin
WHERE sales_contracts.date = '2024-03-11';

