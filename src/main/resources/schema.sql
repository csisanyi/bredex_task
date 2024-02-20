-- Create table for Client entity
CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(255) UNIQUE,
    uuid VARCHAR(36) UNIQUE
);

-- Create table for Position entity
CREATE TABLE IF NOT EXISTS position (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(50),
    name VARCHAR(50)
);
