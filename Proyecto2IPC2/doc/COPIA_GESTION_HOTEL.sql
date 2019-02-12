-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: localhost    Database: GESTION_HOTEL
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

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
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CLIENTE` (
  `NIT` varchar(10) NOT NULL,
  `CUI` varchar(13) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Telefono` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`NIT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES ('1234977-1','3303221411276','cliente2','77602112'),('1234977-2','3303221411271','cliente1','77602111'),('1234977-3','3303221411277','cliente3','77602113'),('1234977-4','3303221411278','cliente4','77602114');
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CONSUMO_RESTAURANTE`
--

DROP TABLE IF EXISTS `CONSUMO_RESTAURANTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CONSUMO_RESTAURANTE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Reservacion` int(11) NOT NULL,
  `ID_Menu` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Encargado_Restaurante` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_CONSUMO_RESTAURANTE1_R` (`ID_Reservacion`),
  KEY `fk_CONSUMO_RESTAURANTE2_M` (`ID_Menu`),
  KEY `fk_CONSUMO_RESTAURANTE3_U` (`Encargado_Restaurante`),
  CONSTRAINT `Encargado_Restaurante` FOREIGN KEY (`Encargado_Restaurante`) REFERENCES `USUARIO` (`User`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_Menu` FOREIGN KEY (`ID_Menu`) REFERENCES `MENU` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_Reservacion` FOREIGN KEY (`ID_Reservacion`) REFERENCES `RESERVACION` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CONSUMO_RESTAURANTE`
--

LOCK TABLES `CONSUMO_RESTAURANTE` WRITE;
/*!40000 ALTER TABLE `CONSUMO_RESTAURANTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CONSUMO_RESTAURANTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HABITACION`
--

DROP TABLE IF EXISTS `HABITACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HABITACION` (
  `ID` int(11) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `Nivel` int(11) NOT NULL,
  `Precio` double NOT NULL,
  `Estado` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HABITACION`
--

LOCK TABLES `HABITACION` WRITE;
/*!40000 ALTER TABLE `HABITACION` DISABLE KEYS */;
INSERT INTO `HABITACION` VALUES (1,'Habitacion_Junior',1,50,'Desocupada'),(2,'Habitacion_Junior',1,50,'Desocupada'),(3,'Habitacion_Master',1,75,'Desocupada'),(4,'Habitacion_De_Lujo',1,100,'Desocupada'),(5,'Habitacion_Junior',2,50,'Desocupada'),(6,'Habitacion_Junior',2,50,'Desocupada'),(7,'Habitacion_Master',2,75,'Desocupada'),(8,'Habitacion_De_Lujo',2,100,'Desocupada'),(9,'Habitacion_Junior',3,50,'Desocupada'),(10,'Habitacion_Junior',3,50,'Desocupada'),(11,'Habitacion_Master',3,75,'Desocupada'),(12,'Habitacion_De_Lujo',3,100,'Desocupada'),(13,'Habitacion_Junior',4,50,'Desocupada'),(14,'Habitacion_Junior',4,50,'Desocupada'),(15,'Habitacion_Master',4,75,'Desocupada'),(16,'Habitacion_De_Lujo',4,100,'Desocupada');
/*!40000 ALTER TABLE `HABITACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MENU`
--

DROP TABLE IF EXISTS `MENU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MENU` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(15) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `Precio` double NOT NULL,
  `Gerente` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `fk_MENU_USUARIO1_idx` (`Gerente`),
  CONSTRAINT `Gerente` FOREIGN KEY (`Gerente`) REFERENCES `USUARIO` (`User`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MENU`
--

LOCK TABLES `MENU` WRITE;
/*!40000 ALTER TABLE `MENU` DISABLE KEYS */;
INSERT INTO `MENU` VALUES (1,'Bebida','Pepsi','Litro de Bebida\ngaseosa sabor\na cola',7.5,'usuario1'),(2,'Bebida','Licuado de Fresa','Vaso de Licuado\nsabor a Fresa',10.5,'usuario1'),(3,'Comida ','Combo de Pollo 1','Pollo con Papas\nmas Bebida',25.5,'usuario1'),(4,'Bebida','CocaCola','Litro de Bebida\ngaseosa sabor\na cola',8.5,'usuario1'),(5,'Bebida','Licuado de Mora','Vaso de Licuado\nsabor a Mora',10.5,'usuario1'),(7,'Comida ','Combo Churrasco1','Carne asada\ncon papas\nmas bebida',30.5,'usuario1'),(8,'Bebida','Seven','Bebida gasesosa\nsabor a limon',7.5,'usuario1'),(9,'Comida ','Ceviche de Camaron','Ceviche de camaron\nincluye tostadas',25.5,'usuario1');
/*!40000 ALTER TABLE `MENU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `REGISTRO_PAGO`
--

DROP TABLE IF EXISTS `REGISTRO_PAGO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `REGISTRO_PAGO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(20) NOT NULL,
  `ID_Reserv` int(11) NOT NULL,
  `ID_Consumo` int(11) NOT NULL,
  `Nombre_Cliente` varchar(45) NOT NULL,
  `NIT_Cliente` varchar(10) NOT NULL,
  `Fecha` date NOT NULL,
  `Recep` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_RESERVACION_IN_ID_RESERV` (`ID_Reserv`),
  KEY `fk_CONSUMO_RESTAURANTE_IN_ID_CONSUMO` (`ID_Consumo`),
  KEY `fk_REGISTRO_PAGO` (`Recep`),
  CONSTRAINT `ID_Consumo` FOREIGN KEY (`ID_Consumo`) REFERENCES `CONSUMO_RESTAURANTE` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ID_Reserv` FOREIGN KEY (`ID_Reserv`) REFERENCES `RESERVACION` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Recep` FOREIGN KEY (`Recep`) REFERENCES `USUARIO` (`User`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REGISTRO_PAGO`
--

LOCK TABLES `REGISTRO_PAGO` WRITE;
/*!40000 ALTER TABLE `REGISTRO_PAGO` DISABLE KEYS */;
/*!40000 ALTER TABLE `REGISTRO_PAGO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RESERVACION`
--

DROP TABLE IF EXISTS `RESERVACION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RESERVACION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre_Huesped` varchar(45) NOT NULL,
  `NIT_Huesped` varchar(10) NOT NULL,
  `ID_Habitacion` int(11) NOT NULL,
  `Precio_Habitacion` double NOT NULL,
  `Fecha_Ingreso` date NOT NULL,
  `Fecha_Retiro` date NOT NULL,
  `Cantidad_Dias` int(11) NOT NULL,
  `Recepcionista` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_HABITACION_IN_ID_HABITACION` (`ID_Habitacion`),
  KEY `fk_CLIENTE_IN_NIT_HUESPED` (`NIT_Huesped`),
  KEY `fk_RESERVACION` (`Recepcionista`),
  CONSTRAINT `ID_Habitacion` FOREIGN KEY (`ID_Habitacion`) REFERENCES `HABITACION` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `NIT_Huesped` FOREIGN KEY (`NIT_Huesped`) REFERENCES `CLIENTE` (`NIT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Recepcionista` FOREIGN KEY (`Recepcionista`) REFERENCES `USUARIO` (`User`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RESERVACION`
--

LOCK TABLES `RESERVACION` WRITE;
/*!40000 ALTER TABLE `RESERVACION` DISABLE KEYS */;
/*!40000 ALTER TABLE `RESERVACION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USUARIO` (
  `User` varchar(45) NOT NULL,
  `Pass` varchar(30) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `CUI` varchar(13) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `Estado` varchar(10) NOT NULL,
  PRIMARY KEY (`User`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES ('usuario1','miPassword1','usuario1','3303221411272','Gerente','Activo'),('usuario2','miPassword2','usuario2','3303221411273','Recepcionista','Activo'),('usuario3','miPassword3','usuario3','3303221411274','Encargado_Restaurante','Activo'),('usuario4','miPassword4','usuario4','3303221411208','Recepcionista','Activo'),('usuario5','miPassword5','usuario5','3303221411209','Encargado_Restaurante','Activo');
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-19  0:14:53
