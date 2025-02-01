-- Drop existing tables if they exist
DROP TABLE IF EXISTS worker;
DROP TABLE IF EXISTS engineer;


CREATE TABLE worker (
    worker_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    position VARCHAR(255) NOT NULL
);


CREATE TABLE engineer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255),
    department VARCHAR(255),
    role VARCHAR(255)
);