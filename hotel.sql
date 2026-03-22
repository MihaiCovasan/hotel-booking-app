-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: Localhost:4000
-- Generation Time: May 15, 2023 at 07:08 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `reservationconferences`
--

CREATE TABLE `reservationconferences` (
  `idreservationconferences` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `startdate` varchar(30) NOT NULL,
  `enddate` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `numberofperson` int(11) NOT NULL,
  `checkout` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservationconferences`
--

INSERT INTO `reservationconferences` (`idreservationconferences`, `iduser`, `startdate`, `enddate`, `price`, `numberofperson`, `checkout`) VALUES
(1, 1, '5/17/2023', '5/24/2023', 700, 30, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservationroom`
--

CREATE TABLE `reservationroom` (
  `idreservation` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `startdate` varchar(30) NOT NULL,
  `enddate` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `numberofperson` int(11) NOT NULL,
  `checkout` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservationroom`
--

INSERT INTO `reservationroom` (`idreservation`, `iduser`, `startdate`, `enddate`, `price`, `numberofperson`, `checkout`) VALUES
(1, 1, '5/10/2023', '', 800, 2, 0),
(2, 1, '5/10/2023', '', 800, 2, 0),
(3, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(4, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(5, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(6, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(7, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(8, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(9, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(10, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(11, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(12, 1, '5/10/2023', '5/18/2023', 800, 2, 0),
(13, 0, '5/10/2023', '5/18/2023', 800, 2, 0),
(14, 0, '5/10/2023', '5/18/2023', 800, 2, 0),
(15, 1, '5/19/2023', '5/30/2023', 1100, 2, 0),
(16, 1, '5/19/2023', '5/30/2023', 1100, 2, 0),
(17, 1, '5/19/2023', '5/30/2023', 1100, 2, 0),
(18, 1, '5/19/2023', '5/30/2023', 1100, 2, 0),
(19, 1, '5/19/2023', '5/30/2023', 1100, 2, 0),
(20, 1, '7/13/2023', '7/21/2023', 800, 2, 0),
(21, 1, '7/13/2023', '7/21/2023', 800, 2, 0),
(22, 2, '9/13/2023', '7/21/2023', 5400, 2, 0),
(23, 2, '5/13/2023', '5/20/2023', 700, 2, 0),
(24, 2, '5/13/2023', '5/20/2023', 700, 2, 0),
(25, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(26, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(27, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(28, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(29, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(30, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(31, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(32, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(33, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(34, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(35, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(36, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(37, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(38, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(39, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(40, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(41, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(42, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(43, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(44, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(45, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(46, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(47, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(48, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(49, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(50, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(51, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(52, 2, '5/24/2023', '5/25/2023', 100, 2, 0),
(53, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(54, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(55, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(56, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(57, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(58, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(59, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(60, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(61, 2, '5/26/2023', '5/27/2023', 100, 2, 0),
(62, 2, '10/1/2023', '10/2/2023', 100, 2, 0),
(63, 2, '10/1/2023', '10/2/2023', 100, 2, 0),
(64, 2, '10/3/2023', '10/4/2023', 100, 2, 0),
(65, 2, '10/3/2023', '10/4/2023', 100, 2, 0),
(66, 2, '10/6/2023', '10/7/2023', 100, 2, 0),
(67, 2, '10/6/2023', '10/7/2023', 100, 2, 0),
(68, 2, '10/6/2023', '10/7/2023', 100, 2, 0),
(69, 2, '10/6/2023', '10/7/2023', 100, 2, 0),
(70, 2, '10/6/2023', '10/7/2023', 100, 2, 0),
(71, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(72, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(73, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(74, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(75, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(76, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(77, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(78, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(79, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(80, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(81, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(82, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(83, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(84, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(85, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(86, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(87, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(88, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(89, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(90, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(91, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(92, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(93, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(94, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(95, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(96, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(97, 2, '10/9/2023', '10/12/2023', 300, 2, 0),
(98, 2, '10/21/2023', '10/23/2023', 200, 2, 0),
(99, 2, '10/21/2023', '10/23/2023', 200, 2, 0),
(100, 2, '10/21/2023', '10/23/2023', 200, 2, 1),
(101, 1, '9/14/2023', '5/15/2023', 12200, 3, 0),
(102, 1, '9/14/2023', '5/15/2023', 12200, 3, 1),
(103, 4, '5/15/2023', '5/16/2023', 100, 2, 0),
(104, 5, '5/15/2023', '5/18/2023', 300, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `reservationspa`
--

CREATE TABLE `reservationspa` (
  `idreservationspa` int(11) NOT NULL,
  `iduser` int(11) NOT NULL,
  `startdate` varchar(30) NOT NULL,
  `enddate` varchar(30) NOT NULL,
  `price` int(11) NOT NULL,
  `numberofperson` int(11) NOT NULL,
  `checkout` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservationspa`
--

INSERT INTO `reservationspa` (`idreservationspa`, `iduser`, `startdate`, `enddate`, `price`, `numberofperson`, `checkout`) VALUES
(1, 1, '5/14/2023', '5/16/2023', 200, 2, 1),
(2, 4, '5/16/2023', '5/17/2023', 100, 2, 0),
(3, 5, '5/17/2023', '5/18/2023', 100, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `idroom` int(11) NOT NULL,
  `facilities` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `gdpr` varchar(30) NOT NULL,
  `cnp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`iduser`, `email`, `password`, `firstname`, `lastname`, `phone`, `gdpr`, `cnp`) VALUES
(1, 'adi@yahoo.com', 'adi', '', '', '345435435', '', ''),
(2, 'adrian@yahoo.com', 'adi', 'aaa', 'aaa', '235234545', '', ''),
(3, 'patrick@yahoo.com', 'adi', 'asdasdasd', 'asdasd', '56', '1', ''),
(4, 'asd@yahoo.com', 'asd', 'asd', 'asd', '0755398923', '1', '1234234236767'),
(5, 'covasan@yahoo.com', 'covasan', 'covasan', 'mihai', '0755398923', '1', '2311545134344');

-- --------------------------------------------------------

--
-- Table structure for table `user_office`
--

CREATE TABLE `user_office` (
  `iduseroffice` int(11) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_office`
--

INSERT INTO `user_office` (`iduseroffice`, `firstname`, `lastname`, `email`, `password`) VALUES
(1, 'asd', 'asd', 'adi@yahoo.com', 'adi'),
(2, '', '', '', ''),
(3, '', '', '', ''),
(4, '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reservationconferences`
--
ALTER TABLE `reservationconferences`
  ADD PRIMARY KEY (`idreservationconferences`);

--
-- Indexes for table `reservationroom`
--
ALTER TABLE `reservationroom`
  ADD PRIMARY KEY (`idreservation`);

--
-- Indexes for table `reservationspa`
--
ALTER TABLE `reservationspa`
  ADD PRIMARY KEY (`idreservationspa`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`idroom`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`);

--
-- Indexes for table `user_office`
--
ALTER TABLE `user_office`
  ADD PRIMARY KEY (`iduseroffice`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reservationconferences`
--
ALTER TABLE `reservationconferences`
  MODIFY `idreservationconferences` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reservationroom`
--
ALTER TABLE `reservationroom`
  MODIFY `idreservation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=105;

--
-- AUTO_INCREMENT for table `reservationspa`
--
ALTER TABLE `reservationspa`
  MODIFY `idreservationspa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `idroom` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user_office`
--
ALTER TABLE `user_office`
  MODIFY `iduseroffice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
