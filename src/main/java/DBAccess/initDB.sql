CREATE DATABASE  IF NOT EXISTS `fogcarport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fogcarport`;
-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: fogcarport
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `carport_materials`
--

DROP TABLE IF EXISTS `carport_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_materials` (
  `material_id` int(11) NOT NULL AUTO_INCREMENT,
  `material_name` varchar(45) NOT NULL,
  `material_price_m` double NOT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_materials`
--

LOCK TABLES `carport_materials` WRITE;
/*!40000 ALTER TABLE `carport_materials` DISABLE KEYS */;
INSERT INTO `carport_materials` VALUES (1,'Egetræsplader',795),(2,'Bøgetræsplade',1000),(3,'Plastiktræ',400);
/*!40000 ALTER TABLE `carport_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_calcs`
--

DROP TABLE IF EXISTS `customer_calcs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_calcs` (
  `customer_calcs_id` int(11) NOT NULL AUTO_INCREMENT,
  `cp_length` int(11) NOT NULL,
  `cp_width` int(11) NOT NULL,
  `roof_angle` int(11) DEFAULT NULL,
  `shed_length` int(11) DEFAULT NULL,
  `shed_width` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_calcs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_calcs`
--

LOCK TABLES `customer_calcs` WRITE;
/*!40000 ALTER TABLE `customer_calcs` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_calcs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `uom` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Bræt 25x200 trykimp.','m',5495),(2,'Bræt 25x125 trykimp.','m',3195),(3,'Lægte 38x73 ubeh.','m',1395),(4,'Spærtræ 45x195 ubeh.','m',4395),(5,'Stolpe 97x97 trykimp.','stk.',32700),(6,'Bræt 19x100 trykimp.','m',795),(7,'Tagplader Plastmo blåtonet','stk.',33000),(8,'Plastmo bundskruer','stk.',250),(9,'Hulbånd, 1x20mm','m',2100),(10,'Universalbeslag 190mm højre','stk.',4400),(11,'Universalbeslag 190mm venstre','stk.',4400),(12,'Skruer, 4,5x60mm','stk.',25),(13,'Beslagskruer, 4,0x50mm','stk.',110),(14,'Bræddebolte 10x120mm','stk.',500),(15,'Firkantskiver 40x40x11mm','stk.',400),(16,'Lægte 38x73 ubeh.','m',1495),(17,'Reglar 45x95mm, ubeh.','m',1895),(18,'Bræt 25x150 trykimp.','m',3395),(19,'Byg-selv-spær','stk.',39995),(20,'Bræt 25x50mm, trykimp.','m',995),(21,'Tagsten B&C dobbelt-S sort','stk.',795),(22,'Rygsten B&C sort','stk.',4995),(23,'Toplægteholder B&C','stk.',2495),(24,'Rygstenbeslag B&C','stk.',995),(25,'Bindere B&C','stk.',200),(26,'Skruer, 5,0x100mm','stk.',190),(27,'Skruer, 4,5x70mm','stk.',50),(28,'Skruer, 4,5x50mm','stk.',60),(29,'Stalddørsgreb 50x75','sæt',21900),(30,'T-hængsel 390mm','stk.',10900),(31,'Vinkelbeslag 35','stk.',595);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roof_materials`
--

DROP TABLE IF EXISTS `roof_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roof_materials` (
  `material_id` int(11) NOT NULL AUTO_INCREMENT,
  `material_name` varchar(45) NOT NULL,
  `material_price_m` double DEFAULT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roof_materials`
--

LOCK TABLES `roof_materials` WRITE;
/*!40000 ALTER TABLE `roof_materials` DISABLE KEYS */;
INSERT INTO `roof_materials` VALUES (1,'Tagplader Plastmo blåtonet',33000),(2,'Tagsten B&C dobbelt-S sort',795),(6,'plasttrapezplader',400);
/*!40000 ALTER TABLE `roof_materials` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-17 12:16:34
