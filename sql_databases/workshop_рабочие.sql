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
-- Table structure for table `рабочие`
--

DROP TABLE IF EXISTS `рабочие`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `рабочие` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ФИО` varchar(30) DEFAULT NULL,
  `№_цеха` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `№_цеха` (`№_цеха`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `рабочие`
--

LOCK TABLES `рабочие` WRITE;
/*!40000 ALTER TABLE `рабочие` DISABLE KEYS */;
INSERT INTO `рабочие` VALUES (1,'Егоров Дмитрий Анатольевич',1),(2,'Иванов Павел Анатольевич',1),(3,'Петров Георий Иванович',1),(4,'Греков Алексей Игоревич',1),(5,'Лавров Игорь Алесеевич',1),(6,'Мяткин Павел Олегович',2),(7,'Ефремов Олег Даниилович',2),(8,'Сидоров Евгений Михайлович',2),(9,'Шевченко Юрий Денисович',2),(10,'Огурцов Илья Павлович',3),(11,'Суханов Иван Алексеевич',3),(12,'Воронов Георгий Евгеньевич',3),(13,'Волков Виталий Иванович',3),(14,'Воронцов Илья Евгеньевич',4),(15,'Дроздов Игорь Александрович',4),(16,'Рубцов Пётр Анатольевич',4),(17,'Мишин Александр Алексеевич',4);
/*!40000 ALTER TABLE `рабочие` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-12 19:13:43
