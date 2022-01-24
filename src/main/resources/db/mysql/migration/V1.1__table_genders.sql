CREATE TABLE `genders` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO genders(id, name) VALUES(1, 'Hombre');
INSERT INTO genders(id, name) VALUES(2, 'Mujer');
INSERT INTO genders(id, name) VALUES(3, 'Otro');