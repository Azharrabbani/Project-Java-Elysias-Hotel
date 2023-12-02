package com.project.wallet;

import com.project.Database.DatabaseWallet;
import com.project.User.Guest;

public class Payment extends DatabaseWallet {

    @Override
    public boolean addWallet(Guest guest){
        return super.addWallet(guest);
    }

    @Override
    public boolean addSaldo(Guest guest, double jumlah) {
        return super.addSaldo(guest, jumlah);
    }


    @Override
    public double getSaldo(Guest guest){
        return super.getSaldo(guest);
    }

    public double checkSaldo(Guest guest){
        return super.checkSaldo(guest);
    }

    public void UpdateSaldo(Guest guest, double saldoTambah){
        super.UpdateSaldo(guest, saldoTambah);
    }
}
