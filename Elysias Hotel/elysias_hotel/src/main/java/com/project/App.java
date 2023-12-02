package com.project;

import com.project.User.Guest;
import com.project.User.User;


public class App 
{
    public static void main( String[] args )
    {
        User user1 = new User("aku", "password");
        Guest guest1 = new Guest(user1);
//        guest1.isExsist(user1);



//        if (guest1.Login(user1)){
//            System.out.println("Berhasil Login");
//        }
//        else{
//            System.out.println("Your Username or Password is Wrong");
//        }

//        if (guest1.SignUp(user1)){
//            System.out.println("Berhasil membuat akun");
//            guest1.addWallet(guest1);
//        }
//        else {
//            System.out.println("Gagal membuat akun");
//        }

//        guest1.DelAccount(user1);


        //guest1.AddProfile(user1);
//        guest1.DisplayProfile(user1);
//        guest1.UpdateProfile(user1);
//        guest1.DisplayProfile(user1);

        // Wallet
//        guest1.addWallet(guest1);
//
//guest1.UpdateSaldo(guest1, 50000);
//        guest1.checkcSaldo(guest1);






    }
}
