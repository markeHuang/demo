-- create database
Create DATABASE IF NOT EXISTS smme_db default charset utf8 COLLATE utf8_general_ci;

-- create user
CREATE USER smme IDENTIFIED BY 'smme_123456';

-- GRANT privileges
GRANT All ON smme_db.* TO smme;

-- flush privileges
flush privileges;