package com.project.User;

public interface UserService {
    public boolean Login(User user);
    public boolean SignUp(User user);
    public void DelAccount(User user);
    public void AddProfile(User user);

}
