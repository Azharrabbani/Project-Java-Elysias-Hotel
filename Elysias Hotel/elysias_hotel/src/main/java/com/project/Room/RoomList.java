package com.project.Room;

import java.sql.SQLException;

public interface RoomList {

        public void checkRoom(Room room) throws SQLException;

        public void bookRoom(Room room);

        public  void cancelBooking(Room room);

        public  void displayRoom();


}
