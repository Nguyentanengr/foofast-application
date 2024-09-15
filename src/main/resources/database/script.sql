CREATE DATABASE foofast_db;
USE foofast_db;

CREATE TABLE `users` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) DEFAULT NULL,
    `day_of_birth` date DEFAULT NULL,
    `last_name` VARCHAR(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
	`username` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_users_username_dkfj` (`username`)
)  ENGINE=InnoDB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO users (`first_name`, `last_name`, `username`, `password`, `day_of_birth`)
VALUES
	('John', 'Doe', 'johndoe1', 'password123', '1990-01-01'),
    ('Jane', 'Smith', 'janesmith1', 'password123', '1992-02-02'),
    ('Robert', 'Johnson', 'robertj1', 'password123', '1988-03-03'),
    ('Emily', 'Davis', 'emilyd1', 'password123', '1994-04-04'),
    ('Michael', 'Brown', 'michaelb1', 'password123', '1985-05-05'),
    ('Sarah', 'Taylor', 'saraht1', 'password123', '1991-06-06'),
    ('David', 'Wilson', 'davidw1', 'password123', '1987-07-07'),
    ('Laura', 'Moore', 'lauram1', 'password123', '1993-08-08'),
    ('James', 'Anderson', 'jamesa1', 'password123', '1986-09-09'),
    ('Mary', 'Thomas', 'maryt1', 'password123', '1995-10-10'),
    ('Christopher', 'Jackson', 'chrisj1', 'password123', '1989-11-11'),
    ('Patricia', 'White', 'patriciaw1', 'password123', '1996-12-12'),
    ('Linda', 'Harris', 'lindah1', 'password123', '1997-01-13'),
    ('Charles', 'Martin', 'charlesm1', 'password123', '1984-02-14'),
    ('Elizabeth', 'Lee', 'elizabethl1', 'password123', '1983-03-15'),
    ('Joseph', 'Perez', 'josephp1', 'password123', '1998-04-16'),
    ('Karen', 'Garcia', 'kareng1', 'password123', '1981-05-17'),
    ('William', 'Martinez', 'williamm1', 'password123', '1982-06-18'),
    ('Barbara', 'Rodriguez', 'barbarar1', 'password123', '1979-07-19'),
    ('Matthew', 'Lopez', 'matthewl1', 'password123', '1980-08-20'),
    ('Jessica', 'Gonzalez', 'jessicag1', 'password123', '1999-09-21'),
    ('George', 'Wilson', 'georgew1', 'password123', '1986-10-22'),
    ('Ashley', 'Clark', 'ashleyc1', 'password123', '1990-11-23'),
    ('Brian', 'Lewis', 'brianl1', 'password123', '1992-12-24');
	