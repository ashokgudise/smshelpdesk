CREATE TABLE subscribers (
  id SERIAL UNIQUE NOT NULL PRIMARY KEY,
  phone_number VARCHAR(50) NOT NULL,
  suscribed BOOLEAN DEFAULT FALSE NOT NULL
);