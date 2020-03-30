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