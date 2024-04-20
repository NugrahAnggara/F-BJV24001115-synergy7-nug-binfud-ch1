CREATE TABLE order (
    id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    order_time CURRENT_DATE NOT NULL,
    destination_address VARCHAR(100) NOT NULL,
    id_user INTEGER REFERENCES users(id)
);