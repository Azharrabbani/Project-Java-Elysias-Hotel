package com.project.admin;

import java.util.Scanner;

public class Admin extends UpdateData{
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean UpdateRoomAvailable(int room){
       return super.UpdateRoomAvailable(room);
    }

    public boolean Login(Admin admin){
        return super.Login(admin);
    }

    public boolean UpadateReserveStatus(String userName, int room){
        return super.UpadateReserveStatus(userName, room);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
