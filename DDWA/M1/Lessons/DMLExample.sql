-- This approach destroys the existing database and starts from scratch each time you run it.

-- It's good for new development, but won't work for existing
-- databases that must be altered but left intact

DROP DATABASE IF EXISTS TrackIt;

CREATE DATABASE TrackIt;

-- Make sure we're in the correct database before we add schema.
USE TrackIt;

CREATE TABLE Project (
ProjectId CHAR(50) PRIMARY KEY,
`Name` VARCHAR(100) NOT NULL,
Summary VARCHAR(2000) NULL,
DueDate DATE NOT NULL,
IsActive BOOL NOT NULL DEFAULT 1
);

CREATE TABLE Worker(
WorkerId INT PRIMARY KEY AUTO_INCREMENT,
FirstName VARCHAR(50) NOT NULL,
LastName VARCHAR(50) NOT NULL
);

CREATE TABLE ProjectWorker(
ProjectId CHAR(50) NOT NULL,
WorkerId INT NOT NULL,
PRIMARY KEY pk_ProjectWorker(ProjectId, WorkerId),
FOREIGN KEY fk_ProjectWorker_Project(ProjectId)
REFERENCES Project(ProjectId),
FOREIGN KEY fk_ProjectWorker_Worker(WorkerId)
REFERENCES Worker(WorkerId)
);

CREATE TABLE Task (
TaskId INT PRIMARY KEY AUTO_INCREMENT,
Title VARCHAR(100) NOT NULL,
Details TEXT NULL,
DueDate DATE NOT NULL,
EstimatedHours DECIMAL(5, 2) NULL,
ProjectId CHAR(50) NOT NULL,
WorkerId INT NOT NULL,
FOREIGN KEY fk_Take_ProjectWorker(ProjectId, WorkerId)
REFERENCES ProjectWorker(ProjectId, WorkerId)
);



INSERT INTO Project (ProjectId, Name, DueDate)VALUES
('db-milestone', 'Database Material', '2018-12-31');

INSERT INTO ProjectWorker(ProjectId, WorkerId) VALUES('db-milestone', 75);

INSERT INTO Worker(FirstName, LastName) VALUES
('Goldi', 'Pilipets'),
('Dorey', 'Rulf'),
('Panchito', 'Ashtonhurst');

INSERT INTO Worker(WorkerId, FirstName, LastName)VALUES
(4, 'RoseMade', 'Featherbie' );

INSERT INTO Worker(FirstName, LastName)VALUES
('Kingsly', 'Besantie');

INSERT INTO Project(ProjectId, `Name`, DueDate) VALUES
('kitchen', 'Kitchen Remodel','2025-07-25' );


INSERT INTO ProjectWorker(ProjectId, WorkerId) VALUES
('db-milestone', 1), -- Rosemonde, Database
('kitchen', 2), -- Kingsley, Kitchen
('db-milestone', 3), -- Goldi, Database
('db-milestone', 4); -- Dorey, Database

UPDATE Worker SET
FirstName = 'RoseMade',
LastName  = 'Featherbie'
WHERE WorkerId = 1;

UPDATE Worker SET
FirstName = 'Kingsly',
LastName = 'Besantie'
WHERE WorkerId = 2;

UPDATE Worker SET
FirstName = 'Goldie',
LastName = 'Pilipets'
WHERE WorkerId = 3;

UPDATE Worker SET
FirstName = 'Dorey',
LastName = 'Rulf'
WHERE WorkerId = 4;

UPDATE Worker SET
FirstName = 'Panchito',
LastName = 'Ashtonhurst'
WHERE WorkerId = 5;

-- Provide a Project Summary and change the DueDate.
UPDATE Project SET
Summary = 'All lessons and exercises for the relational database milestone.',
DueDate = '2018-10-15'
WHERE ProjectId = 'db-milestone';

-- Change Kingsly's to 'Oaks'.
UPDATE Worker SET
LastName = 'Oaks'
WHERE WorkerId = 2;

-- Disable safe updates.
SET SQL_SAFE_UPDATES = 0;

-- Deactivate active Projects from 2017
UPDATE Project SET
IsActive = 0
WHERE DueDate BETWEEN '2017-01-01' AND '2017-12-31'
AND IsActive = 1;

-- Enable safe updates
SET SQL_SAFE_UPDATES = 1;

SET SQL_SAFE_UPDATES = 0;

UPDATE Task SET 
EstimatedHours = EstimatedHours * 1.25
WHERE WorkerId = 2; -- confused at to why this needed safety disabled

SET SQL_SAFE_UPDATES = 1;

INSERT INTO Worker (WorkerId, FirstName, LastName)
VALUES(50, 'Valentino', 'Newvill');

-- Delete our out-of-order WorkerId
DELETE FROM Worker
WHERE WorkerId = 50;

-- Safe updates also prevent DELETE
SET SQL_SAFE_UPDATES = 0;

DELETE FROM Worker
WHERE FirstName = 'Kingsly';

DELETE FROM ProjectWorker
WHERE FirstName = 'Kingsly';

DELETE FROM Worker
WHERE WorkerId = 2;

SET SQL_SAFE_UPDATES =1;

DELETE FROM Worker
WHERE FirstName = 'Kingsly';

SET SQL_SAFE_UPDATES = 0;

-- To delete record properly you must delete dependency first then original

-- Delete Tasks first since Task references ProjectWorker.
DELETE FROM Task
WHERE WorkerId = 2;

-- Delete ProjectWorker
-- That removes Kingsly from all projects.
DELETE FROM  ProjectWorker
WHERE workerId = 2;

-- Finally, remove Kingsly
DELETE FROM Worker
WHERE FirstName = 'Kingsly';

DELETE FROM Worker
WHERE WorkerId = 2; -- just checking to see if anything happened

SET SQL_SAFE_UPDATES = 1;








 