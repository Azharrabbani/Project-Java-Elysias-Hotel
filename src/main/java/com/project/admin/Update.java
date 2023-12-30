package com.project.admin;

import com.project.User.User;

public interface Update {

    public boolean UpdateRoomAvailable(int room);
    public boolean Login(Admin admin);
    public boolean UpadateReserveStatus(String userName, int room);


}
