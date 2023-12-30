package com.project.User;

import com.project.Database.DatabaseUser;
import com.project.Room.Room;
import com.project.wallet.Payment;

import java.sql.Date;
import java.util.Scanner;

public class Guest {

    private User user;
    private final Payment payment;

    public Guest(User user){
        this.user = user;
        this.payment = new Payment();
    }

    public boolean Login(User user){
        return user.Login(user);
    }

    public boolean SignUp(User user){
        return user.SignUp(user);
    }

    public void DelAccount(User user) {
        user.DelAccount(user);
    }

//    public void isExsist(User user){
//        user.isExist(user);
//    }

    public void AddProfile(User user){
        user.AddProfile(user);
    }

    public void DelProfile(User user){
        user.DelProfile(user);
    }

    public String getUserName(User user){
        return user.getUserName(user);
    }

    public String getNama(Guest guest){
        return user.getNama(guest);
    }

    public void UpdateProfile(User user){
        user.UpdateProfile(user);
    }

    public void setUserName(User user){
        this.user = user;
    }

    public String getUserName(){
        return user.getUserName();
    }

    public String getNoTel(Guest guest){ // Untuk di tampilkan
        return user.getNoTel(guest);
    }

    public String getAlamat(Guest guest){
       return user.getAlamat(guest);
    }

    public String getKota(Guest guest){
        return user.getKota(guest);
    }

    public String getNoTelGuest(Guest guest){ // untuk mengambil saja
        return user.getNoTelGuest(guest);
    }

    public int getTotal(Guest guest){
        return user.getTotal(guest);
    }


    // Wallet
    public boolean addWallet(Guest guest){
        return payment.addWallet(guest);
    }

    public boolean delWallet(Guest guest){
        return payment.delWallet(guest);
    }

    public boolean addSaldo(Guest guest, double jumlah){
        return payment.addSaldo(guest, jumlah);
    }

    public double getSaldo(Guest guest){
        return payment.getSaldo(guest);
    }

    public double getSaldoSaatIni(Guest guest){
        return payment.getSaldoSaatIni(guest);
    }



    public  void UpdateSaldo(Guest guest, double saldoJumlah){
        payment.UpdateSaldo(guest, saldoJumlah);
    }

    public void updateSaldoPayment(Guest guest, double price){
        payment.updateSaldoPayment(guest, price);
    }

    public void Return(Guest guest,double price){
        payment.Return(guest, price);
    }
    // Room
    public boolean bookRoom(Guest guest, Room room){
        return room.bookRoom(guest, room);
    }

    public boolean cancelBooking(Guest guest, Room room){
        return room.cancelBooking(guest, room);
    }






}

