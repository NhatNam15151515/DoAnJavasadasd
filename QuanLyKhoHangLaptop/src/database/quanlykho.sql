-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for quanlykho
CREATE DATABASE IF NOT EXISTS `quanlykho` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `quanlykho`;

-- Dumping structure for table quanlykho.chitietphieunhap
CREATE TABLE IF NOT EXISTS `chitietphieunhap` (
  `MaPhieuNhap` varchar(50) NOT NULL,
  `MaLaptop` varchar(50) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` double NOT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  KEY `MaPhieuNhap` (`MaPhieuNhap`),
  KEY `MaLaptop` (`MaLaptop`),
  CONSTRAINT `FK_chitietphieunhap_laptop` FOREIGN KEY (`MaLaptop`) REFERENCES `laptop` (`MaLaptop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_chitietphieunhap_phieunhap` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`MaPhieuNhap`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.chitietphieunhap: ~18 rows (approximately)
INSERT INTO `chitietphieunhap` (`MaPhieuNhap`, `MaLaptop`, `SoLuong`, `ThanhTien`, `isDelete`) VALUES
	('PN1', 'VB15X5', 10, 154900000, 0),
	('PN1', 'VBG15E', 10, 122900000, 0),
	('PN1', 'TUFA15F', 10, 219900000, 0),
	('PN2', 'GB15BR5', 20, 373800000, 0),
	('PN2', 'GKAABR7', 20, 579800000, 0),
	('PN2', 'GT18HXAI9', 20, 2999800000, 0),
	('PN3', 'MA13M222', 30, 749700000, 0),
	('PN3', 'MP14M3M', 30, 2384700000, 0),
	('PN3', 'MP14M3P', 30, 1484700000, 0),
	('PN1', 'VB15X5', 10, 154900000, 0),
	('PN1', 'VBG15E', 10, 122900000, 0),
	('PN1', 'TUFA15F', 10, 219900000, 0),
	('PN2', 'GB15BR5', 20, 373800000, 0),
	('PN2', 'GKAABR7', 20, 579800000, 0),
	('PN2', 'GT18HXAI9', 20, 2999800000, 0),
	('PN3', 'MA13M222', 30, 749700000, 0),
	('PN3', 'MP14M3M', 30, 2384700000, 0),
	('PN3', 'MP14M3P', 30, 1484700000, 0);

-- Dumping structure for table quanlykho.chitietphieuxuat
CREATE TABLE IF NOT EXISTS `chitietphieuxuat` (
  `MaPhieuXuat` varchar(50) NOT NULL,
  `MaLapTop` varchar(50) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `ThanhTien` double NOT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  KEY `MaPhieuXuat` (`MaPhieuXuat`),
  KEY `MaLapTop` (`MaLapTop`),
  CONSTRAINT `FK_chitietphieuxuat_laptop` FOREIGN KEY (`MaLapTop`) REFERENCES `laptop` (`MaLaptop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_chitietphieuxuat_phieuxuat` FOREIGN KEY (`MaPhieuXuat`) REFERENCES `phieuxuat` (`MaPhieuXuat`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.chitietphieuxuat: ~19 rows (approximately)
INSERT INTO `chitietphieuxuat` (`MaPhieuXuat`, `MaLapTop`, `SoLuong`, `ThanhTien`, `isDelete`) VALUES
	('PX1', 'ROGSS17', 50, 3474500000, 0),
	('PX1', 'MA13M222', 50, 1249500000, 0),
	('PX1', 'MP14M3', 50, 1949500000, 0),
	('PX2', 'MA15M235W', 50, 1444500000, 0),
	('PX2', 'MP14M3P', 50, 2474500000, 0),
	('PX2', 'VB15X', 50, 495000000, 0),
	('PX3', 'ROGSS18', 50, 6049500000, 0),
	('PX3', 'VBG15E', 50, 614500000, 0),
	('PX3', 'ZB14OLUX', 50, 1364500000, 0),
	('PX1', 'ROGSS17', 50, 3474500000, 0),
	('PX1', 'MA13M222', 50, 1249500000, 0),
	('PX1', 'MP14M3', 50, 1949500000, 0),
	('PX2', 'MA15M235W', 50, 1444500000, 0),
	('PX2', 'MP14M3P', 50, 2474500000, 0),
	('PX2', 'VB15X', 50, 495000000, 0),
	('PX3', 'ROGSS18', 50, 6049500000, 0),
	('PX3', 'VBG15E', 50, 614500000, 0),
	('PX3', 'ZB14OLUX', 50, 1364500000, 0),
	('PX1', 'MP14M3M', 999, 79410510000, 0);

-- Dumping structure for table quanlykho.cuahang
CREATE TABLE IF NOT EXISTS `cuahang` (
  `MaCuaHang` varchar(50) NOT NULL,
  `TenCH` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaCuaHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.cuahang: ~3 rows (approximately)
INSERT INTO `cuahang` (`MaCuaHang`, `TenCH`, `DiaChi`, `SDT`, `isDelete`) VALUES
	('CH1', 'Cua Hang 1', '55 Cách Mạng tháng 8, phường 1, quận 8, TP HCM', NULL, 0),
	('CH2', 'Cua Hang 2', 'hẻm 77, phường Bến Nghé, Quận 1, TP HCM', NULL, 0),
	('CH3', 'Cua Hang 3', '243/17 Tô Hiến Thành, Phường 13, Quận 10, TP HCM', NULL, 0);

-- Dumping structure for table quanlykho.laptop
CREATE TABLE IF NOT EXISTS `laptop` (
  `MaLaptop` varchar(50) NOT NULL,
  `TenLaptop` varchar(50) NOT NULL,
  `CPU` varchar(50) DEFAULT NULL,
  `GPU` varchar(50) DEFAULT NULL,
  `Ram` varchar(50) DEFAULT NULL,
  `Rom` varchar(50) DEFAULT NULL,
  `HeDieuHanh` varchar(50) DEFAULT NULL,
  `ManHinh` varchar(50) DEFAULT NULL,
  `Hang` varchar(50) DEFAULT NULL,
  `NamSanXuat` int(11) DEFAULT NULL,
  `Gia` double NOT NULL DEFAULT 0,
  `SoLuong` int(11) NOT NULL DEFAULT 0,
  `MaNhaCungCap` varchar(50) NOT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaLaptop`),
  UNIQUE KEY `MaLaptop` (`MaLaptop`),
  KEY `FK_laptop_nhacungcap` (`MaNhaCungCap`),
  CONSTRAINT `FK_laptop_nhacungcap` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`MaNhaCungCap`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.laptop: ~26 rows (approximately)
