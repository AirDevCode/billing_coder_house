INSERT INTO clients (document_type, document, name, last_name, email) VALUES
('DNI', '12345678A', 'Carla', 'Gallardo', 'juan.perez@email.com'),
('NIE', 'X87654321', 'Ana', 'Lizarazo', 'ana.gomez@email.com'),
('PASSPORT', 'AB123456', 'Carlos', 'Ruiz', 'carlos.ruiz@email.com'),
('DNI', '98765432B', 'Marta', 'Mora', 'maria.lopez@email.com'),
('NIE', 'Y98765432', 'Pedro', 'Baranoa', 'pedro.sanchez@email.com');

INSERT INTO products (product_code, name, price, description, stock) VALUES
('P001', 'Laptop', 999.99, 'Powerful laptop for professional use', 100),
('P002', 'Smartphone', 299.99, 'High-end smartphone with advanced features', 500),
('P003', 'Headphones', 79.99, 'Over-ear headphones with noise cancellation', 450),
('P004', 'Tablet', 199.99, 'Compact tablet for entertainment on the go', 350),
('P005', 'Camera', 499.99, 'Digital camera with high-resolution sensor', 230);


/* 
INSERT INTO sales (date, client_id, salevalue) VALUES
('2024-01-23', 1, 1200.00),
('2024-01-24', 3, 899.99),
('2024-01-25', 2, 350.00),
('2024-01-26', 4, 450.00),
('2024-01-27', 5, 1800.00);

INSERT INTO salesDetail (sale_id, product_id, quantity, subtotal) VALUES
(1, 1, 2, 1999.98),
(2, 3, 1, 79.99),
(3, 2, 3, 899.97),
(4, 4, 2, 399.98),
(5, 5, 1, 499.99); 
*/