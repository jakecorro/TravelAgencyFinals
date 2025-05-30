-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 30, 2025 at 02:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tagency`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bookings`
--

CREATE TABLE `tbl_bookings` (
  `b_id` int(50) NOT NULL,
  `u_id` int(50) NOT NULL,
  `f_id` int(50) NOT NULL,
  `b_date` date NOT NULL,
  `b_status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_flights`
--

CREATE TABLE `tbl_flights` (
  `f_id` int(100) NOT NULL,
  `f_destination` varchar(100) NOT NULL,
  `f_sdate` date NOT NULL,
  `f_edate` date NOT NULL,
  `f_price` varchar(100) NOT NULL,
  `f_status` varchar(100) NOT NULL,
  `f_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_flights`
--

INSERT INTO `tbl_flights` (`f_id`, `f_destination`, `f_sdate`, `f_edate`, `f_price`, `f_status`, `f_image`) VALUES
(1, 'Japan', '2026-09-01', '2026-01-06', '45000', 'Available', ''),
(2, 'Thailand', '0000-00-00', '2026-06-24', '50000', 'Available', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `l_id` int(20) NOT NULL,
  `u_id` int(20) NOT NULL,
  `f_id` int(20) NOT NULL,
  `f_date` date NOT NULL,
  `actions` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_type` varchar(20) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `u_image` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `u_image`) VALUES
(11, 'Vivian', 'Torrenueva', 'vvt@gmail.com', 'bibyans', 'ZHjuuTy8L9rnZvWujHnv0P9/oZ9FpV0MOyV0Cftc1sA=', 'Admin', 'Active', ''),
(13, 'Jake ', 'Corro', 'jakeemman@gmail.com', 'emman', 'Emmanuel@12', 'Admin', 'Active', 'src/userimages/2f289049-d92b-434c-a3a8-d7ee89c3bed4.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_bookings`
--
ALTER TABLE `tbl_bookings`
  ADD PRIMARY KEY (`b_id`),
  ADD KEY `f_id` (`f_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_flights`
--
ALTER TABLE `tbl_flights`
  ADD PRIMARY KEY (`f_id`);

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`l_id`),
  ADD KEY `u_id` (`u_id`,`f_id`),
  ADD KEY `f_id` (`f_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_bookings`
--
ALTER TABLE `tbl_bookings`
  MODIFY `b_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_flights`
--
ALTER TABLE `tbl_flights`
  MODIFY `f_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `l_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_bookings`
--
ALTER TABLE `tbl_bookings`
  ADD CONSTRAINT `f_id` FOREIGN KEY (`f_id`) REFERENCES `tbl_flights` (`f_id`),
  ADD CONSTRAINT `u_id` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`);

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`),
  ADD CONSTRAINT `tbl_logs_ibfk_2` FOREIGN KEY (`f_id`) REFERENCES `tbl_flights` (`f_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
