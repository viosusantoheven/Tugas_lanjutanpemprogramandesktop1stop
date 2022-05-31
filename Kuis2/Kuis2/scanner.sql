-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 31 Bulan Mei 2022 pada 07.38
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ilkom`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `scanner`
--

CREATE TABLE `scanner` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(10) NOT NULL,
  `jenis` enum('Scanner Drum','Scanner Flatbed','Barcode scanner','Scanner X-Ray') NOT NULL,
  `merek` varchar(50) NOT NULL,
  `harga` int(10) NOT NULL,
  `warna` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `scanner`
--

INSERT INTO `scanner` (`id`, `tanggal`, `jenis`, `merek`, `harga`, `warna`) VALUES
(3, '2022-05-24', 'Barcode scanner', 'Logitech', 250000, 'biru');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `scanner`
--
ALTER TABLE `scanner`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `scanner`
--
ALTER TABLE `scanner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
