DROP DATABASE IF EXISTS MovieCatalogue;

CREATE DATABASE MovieCatalogue;

USE MovieCatalogue;

CREATE TABLE Genre (
GenreID INT PRIMARY KEY AUTO_INCREMENT,
GenreName CHAR(30) NOT NULL
);

CREATE TABLE Director(
DirectorID INT PRIMARY KEY AUTO_INCREMENT,
FirstName CHAR(30) NOT NULL,
LastName CHAR(30) NOT NULL,
BirthDate VARCHAR(10) NULL
);

CREATE TABLE Rating(
RatingID INT PRIMARY KEY AUTO_INCREMENT,
RatingName CHAR(5) NOT NULL 
);

CREATE TABLE Actor(
ActorID INT PRIMARY KEY AUTO_INCREMENT,
FirstName CHAR(30) NOT NULL,
LastName CHAR(30) NOT NULL,
BirthDate VARCHAR(10) NULL
);

CREATE TABLE Movie(
MovieID INT PRIMARY KEY AUTO_INCREMENT,
GenreID INT NOT NULL,
DirectorID INT NULL,
RatingID INT NULL,
Title CHAR(128) NOT NULL,
ReleaseDate VARCHAR(30) NULL,
FOREIGN KEY fk_Movie_Genre(GenreID)
REFERENCES Genre(GenreID),
FOREIGN KEY fk_Movie_Director (DirectorID)
REFERENCES Director(DirectorID),
FOREIGN KEY fk_Movie_Rating(RatingID)
REFERENCES Rating(RatingID)
);

CREATE TABLE CastMembers(
CastMemberID INT PRIMARY KEY AUTO_INCREMENT,
ActorID INT NOT NULL,
MovieID INT NOT NULL,
Role CHAR(50) NOT NULL,
FOREIGN KEY CastMember_Actor(ActorID)
REFERENCES Actor(ActorID),
FOREIGN KEY CastMember_Movie(MovieID)
REFERENCES Movie(MovieID)
);

INSERT INTO Actor (FirstName, LastName, BirthDate)
VALUES
('Bill', 'Murray', '1950/09/21'),
('Dan', 'Aykroyd', '1952/07/01'),
('John', 'Candy', '1950/10/31'),
('Steve', 'Martin', NULL),
('Sylvester', 'Stallone', NULL);

INSERT INTO Director(FirstName, LastName, BirthDate)
VALUES
('Ivan', 'Reitman', '1946/10/27'),
('Ted', 'Kotchen', NULL);

INSERT INTO Rating (RatingName)
VALUES
('G'),
('PG'),
('PG-13'),
('R');

INSERT INTO Genre (GenreName)
VALUES
('Action'),
('Comedy'),
('Drama'),
('Horror');

INSERT INTO Movie(GenreID, DirectorID, RatingID, Title, ReleaseDate)
VALUES
(1,2,4,'Rambo: First Blood', '1982/10/22'),
(2,NULL,4, 'Planes, Trains & Automobiles', '1987/11/25'),
(2,1,2,'Ghostbusters', NULL),
(2,NULL,2,'The Great Outdoors', '1988/06/17');

INSERT INTO CastMembers(ActorID, MovieID, Role)
VALUES
(5,1,'John Rambo'),
(4,2,'Neil Page'),
(3,2,'Del Griffith'),
(1,3,'Dr. Peter Venkman'),
(2,3,'Dr. Raymond Stanz'),
(2,4,'Roman Craig'),
(3,4,'Chet Ripley');

Select *
FROM Movie
WHERE MovieID = 3;

UPDATE Movie SET
Title = 'Ghostbusters(1984)',
ReleaseDate = '1984/06/08'
WHERE MovieID = 3;

Select *
FROM Movie
WHERE MovieID = 3;

UPDATE Genre SET
GenreName = 'Action/Adventure'
WHERE GenreID = 1;

Select *
FROM GENRE
WHERE GenreID = 1;

-- USED ansewer for remove Movie becasue didn't know which parent relationship was 
-- affecting the delete. Though to be honest, didn't read the whole error at first.

DELETE FROM CastMembers
WHERE MovieID = 1;

 DELETE FROM Movie
WHERE MovieID = 1;

ALTER TABLE Actor
ADD COLUMN (DateOfDeath DATE NULL);

UPDATE Actor SET
DateOfDeath = '1994/03/04'
WHERE ActorID = 3;



