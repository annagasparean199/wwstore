CREATE TABLE cart (
    id SERIAL PRIMARY KEY,
    quantity INTEGER NOT NULL,
    product_id INTEGER REFERENCES products(id),
    user_id INTEGER REFERENCES users(id)
);