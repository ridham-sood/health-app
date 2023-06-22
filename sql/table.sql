DROP DATABASE IF EXISTS healthDB;
CREATE DATABASE healthDB;

USE healthDB;

CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE food (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    calories INT,
    protein INT,
    carbs INT,
    fat INT,
    date VARCHAR(255),
    mid INT,
    FOREIGN KEY (mid) REFERENCES member(id)
);
