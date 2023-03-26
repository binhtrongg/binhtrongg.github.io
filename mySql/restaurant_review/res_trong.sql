-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 26, 2023 at 07:09 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `res_trong`
--

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `post_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`id`, `post_id`, `user_id`, `content`, `publish_time`, `status_id`) VALUES
(1, 1, 1, 'đúng vậy,đồng quan điểm', '2023-03-27 05:43:26', 10),
(2, 2, 1, 'đồng quan điểm', '2023-03-21 13:12:29', 8),
(3, 4, 2, 'thật!', '2023-03-26 05:14:38', 9),
(4, 5, 3, 'quá đúng', '2023-03-08 07:10:05', 8);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `price` double DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `restaurant_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `name`, `description`, `price`, `status_id`, `restaurant_id`) VALUES
(1, 'xôi', 'ngon,ngọt,dẻo', 15, 5, 1),
(2, 'cơm', 'ngon ', 30, 5, 1),
(3, 'cá chép om dưa', 'chua', 100, 5, 2),
(4, 'trứng cuộn', 'mềm', 12, 5, 2),
(5, 'Bánh bao', 'mặn', 18, 5, 3),
(6, 'Bánh mì', 'đắng', 22, 5, 3),
(7, 'cháo lòng', 'thơm,ngon', 35, 5, 4),
(8, 'cơm chiên dương châu', 'béo', 18, 5, 4),
(9, 'cơm tấm', 'chát', 70, 5, 5),
(10, 'hàu nướng', 'bổ', 90000, 5, 6),
(11, 'cua hoàng đế háp bia', 'giá hợp lí', 1.1, 5, 7);

-- --------------------------------------------------------

--
-- Table structure for table `permision`
--

CREATE TABLE `permision` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `permision`
--

INSERT INTO `permision` (`id`, `name`) VALUES
(1, 'review'),
(2, 'comment'),
(3, 'post'),
(4, 'band user'),
(5, 'delete post'),
(6, 'delete comment'),
(7, 'delete review'),
(8, 'hidden post'),
(9, 'hidden comment'),
(10, 'hidden review');

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `id` int(11) NOT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `publish_time` datetime DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `posts`
--

INSERT INTO `posts` (`id`, `restaurant_id`, `title`, `content`, `publish_time`, `status_id`) VALUES
(1, 1, 'đắt', 'không như mong đợi', '2023-03-13 13:19:23', 12),
(2, 2, 'không ngon', 'đúng là không ngon', '2023-03-05 13:41:13', 11),
(3, 3, 'bẩn', 'không như mong đợi', '2023-03-13 13:19:23', 11),
(4, 4, 'không ngon,đắt', 'đúng là không ngon và ngấy', '2023-03-05 13:41:13', 13),
(5, 5, 'rẻ,món ăn hấp dẫn', 'ngon', '2023-03-26 06:28:20', 13),
(6, 6, 'ngon bổ rẻ', 'sẽ quay lại', '2023-03-26 06:28:20', 13),
(7, 7, 'hấp dẫn', 'sẽ giới thiệu', '2023-03-09 01:49:18', 13);

-- --------------------------------------------------------

--
-- Table structure for table `restaurants`
--

CREATE TABLE `restaurants` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone_number` varchar(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `open_time` time DEFAULT NULL,
  `close_time` time DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `restaurants`
--

INSERT INTO `restaurants` (`id`, `name`, `address`, `phone_number`, `email`, `open_time`, `close_time`, `status_id`, `role_id`) VALUES
(1, 'Chen', 'Số 18 Đoàn Trần Nghiệp, Hai Bà Trưng, Hà Nội.', '0123456789', 'chen_res@gmail.com', '09:00:00', '22:00:00', 1, 1),
(2, 'Hải Sản Biển Đông', 'Số 36, đầu ngõ 84, Trần Thái Tông, quận Cầu Giấy, Hà Nội.', '345678910', 'biendong@gmail.com', '10:30:00', '23:00:00', 1, 1),
(3, 'Nét Huế', 'Số 57 Lạc Trung, Phường Vĩnh Tuy, Quận Hai Bà Trưng, Hà Nội', '987654321', 'nethue@gmail.com', '08:30:00', '24:00:00', 1, 1),
(4, 'Moo Beef Steak', 'Số 2F Nguyễn Khánh Toàn, Phường Quan Hoa, Quận Cầu Giấy, Hà Nội (gần ngã tư Quan Hoa giao với Nguyễn Khánh Toàn)', '0437263624', 'beff@gmail.com', '07:00:00', '21:00:00', 1, 2),
(5, 'Lão ngư Chả cá', ' Số 171 Thái Hà, quận Đống Đa, Hà Nội', '02345426566', 'chaca@gmail.com', '08:30:00', '22:00:00', 1, 2),
(6, 'Nấm Việt Hà Thành', ' số 6A Ô Chợ Dừa, Quận Đống Đa, Hà Nội', '04383823238', 'namviet@gmail.com', '09:00:00', '21:30:00', 1, 2),
(7, 'Al Fresco’s', 'số 62 đường Xuân Diệu, quận Tây Hồ, Hà Nội', '04383214343', 'fesco@gmail.com', '09:30:00', '23:30:00', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `id` int(11) NOT NULL,
  `restaurant_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `photo_url` varchar(255) DEFAULT NULL,
  `content` text DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`id`, `restaurant_id`, `user_id`, `photo_url`, `content`, `rating`, `status_id`) VALUES
