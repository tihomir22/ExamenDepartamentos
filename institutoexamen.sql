-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 05-02-2019 a les 10:41:22
-- Versió del servidor: 10.1.36-MariaDB
-- Versió de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `institutoexamen`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `aula`
--

CREATE TABLE `aula` (
  `codiaula` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Bolcament de dades per a la taula `aula`
--

INSERT INTO `aula` (`codiaula`, `nombre`) VALUES
('TIC', 'nuevo nombre 2');

-- --------------------------------------------------------

--
-- Estructura de la taula `departament`
--

CREATE TABLE `departament` (
  `dep` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `nom` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `data` date NOT NULL,
  `hores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Bolcament de dades per a la taula `departament`
--

INSERT INTO `departament` (`dep`, `nom`, `data`, `hores`) VALUES
('Adm', 'Nombre ejem', '2005-01-01', 10),
('Bio', 'Biologia', '2004-01-07', 20),
('Inf', 'Informatica', '2003-09-19', 15),
('San', 'Sanitaria', '2004-07-15', 30),
('Tec', 'Tecnologia', '2004-07-15', 16),
('TIC', 'Informatica Tratamiento', '2019-02-05', 10);

-- --------------------------------------------------------

--
-- Estructura de la taula `projecte`
--

CREATE TABLE `projecte` (
  `codproj` int(11) NOT NULL,
  `nom` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `lloc` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `dep` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Bolcament de dades per a la taula `projecte`
--

INSERT INTO `projecte` (`codproj`, `nom`, `lloc`, `dep`) VALUES
(1, 'eheheheh', 'Laborator', 'San'),
(2, 'Herramientas', 'Exterior', 'Tec'),
(3, 'Botanica', 'Laborator', 'Bio'),
(4, 'RAW', 'Aula', 'Inf'),
(5, 'RAL', 'Aula', 'Inf'),
(6, 'Empresa', 'Laborator', 'Adm'),
(7, 'Anna Bonilla', 'Aula', 'Inf'),
(9, 'proyecto de prueba', 'Aula', 'TIC'),
(10, 'proyecto de prueba', 'Aula', 'TIC');

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`codiaula`);

--
-- Índexs per a la taula `departament`
--
ALTER TABLE `departament`
  ADD PRIMARY KEY (`dep`);

--
-- Índexs per a la taula `projecte`
--
ALTER TABLE `projecte`
  ADD PRIMARY KEY (`codproj`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `projecte`
--
ALTER TABLE `projecte`
  MODIFY `codproj` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
