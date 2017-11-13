-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: wololo
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `elemento`
--

DROP TABLE IF EXISTS `elemento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elemento` (
  `idElemento` int(11) NOT NULL AUTO_INCREMENT,
  `Id` varchar(45) DEFAULT NULL,
  `Clase` varchar(100) NOT NULL,
  PRIMARY KEY (`idElemento`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elemento`
--

LOCK TABLES `elemento` WRITE;
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
INSERT INTO `elemento` VALUES (1,'Boton','btn btn-circle js-scroll-trigger'),(2,'Grafica','btn'),(3,'Contacto','nav-link js-scroll-trigger'),(4,'Animacion','fa fa-angle-double-down animated'),(5,'navBarAuto','navbar-nav ml-auto'),(6,'navbarResponsive','collapse navbar-collapse'),(7,'mainNav','navbar navbar-expand-lg navbar-light fixed-top navbar-shrink'),(8,'containerNav','container'),(9,'about','content-section text-center'),(10,'','col-lg-8 mx-auto'),(11,'','container'),(12,'download','download-section content-section text-center'),(13,'Columna','col-lg-8 mx-auto'),(14,'Fila','row'),(15,'Container','container'),(16,'mainNav','navbar navbar-expand-lg navbar-light fixed-top'),(17,'Titulo','brand-heading'),(18,'IntroBody','intro-body'),(19,'Head','masthead'),(20,'Inicio','navbar-brand js-scroll-trigger'),(21,'Acerca','nav-link js-scroll-trigger active');
/*!40000 ALTER TABLE `elemento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-13 13:03:56
