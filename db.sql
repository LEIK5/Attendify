CREATE DATABASE attendify;
USE attendify;
CREATE TABLE students(
    studentNumber VARCHAR(255), 
    lastName VARCHAR(255), 
    firstName VARCHAR(255), 
    middleName VARCHAR(255),
    imagePath VARCHAR(255)
);
CREATE TABLE users( 
    lastName VARCHAR(255), 
    firstName VARCHAR(255),
    contactNumber VARCHAR(11),
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);
CREATE TABLE classes( 
    className VARCHAR(255), 
    timeStart VARCHAR(255),
    timeEnd VARCHAR(255),
    dateOfSessions VARCHAR(255)
);
