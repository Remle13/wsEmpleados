CREATE TABLE `jobs` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `salary` decimal(9,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`)
);

INSERT INTO jobs(id, name, salary) VALUES(1, 'Gerente', 467.50);
INSERT INTO jobs(id, name, salary) VALUES(2, 'Scrum Master', 343.25);
INSERT INTO jobs(id, name, salary) VALUES(3, 'Lider tecnico', 312.75);
INSERT INTO jobs(id, name, salary) VALUES(4, 'Senior Dev', 281.50);
INSERT INTO jobs(id, name, salary) VALUES(5, 'Junior Dev', 219.00);