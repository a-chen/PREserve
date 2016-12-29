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
		REFERENCES tables(id),
	FOREIGN KEY (customer_id)
		REFERENCES customer(id)
);

CREATE TABLE orders(
	id INT NOT NULL AUTO_INCREMENT,
    reservation_id INT NOT NULL,
    customer_id INT NOT NULL,
    
    PRIMARY KEY (id),
    FOREIGN KEY (reservation_id)
		REFERENCES reservation(id),
	FOREIGN KEY (customer_id)
		REFERENCES customer(id)
);

CREATE TABLE order_item(
	orders_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT NOT NULL,
    
    FOREIGN KEY (orders_id)
		REFERENCES orders(id),
	FOREIGN KEY (item_id)
		REFERENCES item(id),
	PRIMARY KEY (orders_id, item_id)
);

#see tables
show tables;

drop table reservation_table;

#check foreign keys
SHOW CREATE TABLE `reservation`;