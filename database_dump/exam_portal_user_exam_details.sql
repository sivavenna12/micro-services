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
-- Table structure for table `user_exam_details`
--

DROP TABLE IF EXISTS `user_exam_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_exam_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_duration` int NOT NULL,
  `login_time` time DEFAULT NULL,
  `logout_time` time DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `exam_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmb3cxjrsiicksu7el6dvti3n` (`exam_id`),
  KEY `FKamv6wrq8wcohythsb4u83yuyw` (`user_id`),
  CONSTRAINT `FKamv6wrq8wcohythsb4u83yuyw` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKmb3cxjrsiicksu7el6dvti3n` FOREIGN KEY (`exam_id`) REFERENCES `scheduled_exam_table` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_exam_details`
--

LOCK TABLES `user_exam_details` WRITE;
/*!40000 ALTER TABLE `user_exam_details` DISABLE KEYS */;
INSERT INTO `user_exam_details` VALUES (1,2,'15:36:30','15:39:50','completed',3,5),(2,2,'11:02:03','11:03:30','completed',3,7),(3,2,'11:05:33','11:07:59','completed',3,8),(4,2,'12:02:56','12:02:56','inprogress',4,2),(5,2,'12:02:56','12:02:56','inprogress',4,2),(6,2,'12:36:23','12:36:41','completed',4,3),(7,2,'15:41:44','15:42:01','completed',4,7);
/*!40000 ALTER TABLE `user_exam_details` ENABLE KEYS */;
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
