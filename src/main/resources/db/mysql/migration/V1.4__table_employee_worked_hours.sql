CREATE TABLE `employee_worked_hours` (
  `id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `worked_hours` int NOT NULL,
  `worked_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_EMPLOYEES` (`employee_id`),
  CONSTRAINT `FK_EMPLOYEES` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`)
);

INSERT INTO employee_worked_hours (id, employee_id, worked_hours, worked_date) 
VALUES (1, 1, 45, '2011-11-11');
INSERT INTO employee_worked_hours (id, employee_id, worked_hours, worked_date) 
VALUES (2, 2, 40, '2013-07-15');