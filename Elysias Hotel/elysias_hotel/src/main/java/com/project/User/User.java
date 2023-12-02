package com.project.User;

import com.project.Database.DatabaseUser;

import java.util.Scanner;

public class User extends DatabaseUser{

    private String UserName;
    private String Password;
    public String Nama;
    private String NoTel;
    private String Alamat;
    private String Kota;

    public User(String UserName, String Password){
        this.UserName = UserName;
        this.Password = Password;
    }

    @Override
    public boolean Login(User user){
        return super.Login(user);
    }

    @Override
    public boolean SignUp (User user){
         return super.SignUp(user);
    }

    @Override
    public void DelAccount(User user) {
        super.DelAccount(user);
    }

    @Override
    public void AddProfile(User user) {
        System.out.println("WELCOME " + user.getUserName());
        Scanner input = new Scanner(System.in);


        if (user.getNama() == null) {
            System.out.print("Nama : ");
            user.setNama(input.nextLine());
        }

        if (user.getNoTel() == null) {
            System.out.print("NoTel : ");
            user.setNoTel(input.nextLine());
        }

        if (user.getAlamat() == null) {
            System.out.print("Alamat : ");
            user.setAlamat(input.nextLine());
        }

        if (user.getKota() == null) {
            System.out.print("Kota : ");
            user.setKota(input.nextLine());
        }
        super.AddProfile(user);
    }

    public void DisplayProfile(User user){
        super.DisplayProfile(user);
    }

    public void UpdateProfile(User user){
        System.out.println("Manage Profile");
        Scanner input = new Scanner(System.in);

        if (user.getNama() == null) {
            System.out.print("Nama \t : ");
            user.setNama(input.nextLine());
        }

        if (user.getNoTel() == null) {
            System.out.print("No Tel \t : ");
            user.setNoTel(input.nextLine());
        }

        if (user.getAlamat() == null) {
            System.out.print("Alamat \t : ");
            user.setAlamat(input.nextLine());
        }

        if (user.getKota() == null) {
            System.out.print("Kota \t : ");
            user.setKota(input.nextLine());
        }
        super.UpdateProfile(user);
    }

    public void isExsist(User user){
        super.isExist(user);
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this. UserName = userName;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getNama() {
        return this.Nama;
    }

    public void setNama(String nama) {
        this.Nama = nama;
    }

    public String getNoTel() {
        return this.NoTel;
    }

    public void setNoTel(String noTel) {
        this.NoTel = noTel;
    }

    public String getAlamat() {
        return this.Alamat;
    }

    public void setAlamat(String alamat) {
        this.Alamat = alamat;
    }

    public String getKota() {
        return this.Kota;
    }

    public void setKota(String kota) {
        this.Kota = kota;
    }

}
