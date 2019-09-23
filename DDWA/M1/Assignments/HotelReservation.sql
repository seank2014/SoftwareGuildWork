DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel;

USE Hotel;

CREATE TABLE HotelRoom (
HotelRoomNumber INT PRIMARY KEY,
RoomTypeId INT NOT NULL,
HotelFloor INT NOT NULL,
RoomType VARCHAR(45) NOT NULL,
RoomLimit INT NOT NULL
);

CREATE TABLE NumberOfRooms(
NumberId INT PRIMARY KEY AUTO_INCREMENT,
Number INT NOT NULL
);

CREATE TABLE RoomOccupants(
RoomOccupantsId INT PRIMARY KEY AUTO_INCREMENT,
RoomOccupantsName VARCHAR(45) NOT NULL,
OccupantAge CHAR(50) NOT NULL
);

CREATE TABLE CustomerInfo(
CustomerInfoId INT PRIMARY KEY AUTO_INCREMENT,
Name CHAR(50) NOT NULL,
Address VARCHAR(45) NOT NULL,
Telephone CHAR(50) NOT NULL,
Email VARCHAR(45) NOT NULL,
RoomOccupantsId INT NOT NULL,
NumberId INT NOT NULL,
FOREIGN KEY fk_CustomerInfo_RoomOccupants(RoomOccupantsId)
REFERENCES RoomOccupants(RoomOccupantsId),
FOREIGN KEY fk_CustomerInfo_NumberOfRooms(NumberId)
REFERENCES NumberOfRooms(NumberId)
);

CREATE TABLE HotelAmentitiesQuantity(
QuantityId INT PRIMARY KEY AUTO_INCREMENT,
Amount INT NOT NULL
);

CREATE TABLE HotelAmentities(
AmentitiesId INT PRIMARY KEY AUTO_INCREMENT,
Type VARCHAR(100) NOT NULL,
QuantityId INT NOT NULL,
FOREIGN KEY fk_HotelAmentities_HotelAmentitiesQuantity(QuantityId)
REFERENCES HotelAmentitiesQuantity(QuantityId)
);

CREATE TABLE HotelRoomAmentites(
HotelRoomNumber INT NOT NULL,
AmentitiesId INT NOT NULL,
PRIMARY KEY pk_HotelRoomAmentites(HotelRoomNumber, AmentitiesId),
FOREIGN KEY fk_HotelRoomAmentities_HotelRoom(HotelRoomNumber)
REFERENCES HotelRoom(HotelRoomNumber),
FOREIGN KEY fk_HotelRoomAmentites_HotelAmentities(AmentitiesId)
REFERENCES HotelAmentities(AmentitiesId)
);

CREATE TABLE PromotionCode(
PromotionCodeId INT PRIMARY KEY AUTO_INCREMENT,
Type VARCHAR(45) NOT NULL
);

CREATE TABLE TypeOfSeason(
SeasonId INT PRIMARY KEY AUTO_INCREMENT,
SeasonName VARCHAR(45) NOT NULL
);

CREATE TABLE HotelPriceTotal(
TotalId INT PRIMARY KEY AUTO_INCREMENT,
PromotionCodeId INT NOT NULL,
SeasonId INT NOT NULL,
RoomOccupantsId INT NOT NULL,
HotelRoomNumber INT NOT NULL,
AmentitiesId INT NOT NULL,
FOREIGN KEY fk_HotelPriceTotal_PromotionCode(PromotionCodeId)
REFERENCES PromotionCode(PromotionCodeId),
FOREIGN KEY fk_HotelPriceTotal_TypeOfSeason(SeasonId)
REFERENCES TypeOfSeason(SeasonId),
FOREIGN KEY fk_HotelPriceTotal_CustomerInfo(RoomOccupantsId)
REFERENCES CustomerInfo(RoomOccupantsId),
FOREIGN KEY fk_HotelPriceTotal_HotelRoomAmentities(HotelRoomNumber, AmentitiesId)
REFERENCES HotelRoomAmentites(HotelRoomNumber, AmentitiesId)
);

CREATE TABLE HotelBilling(
BillingId INT PRIMARY KEY AUTO_INCREMENT,
Description CHAR(50) NOT NULL,
Amount DECIMAL(6,2) NOT NULL,
TotalId INT NOT NULL,
CustomerInfoId INT NOT NULL,
RoomOccupantsId INT NOT NULL,
FOREIGN KEY fk_HotelBilling_HotelPriceTotal(TotalId)
REFERENCES HotelPriceTotal(TotalId),
FOREIGN KEY fk_HotelBilling_CustomerInfo(CustomerInfoId)
REFERENCES CustomerInfo(CustomerInfoId)
);