INSERT INTO `laptop` (`MaLaptop`, `TenLaptop`, `CPU`, `GPU`, `Ram`, `Rom`, `HeDieuHanh`, `ManHinh`, `Hang`, `NamSanXuat`, `Gia`, `SoLuong`, `MaNhaCungCap`, `isDelete`) VALUES
	('GB15BR5', 'MSI Gaming Bravo 15 B7ED R5', 'Ryzen 5, 7535HS', 'Card rời, RX 6550M', '16 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD', 'MSI', 2023, 18690000, 0, 'ncc2', 0),
	('GG63T12U', 'MSI Gaming GF63 Thin 12UCX i5', 'intel i5, 12450H', 'Card rời, RTX 2050 ', '16 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD', 'MSI', 2023, 16990000, 0, 'ncc2', 0),
	('GKAABR7', 'MSI Gaming Katana A15 AI B8VE R7', 'Ryzen 7, 8845HS', 'Card rời, RTX 4050', '16 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD', 'MSI', 2023, 28990000, 0, 'ncc2', 0),
	('GS16AIS', 'MSI Gaming Stealth 16 AI Studio', 'Ultra 9, 185H', 'Card rời, RTX 4070', '32 GB', '2 TB', 'Windows 11', '16 inch, QHD+', 'MSI', 2023, 64990000, 0, 'ncc2', 0),
	('GT18HXAI9', 'MSI Gaming Titan 18 HX A14VIG i9', 'intel i9, 14900HX', 'Card rời, RTX 4090', '128 GB', '4 TB', 'Windows 11', '18 inch, 4K/UHD+', 'MSI', 2023, 149990000, 0, 'ncc2', 0),
	('M14C11I3', ' MSI Modern 14 C11M i3', 'intel i3, 1115G4', 'Card tích hợp, Intel UHD', '8 GB', '512 GB', 'Windows 11', '14 inch, Full HD', 'MSI', 2023, 8490000, 0, 'ncc2', 0),
	('MA13M1208C', 'MacBook Air 13 inch M1 2020 8-core ', 'Apple M1', 'Card tích hợp7 nhân GPU', '8 GB', '256 GB', 'macOS', '13.3 inch, Retina', 'Apple', 2020, 18990000, 0, 'ncc3', 0),
	('MA13M222', 'MacBook Air 13 inch M2 8GB/256GB ', 'Apple M2', 'Card tích hợp, 8 nhân GPU', '8 GB', '256 GB', 'macOS', '13.6 inch, Liquid Retina', 'Apple', 2022, 24990000, 0, 'ncc3', 0),
	('MA15M235W', 'MacBook Air 15 inch M2 35W', 'Apple M2', 'Card tích hợp, 10 nhân GPU', '8 GB', '256 GB', 'macOS', '15.3 inch, Liquid Retina', 'Apple', 2023, 28890000, 0, 'ncc3', 0),
	('MP14M3', 'MacBook Pro 14 inch M3 8GB/512GB', 'Apple M3', 'Card tích hợp, 10 nhân GPU', '8 GB', '512 GB', 'macOS', '14.2 inch, Liquid Retina ', 'Apple', 2023, 38990000, 0, 'ncc3', 0),
	('MP14M3M', 'MacBook Pro 14 inch M3 Max 36GB/1TB ', 'Apple M3 Max', 'Card tích hợp30 nhân GPU', '32 GB', '1 TB', 'macOS', '14.2 inch, Liquid Retina ', 'Apple', 2023, 79490000, 0, 'ncc3', 0),
	('MP14M3P', 'MacBook Pro 14 inch M3 Pro 18GB/512GB', 'Apple M3 Pro', 'Card tích hợp, 14 nhân GPU', '16 GB', '512 GB', 'macOS', '14.2 inch, Liquid Retina ', 'Apple', 2023, 49490000, 0, 'ncc3', 0),
	('P16STA1I', 'MSI Prestige 16 Studio A13VE i7', 'intel i7, 13700H', 'Card rời, RTX 4050 ', '16 GB', '1 TB', 'Windows 11', '16 inch, QHD+', 'MSI', 2023, 44490000, 0, 'ncc2', 0),
	('ROGSS17', 'ASUS Gaming ROG Strix SCAR 17', 'Ryzen 9, 7945HX', 'Card rời, RTX 4080 ', '32 GB', '1 TB', 'Windows 11', '17.3 inch, WQHD', 'ASUS', 2023, 69490000, 0, 'ncc1', 0),
	('ROGSS18', 'ASUS Gaming ROG Strix SCAR 18', 'intel i9, 14900HX', 'Card rời, RTX 4090', '64 GB', '2 TB', 'Windows 11', '18 inch, QHD+', 'ASUS', 2023, 120990000, 0, 'ncc1', 0),
	('ROGZM16', 'ASUS Gaming ROG Zephyrus M16 ', 'intel i9, 13900H', 'Card rời, RTX 4070', '32 GB', '1 TB', 'Windows 11', '16 inch, QHD+', 'ASUS', 2023, 72490000, 0, 'ncc1', 0),
	('TUF15FX5', 'ASUS TUF Gaming F15 FX507ZC4', 'intel i5, 12500H', 'Card rời, RTX 3050', '16 GB', '1 TB', 'Windows 11', '15.6 inch, Full HD', 'ASUS', 2023, 21990000, 0, 'ncc1', 0),
	('TUF15FX5I7', 'ASUS TUF Gaming F15 FX507VU i7 ', 'intel i7, 13620H', 'Card rời, RTX 4050', '16 GB', '1 TB', 'Windows 11', '15.6 inch, Full HD', 'ASUS', 2023, 28290000, 0, 'ncc1', 0),
	('TUF15FXI7', 'ASUS TUF Gaming F15 FX507VV i7', 'intel i7, 13620H', 'Card rời, RTX 4060', '32 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD', 'ASUS', 2023, 33490000, 0, 'ncc1', 0),
	('TUF17FX7', 'ASUS TUF Gaming F17 FX706HF', 'intel i5, 11400H', 'Card rời, RTX 2050 4GB', '16 GB', '512 GB', 'Windows 11', '17.3 inch, Full HD', 'ASUS', 2023, 17490000, 0, 'ncc1', 0),
	('TUFA15F', 'ASUS TUF Gaming A15 FA507NU', 'Ryzen, 57535HS', 'Card rời, RTX 4050', '16 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD', 'ASUS', 2023, 21990000, 0, 'ncc1', 0),
	('VB15OA', 'ASUS Vivobook 15 OLED A1505ZA', 'intel i5, 12500H', 'Card tích hợp, Intel Iris Xe', '16 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD', 'ASUS', 2023, 16490000, 0, 'ncc1', 0),
	('VB15X', 'ASUS Vivobook 15 X1504ZA', 'intel i3, 1215U', 'Card tích hợp, Intel UHD', '8 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD ', 'ASUS', 2023, 9900000, 0, 'ncc1', 0),
	('VB15X5', 'ASUS Vivobook 15 X1504ZA5', 'intel i5, 1235U', 'Card tích hợp, Intel Iris Xe', '16 GB', '1 TB', 'Windows 11', '15.6 inch, Full HD', 'ASUS', 2023, 15490000, 0, 'ncc1', 0),
	('VBG15E', 'ASUS Vivobook Go 15 E1504FA', 'Ryzen 57520U', 'Card tích hợp, Radeon', '16 GB', '512 GB', 'Windows 11', '15.6 inch, Full HD ', 'ASUS', 2023, 12290000, 0, 'ncc1', 0),
	('ZB14OLUX', 'ASUS Zenbook 14 OLED UX3405MA', 'Ultra 5, 125H', 'Card tích hợp, Intel Arc Graphics', '16 GB', '512 GB', 'Windows 11', '14 inch, 2.8K', 'ASUS', 2023, 27290000, 0, 'ncc1', 0);

