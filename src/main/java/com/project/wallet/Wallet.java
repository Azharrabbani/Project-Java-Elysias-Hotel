package com.project.wallet;

import com.project.User.Guest;

import java.sql.Connection;

public interface Wallet {

    public boolean addWallet(Guest guest);
    public boolean addSaldo(Guest guest, double jumlah);
    public double getSaldo(Guest guest);

}
