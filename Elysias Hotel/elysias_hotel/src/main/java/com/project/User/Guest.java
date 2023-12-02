package com.project.User;

import com.project.Database.DatabaseWallet;
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

    public void isExsist(User user){
        user.isExist(user);
    }

    public void AddProfile(User user){
        user.AddProfile(user);
    }

    public void DisplayProfile(User user) {
        user.DisplayProfile(user);
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

    // Wallet
    public boolean addWallet(Guest guest){
        return payment.addWallet(guest);
    }

    public void checkcSaldo(Guest guest){
        payment.checkSaldo(guest);
    }

    public boolean addSaldo(Guest guest, double jumlah){
        return payment.addSaldo(guest, jumlah);
    }

    public  void UpdateSaldo(Guest guest, double saldoJumlah){
        payment.UpdateSaldo(guest, saldoJumlah);
    }



}

