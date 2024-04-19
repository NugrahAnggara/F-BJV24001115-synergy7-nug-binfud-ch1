CREATE TABLE order (
    id int PRIMARY KEY NOT NULL,
    order_time CURRENT_DATE NOT NULL,
    destination_address VARCHAR(100) NOT NULL,
    id_user INTEGER REFERENCES users(id)
);