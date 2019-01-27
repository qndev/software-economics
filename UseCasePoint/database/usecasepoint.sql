-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 27, 2019 at 10:09 PM
-- Server version: 5.7.25
-- PHP Version: 7.0.33-0+deb9u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `usecasepoint`
--

-- --------------------------------------------------------

--
-- Table structure for table `environmental_complexity_factor`
--

CREATE TABLE `environmental_complexity_factor` (
  `id_ecf` int(11) NOT NULL,
  `factor_ecf` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `weight` float NOT NULL,
  `complexity_ecf` float NOT NULL,
  `id_project` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `environmental_complexity_factor`
--

INSERT INTO `environmental_complexity_factor` (`id_ecf`, `factor_ecf`, `description`, `weight`, `complexity_ecf`, `id_project`) VALUES
(1, 'ECF 01', 'Familiarity with development process used', 1.5, 5, 'P001'),
(2, 'ECF 01', 'Familiarity with development process used', 1.5, 3, 'P001'),
(3, 'ECF 01', 'Familiarity with development process used', 1.5, 5, 'KTCNPM.20181'),
(4, 'ECF 02', 'Application experience', 0.5, 5, 'KTCNPM.20181'),
(5, 'ECF 03', 'Object-oriented experience of team', 1, 3, 'KTCNPM.20181'),
(6, 'ECF 04', 'Lead analyst capability', 0.5, 3, 'KTCNPM.20181'),
(7, 'ECF 05', 'Motivation of the team', 1, 5, 'KTCNPM.20181'),
(8, 'ECF 06', 'Stability of requirements', 2, 5, 'KTCNPM.20181'),
(9, 'ECF 07', 'Part-time staff', -1, 0, 'KTCNPM.20181'),
(10, 'ECF 08', 'Difficult programming language', -1, 3, 'KTCNPM.20181');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id_project` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id_project`, `name`, `description`) VALUES
('KTCNPM.20181', 'Student Information System', 'Software Economics'),
('P001', 'SIS', 'Student Information System'),
('P002', 'DEMO', 'DEMO DES');

-- --------------------------------------------------------

--
-- Table structure for table `technical_complexity_factor`
--

