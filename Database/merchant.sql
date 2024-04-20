CREATE TABLE merchant (
    id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    merchant_name VARCHAR(100) NOT NULL,
    merchant_location VARCHAR(100) NOT NULL,
    status BOOLEAN
);