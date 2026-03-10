-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: trumio_db
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Learn Spring Boot and Hibernate from scratch.','Java Frameworks'),(2,'Complete MERN Stack to Deployment','MERN Stack'),(3,'Fundamentals & Advanced Go Lang','Go Lang'),(4,'Master C++ and OOPS','C++');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('20260106-01','trumio','db/changelog/changes/001-create-users-table.yaml','2026-01-06 11:41:41',1,'EXECUTED','9:83919b0557c7173dc88ffdf694fb2a90','createTable tableName=users','',NULL,'4.31.1',NULL,NULL,'7679899950'),('20260106-02','trumio','db/changelog/changes/002-seed-users.yaml','2026-01-06 11:41:41',2,'EXECUTED','9:1a3c417d346e7b6bc9e45c40cd9f8c64','insert tableName=users; insert tableName=users','',NULL,'4.31.1','(dev, qa)',NULL,'7679899950'),('20260107-01','code-county','db/changelog/changes/000-pre-setup-tables.yaml','2026-01-08 07:02:17',3,'MARK_RAN','9:ee7c91df3d9284dba1133dd390d68013','createTable tableName=student; createTable tableName=course; createTable tableName=student_course; addPrimaryKey constraintName=pk_student_course, tableName=student_course; addForeignKeyConstraint baseTableName=student_course, constraintName=fk_st...','',NULL,'4.31.1',NULL,NULL,'7835937205'),('20260107-02','code-county','db/changelog/changes/003-seed-pre-setup-tables.yaml','2026-01-08 07:02:17',4,'MARK_RAN','9:555e99629672b575b1d7a5501f4370e5','insert tableName=course; insert tableName=course; insert tableName=student; insert tableName=student; insert tableName=student_course; insert tableName=student_course','',NULL,'4.31.1',NULL,NULL,'7835937205');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangeloglock`
--

DROP TABLE IF EXISTS `databasechangeloglock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `databasechangeloglock` (
  `ID` int NOT NULL,
  `LOCKED` tinyint NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,0,NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `version` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'John Doe',NULL),(2,'Bob Wilson',NULL),(3,'Alice Smith',NULL);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `example_timestamp`
--

DROP TABLE IF EXISTS `example_timestamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `example_timestamp` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `DATA` varchar(100) NOT NULL,
  `CUR_TIMESTAMP` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `example_timestamp`
--

