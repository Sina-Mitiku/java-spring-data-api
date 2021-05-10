DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS ideas;
CREATE TABLE ideas (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  appCategory_id int REFERENCES categories(id)
);