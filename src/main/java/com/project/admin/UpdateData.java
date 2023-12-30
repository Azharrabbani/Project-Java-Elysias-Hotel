package com.project.admin;

import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UpdateData implements Update{

    // Update Status Room menjadi AVAILABLE
    @Override
    public boolean UpdateRoomAvailable(int room) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "UPDATE ROOM SET Status = 'AVAILABLE' WHERE Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, room);
                int rowsEffected = statement.executeUpdate();
                return rowsEffected > 0;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Login untuk Admin
    @Override
    public boolean Login(Admin admin) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM Admin WHERE Username = ? AND Password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, admin.getUsername());
                statement.setString(2, admin.getPassword());

                try (ResultSet resultSet = statement.executeQuery()){
                    return resultSet.next();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean isReservationExist(String userName, int roomNumber) {
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "SELECT * FROM GuestReservation WHERE UserName = ? AND RoomNumber = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, userName);
                statement.setInt(2, roomNumber);

                try (ResultSet resultSet = statement.executeQuery()){
                    return resultSet.next();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // Update status History Guest
    @Override
    public boolean UpadateReserveStatus(String userName, int room){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "UPDATE GuestReservation set Status = 'COMPLETE' WHERE UserName = ? AND Room_Number = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, userName);
                statement.setInt(2, room);
                int rowsEffected = statement.executeUpdate();
                return rowsEffected > 0;

            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean displayReservation(String nama, String userName){
        try (Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = """
                    SELECT Room.Room_Number, Room.Room_Name, Type.RoomType, GuestReservation.CheckIn, GuestReservation.CheckOut, GuestReservation.Night, GuestReservation.Total, GuestReservation.Status from GuestReservation
                    INNER JOIN Room ON (GuestReservation.Room_Number = Room.Room_Number)
                    INNER JOIN Type ON (Room.TypeId = Type.TypeId)
                    INNER JOIN GuestHotel ON (GuestHotel.UserName = GuestResevation.UserName)
                    WHERE GuestReservation.UserName = ? AND GuestHotel.Nama = ?
                    """;
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1, userName);
                statement.setString(2, nama);
                try (ResultSet resultSet = statement.executeQuery()){
                    return resultSet.next();
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}


