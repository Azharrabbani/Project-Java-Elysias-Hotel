package com.project.Database;

import com.project.User.User;
import com.project.User.UserService;
import util.ConnectionUtil;

import java.net.ConnectException;
import java.sql.*;

public abstract class DatabaseUser implements UserService {

    private User user;

    public boolean Login(User user){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM UserGuest WHERE Username = ? AND Password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());

                try (ResultSet resultSet = statement.executeQuery()){
                    return resultSet.next();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    @Override
    public boolean SignUp(User user) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "INSERT INTO UserGuest(UserName, Password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getPassword());

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }

        }catch (SQLException e){
                throw new RuntimeException("Username already in use");

        }
    }

    @Override
    public void DelAccount(User user) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection();){
            String sql = "DELETE FROM UserGuest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());

                int rowsEffected = statement.executeUpdate();

                System.out.println(rowsEffected > 0 ? "Akun berhasil di hapus" : "Akun tidak ditemukan");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AddProfile(User user) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "INSERT INTO Guest (UserName, Nama, NoTel, Alamat, Kota) VALUES (?, ?, ?, ?, ?)" ;
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                statement.setString(2, user.getNama());
                statement.setString(3, user.getNoTel());
                statement.setString(4, user.getAlamat());
                statement.setString(5,user.getKota());

                int rowsAffected = statement.executeUpdate();
                System.out.println(rowsAffected > 0 ? "Berhasil menambah profile" : "Gagal membuat profile");
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void DisplayProfile(User user){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        System.out.println("Profile");
                        System.out.println(user.getUserName());
                        System.out.println("Nama \t : " + resultSet.getString("Nama"));
                        System.out.println("No Tel \t : " + resultSet.getString("NoTel"));
                        System.out.println("Alamat \t : " + resultSet.getString("Alamat"));
                        System.out.println("Kota \t : " + resultSet.getString("Kota"));
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void UpdateProfile(User user){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "UPDATE Guest set Nama = ?, NoTel = ?, Alamat = ?, Kota = ? WHERE UserName = ? ";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getNama());
                statement.setString(2, user.getNoTel());
                statement.setString(3, user.getAlamat());
                statement.setString(4, user.getKota());
                statement.setString(5, user.getUserName());

                int rowsEffected = statement.executeUpdate();
                System.out.println(rowsEffected > 0 ? "Profile berhasil di update" : "Profile Gagal di Update");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    public boolean isExist(User user){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        System.out.println("Akun ditemukan");
                        return true;
                    }
                    else {
                        System.out.println("Akun tidak di temukan");
                        return false;
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
