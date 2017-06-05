package controllers;

import dao.UserDao;
import model.User;
import model.Vehicle;

/**
 * Created by user on 6/4/2017.
 */

public class UserControl {
    public User saveUser(String name, double score, Vehicle vehicle)
    {
        User newUser = new User(0,name,score,vehicle);

        UserDao ud = new UserDao();
        ud.saveUser(newUser);
        return newUser;
    }
}
