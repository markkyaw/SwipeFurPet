CREATE DATABASE IF NOT EXISTS SwipeFurPets;
USE SwipeFurPets;

CREATE TABLE Rescue (
	Rescue_ID varchar(45) primary key,
    Organization_Name varchar(45) not null,
    Email varchar(45) not null,
    Phone varchar(45) not null,
    Link varchar(500) not null, 
    City varchar(100) not null,
    Zipcode varchar(11) not null
);

CREATE TABLE Pet (
	Pet_ID INT(11) primary key not null, 
    Pet_Name varchar(45) not null,
    PetType varchar(45) not null,
    Age varchar(45) not null,
    Size varchar(45) not null,
    Gender varchar(45) not null, 
    Rescue_ID varchar(45) not null,
    ImgLink varchar(500) not null,
    Children int(1) not null,
    Dogs int(1) not null,
    Cats int(1) not null,

	foreign key fk(Rescue_ID) references Rescue(Rescue_ID)
);

CREATE TABLE Adopter (
    Email varchar(200) primary key,
    First_Name varchar(45) not null, 
	Last_Name varchar(45) not null, 
    Phone varchar(45) not null,
    Zipcode varchar(11) not null,
    City varchar(100) not null, 
    Password varchar(200) not null
);

CREATE TABLE Preferences (
    Email varchar(200) primary key,
    PetType varchar(45) not null, 
    Size varchar(45) not null,
    Age varchar(45) not null,
    Children int(1) not null,
    Dogs int(1) not null,
    Cats int(1) not null
);

CREATE TABLE Interest (
	Interest_ID INT(11) primary key auto_increment, 
	Email varchar(200) not null,
    Pet_ID INT(11) not null, 
    
	foreign key fk1(Email) references Adopter(Email),
    foreign key fk2(Pet_ID) references Pet(Pet_ID)

);

CREATE TABLE Message (
	Message_ID INT(11) primary key auto_increment,
    Sender tinyint(1) not null,
	Pet_ID int(11) not null,
    Email varchar(200) not null,
    Date_Time datetime(0) not null, 
    Content varchar(250) not null, 

	foreign key message1(Email) references Adopter(Email),
	foreign key message2(Pet_ID) references Pet(Pet_ID)
);




