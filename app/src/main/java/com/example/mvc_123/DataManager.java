package com.example.mvc_123;

import java.util.ArrayList;

public class DataManager {
    public static ArrayList<User> users = new ArrayList<>();

    public User createUser(String name, String password)
    {
        User user = new User(name, password);
        users.add(user);
        return user;
    }

    public static boolean validateUser(String name, String password)
    {
        for (User user: users)
        {
           if(user.getUserName().equals(name))
           {
               if(user.getPassword().equals(password))
               {
                   return true;
               }
           }
        }
        return false;
    }
}
