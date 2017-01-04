#creating tables and primary keys
CREATE TABLE tables(
	id INT NOT NULL AUTO_INCREMENT,
    capacity INT NOT NULL,
    
    PRIMARY KEY (id)
);

CREATE TABLE item(
	id INT NOT NULL AUTO_INCREMENT,
    price DECIMAL(13,2) NOT NULL,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(50),
    
    PRIMARY KEY (id)
);

CREATE TABLE customer(
	id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    username VARCHAR (20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    
    PRIMARY KEY (id),
    UNIQUE (username)
);

CREATE TABLE reservation(
	id INT NOT NULL AUTO_INCREMENT,
    date DATETIME NOT NULL,
    tables_id INT NOT NULL,
    customer_id INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (tables_id)
		REFERENCES tables(id)
        ON DELETE CASCADE,
	FOREIGN KEY (customer_id)
		REFERENCES customer(id)
        ON DELETE CASCADE
);

CREATE TABLE orders(
	id INT NOT NULL AUTO_INCREMENT,
    reservation_id INT NOT NULL,
    customer_id INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (reservation_id)
		REFERENCES reservation(id)
        ON DELETE CASCADE,
	FOREIGN KEY (customer_id)
		REFERENCES customer(id)
        ON DELETE CASCADE
);

CREATE TABLE order_item(
	id INT NOT NULL AUTO_INCREMENT,
	orders_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (orders_id)
		REFERENCES orders(id)
        ON DELETE CASCADE,
	FOREIGN KEY (item_id)
		REFERENCES item(id)
		ON DELETE CASCADE
);

#Test Data

#tables
INSERT INTO tables (id, capacity) VALUES (1, 6);
INSERT INTO tables (capacity) VALUES (6);
INSERT INTO tables (capacity) VALUES (6);
INSERT INTO tables (capacity) VALUES (2);
INSERT INTO tables (capacity) VALUES (2);
INSERT INTO tables (capacity) VALUES (2);
INSERT INTO tables (capacity) VALUES (8);

INSERT INTO customer (id, first_name, last_name, username, email, phone) VALUES (1, 'Jason', 'Bourne', 'bourne2win', 'jasonbourne@gmail.com',  '3829879876');

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

#
#SET FOREIGN_KEY_CHECKS = 0;
#drop table order_item;
#drop table reservation;
#drop table customer;
#drop table item;
#drop table orders;
#drop table tables;
#SET FOREIGN_KEY_CHECKS = 1;