package com.project.Database;

import com.project.User.Guest;
import com.project.wallet.Wallet;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseWallet implements Wallet {
    Guest guest;

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

    @Override
    public double getSaldo(Guest guest) {
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

    public void UpdateSaldo(Guest guest, double saldoTambah){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){

            String sql = "UPDATE Wallet set Balance = ? WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                double saldoSaatIni = getSaldo(guest);
                double saldoBaru = saldoSaatIni + saldoTambah;
                statement.setDouble(1, saldoBaru);
                statement.setString(2, guest.getUserName());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
