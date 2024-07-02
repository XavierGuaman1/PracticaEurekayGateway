CREATE TABLE IF NOT EXISTS students(
    id SERIAL PRIMARY KEY,
    name VARCHAR(10),
    password VARCHAR(50),
    address VARCHAR(50)
    );