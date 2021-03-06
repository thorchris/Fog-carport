CREATE DATABASE  IF NOT EXISTS `fogcarport` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fogcarport`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
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
  `material_name` varchar(45) NOT NULL DEFAULT 'DEFAULT CHARSET=utf8',
  `material_piece_price` double NOT NULL,
  `width` double NOT NULL,
  `length` double NOT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_materials`
--

LOCK TABLES `carport_materials` WRITE;
/*!40000 ALTER TABLE `carport_materials` DISABLE KEYS */;
INSERT INTO `carport_materials` VALUES (1,'Egetræsbrædder',14,0.15,3),(2,'Bøgetræsplade',12,0.15,3),(3,'Plastiktræ',10,0.15,3);
/*!40000 ALTER TABLE `carport_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_order` (
  `co_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `cp_length` double NOT NULL,
  `cp_width` double NOT NULL,
  `hasShed` tinyint(4) DEFAULT NULL,
  `shedHalf` tinyint(4) DEFAULT NULL,
  `roof_mats` int(11) NOT NULL,
  `shed_mats` int(11) NOT NULL,
  `cp_mats` int(11) NOT NULL,
  `cladding_sides` int(11) NOT NULL,
  `roof_angle` int(11) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`co_id`),
  KEY `fk_customer_idx` (`user_id`),
  KEY `fk_order_idx` (`order_id`),
  KEY `shed_material` (`shed_mats`),
  KEY `fk_cp_idx` (`cp_mats`),
  KEY `fk_roof_idx` (`roof_mats`),
  CONSTRAINT `fk_cp` FOREIGN KEY (`cp_mats`) REFERENCES `carport_materials` (`material_id`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `fk_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`),
  CONSTRAINT `fk_roof` FOREIGN KEY (`roof_mats`) REFERENCES `roof_materials` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT INTO `customer_order` VALUES (48,61,2,2.4,2.4,1,1,1,1,1,2,25,10000),(49,62,2,5.4,7.8,0,0,2,2,2,2,10,15000);
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `rafters` int(11) NOT NULL,
  `cladding` int(11) NOT NULL,
  `posts` int(11) NOT NULL,
  `screws` int(11) NOT NULL,
  `fascia` int(11) NOT NULL,
  `brackets` int(11) NOT NULL,
  `straps` int(11) NOT NULL,
  `doorknobs` int(11) NOT NULL,
  `doorhinges` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id_fk_idx` (`user_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (61,2,4,24,4,10,4,10,4,1,2),(62,2,12,36,4,100,4,10,4,1,2);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
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
  `price` double NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'skrue','stk',1),(2,'stolpe','stk',50),(3,'rem','m',20),(4,'spær','m',14),(5,'stern','m',30),(6,'beslag','stk',50),(7,'beklædning','m',30),(8,'dørhåndtag','stk',100),(9,'dørhængsel','stk',55);
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
  `material_name` varchar(45) NOT NULL DEFAULT 'DEFAULT CHARSET=utf8',
  `material_price_m2` double NOT NULL,
  `width` double NOT NULL,
  `length` double NOT NULL,
  PRIMARY KEY (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roof_materials`
--

LOCK TABLES `roof_materials` WRITE;
/*!40000 ALTER TABLE `roof_materials` DISABLE KEYS */;
INSERT INTO `roof_materials` VALUES (1,'Tagplader Plastmo blåtonet',250,1.06,2.4),(2,'Betontagsten - rød',450,1,2),(6,'Betontagsten - teglrød ',450,1,2),(7,'Betontagsten - rødbrun',450,1,2),(8,'Betontagsten - sort',450,1,2),(9,'Eternittag B6 - grå',350,1.5,2.5),(10,'Eternittag B6 - sort',350,1.5,2.5),(11,'Eternittag B6 - mokkabrun',350,1.5,2.5),(12,'Eternittag B6 - rødbrun',350,1.5,2.5),(13,'Eternittag B6 - teglrød',350,1.5,2.5),(14,'Eternittag B7 - grå',400,2,3),(15,'Eternittag B7 - sort',400,2,3),(16,'Eternittag B7 - mokkabrun',400,2,3),(17,'Eternittag B7 - rødbrun',400,2,3),(18,'Eternittag B7 - teglrød ',400,2,3),(19,'Eternittag B7 - rødflammet ',400,2,3);
/*!40000 ALTER TABLE `roof_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'customer',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,'KundeUdenLogin@user.com','1234','customer'),(1,'admin@admin.com','admin','employee'),(2,'user@user.com','user','customer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-18 11:32:47