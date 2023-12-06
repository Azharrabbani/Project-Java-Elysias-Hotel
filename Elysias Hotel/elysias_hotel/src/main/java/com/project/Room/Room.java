package com.project.Room;

import com.project.Database.DatabaseRoom;
import com.project.User.Guest;
import com.project.User.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
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



    @Override
    public void displayRoom(Room room) {
        super.displayRoom(room);
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

    public void UpdateReserveStatus(Guest guest, Room room){
        super.UpdateReserveStatus(guest, room);
    }

    public long calculateDurationInDays(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public boolean bookRoom(Guest guest, Room room) {
        if (checkIfAvailable(room)) {
            System.out.println("Booking Room");
            Scanner input = new Scanner(System.in);

            System.out.println("UserName \t\t\t\t\t: " + guest.getUserName());
            System.out.println("Room Number \t\t\t\t: " + room.getRoom_Number());

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            if (room.getCheckIn() == null) {
                try {
                    System.out.print("Check-in date (dd/MM/yyyy) \t: ");
                    String checkInStr = input.next();
                    Date checkInDate = sdf.parse(checkInStr);
                    room.setCheckIn(new java.sql.Date(checkInDate.getTime()));
                } catch (ParseException e) {
                    throw new RuntimeException("Invalid date format. Please use dd/MM/yyyy format");
                }
            }

            if (room.getCheckOut() == null) {
                try {
                    System.out.print("Check-out date (dd/MM/yyyy) : ");
                    String checkOutStr = input.next();
                    Date checkOutDate = sdf.parse(checkOutStr);
                    room.setCheckOut(new java.sql.Date(checkOutDate.getTime()));
                } catch (ParseException e) {
                    throw new RuntimeException("Invalid date format. Please use dd/MM/yyyy format");
                }
            }
            long durationInDays = calculateDurationInDays(room.getCheckIn(), room.getCheckOut());
            System.out.println("Night \t\t\t: " + durationInDays + " night");
            room.setNight(durationInDays);
            double total = room.getPrice(room) * durationInDays;
            System.out.println("Total \t\t\t: " + total);
            room.setTotal(total);

            if (guest.getSaldoSaatIni(guest) >= room.getTotal()) {
                super.bookRoom(guest, room);
                guest.updateSaldoPayment(guest, room.getTotal());
                UpdateRoomBooked(room);
                return true;
            } else {
                System.out.println("Gagal Melakukan Booking, Silahkan Isi Saldo Anda");
            }
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

    public void cancelBooking(Guest guest, Room room){
        if (isNotComplete(guest, room)){
            double price = getPriceFromReservation(guest, room);
            guest.Return(guest, price);
            super.cancelBooking(guest, room);
            UpdateRoomAvailable(room);
        }
        else {
            System.out.println("Cancel Failed, You Already Completed Your Reservation");
        }
    }

    public double getPrice(Room room){
        return super.getPrice(room);
    }

}
