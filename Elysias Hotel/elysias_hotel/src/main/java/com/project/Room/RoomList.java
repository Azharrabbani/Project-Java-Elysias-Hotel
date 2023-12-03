package com.project.Room;

import com.project.User.Guest;

public interface RoomList {

        public boolean checkIfAvailable(Room room);

        public void bookRoom(Guest guest, Room room);

        public  void cancelBooking();

        void displayRoom(Room room);
}
