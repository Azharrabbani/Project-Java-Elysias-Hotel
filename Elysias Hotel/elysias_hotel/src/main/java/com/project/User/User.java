package com.project.User;

import com.project.Database.DatabaseUser;

import java.util.Scanner;

public class User extends DatabaseUser{

    private String UserName;
    private String Password;
    public String Nama;
    private String NoTel;
    private String Alamat;
    private String Kota;

    public User(String UserName, String Password){
        this.UserName = UserName;
        this.Password = Password;
    }


    // Login
    @Override
    public boolean Login(User user){
        return super.Login(user);
    }

    // Sign Up
    @Override
    public boolean SignUp (User user){
         return super.SignUp(user);
    }


    // Delete Akun
    @Override
    public void DelAccount(User user) {
        super.DelAccount(user);
    }


    // Menambah Profile Buat jadi interaktif layaknya login
    @Override
    public void AddProfile(User user) {
        System.out.println("WELCOME " + user.getUserName());
        Scanner input = new Scanner(System.in);


        if (user.getNama() == null) {
            System.out.print("Nama : ");
            user.setNama(input.nextLine());
        }

        if (user.getNoTel() == null) {
            System.out.print("NoTel : ");
            user.setNoTel(input.nextLine());
        }

        if (user.getAlamat() == null) {
            System.out.print("Alamat : ");
            user.setAlamat(input.nextLine());
        }

        if (user.getKota() == null) {
            System.out.print("Kota : ");
            user.setKota(input.nextLine());
        }
        super.AddProfile(user);
    }

    // Menampilkan Profile
    public void DisplayProfile(User user){
        super.DisplayProfile(user);
    }


    // Mendapatkan nama dari database
    public void getNama(Guest guest){
        super.getNama(guest);
    }


    // Mendapatkan noTel dari database
    public void getNoTel(Guest guest){
        super.getNoTel(guest);
    }


    // Mendapatkan noTel dari database untuk dimasukkan ke method
    public String getNoTelGuest(Guest guest){
        return super.getNoTelGuest(guest);
    }


    // Mendapatkan Alamat dari database
    public void getAlamat(Guest guest){
        super.getAlamat(guest);
    }


    // Mendapatkan Kota dari database
    public void getKota(Guest guest){
        super.getKota(guest);
    }


    // Update Profile sama buat java fx interaktif layaknya login
    public void UpdateProfile(User user){
        System.out.println("Manage Profile");
        Scanner input = new Scanner(System.in);

        if (user.getNama() == null) {
            System.out.print("Nama \t : ");
            user.setNama(input.nextLine());
        }

        if (user.getNoTel() == null) {
            System.out.print("No Tel \t : ");
            user.setNoTel(input.nextLine());
        }

        if (user.getAlamat() == null) {
            System.out.print("Alamat \t : ");
            user.setAlamat(input.nextLine());
        }

        if (user.getKota() == null) {
            System.out.print("Kota \t : ");
            user.setKota(input.nextLine());
        }
        super.UpdateProfile(user);
    }

    // Menampilkan History
    public void displayReservation(Guest guest){
        super.displayReservation(guest);
    }


    // Mengecek username ada atau tidak
//    public void isExsist(User user){
//        super.isExist(user);
//    }

    // getter
    public String getUserName() {
        return this.UserName;
    }

    // setter
    public void setUserName(String userName) {
        this. UserName = userName;
    }

    // getter
    public String getPassword() {
        return this.Password;
    }

    // setter
    public void setPassword(String password) {
        this.Password = password;
    }

    // getter
    public String getNama() {
        return this.Nama;
    }

    // setter
    public void setNama(String nama) {
        this.Nama = nama;
    }

    // getter
    public String getNoTel() {
        return this.NoTel;
    }

    // setter
    public void setNoTel(String noTel) {
        this.NoTel = noTel;
    }

    // getter
    public String getAlamat() {
        return this.Alamat;
    }

    // setter
    public void setAlamat(String alamat) {
        this.Alamat = alamat;
    }

    // getter
    public String getKota() {
        return this.Kota;
    }

    // setter
    public void setKota(String kota) {
        this.Kota = kota;
    }

}
