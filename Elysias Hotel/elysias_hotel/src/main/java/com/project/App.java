package com.project;

import com.project.Room.Room;
import com.project.User.Guest;
import com.project.User.User;

import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        // java fx buat interaktif
//        Scanner input = new Scanner(System.in);
//        System.out.print("UserName : " );     // Gambaran untuk input dari pengguna sesuaikan dengan java fx
//        String userName = input.nextLine();
//        System.out.print("Password : " );
//        String password = input.nextLine();

        User user = new User("kita", "password"); // Awal user masukin username dan password buat jadi interaktif
        Guest guest = new Guest(user);



        //User Login dengan method login
//        if (guest.Login(user)){
//            System.out.println("Berhasil Login"); // kalau berhasil user diarahkan ke halaman utama
//        }
//        else{
//            System.out.println("Your Username or Password is Wrong");
//        }

//        guest.isExsist(user);

        // Kalau misal blm punya ke signUp data nya dari User user
//        if (guest.SignUp(user)){
//            System.out.println("Berhasil membuat akun");
//            guest.addWallet(guest); // pas buat akun wallet otomastis dibuat
//            guest.AddProfile(user); // User diarahkan ke halaman add profile untuk mengisi profile mereka
//        }


//        guest.DelAccount(user); // untuk delete akun user
//
//        guest.UpdateProfile(user); // Update Profile user diarahkan ke halaman untuk update profile


//        guest.DisplayProfile(user);

//        guest.getNama(guest); // Mendapatkan nama user
//        guest.getNoTel(guest); // Mendapatkan noTel user
//        guest.getAlamat(guest); // Mendapatkan Alamat user
//        guest.getKota(guest);  // Mendapatkan kota user

        // Wallet
//        guest.getSaldo(guest); // method untuk mengambil balance
//
        // java fx buat interaktif
//        guest.UpdateSaldo(guest, 300000); // method untuk menambah balance wallet (buat interaktif)
//        guest.checkSaldo(guest);



        // Room
//        Room room = new Room(105); // Masukkan Room Number bisa pake Scanner atau Input
//
//        // Book Room
//        if (guest.bookRoom(guest,room)){
//            System.out.println("Berhasil Booking");
//        }
//
//        // Display Room Sesuai Room Number Yang di Masukkan
//        room.displayRoom(room);
//
//
//        // Menampilkan History Reservation Guest
//        guest.DisplayReservation(guest);
//
//        // Cancel Booking
//        guest.cancelBooking(guest, room);
//
//
//
//
//
//
//
//
//


    }
}
