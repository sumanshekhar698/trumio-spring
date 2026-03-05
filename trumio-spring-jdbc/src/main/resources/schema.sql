-- trumio_db.student definition

CREATE TABLE `student` (
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `name` varchar(100) NOT NULL,
                           `city` varchar(200) DEFAULT NULL,
                           `version` int NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;