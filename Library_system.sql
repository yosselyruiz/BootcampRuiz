CREATE TABLE Library(
	LibraryId int,
    Name varchar (50) NOT NULL,
    Address varchar (100)
);
CREATE TABLE Authors (
    Author_Id INT PRIMARY KEY AUTO_INCREMENT,
    Name varchar (100),
    country varchar (50)
);
CREATE TABLE Books (
	Book_Id INT PRIMARY KEY AUTO_INCREMENT,
    Title varchar (200),
    Genre varchar (50),
    Author_Id INT, 
    FOREIGN KEY (Author_Id) REFERENCES Authors (Author_Id)
);