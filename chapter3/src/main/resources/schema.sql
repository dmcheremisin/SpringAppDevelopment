DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT into employee(name) values ('Dmitrii'), ('Irina');

DROP TABLE IF EXISTS worker;
CREATE TABLE worker (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT into worker(name, age) values ('Dmitrii', 31), ('Irina', 58);