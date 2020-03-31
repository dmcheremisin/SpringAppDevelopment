DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `job_title` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `salary` int(11),
  PRIMARY KEY (`id`)
);

INSERT INTO employee(first_name, last_name, job_title, department, salary)
VALUES
('Dmitrii', 'Cheremisin', 'Software Developer', 'IT', 100000),
('Irina', 'Cheremisina', 'CEO', 'Administration', 200000);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
   `username` varchar(45) NOT NULL,
   `password` varchar(80) NOT NULL,
   `enabled` boolean,
   PRIMARY KEY (`username`)
);

DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
    `username` varchar(45) NOT NULL,
    `role` varchar(45) NOT NULL,
    PRIMARY KEY (`username`)
);

INSERT INTO `users`(username, password, enabled)
VALUES
('john', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', true),
('mary', '$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K', true);

INSERT INTO `users_roles`(username, role)
VALUES
('john', 'ROLE_ADMIN'),
('mary', 'ROLE_USER');