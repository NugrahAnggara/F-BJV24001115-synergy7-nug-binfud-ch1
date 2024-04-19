CREATE TABLE order_detail (
    id int PRIMARY KEY NOT NULL,
    quantity INTEGER Not NULL,
    total_price INTEGER NOT NULL,
    order INTEGER REFERENCES order(id),
    product INTEGER REFERENCES product(id),
);