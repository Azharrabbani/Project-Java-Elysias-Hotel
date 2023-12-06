package com.project.Room;

import com.project.User.Guest;

public interface RoomList {

        public boolean checkIfAvailable(Room room);

        public boolean bookRoom(Guest guest, Room room);

        public  void cancelBooking(Guest guest, Room room);

        public void displayRoom(Room room);
}
