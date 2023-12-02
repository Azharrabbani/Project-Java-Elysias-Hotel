package com.project.Room;

import com.project.Database.DatabaseRoom;

public class Room extends DatabaseRoom {

    private int Room_Number;

    public int getRoom_Number() {
        return Room_Number;
    }

    public Room(int Room_Number){
        this.Room_Number = Room_Number;
    }
    
    @Override
    public void displayRoom(Room room) {
        super.displayRoom(room);
    }



}
