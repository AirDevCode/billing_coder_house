DROP TABLE IF EXISTS clients;
CREATE TABLE clients (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    document_type VARCHAR(255),
    document VARCHAR(255),
    name VARCHAR(255),
    last_name VARCHAR(255),
    email VARCHAR(255)
);

DROP TABLE IF EXISTS products;
CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_code VARCHAR(255),
    name VARCHAR(255),
    price DOUBLE,
    description TEXT,
    stock INT
);


DROP TABLE IF EXISTS sales;
CREATE TABLE sales (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date DATE,
    client_id BIGINT,
    sale_value DOUBLE,
    total DOUBLE,
    total_products INT,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);


DROP TABLE IF EXISTS sales_detail;
CREATE TABLE sales_detail (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sale_id BIGINT,
    product_id BIGINT,
    quantity INT,
    subtotal DOUBLE,
    FOREIGN KEY (sale_id) REFERENCES sales(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);