package com.project.User;

import com.project.Database.DatabaseUser;
import com.project.Room.Room;
import com.project.wallet.Payment;

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

    public void DisplayProfile(User user) {
        user.DisplayProfile(user);
    }

    public void getNama(Guest guest){
        user.getNama(guest);
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

    public void getNoTel(Guest guest){ // Untuk di tampilkan
        user.getNoTel(guest);
    }

    public void getAlamat(Guest guest){
        user.getAlamat(guest);
    }

    public void getKota(Guest guest){
        user.getKota(guest);
    }

    public String getNoTelGuest(Guest guest){ // untuk mengambil saja
        return user.getNoTelGuest(guest);
    }

    // Wallet
    public boolean addWallet(Guest guest){
        return payment.addWallet(guest);
    }

    public void checkSaldo(Guest guest){
        payment.checkSaldo(guest);
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

    public void cancelBooking(Guest guest, Room room){
        room.cancelBooking(guest, room);
    }

    public void DisplayReservation(Guest guest){
        user.displayReservation(guest);
    }



}

