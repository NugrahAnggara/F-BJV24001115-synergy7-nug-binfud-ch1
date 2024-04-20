CREATE TABLE product (
    id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    product_name VARCHAR(100) NOT NULL,
    price INTEGER NOT NULL,
    id_merchant INTEGER REFERENCES merchant(id)
);