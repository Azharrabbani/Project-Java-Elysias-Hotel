package com.project.Room;

import com.project.Database.DatabaseRoom;
import com.project.User.Guest;

import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Room extends DatabaseRoom{

    private int Room_Number;
    private Date checkIn;
    private Date checkOut;
    private long night;
    private double total;

    public Room(int Room_Number){
        this.Room_Number = Room_Number;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public long getNight() {
        return night;
    }

    public void setNight(long night) {
        this.night = night;
    }

    public java.sql.Date getCheckIn() {
        return (java.sql.Date) checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public java.sql.Date getCheckOut() {
        return (java.sql.Date) checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getRoom_Number() {
        return Room_Number;
    }





    public boolean checkIfAvailable(Room room){
       return super.checkIfAvailable(room);
    }

    public void UpdateRoomBooked(Room room){
        super.UpdateRoomBooked(room);
    }

    public void UpdateRoomAvailable(Room room){
        super.UpdateRoomAvailable(room);
    }

    public long calculateDurationInDays(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public boolean bookRoom(Guest guest, Room room) {
        if (checkIfAvailable(room)) {
                super.bookRoom(guest, room);
                guest.updateSaldoPayment(guest, room.getTotal());
                UpdateRoomBooked(room);
                return true;
        } else {
            System.out.println("Room Already BOOKED");
        }
        return false;
    }

    public double getPriceFromReservation(Guest guest, Room room){
        return super.getPriceFromReservation(guest, room);
    }

    @Override
    public boolean isNotComplete(Guest guest, Room room) {
        return super.isNotComplete(guest, room);
    }

    public boolean cancelBooking(Guest guest, Room room){
        if (isNotComplete(guest, room)){
            double price = getPriceFromReservation(guest, room);
            guest.Return(guest, price);
            super.cancelBooking(guest, room);
            UpdateRoomAvailable(room);
            return true;
        }
        else {
            System.out.println("Cancel Failed, You Already Completed Your Reservation");
            return false;
        }

    }

    public double getPrice(Room room){
        return super.getPrice(room);
    }


}
