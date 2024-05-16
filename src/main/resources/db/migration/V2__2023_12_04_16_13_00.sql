CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact VARCHAR(255) NOT NULL,
    total_price NUMERIC NOT NULL,
    user_id INTEGER REFERENCES users(id)
);
