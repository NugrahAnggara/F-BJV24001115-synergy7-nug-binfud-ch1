CREATE TABLE users (
    id uuid PRIMARY KEY NOT NULL DEFAULT gen_random_uuid(),
    usename VARCHAR(100) NOT NULL,
    email_address VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
);