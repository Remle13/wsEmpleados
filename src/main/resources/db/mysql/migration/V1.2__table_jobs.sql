CREATE TABLE `jobs` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `salary` decimal(9,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`)
);

INSERT INTO jobs(id, name, salary) VALUES(1, 'Gerente', 75000.00);
INSERT INTO jobs(id, name, salary) VALUES(2, 'Scrum Master', 55000.00);
INSERT INTO jobs(id, name, salary) VALUES(3, 'Lider tecnico', 50000.00);
INSERT INTO jobs(id, name, salary) VALUES(4, 'Senior Dev', 45000.00);
INSERT INTO jobs(id, name, salary) VALUES(5, 'Junior Dev', 35000.00);