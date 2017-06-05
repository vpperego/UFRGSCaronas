package dao;

import java.util.ArrayList;

import model.User;
import model.Vehicle;

/**
 * Created by user on 6/4/2017.
 */

public class UserDao {
    private static ArrayList<User> users;

    public  UserDao()
    {
        users = new ArrayList<User>();
    }

    public void saveUser(User newUser){
         users.add(newUser);

    }

}
