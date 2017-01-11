#creating tables and primary keys
CREATE TABLE tables(
	tables_id INT NOT NULL AUTO_INCREMENT,
    capacity INT NOT NULL,
    
    PRIMARY KEY (tables_id)
);

CREATE TABLE item(
	item_id INT NOT NULL AUTO_INCREMENT,
    price DECIMAL(13,2) NOT NULL,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(50),
    
    PRIMARY KEY (item_id)
);

CREATE TABLE customer(
	customer_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    username VARCHAR (20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    
    PRIMARY KEY (customer_id),
    UNIQUE (username)
);

CREATE TABLE reservation(
	reservation_id INT NOT NULL AUTO_INCREMENT,
    date DATETIME NOT NULL,
    tables_id INT NOT NULL,
    customer_id INT NOT NULL,
    
    PRIMARY KEY (reservation_id),
    FOREIGN KEY (tables_id)
		REFERENCES tables(tables_id)
        ON DELETE CASCADE,
	FOREIGN KEY (customer_id)
		REFERENCES customer(customer_id)
        ON DELETE CASCADE
);

CREATE TABLE orders(
	orders_id INT NOT NULL AUTO_INCREMENT,
    reservation_id INT NOT NULL,
    
    PRIMARY KEY (orders_id),
    FOREIGN KEY (reservation_id)
		REFERENCES reservation(reservation_id)
        ON DELETE CASCADE
);

CREATE TABLE orderItem(
	order_item_id INT NOT NULL AUTO_INCREMENT,
	orders_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (orders_id)
		REFERENCES orders(orders_id)
        ON DELETE CASCADE,
	FOREIGN KEY (item_id)
		REFERENCES item(item_id)
        ON DELETE CASCADE	
);

#check foreign keys
#SHOW CREATE TABLE `reservation`;

#Test Data

#tables
INSERT INTO tables (tables_id, capacity) VALUES (1, 6);
INSERT INTO tables (capacity) VALUES (6);
INSERT INTO tables (capacity) VALUES (6);
INSERT INTO tables (capacity) VALUES (2);
INSERT INTO tables (capacity) VALUES (2);
INSERT INTO tables (capacity) VALUES (2);
INSERT INTO tables (capacity) VALUES (8);

#customer
INSERT INTO customer (customer_id, first_name, last_name, username, email, phone) VALUES (1, 'Jason', 'Bourne', 'bourne2win', 'jasonbourne@gmail.com',  '3829879876');

#items
INSERT INTO item 
	VALUES(1, 10.0, 'Regular Pizza', '18 inch classic pizza pie.');

INSERT INTO item(price, name, description) 
	VALUES(15.0, 'Anchovy Pizza', '18 inch pizza pie with anchovies.');
    
INSERT INTO item(price, name, description)  
	VALUES(15.0, 'Hawaiian Pizza', '18 inch pizza pie with ham and pineapple');
    
INSERT INTO item(price, name, description) 
	VALUES(15.0, 'French Fries Pizza', '18 inch pizza pie topped with french fries');

commit;

#run below to drop all tables while ignoring foreign key constraints

SET FOREIGN_KEY_CHECKS = 0;
drop table orderItem;
drop table reservation;
drop table customer;
drop table item;
drop table orders;
drop table tables;

show tables;

SET FOREIGN_KEY_CHECKS = 1;
