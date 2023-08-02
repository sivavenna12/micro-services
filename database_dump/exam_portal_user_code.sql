-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exam_portal
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_code`
--

DROP TABLE IF EXISTS `user_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_code` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` longblob,
  `iscorrect` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  `exam_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKowu1brf4dbr3l5un49k1mcaqa` (`question_id`),
  KEY `FKrsfngf3b24k1bp3ttm9ukount` (`exam_id`),
  KEY `FK5h8mxl3f5wvhvywksxt2yv9ie` (`user_id`),
  CONSTRAINT `FK5h8mxl3f5wvhvywksxt2yv9ie` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKowu1brf4dbr3l5un49k1mcaqa` FOREIGN KEY (`question_id`) REFERENCES `coding_questions` (`id`),
  CONSTRAINT `FKrsfngf3b24k1bp3ttm9ukount` FOREIGN KEY (`exam_id`) REFERENCES `scheduled_exam_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_code`
--

LOCK TABLES `user_code` WRITE;
/*!40000 ALTER TABLE `user_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_code` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-02 12:40:36
