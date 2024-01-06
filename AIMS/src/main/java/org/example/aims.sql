-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2023 at 06:30 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aims`
--


-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `media_id` int(11) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `cover_type` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL,
  `publish_date` varchar(45) DEFAULT NULL,
  `num_of_pages` int(11) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `book_category` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- --------------------------------------------------------

--
-- Table structure for table `cd`
--

CREATE TABLE `cd` (
  `cd_id` int(11) NOT NULL,
  `media_id` int(11) DEFAULT NULL,
  `artist` varchar(45) DEFAULT NULL,
  `released_date` varchar(45) DEFAULT NULL,
  `record_lable` varchar(45) DEFAULT NULL,
  `music_type` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `delivery_info`
--

CREATE TABLE `delivery_info` (
  `delivery_info_id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `instruction` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `is_rush` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `delivery_info`
--


-- --------------------------------------------------------

--
-- Table structure for table `dvd`
--

CREATE TABLE `dvd` (
  `dvd_id` int(11) NOT NULL,
  `media_id` int(11) DEFAULT NULL,
  `disc_type` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  `studio` varchar(45) DEFAULT NULL,
  `released_date` varchar(45) DEFAULT NULL,
  `subtitle` varchar(45) DEFAULT NULL,
  `runtime` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoice_id` int(11) NOT NULL,
  `transaction_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `status` char(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `media`
--

CREATE TABLE `media` (
  `media_id` int(11) NOT NULL,
  `price` float DEFAULT NULL,
  `available` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `imageURL` char(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `support_rush_delivery` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(11) NOT NULL,
  `delivery_info_id` int(11) DEFAULT NULL,
  `shipping_amounts` float DEFAULT NULL,
  `total_amounts` float DEFAULT NULL,
  `cart_amounts` float DEFAULT NULL,
  `rush_order` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `order`
--

-- --------------------------------------------------------

--
-- Table structure for table `order_media`
--

CREATE TABLE `order_media` (
  `media_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `delivery_info_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;



CREATE TABLE `rush_delivery_info` (
  `delivery_info_id` int(11) NOT NULL,
  `rd_time` varchar(45) DEFAULT NULL,
  `rd_address` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL,
  `amount` float DEFAULT NULL,
  `contents` varchar(45) DEFAULT NULL,
  `error_message` varchar(45) DEFAULT NULL,
  `time` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `ref_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`book_id`),
  ADD KEY `media_id` (`media_id`);

--
-- Indexes for table `cd`
--
ALTER TABLE `cd`
  ADD PRIMARY KEY (`cd_id`),
  ADD KEY `media_id` (`media_id`);

--
-- Indexes for table `delivery_info`
--
ALTER TABLE `delivery_info`
  ADD PRIMARY KEY (`delivery_info_id`);

--
-- Indexes for table `dvd`
--
ALTER TABLE `dvd`
  ADD PRIMARY KEY (`dvd_id`),
  ADD KEY `media_id` (`media_id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoice_id`),
  ADD UNIQUE KEY `transaction_id` (`transaction_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`media_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `delivery_info_id` (`delivery_info_id`);

--
-- Indexes for table `order_media`
--
ALTER TABLE `order_media`
  ADD PRIMARY KEY (`media_id`,`order_id`,`delivery_info_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `rush_delivery_info`
--
ALTER TABLE `rush_delivery_info`
  ADD PRIMARY KEY (`delivery_info_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transaction_id`);

INSERT INTO `media` (`media_id`, `price`, `available`, `name`, `imageURL`, `category`, `weight`, `support_rush_delivery`) VALUES
(1, 500000, 10, 'The Great Gatsby', 'images/gatsby.png', 'Book', 0.5, 1),
(2, 350000, 5, 'Kind of Blue - Miles Davis', 'images/kindofblue.jpg', 'CD', 0.2, 0),
(3, 600000, 8, 'Inception', 'images/inception.png', 'DVD', 0.3, 1),
(4, 400000, 15, '1984 - George Orwell', 'images/1984.png', 'Book', 0.6, 1),
(5, 300000, 20, 'Abbey Road - The Beatles', 'images/abbeyroad.png', 'CD', 0.2, 0),
(6, 750000, 4, 'The Godfather', 'images/godfather.png', 'DVD', 0.4, 1);
--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `cd`
--
ALTER TABLE `cd`
  MODIFY `cd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `delivery_info`
--
ALTER TABLE `delivery_info`
  MODIFY `delivery_info_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT for table `dvd`
--
ALTER TABLE `dvd`
  MODIFY `dvd_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoice_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `media`
--
ALTER TABLE `media`
  MODIFY `media_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14266178;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `book_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`);

--
-- Constraints for table `cd`
--
ALTER TABLE `cd`
  ADD CONSTRAINT `cd_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`);

--
-- Constraints for table `dvd`
--
ALTER TABLE `dvd`
  ADD CONSTRAINT `dvd_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`);

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`transaction_id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `order_ibfk_1` FOREIGN KEY (`delivery_info_id`) REFERENCES `delivery_info` (`delivery_info_id`);

--
-- Constraints for table `order_media`
--
ALTER TABLE `order_media`
  ADD CONSTRAINT `order_media_ibfk_1` FOREIGN KEY (`media_id`) REFERENCES `media` (`media_id`),
  ADD CONSTRAINT `order_media_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`);

--
-- Constraints for table `rush_delivery_info`
--
ALTER TABLE `rush_delivery_info`
  ADD CONSTRAINT `rush_delivery_info_ibfk_1` FOREIGN KEY (`delivery_info_id`) REFERENCES `delivery_info` (`delivery_info_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
