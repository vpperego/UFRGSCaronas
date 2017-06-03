package model;

import java.util.ArrayList;

/**
 * Created by user on 6/3/2017.
 */

public class Ride {
    private User driver;
    private ArrayList<User> passangers;
    private Travel travel;

    public Ride(User driver, ArrayList<User> passangers, Travel travel) {
        this.driver = driver;
        this.passangers = passangers;
        this.travel = travel;
    }

    public Ride() {

    }

    public User getDriver() {
        return driver;
    }

    public void setDriver(User driver) {
        this.driver = driver;
    }

    public ArrayList<User> getPassangers() {
        return passangers;
    }

    public void setPassangers(ArrayList<User> passangers) {
        this.passangers = passangers;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }
}
