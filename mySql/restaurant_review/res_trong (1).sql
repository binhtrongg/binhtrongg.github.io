-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2023 at 09:29 AM
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
(1, 1, 1, 'ngon ghê', '2023-03-27 05:43:26', 10),
(2, 2, 1, 'sẽ quay lại', '2023-03-21 13:12:29', 8),
(3, 4, 2, 'thật!', '2023-03-26 05:14:38', 9),
(4, 5, 3, 'tuyệt vời', '2023-03-08 07:10:05', 8),
(5, 7, 6, 'wow!', '2023-03-20 07:45:11', 8),
(6, 4, 5, 'quá ok', '2023-03-15 06:51:06', 8);

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
(1, 'Nấm Truffle Alba trắng', 'Nếu nấm Truffle đen là nguyên liệu có thể được tìm thấy và làm vô vàn món ăn trên khắp thế giới thì nấm  Truffle Alba trắng lại có giá đắt đỏ và chỉ dành cho giới thượng lưu. Loai nấm này được trồng ở Ý và được nuôi trong điều kiện vô cùng khắt khe, bảo quản và thu hoạch vô cùng nghiêm ngặt.', 1500000, 5, 1),
(2, 'Trứng cá muối Beluga', 'Trứng cá muối Beluga đã giành lấy ngôi vị món ăn đắt nhất thế giới của trứng cá tầm Siberia. Trứng cá muối Beluga có nguồn gốc từ Iran. Trứng cá muối có giá 20.000 bảng Anh với 1kg trứng cá muối (hơn 600 triệu VNĐ). Trứng cá muối thường được lấy từ cá tầm Beluga nặng đến 900 kg.', 3000000, 5, 1),
(3, 'Pho mát nai sừng tấm', 'Pho mát nai sừng tấm là loại ho mát nai sừng tấm có vị hoàn toàn khác với bất kỳ loại phô mai nào trên thế giới. Loại phô mai này sản xuất từ nguyên liệu là sữa nai sừng tấm. Phô mai này chỉ được sản xuất Thụy Điển, hương vị độc đáo, được bán với giá khoảng 1.000USD/kg và được sản xuất với số lượng giới hạn.', 10000000, 5, 2),
(4, 'Hạt dẻ cười Iran', 'Một trong những loại hạt dẻ ngon nhất hiện nay là hạt dẻ cười Iran, loại hạt này thơm ngon. Hạt dẻ cười Iran là sự pha trộn của hai màu xanh lam và tím đặc biệt. Hạt dẻ cười Iran được trồng trên núi có vị béo ngậy kỳ lạ do ảnh hưởng của môi trường. Giá của loại hạt này là 154 USD (gần 4 triệu đồng).', 12000000, 5, 2),
(5, 'Bò Kobe Nhật Bản', 'Thịt bò Kobe được tạo nên bởi các lớp thịt và mỡ đan xen nhau theo hình vân rất đẹp mắt. Tại Las Vegas, 28 gram thịt bò Kobe Nhật Bản được bán với giá 33 USD (hơn 700.000 đồng) và một miếng bít tết tiêu chuẩn 200 gram có giá 240 USD (hơn 5 triệu đồng).', 1800000, 5, 3),
(6, 'Cà phê cầy hương', 'Cà phê cầy hương là loại cà phê đắt nhất thế giới hiện nay. Cà phê được sản xuất với quy trình đặc biệt chính là cần đi hệ tiêu hóa của cầy hương. Do quý hiếm và giá thành cao nên trên thị trường xuất hiện nhiều loại cà phê cầy nhái, 100 gram hạt cà phê có giá khoảng 150 đô la Mỹ (hơn 3 triệu đồng).', 2200000, 5, 3),
(7, 'Saffron', 'Saffron có nguồn gốc từ Hy Lạp và đã được thu hoạch hoàn toàn bằng tay ở Iran. Vì nghệ tây chỉ sản xuất bảy ngày trong một năm vào mùa thu nên rất hiếm. Để thu hoạch đc nửa gam nghệ tây thì cần phải hái 300.000 bông hoa, có giá 9,90 USD (hơn 200.000 VNĐ).', 3500000, 5, 4),
(8, 'Yến sào', 'Yến sào là món ngon nổi tiếng thế giới và được biết đến như một phương thuốc chữa bệnh hiệu quả cao. Một chén súp yến trắng được bán với giá 2.000 USD (hơn 45 triệu đồng) và một bát súp yến đỏ có giá 10.000 USD (hơn 200 triệu đồng).', 1200000, 5, 4),
(9, 'Dưa hấu đen', 'Dưa hấu đen Densuke có nguồn gốc từ Nhật Bản, là loại trái cây hiếm và đắt gấp 20 lần so với những trái dưa hấu thông thường. Có thời điểm, trái cây này đã được bán trong một cuộc đấu giá trái cây với giá 6.300 USD (hơn 140 triệu đồng). Loại trái cây này rất ít hạt, thậm chí có quả không có hạt và có vị ngọt vô cùng đặc biệt.', 700000, 5, 5),
(10, '24k Pizza', 'Có rất nhiều thứ làm nên độ \"khủng\" của chiếc bánh pizza này. Chẳng hạn như nguyên liệu làm bánh đều khá đắt đỏ như lớp vỏ bánh đen được nhuộm từ mực của con mực, phía trên là lớp phô mai Stilton (một trong những loại phô mai đắt nhất thế giới có nguồn gốc từ Anh với giá thành lên tới gần 9 triệu đồng cho 1kg), gan ngỗng, nấm Truffle trắng gốc Ý (giá lên tới 20 triệu đồng/1kg) và một lớp trứng cá tầm muối.', 900000, 5, 5),
(11, 'Bánh Fleur Burger', 'Với 5.000 USD (tương đương 115 triệu VNĐ), quý khách sẽ được phục vụ một chiếc bánh Fleur burger với phần nhân từ bò Kobe, nấm đen, gan ngỗng và rưới phần nước sốt từ làm nhiều loại nấm Truffle khác nhau (một loại nấm có giá thành rất đắt, thường mọc ngầm dưới đất, không thể trồng bằng biện pháp nhân tọa và rất khó để khai khác).', 1.1, 5, 6),
(12, 'Bánh Posh Pie', 'Chiếc bánh này có phần nhân làm từ thịt bò thượng hạng, tôm hùm đá Úc, nấm Truffle đen mùa đông cực hiếm và điểm tô vài lá vàng để trang trí.', 1555555, 5, 6),
(13, 'Bánh Pizza Louis XIII', 'Để làm được một chiếc pizza Louis XIII, các đầu bếp nơi đây phải tỉ mỉ từng công đoạn. Đối với vỏ bánh, các loại bột được chọn phải là loại hảo hạng, được nhập từ Ả Rập. Kế đến, chúng sẽ được trộn với 1 ít muối hồng Murray và ủ trong trong 72 giờ trước khi đem chế biến.', 20000000, 5, 7),
(14, 'Bánh Fortress Stilt Fisherman Indulgence', 'Ngoài nguyên liệu tươi mới, món bánh này còn thu hút thực khách bởi sự trang trí công phu, cực ấn tượng bằng hình ảnh một người đánh cá được làm thủ công từ socola, bên dưới có một viên ngọc bích 80 cara. Bức tượng này lấy cảm hứng từ chính sở thích câu cá của người Sri Lanka.', 1888888, 5, 7);

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
(1, 1, 'Bào ngư nướng phủ vàng – Quà ngập tràn hạnh phúc', 'Mỗi món quà không đơn giản là 1 tặng phẩm, mà còn là tình cảm, sự tri ân, cùng nhiều tầng ý nghĩa. Bào ngư nướng phủ vàng – Viên ngọc lam quý giá tại Hatoyama chính là một món quà như thế, tượng trưng cho lời cảm ơn, hạnh phúc và sự thịnh vượng Hatoyama muốn dành tặng thực khách:', '2023-03-13 13:19:23', 12),
(2, 2, 'MÀN TRÌNH DIỄN KIM CƯƠNG ĐEN GIỮA LÒNG DI SẢN', 'Chú cá ngừ vây xanh Nhật Bản - viên \"kim cương đen\" quý giá từ đại dương - đã cập bến\" Hatoyama Hạ Long sau hành trình chưa đầy 24h từ phiên chợ Tokyo, Nhật Bản. \r\nBảo vật đã sẵn sàng cho màn trình diễn đặc sắc tại \"thành phố di sản\"', '2023-03-05 13:41:13', 11),
(3, 3, 'XẺ CÁ NGỪ VÂY XANH NHẬT BẢN – TUYỆT TÁC ẨM THỰC, PHONG VỊ THƯỢNG LƯU', '️Với Hatoyama, mỗi thực khách chính là một người thầy, người thân, và là niềm tự hào. Chính bởi vậy, thực khách luôn xứng đáng với những món quà và trải nghiệm ẩm thực đẳng cấp nhất. Đó là lý do Hatoyama dành tặng thực khách buổi trình diễn “Kim cương đen giữa lòng di ', '2023-03-13 13:19:23', 11),
(4, 4, '𝑩𝒍𝒂𝒄𝒌 𝒅𝒊𝒂𝒎𝒐𝒏𝒅 𝒇𝒓𝒐𝒎 𝒐𝒄𝒆𝒂𝒏 | Món quà quý giá cho tình yêu vĩnh cửu', 'Khi mà người người dùng hoa hồng cùng chocolate trong ngày Valentine Trắng, Hatoyama lại dành tặng thực khách - những người thương yêu - một cách riêng để kỷ niệm Lễ Tình Nhân White Day 14/3, đó là màn xẻ cá ngừ vây xanh khủng nặng 156kg tại số 13 Lý Thường Kiệt.', '2023-03-05 13:41:13', 13),
(5, 5, '𝑴𝒐̂̃𝒊 𝒕𝒉𝒖̛̣𝒄 𝒌𝒉𝒂́𝒄𝒉 𝒍𝒂̀ 𝒎𝒐̣̂𝒕 𝒏𝒈𝒖̛𝒐̛̀𝒊 𝒕𝒉𝒂̂𝒏, 𝒏𝒈𝒖̛𝒐̛̀𝒊 𝒕𝒉𝒂̂̀𝒚, 𝒗𝒂̀ 𝒍𝒂̀ 𝒏𝒊𝒆̂̀𝒎 𝒕𝒖̛̣ 𝒉𝒂̀𝒐', 'Tại Hatoyama, có một triết lý mà bất kể cán bộ công nhân viên nào trong nhà hàng đều phải nằm lòng, khắc ghi trong tâm để thể hiện ở từng chi tiết nhỏ trong quá trình phục vụ. Đó là \"Mỗi thực khách là một người thân, một người thầy, và là niềm tự hào\".', '2023-03-26 06:28:20', 13),
(6, 6, '𝑵𝒈𝒉𝒆̣̂ 𝒕𝒉𝒖𝒂̣̂𝒕 𝒄𝒂̆́𝒎 𝒉𝒐𝒂 𝒏𝒂̂𝒏𝒈 𝒕𝒂̂̀𝒎 𝒂̂̉𝒎 𝒕𝒉𝒖̛̣𝒄', 'Một nghệ nhân từng nói: \"Ikebana như khoảng lặng nhỏ bé giữa nhịp sống hối hả, để chúng ta cùng thư giãn, nâng niu, trân quý và hiểu rõ giá trị của thiên nhiên trong đời sống hiện đại”. ', '2023-03-26 06:28:20', 13),
(7, 7, 'HATOYAMA TẶNG SUSHI NỮ HOÀNG – CÙNG NÀNG TỎA SÁNG', 'Hatoyama tin rằng mỗi người phụ nữ chính là một Nữ Hoàng tỏa sáng theo cách riêng mình. Dù bằng cách nào đi nữa, họ cũng đều mang đến sắc màu diệu kỳ, làm trái đất trở nên tươi đẹp hơn.', '2023-03-09 01:49:18', 13);

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
(3, 6, 3, 'sad8du8qwd8jc', 'ngon tuyệt vời', 2, 14),
(4, 5, 5, 'sdhisđh3ìei', 'cá hơi tanh', 8, 14),
(5, 6, 5, 'dsisxhc93hc', 'ngon, view đẹp', NULL, NULL);

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
(16, 'REV', 'DELETED'),
(17, 'ADM', 'ACTIVE');

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
(1, 'Rô Nan Đô', 'dsajdhsa8cds767s', '0232826463', 'richa@gmail.com', 'richa123', 3, 1),
(2, 'Méc Si', 'sd8u83c8ds', '02384626233', 'sita@gmail.com', 'sita123', 3, 1),
(3, 'Em Pa Pê', 'ccjdufu83ewdhds', '0343827437', 'chonq@gmail.com', 'chonq123', 3, 1),
(4, 'Trần Bình Trọng', 'dfh9438uhdc', '0379221205', 'binhtrong0504@gmail.com', 'trong123', 17, 3),
(5, 'Bủ Nô', 'cdiwfu38hfeed', '02398327347', 'buno@gmail.com', 'buno123', 3, 1),
(6, 'Cà Sê Mi Rô', 'dfjid4ivdi', '05432764332', 'case@gmail.com', 'case', 3, 1);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

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
