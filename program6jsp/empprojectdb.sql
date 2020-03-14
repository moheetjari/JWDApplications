-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2020 at 07:27 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `empprojectdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `depttb`
--

CREATE TABLE `depttb` (
  `depid` int(11) NOT NULL,
  `deptname` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `depttb`
--

INSERT INTO `depttb` (`depid`, `deptname`) VALUES
(1, 'HR'),
(2, 'Sales'),
(3, 'IT');

-- --------------------------------------------------------

--
-- Table structure for table `emptb`
--

CREATE TABLE `emptb` (
  `empid` int(11) NOT NULL,
  `empname` varchar(50) NOT NULL,
  `designation` varchar(50) NOT NULL,
  `deptid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `projecttb`
--

CREATE TABLE `projecttb` (
  `projectid` int(11) NOT NULL,
  `projectname` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL,
  `duration` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `project_assigntb`
--

CREATE TABLE `project_assigntb` (
  `projectid` int(11) NOT NULL,
  `empid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `depttb`
--
ALTER TABLE `depttb`
  ADD PRIMARY KEY (`depid`);

--
-- Indexes for table `emptb`
--
ALTER TABLE `emptb`
  ADD PRIMARY KEY (`empid`),
  ADD KEY `fk_deptid` (`deptid`);

--
-- Indexes for table `projecttb`
--
ALTER TABLE `projecttb`
  ADD PRIMARY KEY (`projectid`);

--
-- Indexes for table `project_assigntb`
--
ALTER TABLE `project_assigntb`
  ADD PRIMARY KEY (`projectid`),
  ADD KEY `fk_empidpro` (`empid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `depttb`
--
ALTER TABLE `depttb`
  MODIFY `depid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `emptb`
--
ALTER TABLE `emptb`
  MODIFY `empid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `projecttb`
--
ALTER TABLE `projecttb`
  MODIFY `projectid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `project_assigntb`
--
ALTER TABLE `project_assigntb`
  MODIFY `projectid` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emptb`
--
ALTER TABLE `emptb`
  ADD CONSTRAINT `fk_deptid` FOREIGN KEY (`deptid`) REFERENCES `depttb` (`depid`);

--
-- Constraints for table `project_assigntb`
--
ALTER TABLE `project_assigntb`
  ADD CONSTRAINT `fk_empidpro` FOREIGN KEY (`empid`) REFERENCES `emptb` (`empid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
