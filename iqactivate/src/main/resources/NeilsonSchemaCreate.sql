Create database nielson;

use nielson;

CREATE TABLE Shoppingdetails (
    shopperid varchar(30),
    shelfid varchar(30),
    additional_info varchar(750),
    PRIMARY KEY (shopperid),
    UNIQUE (shelfid)
);

ALTER TABLE Shoppingdetails
ADD  time_created int(32);

ALTER TABLE Shoppingdetails
ADD  time_updated int(32);

CREATE TABLE shelf (
    productid varchar(30),
    score float(20,20),
    time_created int(32),
    time_updated int(32),
    additional_info varchar(750),
    PRIMARY KEY (productid)
);

desc shelf;

desc Shoppingdetails;

ALTER TABLE Shoppingdetails MODIFY time_created int(32) NOT NULL;
ALTER TABLE Shoppingdetails MODIFY time_updated int(32) NOT NULL;

ALTER TABLE shelf MODIFY score float(20,20) NOT NULL;
ALTER TABLE shelf MODIFY time_created int(32) NOT NULL;
ALTER TABLE shelf MODIFY time_updated int(32) NOT NULL;
ALTER TABLE shelf ADD shelfid varchar(30) PRIMARY KEY;

CREATE TABLE product (
    id varchar(30),
    category varchar(100),
    brand varchar(100),
    time_updated int(32),
    time_created int(32),
    additional_info varchar(750),
    PRIMARY KEY (id),
    time_created NOT NULL,
    time_updated NOT NULL
);