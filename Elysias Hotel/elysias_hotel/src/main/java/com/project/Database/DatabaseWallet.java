package com.project.Database;

import com.project.Room.Room;
import com.project.User.Guest;
import com.project.wallet.Wallet;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseWallet implements Wallet {
    Guest guest;

    // Menambah Wallet User
    @Override
    public boolean addWallet(Guest guest) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "INSERT INTO Wallet(UserName) VALUES(?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                int rowsEffected = statement.executeUpdate();
                return rowsEffected > 0;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // Menambah Saldo Di Wallet
    public boolean addSaldo(Guest guest, double jumlah) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            double saldoSaatIni = getSaldo(guest);
            double saldoTambah = saldoSaatIni + jumlah;
            UpdateSaldo(guest, saldoTambah);
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // Mengambil Saldo dari database
    @Override
    public double getSaldo(Guest guest) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Wallet WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        double saldo ;
                        System.out.println(saldo = resultSet.getDouble("Balance"));
                        return saldo;
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
        return 0;
    }


    // Method Mengambil saldo untuk diambil dan digunakan di Method lain
    public double getSaldoSaatIni(Guest guest) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Wallet WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        double saldo = resultSet.getDouble("Balance");
                        return saldo;
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
        return 0;
    }


    // Check Saldo
    public double checkSaldo(Guest guest) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Wallet WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        double saldo = resultSet.getDouble("Balance");
                        System.out.println("UserName \t: " + resultSet.getString("UserName"));
                        System.out.println("balance \t: Rp " + saldo);
                        return saldo;
                    }

                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
        return 0;
    }


    // Update Saldo (Menambah Saldo)
    public void UpdateSaldo(Guest guest, double saldoTambah){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){

            String sql = "UPDATE Wallet set Balance = ? WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                double saldoSaatIni = getSaldoSaatIni(guest);
                double saldoBaru = saldoSaatIni + saldoTambah;
                statement.setDouble(1, saldoBaru);
                statement.setString(2, guest.getUserName());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // Method Saldo Setelah Pembayaran
    public void UpdateSaldoPayment(Guest guest,double price){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){

            String sql = "UPDATE Wallet set Balance = ? WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                double saldoSaatIni = getSaldoSaatIni(guest);
                double saldoBaru = saldoSaatIni - price;
                statement.setDouble(1, saldoBaru);
                statement.setString(2, guest.getUserName());
                if (guest.getSaldoSaatIni(guest) >= price){
                    statement.executeUpdate();
                }
                else {
                    System.out.println("Saldo Anda Tidak Cukup, Silahkan Lakukan Pengisian Ulang");
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // Method Saldo jika terjadi cancel (Pengembalian balance)
    public void Return(Guest guest,double price){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){

            String sql = "UPDATE Wallet set Balance = ? WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                double saldoSaatIni = getSaldoSaatIni(guest);
                double saldoBaru = saldoSaatIni + price;
                statement.setDouble(1, saldoBaru);
                statement.setString(2, guest.getUserName());

                statement.executeUpdate();

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