LOCK TABLES `example_timestamp` WRITE;
/*!40000 ALTER TABLE `example_timestamp` DISABLE KEYS */;
INSERT INTO `example_timestamp` VALUES (1,'TimeStamp Testing','2025-12-22 04:00:35'),(2,'TimeStamp Testing','2025-12-22 04:00:35'),(3,'the current time is','2025-12-22 04:00:35'),(4,'TimeStamp Testing','2025-12-22 04:00:37'),(5,'TimeStamp Testing','2025-12-22 04:00:37'),(6,'the current time is','2025-12-22 04:00:37'),(7,'TimeStamp Testing','2025-12-22 04:00:38'),(8,'TimeStamp Testing','2025-12-22 04:00:38'),(9,'the current time is','2025-12-22 04:00:38'),(10,'TimeStamp Testing','2025-12-22 04:03:39'),(11,'TimeStamp Testing','2025-12-22 04:03:39'),(12,'the current time is','2025-12-22 04:03:39'),(13,'TimeStamp Testing','2025-12-22 04:04:09'),(14,'TimeStamp Testing','2025-12-22 04:04:09'),(15,'the current time is','2025-12-22 04:04:09'),(16,'TimeStamp Testing','2025-12-22 04:07:05'),(17,'TimeStamp Testing','2025-12-22 04:07:05'),(18,'the current time is','2025-12-22 04:07:05'),(19,'TimeStamp Testing','2025-12-22 04:30:53'),(20,'TimeStamp Testing','2025-12-22 04:30:53'),(21,'the current time is','2025-12-22 04:30:53'),(22,'TimeStamp Testing','2025-12-22 04:30:54'),(23,'TimeStamp Testing','2025-12-22 04:30:54'),(24,'the current time is','2025-12-22 04:30:54'),(25,'TimeStamp Testing','2025-12-22 04:30:55'),(26,'TimeStamp Testing','2025-12-22 04:30:55'),(27,'the current time is','2025-12-22 04:30:55'),(28,'TimeStamp Testing','2025-12-22 04:30:58'),(29,'TimeStamp Testing','2025-12-22 04:30:58'),(30,'the current time is','2025-12-22 04:30:58'),(31,'TimeStamp Testing','2025-12-22 05:29:08'),(32,'TimeStamp Testing','2025-12-22 05:29:08'),(33,'the current time is','2025-12-22 05:29:08'),(34,'TimeStamp Testing','2025-12-22 06:04:36'),(35,'TimeStamp Testing','2025-12-22 06:04:36'),(36,'the current time is','2025-12-22 06:04:36'),(37,'TimeStamp Testing','2025-12-22 06:06:43'),(38,'TimeStamp Testing','2025-12-22 06:06:44'),(39,'the current time is','2025-12-22 06:06:44');
/*!40000 ALTER TABLE `example_timestamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `projects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb1eips329e5g70t014t1o8nte` (`emp_id`),
  CONSTRAINT `FKb1eips329e5g70t014t1o8nte` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
INSERT INTO `projects` VALUES (1,'Cloud Migration',1),(2,'Security Patch',1),(3,'Payroll Integration',2),(4,'Database Optimization',3),(5,'Mobile App API',3);
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `city` varchar(200) DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Balwinder','LA',1),(3,'Shalini','Bombay',0),(66,'Ritika','Bangalore',0),(99,'Shalini','Ooty',0),(100,'Sourabh','Miami',0),(102,'Rahul','Bangalore',2),(111,'Name Updated by User A','Delhi',1),(112,'John Doe','Berlin',0),(113,'Angelina','Mexico',2);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_course`
--

DROP TABLE IF EXISTS `student_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_course` (
  `student_id` bigint NOT NULL,
  `course_id` bigint NOT NULL,
  KEY `FKejrkh4gv8iqgmspsanaji90ws` (`course_id`),
  KEY `FKq7yw2wg9wlt2cnj480hcdn6dq` (`student_id`),
  CONSTRAINT `FKejrkh4gv8iqgmspsanaji90ws` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKq7yw2wg9wlt2cnj480hcdn6dq` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_course`
--

LOCK TABLES `student_course` WRITE;
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` VALUES (1,1),(113,2),(113,3);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `taskName` varchar(255) DEFAULT NULL,
  `worker_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3mkg5amon3gmqvqlval1r1dif` (`worker_id`),
  CONSTRAINT `FK3mkg5amon3gmqvqlval1r1dif` FOREIGN KEY (`worker_id`) REFERENCES `workers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tasks`
--

LOCK TABLES `tasks` WRITE;
/*!40000 ALTER TABLE `tasks` DISABLE KEYS */;
INSERT INTO `tasks` VALUES (1,'Code Review',4),(2,'Implement Cache',4),(3,'Fix Bugs',4),(4,'Database Migration',5),(5,'Performance Tuning',5),(6,'Write Tests',6),(7,'Prepare Report',6),(8,'Client Meeting',6),(9,'Code Review',7),(10,'Implement Cache',7),(11,'Fix Bugs',7),(12,'Database Migration',8),(13,'Performance Tuning',8),(14,'Write Tests',9),(15,'Prepare Report',9),(16,'Client Meeting',9);
/*!40000 ALTER TABLE `tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(20) NOT NULL,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_users_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'teacher','admin123','ROLE_ADMIN',_binary ''),(2,'suman','pass123','ROLE_STUDENT',_binary '');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workers`
--

DROP TABLE IF EXISTS `workers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workers`
--

LOCK TABLES `workers` WRITE;
/*!40000 ALTER TABLE `workers` DISABLE KEYS */;
INSERT INTO `workers` VALUES (4,'Rahul'),(5,'Suresh'),(6,'Anita'),(7,'Rahul'),(8,'Suresh'),(9,'Anita');
/*!40000 ALTER TABLE `workers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'trumio_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-11  2:21:43