-- Dumping structure for table quanlykho.luutru
CREATE TABLE IF NOT EXISTS `luutru` (
  `IMEI` varchar(50) NOT NULL,
  `MaPhieuNhap` varchar(50) NOT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`IMEI`),
  KEY `FK_luutru_phieunhap` (`MaPhieuNhap`),
  CONSTRAINT `FK_luutru_phieunhap` FOREIGN KEY (`MaPhieuNhap`) REFERENCES `phieunhap` (`MaPhieuNhap`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.luutru: ~0 rows (approximately)

-- Dumping structure for table quanlykho.nguoidung
CREATE TABLE IF NOT EXISTS `nguoidung` (
  `MaNguoiDung` varchar(50) NOT NULL,
  `TaiKhoan` varchar(50) DEFAULT NULL,
  `MatKhau` varchar(50) DEFAULT NULL,
  `PhamViTruyCap` tinyint(4) NOT NULL DEFAULT 0,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaNguoiDung`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.nguoidung: ~6 rows (approximately)
INSERT INTO `nguoidung` (`MaNguoiDung`, `TaiKhoan`, `MatKhau`, `PhamViTruyCap`, `isDelete`) VALUES
	('ND1', 'HoaiNam', '3001', 0, 0),
	('ND2', 'HoaiThuong', '0312', 1, 0),
	('ND3', 'HuyenMy', '1102', 0, 0),
	('ND4', 'AnhKiet', '1234', 0, 0),
	('ND5', 'MyNhan', '1234', 0, 0),
	('ND6', 'NgocMai', '1234', 0, 0);

-- Dumping structure for table quanlykho.nhacungcap
CREATE TABLE IF NOT EXISTS `nhacungcap` (
  `MaNhaCungCap` varchar(50) NOT NULL DEFAULT '',
  `TenNhaCungCap` varchar(50) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaNhaCungCap`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.nhacungcap: ~3 rows (approximately)
INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `DiaChi`, `SDT`, `Email`, `isDelete`) VALUES
	('ncc1', 'nha cung cap 1', 'TP HCM', NULL, NULL, 0),
	('ncc2', 'nha cung cap 2', 'Ha Noi', NULL, NULL, 0),
	('ncc3', 'nha cung cap 3', 'Da Nang', NULL, NULL, 0);

-- Dumping structure for table quanlykho.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `MaNhanVien` varchar(50) NOT NULL DEFAULT '',
  `TenNhanVien` varchar(50) DEFAULT '',
  `NgaySinh` date DEFAULT NULL,
  `GioiTinh` tinyint(4) DEFAULT NULL,
  `SDT` varchar(50) DEFAULT NULL,
  `MaNguoiDung` varchar(50) NOT NULL DEFAULT '0',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaNhanVien`),
  KEY `FK_nhanvien_nguoidung` (`MaNguoiDung`),
  CONSTRAINT `FK_nhanvien_nguoidung` FOREIGN KEY (`MaNguoiDung`) REFERENCES `nguoidung` (`MaNguoiDung`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.nhanvien: ~6 rows (approximately)
INSERT INTO `nhanvien` (`MaNhanVien`, `TenNhanVien`, `NgaySinh`, `GioiTinh`, `SDT`, `MaNguoiDung`, `isDelete`) VALUES
	('NV1', 'Trần Hoài Nam', '2004-11-01', 1, '0939513574', 'ND1', 0),
	('NV2', 'Phạm Lê Hoài Thương', '2005-12-03', 0, '123456789', 'ND2', 0),
	('NV3', 'Trần Thị Huyền My', '2004-02-11', 0, '987654321', 'ND3', 0),
	('NV4', 'Nguyễn Hoài Anh Kiệt', '2024-04-30', 1, '123456789', 'ND4', 0),
	('NV5', 'Nguyễn Trương Mỹ Nhân', '2004-02-01', 0, '123456789', 'ND5', 0),
	('NV6', 'Trần Thị Ngọc Mai', '2004-02-01', 0, '123456789', 'ND6', 0);

-- Dumping structure for table quanlykho.phieunhap
CREATE TABLE IF NOT EXISTS `phieunhap` (
  `MaPhieuNhap` varchar(50) NOT NULL,
  `MaNhaCungCap` varchar(50) NOT NULL,
  `TongSoLuong` int(11) NOT NULL DEFAULT 0,
  `TongTien` double NOT NULL DEFAULT 0,
  `NgayNhap` date NOT NULL,
  `MaNhanVien` varchar(50) NOT NULL DEFAULT '0',
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaPhieuNhap`),
  KEY `FK_phieunhap_nhacungcap` (`MaNhaCungCap`),
  KEY `FK_phieunhap_nhanvien` (`MaNhanVien`),
  CONSTRAINT `FK_phieunhap_nhacungcap` FOREIGN KEY (`MaNhaCungCap`) REFERENCES `nhacungcap` (`MaNhaCungCap`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_phieunhap_nhanvien` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.phieunhap: ~3 rows (approximately)
INSERT INTO `phieunhap` (`MaPhieuNhap`, `MaNhaCungCap`, `TongSoLuong`, `TongTien`, `NgayNhap`, `MaNhanVien`, `isDelete`) VALUES
	('PN1', 'ncc1', 60, 995400000, '0000-00-00', 'NV1', 0),
	('PN2', 'ncc2', 120, 7906800000, '0000-00-00', 'NV1', 0),
	('PN3', 'ncc3', 180, 9238200000, '2024-04-17', 'NV3', 0);

-- Dumping structure for table quanlykho.phieuxuat
CREATE TABLE IF NOT EXISTS `phieuxuat` (
  `MaPhieuXuat` varchar(50) NOT NULL,
  `MaCuaHang` varchar(50) NOT NULL,
  `TongSoLuong` int(11) NOT NULL,
  `TongTien` double NOT NULL,
  `NgayXuat` date NOT NULL,
  `MaNhanVien` varchar(50) NOT NULL,
  `isDelete` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`MaPhieuXuat`),
  KEY `FK_phieuxuat_cuahang` (`MaCuaHang`),
  KEY `FK_phieuxuat_nhanvien` (`MaNhanVien`),
  CONSTRAINT `FK_phieuxuat_cuahang` FOREIGN KEY (`MaCuaHang`) REFERENCES `cuahang` (`MaCuaHang`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_phieuxuat_nhanvien` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlykho.phieuxuat: ~3 rows (approximately)
INSERT INTO `phieuxuat` (`MaPhieuXuat`, `MaCuaHang`, `TongSoLuong`, `TongTien`, `NgayXuat`, `MaNhanVien`, `isDelete`) VALUES
	('PX1', 'CH1', 1299, 92757510000, '2024-04-17', 'NV1', 0),
	('PX2', 'CH2', 300, 8828000000, '2024-04-17', 'NV2', 0),
	('PX3', 'CH3', 300, 16057000000, '2024-04-17', 'NV3', 0);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
