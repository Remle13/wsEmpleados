CREATE TABLE `employees` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gender_id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `birthdate` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uidx` (`name`,`last_name`),
  KEY `FK_GENDERS` (`gender_id`),
  KEY `FK_JOBS` (`job_id`),
  CONSTRAINT `FK_GENDERS` FOREIGN KEY (`gender_id`) REFERENCES `genders` (`id`),
  CONSTRAINT `FK_JOBS` FOREIGN KEY (`job_id`) REFERENCES `jobs` (`id`)
);

INSERT INTO employees (id, gender_id, job_id, name, last_name, birthdate) 
VALUES (1, 1, 1, 'Elmer', 'López', '1990-02-13');
INSERT INTO employees (id, gender_id, job_id, name, last_name, birthdate) 
VALUES (2, 3, 3, 'Xavier', 'Rodriguez', '1923-11-05');