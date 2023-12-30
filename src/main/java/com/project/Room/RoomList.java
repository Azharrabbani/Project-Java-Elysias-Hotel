package com.project.Room;

import com.project.User.Guest;

import java.sql.ResultSet;

public interface RoomList {

        public boolean checkIfAvailable(Room room);

        public boolean bookRoom(Guest guest, Room room);

        public boolean cancelBooking(Guest guest, Room room);


}
