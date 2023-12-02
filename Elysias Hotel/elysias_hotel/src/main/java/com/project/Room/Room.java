package com.project.Room;

import javax.sql.DataSource;


public class Room implements RoomList{

    private DataSource dataSource;

    private int Room_Number;
    private int Harga;
    private Type RooomType;

    public Room(int room_Number) {
        Room_Number = room_Number;
    }

    public enum Roomstatus{
        BOOKED,
        AVAILABLE
    }

    public void isBooked(Room room){


    }


    @Override
    public void checkRoom(Room room){

    }

    @Override
    public void bookRoom(Room room) {

    }

    @Override
    public void cancelBooking(Room room) {

    }

    @Override
    public void displayRoom() {

    }

    public int getRoomId() {

        return Room_Number;
    }

    public void setRoomId(int Room_Number) {

        this.Room_Number = Room_Number;
    }

    public int getHarga() {

        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public Type getRoomType() {

        return RooomType;
    }

    public void setRoomType(Type RooomType) {

        this.RooomType = RooomType;
    }

}
