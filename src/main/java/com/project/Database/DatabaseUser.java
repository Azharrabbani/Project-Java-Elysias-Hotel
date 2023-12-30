package com.project.Database;

import com.project.User.Guest;
import com.project.User.User;
import com.project.User.UserService;
import util.ConnectionUtil;

import javax.management.RuntimeMBeanException;
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
            String sql = "INSERT INTO GuestHotel (UserName, Nama, NoTel, Alamat, Kota) VALUES (?, ?, ?, ?, ?)" ;
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

    public void DelProfile(User user) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection();){
            String sql = "DELETE FROM GuestHotel WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());

                int rowsEffected = statement.executeUpdate();

                System.out.println(rowsEffected > 0 ? "Akun berhasil di hapus" : "Akun tidak ditemukan");
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    

    // Method Mendapatkan record nama dari database
    public String getNama(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestHotel WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getString("Nama");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public String getUserName(User user){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM UserGuest where UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, user.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getString("Username");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }

        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }

    // Method Mendapatkan record noTel dari database
    public String getNoTel(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestHotel WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        return resultSet.getString("NoTel");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // Method Mendapatkan record Alamat dari database
    public String getAlamat(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestHotel WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        return resultSet.getString("Alamat");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // Method Mendapatkan record Kota dari database
    public String getKota(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestHotel WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if(resultSet.next()){
                        return resultSet.getString("Kota");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("UserName Not Found !!!");
        }
    }

    // get Room Number Yang dipesan
    public int getRoomNumber(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getInt("Room_Number");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // get Tanggal CheckIn Dari Database
    public Date getCheckIn(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getDate("CheckIn");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // get Tanggal CheckOut Dari Database
    public Date getCheckOut(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getDate("CheckOut");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Mengambil data berapa lama menginap
    public int getNight(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getInt("Night");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Mengambil data Total Penginapan
    public int getTotal(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getInt("Total");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Mengambil data Status Penginapan
    public String getStatus(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return resultSet.getString("Status");
                    }
                    else {
                        throw new RuntimeException("UserName Not Found !!!");
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Method Update Profile
    public void UpdateProfile(User user){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "UPDATE GuestHotel set Nama = ?, NoTel = ?, Alamat = ?, Kota = ? WHERE UserName = ? ";
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


    // Method mendapatkan NoTel untuk digunakan di method lain (bukan untuk ditampilkan)
    public String getNoTelGuest(Guest guest) { // Untuk ditampilkan
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestHotel WHERE UserName = ?";
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

}
