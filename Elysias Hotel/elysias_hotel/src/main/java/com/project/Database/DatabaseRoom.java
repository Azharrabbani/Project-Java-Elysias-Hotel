package com.project.Database;

import com.project.Room.Room;
import com.project.Room.RoomList;
import com.project.User.Guest;
import util.ConnectionUtil;

import java.sql.*;

public abstract class DatabaseRoom implements RoomList {
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

    @Override
    public void bookRoom(Guest guest, Room room) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "INSERT INTO Reservation(NoTel, Room_Number, CheckIn, CheckOut, Night) VALUES(?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, guest.getNoTelGuest(guest));
                statement.setInt(2, room.getRoom_Number());
                statement.setDate(3, room.getCheckIn());
                statement.setDate(4, room.getCheckOut());
                statement.setLong(5, room.getNight());

                if (checkIfAvailable(room)){
                    int rowsEffected = statement.executeUpdate();
                    System.out.println(rowsEffected > 0 ? "Booking Successful" : "Booking Failed");
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancelBooking() {

    }

    @Override
    public void displayRoom(Room room) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT Room.Room_Number, Room.Room_Name, Type.RoomType, Room.Price, Room.Status FROM Room INNER JOIN Type ON(Room.TypeId = Type.TypeId) WHERE Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,room.getRoom_Number());
                try (ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        System.out.println("Room \t\t\t: " + resultSet.getInt("Room_Number"));
                        System.out.println("Room Name \t\t: " + resultSet.getString("Room_Name"));
                        System.out.println("Type \t\t\t: " + resultSet.getString("RoomType"));
                        System.out.println("Price \t\t\t: " + resultSet.getInt("Price"));
                        System.out.println("Status \t\t\t: " + resultSet.getString("Status"));
                    }
                }

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
