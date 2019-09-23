DROP DATABASE IF EXISTS GuessTest;

CREATE DATABASE GuessTest;

USE GuessTest;

CREATE TABLE game(
gameId INT PRIMARY KEY AUTO_INCREMENT,
answer VARCHAR(45) NOT NULL,
solved BOOLEAN DEFAULT false
);

CREATE TABLE rounds(
roundId INT PRIMARY KEY AUTO_INCREMENT,
gameId INT NOT NULL,
userGuess VARCHAR(45) NOT NULL,
guessTime DATETIME NOT NULL,
result VARCHAR(45) NOT NULL,
FOREIGN KEY fk_rounds_game(gameId)
        REFERENCES game(gameId)
);






