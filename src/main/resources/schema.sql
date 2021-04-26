DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Orders;
DROP TABLE IF EXISTS SaleItems;

CREATE TABLE Users (
    id int AUTO_INCREMENT,
    username VARCHAR(250) UNIQUE NOT NULL,
    pass VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Products (
    id int AUTO_INCREMENT,
    name VARCHAR(250) NOT NULL,
    price decimal NOT NULL,
    category VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Orders (
    product_id int,
    user_id int,
    FOREIGN KEY (product_id) REFERENCES Products(id),
    FOREIGN KEY (user_id) REFERENCES Users(id)
);

CREATE TABLE SaleItems (
    product_id int,
    PRIMARY KEY (product_id),
    FOREIGN KEY (product_id) REFERENCES Products(id)
);