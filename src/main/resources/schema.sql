CREATE TABLE worker (
    worker_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    position VARCHAR(255) NOT NULL
);