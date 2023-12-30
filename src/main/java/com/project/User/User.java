package com.project.User;

import com.project.Database.DatabaseUser;

import java.sql.Date;
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
        super.AddProfile(user);
    }

    public void DelProfile(User user) {
        super.DelProfile(user);
    }

    public String getUserName(User user){
        return super.getUserName(user);
    }
    
    // Mendapatkan nama dari database
    public String getNama(Guest guest){
        return super.getNama(guest);
    }


    // Mendapatkan noTel dari database
    public String getNoTel(Guest guest){
       return super.getNoTel(guest);
    }


    // Mendapatkan noTel dari database untuk dimasukkan ke method
    public String getNoTelGuest(Guest guest){
        return super.getNoTelGuest(guest);
    }


    // Mendapatkan Alamat dari database
    public String getAlamat(Guest guest){
        return super.getAlamat(guest);
    }


    // Mendapatkan Kota dari database
    public String getKota(Guest guest){
       return super.getKota(guest);
    }

    // Mendapatkan Room Number dari Reservation
    public int getRoomNumber(Guest guest){
        return super.getRoomNumber(guest);
    }

    // Mendapakan Tanggal CheckIn
    public Date getCheckIn(Guest guest){
        return super.getCheckIn(guest);
    }

    // Mendapatkan Tanggal CheckOut
    public Date getCheckOut(Guest guest){
        return super.getCheckOut(guest);
    }

    // Mendapatkan Durasi Pemesanan
    public int getNight(Guest guest){
        return super.getNight(guest);
    }

    // Mendapatkan Total Biaya Kamar
    public int getTotal(Guest guest){
        return super.getTotal(guest);
    }

    // Mendapatkan Status Pemesanan
    public String getStatus(Guest guest){
        return super.getStatus(guest);
    }


    // Update Profile sama buat java fx interaktif layaknya login
    public void UpdateProfile(User user){
        super.UpdateProfile(user);
    }

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
