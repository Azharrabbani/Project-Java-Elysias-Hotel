package com.project.Room;

import java.sql.SQLException;

public interface RoomList {

        public void checkRoom();

        public void bookRoom();

        public  void cancelBooking();

        void displayRoom(Room room);
}
