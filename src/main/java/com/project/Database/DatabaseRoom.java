package com.project.Database;

import com.project.Room.Room;
import com.project.Room.RoomList;
import com.project.User.Guest;
import util.ConnectionUtil;

import java.sql.*;

public abstract class DatabaseRoom implements RoomList {


    // Mengecek Room (Untuk digunakan di method lain)
    @Override
    public boolean checkIfAvailable(Room room){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Room WHERE Room_Number = ? AND Status = 'AVAILABLE'";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, room.getRoom_Number());
                try (ResultSet resultSet = statement.executeQuery()){
                    return resultSet.next();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }


    // Mengubah Status Room yang awalnya AVAILABLE menjadi BOOKED
    public void UpdateRoomBooked(Room room){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "UPDATE ROOM SET Status = 'BOOKED' WHERE Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, room.getRoom_Number());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // Method untuk mengupdate room Menjadi AVAILABLE (digunakan di method lain dan Method yang digunakan Oleh ADMIN)
    public void UpdateRoomAvailable(Room room){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "UPDATE ROOM SET Status = 'AVAILABLE' WHERE Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, room.getRoom_Number());
                statement.executeUpdate();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Mengambil Price dari masing masing room
    public double getPrice(Room room){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Room WHERE Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, room.getRoom_Number());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        double price = resultSet.getInt("Price");
                        return price;
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Room Not Found!!");
        }
        return 0;
    }


    public double getNight(Guest guest){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        double night = resultSet.getInt("Night");
                        return night;
                    }
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Number Not Found !!");
        }
        return 0;
    }


    // Book Room
    public boolean bookRoom(Guest guest, Room room) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "INSERT INTO GuestReservation(UserName, Room_Number, CheckIn, CheckOut, Night, Total) VALUES(?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, guest.getUserName());
                statement.setInt(2, room.getRoom_Number());
                statement.setDate(3, room.getCheckIn());
                statement.setDate(4, room.getCheckOut());
                statement.setLong(5, room.getNight());
                statement.setDouble(6, room.getTotal());

                if (checkIfAvailable(room)) {
                    int rowsEffected = statement.executeUpdate();
                    return rowsEffected > 0; // Return true jika booking berhasil
                } else {
                    System.out.println("Booking Failed: Room Already BOOKED");
                    return false; // Return false jika booking gagal karena kamar sudah dipesan
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Pemisalan untuk history yang belum complete
    public boolean isNotComplete(Guest guest, Room room){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ? AND Room_Number = ? AND Status = 'NOT COMPLETE'";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getUserName());
                statement.setInt(2, room.getRoom_Number());
                try (ResultSet resultSet = statement.executeQuery()){
                    return resultSet.next();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


    // Cancel Booking
    @Override
    public boolean cancelBooking(Guest guest, Room room) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "DELETE FROM GuestReservation WHERE Room_Number = ? AND Status = 'NOT COMPLETE'";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, room.getRoom_Number());
                int rowsEffected = statement.executeUpdate();
                return rowsEffected > 0;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Method ini digunakan di method lain
    public double getPriceFromReservation(Guest guest, Room room) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()) {
            String sql = "SELECT * FROM GuestReservation WHERE Room_Number = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, room.getRoom_Number());
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        double price = resultSet.getDouble("total");
                        return price;
                    } else {
                        System.out.println("Reservasi tidak ditemukan untuk nomor kamar: " + room);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }




}
