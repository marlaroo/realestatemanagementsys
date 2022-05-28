SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS buy;
DROP TABLE IF EXISTS rent;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS owner;
DROP TABLE IF EXISTS type;




/* Create Tables */

CREATE TABLE buy
(
	id int NOT NULL,
	price int NOT NULL,
	selling_date date NOT NULL,
	customer_id int NOT NULL,
	property_id int NOT NULL,
	UNIQUE (property_id)
);


CREATE TABLE customer
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	email varchar(100),
	phone varchar(15) NOT NULL,
	address varchar(255) NOT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE owner
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(50) NOT NULL,
	email varchar(100) NOT NULL,
	phone varchar(15) NOT NULL,
	address varchar(255) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id)
);


CREATE TABLE property
(
	id int NOT NULL AUTO_INCREMENT,
	area varchar(255) NOT NULL,
	price int NOT NULL,
	address varchar(255) NOT NULL,
	update_date date NOT NULL,
	status varchar(255),
	type_id int NOT NULL,
	owner_id int NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (owner_id)
);


CREATE TABLE rent
(
	id int NOT NULL AUTO_INCREMENT,
	price int NOT NULL,
	deposite int NOT NULL,
	from_date date NOT NULL,
	to_date date NOT NULL,
	customer_id int NOT NULL,
	property_id int NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (property_id)
);


CREATE TABLE type
(
	id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	description varchar(255),
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE buy
	ADD FOREIGN KEY (customer_id)
	REFERENCES customer (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent
	ADD FOREIGN KEY (customer_id)
	REFERENCES customer (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE property
	ADD FOREIGN KEY (owner_id)
	REFERENCES owner (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE buy
	ADD FOREIGN KEY (property_id)
	REFERENCES property (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rent
	ADD FOREIGN KEY (property_id)
	REFERENCES property (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE property
	ADD FOREIGN KEY (type_id)
	REFERENCES type (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



