CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(50) CHECK((role in ('USER','SELLER','ADMIN'))) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);