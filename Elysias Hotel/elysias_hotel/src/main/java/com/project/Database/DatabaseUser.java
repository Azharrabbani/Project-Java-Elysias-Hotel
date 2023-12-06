package com.project.Database;

import com.project.User.Guest;
import com.project.User.User;
import com.project.User.UserService;
import util.ConnectionUtil;

import java.sql.*;

public abstract class DatabaseUser implements UserService {

    private User user;

    // Method Login
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



    // Method SignUp (Buat Akun)
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

    // Method Delete Akun
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

    // Method Menambah Profile
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


    // Method Menampilkan Profile
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

    // Method Mendapatkan record nama dari database
    public void getNama(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        System.out.println(resultSet.getString("Nama"));
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Method Mendapatkan record noTel dari database
    public void getNoTel(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        System.out.println(resultSet.getString("NoTel"));
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // Method Mendapatkan record Alamat dari database
    public void getAlamat(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        System.out.println(resultSet.getString("Alamat"));
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // Method Mendapatkan record Kota dari database
    public void getKota(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        System.out.println(resultSet.getString("Kota"));
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // Method Update Profile
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


    // Method mengecek apakah username ada di database
//    public boolean isExist(User user){
//        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
//            String sql = "SELECT * FROM Guest WHERE UserName = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)){
//                statement.setString(1, user.getUserName());
//                try (ResultSet resultSet = statement.executeQuery()){
//                    if (resultSet.next()){
//                        System.out.println("Akun ditemukan");
//                        return true;
//                    }
//                    else {
//                        System.out.println("Akun tidak di temukan");
//                        return false;
//                    }
//                }
//            }
//        } catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//
//    }

    // Method mendapatkan NoTel untuk digunakan di method lain (bukan untuk ditampilkan)
    public String getNoTelGuest(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Guest WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()) {
                        return resultSet.getString("NoTel");
                    } else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // Method Menampilkan History
    public void displayReservation(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = """
                    SELECT Room.Room_Number, Room.Room_Name, Type.RoomType, Reservation.CheckIn, Reservation.CheckOut, Reservation.Night, Reservation.Total, Reservation.Status from Reservation
                    INNER JOIN Room ON (Reservation.Room_Number = Room.Room_Number)
                    INNER JOIN Type ON (Room.TypeId = Type.TypeId)
                    WHERE Reservation.UserName = ?
                    """;
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        System.out.println("Room Number \t: " + resultSet.getInt("Room_Number"));
                        System.out.println("Room Name \t\t: " + resultSet.getString("Room_Name"));
                        System.out.println("Type \t\t\t: " + resultSet.getString("RoomType"));
                        System.out.println("CheckIn \t\t: " + resultSet.getDate("CheckIn"));
                        System.out.println("CheckOut \t\t: " + resultSet.getDate("CheckOut"));
                        System.out.println("Night \t\t\t: " + resultSet.getInt("Night"));
                        System.out.println("Total \t\t\t: " + resultSet.getDouble("Total"));
                        System.out.println("Status \t\t\t: " + resultSet.getString("Status") + "\n");
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
