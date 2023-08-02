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
-- Table structure for table `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_answers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_answer` varchar(255) DEFAULT NULL,
  `exam_id` bigint DEFAULT NULL,
  `question_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKes2tn5o2cb2xowfas814nnkdv` (`exam_id`),
  KEY `FKm6hug73jyq6ginnh6tppmauxq` (`question_id`),
  KEY `FKk4u357ronsopa0vqf16deuxbt` (`user_id`),
  CONSTRAINT `FKes2tn5o2cb2xowfas814nnkdv` FOREIGN KEY (`exam_id`) REFERENCES `scheduled_exam_table` (`id`),
  CONSTRAINT `FKk4u357ronsopa0vqf16deuxbt` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKm6hug73jyq6ginnh6tppmauxq` FOREIGN KEY (`question_id`) REFERENCES `question_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answers`
--

LOCK TABLES `user_answers` WRITE;
/*!40000 ALTER TABLE `user_answers` DISABLE KEYS */;
INSERT INTO `user_answers` VALUES (1,'B',3,2,5),(2,'A',3,3,5),(3,'A',3,4,5),(4,'A',3,5,5),(5,'A',3,5,7),(6,'A',3,2,7),(7,'B',3,4,7),(8,'A',3,3,7),(9,'A',3,4,8),(10,'A',3,3,8),(11,'A',3,5,8),(12,'D',3,2,8),(13,'B',4,311,2),(14,'B',4,322,2),(15,'A',4,311,3),(16,'A',4,322,3),(17,'C',4,322,7),(18,'C',4,311,7);
/*!40000 ALTER TABLE `user_answers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-02 12:40:34
