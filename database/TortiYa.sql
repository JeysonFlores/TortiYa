CREATE DATABASE  IF NOT EXISTS `bdtortiya` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdtortiya`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bdtortiya
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `fk_idempleado` int DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (0,'Mostrador','Mostrador',0,'Mostrador','A',1222),(1236,'Taqueria Don Fer','Jeyson Flores Deras',669135286,'Fernando Villalbazo No. 651','A',1224),(1237,'Minisuper Martin','Martin Espinoza',669684315,'Portal del Sol No. 3162','A',1223),(1238,'Super los Venados','Adrian Uribe',669316489,'Av Los Venados No. 10684','A',1223),(1239,'Taqueria El Michi','Juan de Dios Pantoja',669132648,'Puertas del Mar No. 1356','A',1224),(1240,'Abarrotes Amor','Dora Garcia',669564816,'Capricornio No. 6135','A',1223);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_pedidos`
--

DROP TABLE IF EXISTS `detalle_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_pedidos` (
  `fk_idpedido` int NOT NULL,
  `fk_idproducto` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precio_parcial` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_pedidos`
--

LOCK TABLES `detalle_pedidos` WRITE;
/*!40000 ALTER TABLE `detalle_pedidos` DISABLE KEYS */;
INSERT INTO `detalle_pedidos` VALUES (1,12,6,168),(1,1111,5,150),(2,1117,2,126),(3,1113,5,35),(4,12,6,168),(5,12,5,140),(6,1113,3,21),(6,1111,2,60);
/*!40000 ALTER TABLE `detalle_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_ventas`
--

DROP TABLE IF EXISTS `detalle_ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_ventas` (
  `fk_idventa` int NOT NULL,
  `fk_idproducto` varchar(45) DEFAULT NULL,
  `cantidad` varchar(45) DEFAULT NULL,
  `precio_parcial` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_ventas`
--

LOCK TABLES `detalle_ventas` WRITE;
/*!40000 ALTER TABLE `detalle_ventas` DISABLE KEYS */;
INSERT INTO `detalle_ventas` VALUES (4,'1113','3',21),(5,'1118','3',36),(6,'12','5',140),(7,'1113','2',14),(7,'1112','3',36),(8,'1','1',12),(8,'1125','1',10),(8,'1111','2',60),(9,'1112','2',24),(10,'1112','1',12);
/*!40000 ALTER TABLE `detalle_ventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idempleado` int NOT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `puesto` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `curp` varchar(45) DEFAULT NULL,
  `telefono` int DEFAULT NULL,
  `fecha_nac` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idempleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1211,'Fernando','Murrieta','Gerente','Masculino','Fernando Street No.619','FEMU1805946483AB64',694119088,'18/05/1994','A'),(1222,'Jorge','Milano','Cajero','Masculino','Enrique Segoviano No. 132','JOMI21058721235DS3',669316846,'21/05/1987','A'),(1223,'Gus','Guson','Repartidor','Masculino','Juan de la Barrera No. 1365','GUGU130580132AVS31',669666666,'13/05/1980','A'),(1224,'Nicolas','Toledo','Repartidor','Masculino','Reformadores Panaderos No. 1615','NITO120199135IOA32',669162946,'12/01/1999','A'),(1225,'Fernando','Gonzalez','Repartidor','Masculino','Flores Magon No. 6483','FEGO2105966849OBO1',121213123,'21/05/1996','B');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `idpedido` int NOT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `fk_idcliente` int DEFAULT NULL,
  `fk_idempleado` int DEFAULT NULL,
  PRIMARY KEY (`idpedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
INSERT INTO `pedidos` VALUES (1,'19/06/2020','318.0','P',1237,1223),(2,'23/06/2020','126.0','P',1238,1223),(3,'16/06/2020','35.0','P',1236,1224),(4,'25/06/2020','168.0','P',1239,1224),(5,'11/06/2020','140.0','E',1238,1223),(6,'22/06/2020','81.0','P',1238,1211);
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idproducto` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `existencia` int DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idproducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Paq. 9 pzas.',99,'Paquete de tortillas con 9 piezas',12,'A'),(12,'Paq. Taq. 29 pzas.',45,'Paquete de tortillas taqueritas con 29 piezas',28,'A'),(1111,'Paq. 24 pzas.',46,'Paquete de tortillas con 24 piezas',30,'A'),(1112,'Integrales',44,'Paquete de tortillas integrales',12,'A'),(1113,'Taqueritas',42,'Paquete de tortillas taqueritas',7,'A'),(1114,'Paq. 24 pzas. 1 1/2 b.',20,'Paquete de 24 piezas de 1 y media bolas',43,'A'),(1115,'Paq. 2 b.',20,'Paquete de tortillas de 2 bolas',36,'A'),(1116,'Paq. 3 b.',20,'Paquete de tortillas de 3 bolas',52,'A'),(1117,'Paq. 4 b.',20,'Paquete de tortillas de 4 bolas',63,'A'),(1118,'Frijol puerco',17,'Medio litro de frijol puerco',12,'A'),(1119,'Frijol natural',20,'Medio litro de frijol natural',11,'A'),(1120,'Cochinita',20,'Bote de cochinita pibil',30,'A'),(1121,'Pan Cochito',50,'Pieza de pan cochito',7.5,'A'),(1122,'Papa frita',30,'Bolsa de papitas fritas con sal',12,'A'),(1123,'Salsa roja',20,'Bolsa de salsa roja',12,'A'),(1124,'Salsa verde',20,'Bolsa de salsa verde',12,'A'),(1125,'Galleta nata',29,'Paquete de galletas de nata',10,'A');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `idventa` int NOT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `fk_idcliente` int DEFAULT NULL,
  `fk_idempleado` int DEFAULT NULL,
  PRIMARY KEY (`idventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (4,'11/06/2020',21,0,1222),(5,'11/06/2020',36,0,1222),(6,'11/06/2020',140,1238,1223),(7,'12/06/2020',50,0,1223),(8,'12/06/2020',82,0,1211),(9,'15/06/2020',24,0,1223),(10,'18/06/2020',12,0,1211);
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-19 21:54:06
