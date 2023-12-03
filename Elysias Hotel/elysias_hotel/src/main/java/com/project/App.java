package com.project;

import com.project.Room.Room;
import com.project.User.Guest;
import com.project.User.User;


public class App
{
    public static void main( String[] args )
    {
        // java fx buat interaktif
        User user = new User("azhar", "password"); // Awal user masukin username dan password buat jadi interaktif
        Guest guest = new Guest(user);
        //User Login dengan method login
//        if (guest.Login(user1)){
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

//        guest.UpdateProfile(user); // Update Profile user diarahkan ke halaman untuk update profile


//        guest.DisplayProfile(guest);

//        guest.DisplayProfile(guest);
//        guest.getNama(guest); // Mendapatkan nama user
//        guest.getNoTel(guest); // Mendapatkan noTel user
//        guest.getAlamat(guest); // Mendapatkan Alamat user
//        guest.getKota(guest);  // Mendapatkan kota user

        // Wallet
//        guest.addWallet(guest); // method untuk membuat walelt
//        guest.getSaldo(guest); // method untuk mengambil balance
//
        // java fx buat interaktif
//        guest.UpdateSaldo(guest, 200000); // method untuk menambah balance wallet (buat interaktif)
//        guest.checkcSaldo(guest);

        
        // Room abaikan dulu
        // Room
        // Room room = new Room(204);
        // room.bookRoom(guest,room);
//        room.displayRoom(room);
//        room.UpdateRoomBooked(room);
//        room.UpdateRoomAvailable(room);
//        room.displayRoom(room);
//        guest.UpdateSaldoPayment(guest, room);
//        guest.checkcSaldo(guest);











    }
}
