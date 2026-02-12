-- Run in pgAdmin (Query Tool) in DB: library_endterm
CREATE TABLE IF NOT EXISTS categories (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS books (
  id          SERIAL PRIMARY KEY,
  title       VARCHAR(200) NOT NULL,
  price       NUMERIC(10,2) NOT NULL CHECK (price > 0),
  category_id INT NOT NULL REFERENCES categories(id),
  book_type   VARCHAR(20) NOT NULL CHECK (book_type IN ('EBOOK','PRINTED'))
);

INSERT INTO categories(id, name) VALUES
(1, 'Science'),
(2, 'Programming'),
(3, 'History')
ON CONFLICT DO NOTHING;

INSERT INTO books(title, price, category_id, book_type) VALUES
('Java Programming', 45.00, 2, 'EBOOK'),
('Clean Code', 30.00, 2, 'PRINTED')
ON CONFLICT DO NOTHING;