CREATE TABLE `technical_complexity_factor` (
  `id_tcf` int(11) NOT NULL,
  `factor_tcf` varchar(10) CHARACTER SET utf8 NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `weight` float NOT NULL,
  `complexity_tcf` float NOT NULL,
  `id_project` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `technical_complexity_factor`
--

INSERT INTO `technical_complexity_factor` (`id_tcf`, `factor_tcf`, `description`, `weight`, `complexity_tcf`, `id_project`) VALUES
(1, 'TCF 01', 'Distributed system', 2, 5, 'P001'),
(2, 'TCF 04', 'Internal processing complexity', 1, 3, 'P001'),
(3, 'TCF 01', 'Distributed system', 2, 5, 'KTCNPM.20181'),
(4, 'TCF 02', 'Response time/performance objectives', 1, 3, 'KTCNPM.20181'),
(5, 'TCF 03', 'End-user efficiency', 1, 3, 'KTCNPM.20181'),
(6, 'TCF 04', 'Internal processing complexity', 1, 3, 'KTCNPM.20181'),
(7, 'TCF 05', 'Code reusability', 1, 3, 'KTCNPM.20181'),
(8, 'TCF 06', 'Easy to install', 0.5, 5, 'KTCNPM.20181'),
(9, 'TCF 07', 'Easy to use', 0.5, 5, 'KTCNPM.20181'),
(10, 'TCF 08', 'Portability to other platforms', 2, 5, 'KTCNPM.20181'),
(11, 'TCF 09', 'System maintenance', 1, 5, 'KTCNPM.20181'),
(12, 'TCF 10', 'Concurrent/parallel processing', 1, 5, 'KTCNPM.20181'),
(13, 'TCF 11', 'Security features', 1, 4, 'KTCNPM.20181'),
(14, 'TCF 12', 'Access for third parties', 1, 1, 'KTCNPM.20181'),
(15, 'TCF 13', 'End user training', 1, 2, 'KTCNPM.20181');

-- --------------------------------------------------------

--
-- Table structure for table `use_case_estimate`
--

CREATE TABLE `use_case_estimate` (
  `id_use_case_estimate` int(11) NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `phase` float NOT NULL,
  `type` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `complexity` float NOT NULL,
  `id_project` varchar(45) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `use_case_estimate`
--

INSERT INTO `use_case_estimate` (`id_use_case_estimate`, `name`, `phase`, `type`, `complexity`, `id_project`) VALUES
(1, 'Login', 1, 'UseCase', 5, 'P001'),
(2, 'Delete Account', 1, 'UseCase', 10, 'P001'),
(3, 'Create Courses', 1, 'UseCase', 15, 'P001'),
(4, 'Change Password', 1, 'UseCase', 15, 'P001'),
(5, 'Student', 1, 'Actor', 1, 'P001'),
(6, 'Student', 1, 'Actor', 3, 'KTCNPM.20181'),
(7, 'Admin', 1, 'Actor', 3, 'KTCNPM.20181'),
(8, 'Database Service', 1, 'Actor', 1, 'KTCNPM.20181'),
(9, 'Login', 1, 'UseCase', 15, 'KTCNPM.20181'),
(10, 'Read Course', 1, 'UseCase', 5, 'KTCNPM.20181'),
(11, 'Update Course', 1, 'UseCase', 5, 'KTCNPM.20181'),
(12, 'Delete Course', 1, 'UseCase', 10, 'KTCNPM.20181'),
(13, 'Create Course', 1, 'UseCase', 5, 'KTCNPM.20181'),
(14, 'Search Information', 1, 'UseCase', 5, 'KTCNPM.20181'),
(15, 'Register', 1, 'UseCase', 5, 'KTCNPM.20181'),
(16, 'Create User', 1, 'UseCase', 5, 'KTCNPM.20181'),
(17, 'Delete User', 1, 'UseCase', 5, 'KTCNPM.20181'),
(18, 'Update User', 1, 'UseCase', 5, 'KTCNPM.20181');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `environmental_complexity_factor`
--
ALTER TABLE `environmental_complexity_factor`
  ADD PRIMARY KEY (`id_ecf`),
  ADD KEY `fk_environmental_complexity_factor_1_idx` (`id_project`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id_project`);

--
-- Indexes for table `technical_complexity_factor`
--
ALTER TABLE `technical_complexity_factor`
  ADD PRIMARY KEY (`id_tcf`),
  ADD KEY `fk_technical_complexity_factor_1_idx` (`id_project`);

--
-- Indexes for table `use_case_estimate`
--
ALTER TABLE `use_case_estimate`
  ADD PRIMARY KEY (`id_use_case_estimate`),
  ADD KEY `fk_use_case_estimate_1_idx` (`id_project`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `environmental_complexity_factor`
--
ALTER TABLE `environmental_complexity_factor`
  MODIFY `id_ecf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `technical_complexity_factor`
--
ALTER TABLE `technical_complexity_factor`
  MODIFY `id_tcf` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `use_case_estimate`
--
ALTER TABLE `use_case_estimate`
  MODIFY `id_use_case_estimate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `environmental_complexity_factor`
--
ALTER TABLE `environmental_complexity_factor`
  ADD CONSTRAINT `fk_environmental_complexity_factor_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `technical_complexity_factor`
--
ALTER TABLE `technical_complexity_factor`
  ADD CONSTRAINT `fk_technical_complexity_factor_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `use_case_estimate`
--
ALTER TABLE `use_case_estimate`
  ADD CONSTRAINT `fk_use_case_estimate_1` FOREIGN KEY (`id_project`) REFERENCES `project` (`id_project`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
