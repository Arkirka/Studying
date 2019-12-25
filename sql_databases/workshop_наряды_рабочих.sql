-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: workshop
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `наряды_рабочих`
--

DROP TABLE IF EXISTS `наряды_рабочих`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `наряды_рабочих` (
  `shift_id` int(11) NOT NULL AUTO_INCREMENT,
  `№_цеха` int(11) DEFAULT NULL,
  `месяц` int(11) DEFAULT NULL,
  `техОперация` text,
  `количество` int(11) DEFAULT NULL,
  `расценка` int(11) DEFAULT NULL,
  `сумма` int(11) DEFAULT NULL,
  PRIMARY KEY (`shift_id`),
  KEY `№_цеха_idx` (`№_цеха`) /*!80000 INVISIBLE */,
  KEY `№_цеха` (`№_цеха`),
  CONSTRAINT `№_цеха` FOREIGN KEY (`№_цеха`) REFERENCES `рабочие` (`№_цеха`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `наряды_рабочих`
--

LOCK TABLES `наряды_рабочих` WRITE;
/*!40000 ALTER TABLE `наряды_рабочих` DISABLE KEYS */;
INSERT INTO `наряды_рабочих` VALUES (9,1,1,'установка оборудования',5,5000,100000),(10,2,2,'настройка',5,5000,100000),(11,3,3,'подготовка',5,3000,60000),(12,4,4,'выполнение заказов',10,1000,40000),(13,1,5,'починка',3,3000,36000),(14,2,6,'изготовление заказов',10,1000,40000),(15,3,7,'перенастройка',5,5000,100000);
/*!40000 ALTER TABLE `наряды_рабочих` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-12 19:13:44
