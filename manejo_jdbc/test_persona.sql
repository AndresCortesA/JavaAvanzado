
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.32
--
-- Table structure for table `persona`
--
CREATE TABLE `persona` (
  `id_persona` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_persona`)
)

--
-- Dumping data for table `persona`
--


INSERT INTO `persona` VALUES (1,'Andres','Arias','tucorreo@mail.com','234556678'),(2,'Maria','Pereza','tucorreo@mail.com','2235667'),(3,'Elias','Marino','corri@mail.com','34345567'),(4,'Mario Elias','Marino','corri@mail.com','34345567');