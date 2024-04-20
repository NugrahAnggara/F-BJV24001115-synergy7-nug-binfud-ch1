CREATE TABLE order_detail (
    id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    quantity INTEGER Not NULL,
    total_price INTEGER NOT NULL,
    order INTEGER REFERENCES order(id),
    product INTEGER REFERENCES product(id),
);