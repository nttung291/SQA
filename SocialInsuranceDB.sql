-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: SocialInsuranceDB
-- ------------------------------------------------------
-- Server version	5.6.38

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Account` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Role` int(10) NOT NULL,
  `State` int(10) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CompulsoryContract`
--

DROP TABLE IF EXISTS `CompulsoryContract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CompulsoryContract` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `CompanyCode` varchar(255) DEFAULT NULL,
  `State` int(10) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `StartedDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CompulsoryContract`
--

LOCK TABLES `CompulsoryContract` WRITE;
/*!40000 ALTER TABLE `CompulsoryContract` DISABLE KEYS */;
/*!40000 ALTER TABLE `CompulsoryContract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customer`
--

DROP TABLE IF EXISTS `Customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Customer` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `HometownId` int(10) NOT NULL,
  `VoluntaryContractId` int(10) DEFAULT NULL,
  `CompulsoryContractId` int(10) DEFAULT NULL,
  `AccountId` int(10) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Sex` bit(1) NOT NULL,
  `Dob` varchar(255) DEFAULT NULL,
  `IdNumber` varchar(255) DEFAULT NULL,
  `SocialInsuranceNo` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `PhoneNo` varchar(255) DEFAULT NULL,
  `PaymentDuration` int(10) NOT NULL,
  `TaxCode` varchar(255) DEFAULT NULL,
  `Salary` float NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKCustomer95429` (`AccountId`),
  KEY `FKCustomer988461` (`CompulsoryContractId`),
  KEY `FKCustomer987907` (`VoluntaryContractId`),
  KEY `FKCustomer323840` (`HometownId`),
  CONSTRAINT `FKCustomer323840` FOREIGN KEY (`HometownId`) REFERENCES `Hometown` (`Id`),
  CONSTRAINT `FKCustomer95429` FOREIGN KEY (`AccountId`) REFERENCES `Account` (`Id`),
  CONSTRAINT `FKCustomer987907` FOREIGN KEY (`VoluntaryContractId`) REFERENCES `VoluntaryContract` (`Id`),
  CONSTRAINT `FKCustomer988461` FOREIGN KEY (`CompulsoryContractId`) REFERENCES `CompulsoryContract` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customer`
--

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hometown`
--

DROP TABLE IF EXISTS `Hometown`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hometown` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Section` int(10) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hometown`
--

LOCK TABLES `Hometown` WRITE;
/*!40000 ALTER TABLE `Hometown` DISABLE KEYS */;
INSERT INTO `Hometown` VALUES (10,'An Giang',2),(11,'Bà Rịa - Vũng Tàu',2),(12,'Bắc Giang',2),(13,'Bắc Kạn',2),(14,'Bạc Liêu',2),(15,'Bắc Ninh',2),(16,'Bến Tre',2),(17,'Bình Định',2),(18,'Bình Dương',2),(19,'Bình Phước',2),(20,'Bình Thuận',2),(21,'Cà Mau',3),(22,'Cao Bằng',3),(23,'Đắk Lắk',3),(24,'Đắk Nông',3),(25,'Điện Biên',3),(26,'Đồng Nai',3),(27,'Đồng Tháp',3),(28,'Gia Lai',3),(29,'Hà Giang',3),(30,'Hà Nam',3),(31,'Hà Tĩnh',3),(32,'Hải Dương',3),(33,'Hậu Giang',3),(34,'Hòa Bình',3),(35,'Hưng Yên',3),(36,'Khánh Hòa',3),(37,'Kiên Giang',3),(38,'Cần Thơ',3),(39,'Đà Nẵng',3),(40,'Hải Phòng',4),(41,'Hà Nội',4),(42,'TP HCM',4),(43,'Kon Tum',4),(44,'Lai Châu',4),(45,'Lâm Đồng',4),(46,'Lạng Sơn',4),(47,'Lào Cai',4),(48,'Long An',4),(49,'Nam Định',4),(50,'Nghệ An',4),(51,'Ninh Bình',4),(52,'Ninh Thuận',4),(53,'Phú Thọ',1),(54,'Quảng Bình',1),(55,'Quảng Nam',1),(56,'Quảng Ngãi',1),(57,'Quảng Ninh',1),(58,'Quảng Trị',1),(59,'Sóc Trăng',1),(60,'Sơn La',1),(61,'Tây Ninh',1),(62,'Thái Bình',1),(63,'Thái Nguyên',1),(64,'Thanh Hóa',1),(65,'Thừa Thiên Huế',1),(66,'Tiền Giang',1),(67,'Trà Vinh',1),(68,'Tuyên Quang',1),(69,'Vĩnh Long',1),(70,'Vĩnh Phúc',1),(71,'Yên Bái',1),(72,'Phú Yên',1);
/*!40000 ALTER TABLE `Hometown` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VoluntaryContract`
--

DROP TABLE IF EXISTS `VoluntaryContract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `VoluntaryContract` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `State` int(10) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `StartedDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VoluntaryContract`
--

LOCK TABLES `VoluntaryContract` WRITE;
/*!40000 ALTER TABLE `VoluntaryContract` DISABLE KEYS */;
/*!40000 ALTER TABLE `VoluntaryContract` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-09  9:14:55