(1, 7, 1, 'sjdh9wq88ehde', 'dở tệ,một người ghi bàn bằng tóc như tôi khó có thể chấp nhận', 5, 14),
(2, 5, 2, 'dsf8dyfdsh4h483', 'cũng ngon,nhưng hơi dính râu', 3, 16),
(3, 6, 3, 'sad8du8qwd8jc', 'ngon tuyệt vời', 2, 14);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'user'),
(2, 'restaurant'),
(3, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `role_permision`
--

CREATE TABLE `role_permision` (
  `id` int(11) NOT NULL,
  `role_id` int(11) DEFAULT NULL,
  `permision_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `role_permision`
--

INSERT INTO `role_permision` (`id`, `role_id`, `permision_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 1, 9),
(5, 1, 10),
(6, 1, 6),
(7, 1, 7),
(8, 2, 8),
(9, 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `id` int(11) NOT NULL,
  `key` varchar(20) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`id`, `key`, `content`) VALUES
(1, 'RES', 'OPEN'),
(2, 'RES', 'CLOSE'),
(3, 'USER', 'ACTIVE'),
(4, 'USER', 'BANNED'),
(5, 'MENU', 'ACTIVE'),
(6, 'MENU', 'HIDE'),
(7, 'MENU', 'DELETED'),
(8, 'CMT', 'ACTIVE'),
(9, 'CMT', 'HIDDEN'),
(10, 'CMT', 'DELETED'),
(11, 'POST', 'ACTIVE'),
(12, 'POST', 'HIDDEN'),
(13, 'POST', 'DELETED'),
(14, 'REV', 'ACTIVE'),
(15, 'REV', 'HIDDEN'),
(16, 'REV', 'DELETED');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `avatar`, `phone_number`, `email`, `password`, `status_id`, `role_id`) VALUES
(1, 'ri cha', 'dsajdhsa8cds767s', '0232826463', 'richa@gmail.com', 'richa123', 3, 1),
(2, 'si tạ', 'sd8u83c8ds', '02384626233', 'sita@gmail.com', 'sita123', 3, 1),
(3, 'chonq', 'sekjo ccjdufu83ewdhds', '0343827437', 'chonq@gmail.com', 'chonq123', 3, 1),
(4, 'trần bình trọng', 'dfh9438uhdc', '0379221205', 'binhtrong0504@gmail.com', 'trong123', 3, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_id` (`restaurant_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `permision`
--
ALTER TABLE `permision`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_id` (`restaurant_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_id` (`restaurant_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `status_id` (`status_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role_permision`
--
ALTER TABLE `role_permision`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `permision_id` (`permision_id`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `status_id` (`status_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `permision`
--
ALTER TABLE `permision`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `restaurants`
--
ALTER TABLE `restaurants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role_permision`
--
ALTER TABLE `role_permision`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `menu_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `restaurants`
--
ALTER TABLE `restaurants`
  ADD CONSTRAINT `restaurants_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `restaurants_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`id`),
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `reviews_ibfk_3` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

--
-- Constraints for table `role_permision`
--
ALTER TABLE `role_permision`
  ADD CONSTRAINT `role_permision_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `role_permision_ibfk_2` FOREIGN KEY (`permision_id`) REFERENCES `permision` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
