# 🏨 Hotel Reservation System (Java Console App)

Project UAS PBO: A simple console-based hotel reservation system built in Java.

## 📁 Fitur Utama

- Menambahkan data customer
- Melihat daftar customer
- Menambahkan dan melihat daftar kamar hotel
- Melakukan reservasi (booking kamar)
- Melihat seluruh data reservasi

## 🚀 Cara Menjalankan di Terminal

### 1. Clone Repository

```bash
git clone https://github.com/username/uas-pbo.git
cd uas-pbo/src
```

### 2. Compile Semua File Java

> Pastikan kamu punya Java JDK minimal versi 17 atau lebih tinggi.

```bash
# Compile semua file ke folder `out/`
mkdir -p ../out
javac -d ../out */*.java Main.java
```

### 3. Jalankan Program

```bash
cd ../out
java Main
```

## 🧭 Panduan Penggunaan Program

Setelah dijalankan, kamu akan disambut dengan menu seperti berikut:

```
Hotel Reservation System
1. Customer Menu
2. Room Menu
3. Reservation Menu
0. Exit
```

### 💡 Customer Menu

- Tambah customer: Masukkan nama, email, dan nomor HP
- Lihat daftar customer

### 🛏 Room Menu

- Tambah kamar: Tentukan nomor kamar dan tipe kamar
- Lihat daftar kamar yang tersedia

### 📅 Reservation Menu

- Booking kamar: Pilih customer, pilih kamar, masukkan tanggal check-in dan check-out
- Lihat semua reservasi yang sudah dilakukan

## 🧱 Struktur Folder

```
uas-pbo/
├── src/
│   ├── entities/
│   │   └── Customer.java, Room.java
│   ├── managers/
│   │   └── CustomerManagement.java, RoomManagement.java, ReservationManagement.java
│   └── Main.java
├── out/             # Folder hasil kompilasi (setelah javac)
└── README.md        # Dokumentasi ini
```

## 🧑‍💻 Developer
Ausath Abdi Dzil Ikram, 
Raditya Reza Faizi, 
Rigi Yoga Sumarta, 
Annabelle Evrilya Savhisnu, 
Ilham Rizky Ramadhan
 
