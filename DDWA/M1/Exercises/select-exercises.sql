use PersonalTrainer;

-- Select all rows and columns from the Exercise table.
-- 64 rows

Select * from Exercise;

--------------------
-- Select all rows and columns from the Client table.
-- 500 rows

select * from client;
--------------------
-- Write your query here.

-- Select all columns from Client where the City is Metairie.
-- 29 rows

select * from Client WHERE City = 'Metairie';
--------------------

-- Is there a Client with the ClientId '818u7faf-7b4b-48a2-bf12-7a26c92de20c'?
select * from client where clientId = '818u7faf-7b4b-48a2-bf12-7a26c92de20c';
-- nope


--------------------
-- How many rows in the Goal table?
-- 17 rows

select * from goal;

--------------------

-- Select Name and LevelId from the Workout table.
-- 26 rows

select
`Name`,
LevelId
From
workout;

--------------------

-- Select Name, LevelId, and Notes from Workout where LevelId is 2.
-- 11 rows

select 
`Name`,
LevelId,
`Notes`
From workout
Where levelId = 2;
--------------------

-- Select FirstName, LastName, and City from Client 
-- where City is Metairie, Kenner, or Gretna.
-- 77 rows

select 
`FirstName`,
`LastName`,
`City`
from client
Where `City` IN ('Metairie', 'Kenner', 'Gretna');
--------------------

-- Select FirstName, LastName, and BirthDate from Client
-- for Clients born in the 1980s.
-- 72 rows

select 
`FirstName`,
`LastName`,
BirthDate
From client
where BirthDate between '1980-01-01' and '1989-12-31';

--------------------

-- Write the query above in a different way. 
-- If you used BETWEEN, you can't use it again.
-- If you didn't use BETWEEN, use it!
-- Still 72 rows

select 
`FirstName`,
`LastName`,
BirthDate
From client
where BirthDate <= '1989-12-31' 
and BirthDate >= '1980-01-01';

--------------------

-- How many rows in the Login table have a .gov EmailAddress?
-- 17 rows

select * from login
where `EmailAddress` Like '%.gov';


--------------------

-- How many Logins do NOT have a .com EmailAddress?
-- 122 rows

select * from login 
where `EmailAddress` not like '%.com';

--------------------

-- Select first and last name of Clients without a BirthDate.
-- 37 rows

select 
`FirstName`,
`LastName`
from client
where BirthDate IS NULL;
--------------------

-- Select the Name of each ExerciseCategory that has a parent.
-- (ParentCategoryId value is not null)
-- 12 rows

select
`Name`
from ExerciseCategory where 
ParentCategoryId IS NOT NULL;
--------------------

-- Select Name and Notes of each level 3 Workout that
-- contains the word 'you' in its Notes.
-- 4 rows

select 
`Name`,
`Notes`
from workout
where levelId = 3 and `Notes` Like '%you%';
--------------------

-- Select FirstName, LastName, City from Clients who have a LastName
-- that starts with L,M, or N and who live in LaPlace.
-- 5 rows

select 
`FirstName`,
`LastName`,
`City`
from client
where (`LastName` like 'l%' or `LastName` like 'm%' or `LastName` like 'n%') and
`City` = 'LaPlace';
--------------------

-- Select InvoiceId, Description, Price, Quantity, ServiceDate 
-- and the line item total, a calculated value, where the line item total
-- is between 15 and 25 dollars.
-- 667 rows

select 
InvoiceId,
`Description`,
Price,
Quantity,
ServiceDate,
price * quantity
from InvoiceLineItem
where price * quantity between 15 and  25;

--------------------

-- Does the Client, Estrella Bazely, have a Login? 
-- If so, what is her email address?
-- This requires two queries:
-- First, select a Client record for Estrella Bazely. Does it exist?
-- Second, if it does, select a Login record that matches its ClientId.

select * from client where
`FirstName` = 'Estrella'
and `LastName` = 'Bazely';

select * from login
where clientId = '87976c42-9226-4bc6-8b32-23a8cd7869a5';

--------------------

-- What are the Goals of the Workout with the Name 'This Is Parkour'?
-- You need three queries!:
-- 1. Select the WorkoutId from Workout where Name equals 'This Is Parkour'.
-- 2. Select GoalId from WorkoutGoal where the WorkoutId matches the WorkoutId
--    from your first query.
-- 3. Select everything from Goal where the GoalId is one of the GoalIds from your
--    second query.
-- 1 row, 3 rows, 3 rows

select
workoutId
from workout
where `Name` = 'This Is Parkour';

select 
goalId 
from workoutgoal
where workoutId = 12;

select * from 
goal where goalId = 3;
 
 select * from 
goal where goalId = 8;

select * from 
goal where goalId = 15;
--------------------
