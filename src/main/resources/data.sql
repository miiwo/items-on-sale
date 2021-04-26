INSERT INTO Users(username, pass) VALUES 
('mango', 'pie'),
('testing', 'data');

INSERT INTO Products(name, price, category) VALUES
('PJs', 1.3, 'Clothing'),
('Dell 360', 45.6, 'Electronics'),
('One dollar', 1.0, 'Money'),
('PVR Box', 99.9, 'Electronics'),
('Bluetooth Speaker', 30.2, 'Electronics');

INSERT INTO Orders(product_id, user_id) VALUES
(1, 1);

INSERT INTO SaleItems(product_id) VALUES
(1),
(4);