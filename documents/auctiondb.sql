create database auctiondb;
use auctiondb;

CREATE TABLE AuctionUser(
    userId int NOT NULL AUTO_INCREMENT,
    name varchar(255) ,
    dateOfBirth DATE,
    email varchar(255) UNIQUE,
    phoneNumber VARCHAR(12) ,
    username VARCHAR(255) ,
    pass VARCHAR(255) ,
    address VARCHAR(255) ,
    userType int ,
    walletAmt DOUBLE,
    PRIMARY KEY (userid)
);

CREATE TABLE ProductCategory(
    categoryId int PRIMARY KEY AUTO_INCREMENT,
    categoryName VARCHAR(255) NOT NULL UNIQUE,
    categoryDescription VARCHAR(255) NOT NULL
);

CREATE TABLE Product(
    productId int PRIMARY KEY AUTO_INCREMENT,
    productName VARCHAR(255) NOT NULL,
    productCategory VARCHAR(255) NOT NULL REFERENCES ProductCategory(categoryName),
    productDescription VARCHAR(255) NOT NULL,
    productPrice DOUBLE NOT NULL,
    productQuantity INTEGER NOT NULL,
    productImage VARCHAR(255) NOT NULL,
    sellerId INTEGER NOT NULL REFERENCES AuctionUser(userId)
);

CREATE TABLE Bid(
    bidId int PRIMARY KEY AUTO_INCREMENT,
    bidderId INTEGER NOT NULL REFERENCES AuctionUser(userId),
    bidProductId INTEGER NOT NULL REFERENCES Product(productId),
    bidValue DOUBLE NOT NULL,
    bidStatus INTEGER NOT NULL
);

CREATE TABLE ProductForAuction(
    minBidValue INTEGER NOT NULL,
    bidStartDate DATE  NOT NULL,
    bidEndDate DATE NOT NULL,
    buyerId INTEGER REFERENCES AuctionUser(userId),
    soldPrice DOUBLE,
    bidStatus INTEGER NOT NULL
);
