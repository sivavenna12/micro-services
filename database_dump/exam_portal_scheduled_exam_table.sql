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
-- Table structure for table `scheduled_exam_table`
--

DROP TABLE IF EXISTS `scheduled_exam_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scheduled_exam_table` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `exam_code` varchar(255) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `exam_duration` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `paper_id` bigint DEFAULT NULL,
  `show_results` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5fvrys28pf7q4mvi7knjoju19` (`exam_code`),
  KEY `FKhlif1m8utrd8p8s7xlu8v5nv6` (`paper_id`),
  CONSTRAINT `FKhlif1m8utrd8p8s7xlu8v5nv6` FOREIGN KEY (`paper_id`) REFERENCES `create_paper` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scheduled_exam_table`
--

LOCK TABLES `scheduled_exam_table` WRITE;
/*!40000 ALTER TABLE `scheduled_exam_table` DISABLE KEYS */;
INSERT INTO `scheduled_exam_table` VALUES (2,'TESTJ','2023-06-10 13:19:00.000000',5,'set10','2023-05-25 13:19:00.000000','active',1,_binary '\0'),(3,'JAVA','2023-06-10 18:44:00.000000',2,'javatest','2023-05-25 18:44:00.000000','active',2,_binary '\0'),(4,'456','2023-08-02 11:51:00.000000',2,'exam1','2023-08-01 11:51:00.000000','active',3,_binary '');
/*!40000 ALTER TABLE `scheduled_exam_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-02 12:40:35
