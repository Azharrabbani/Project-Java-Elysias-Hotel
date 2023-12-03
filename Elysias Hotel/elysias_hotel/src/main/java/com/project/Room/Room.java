package com.project.Room;

import com.project.Database.DatabaseRoom;
import com.project.User.Guest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Room extends DatabaseRoom {

    private int Room_Number;
    private Date checkIn;
    private Date checkOut;
    private long night;

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

    public Room(int Room_Number){
        this.Room_Number = Room_Number;
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

    public long calculateDurationInDays(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public void bookRoom(Guest guest, Room room){
        System.out.println("Booking Room");
        Scanner input = new Scanner(System.in);

        System.out.println("No Tel \t\t\t\t\t\t: " + guest.getNoTelGuest(guest));
        System.out.println("Room Number \t\t\t\t: " + room.getRoom_Number());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (room.getCheckIn() == null) {
            try {
                System.out.print("Enter a check-in date (dd/MM/yyyy): ");
                String checkInStr = input.next();
                Date checkInDate = sdf.parse(checkInStr);
                room.setCheckIn(new java.sql.Date(checkInDate.getTime()));
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format. Please use dd/MM/yyyy format");
            }
        }

        if (room.getCheckOut() == null) {
            try {
                System.out.print("Enter a check-out date (dd/MM/yyyy): ");
                String checkOutStr = input.next();
                Date checkOutDate = sdf.parse(checkOutStr);
                room.setCheckOut(new java.sql.Date(checkOutDate.getTime()));
            } catch (ParseException e) {
                throw new RuntimeException("Invalid date format. Please use dd/MM/yyyy format");
            }
        }
        long durationInDays = calculateDurationInDays(room.getCheckIn(), room.getCheckOut());
        System.out.println("Night: " + durationInDays + " night");
        room.setNight(durationInDays);

        super.bookRoom(guest, room);
    }

    public double getPrice(Room room){
        return super.getPrice(room);
    }





}
