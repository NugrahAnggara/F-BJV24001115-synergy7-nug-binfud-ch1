CREATE TABLE product (
    id int PRIMARY KEY NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    price INTEGER NOT NULL,
    id_merchant INTEGER REFERENCES merchant(id)
);