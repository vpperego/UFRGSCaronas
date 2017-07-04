package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 6/3/2017.
 */

public class Ride {
    private User driver;
    private ArrayList<User> passangers;

    private String source;
    private String Destiny;
    private Date date;

    public Ride(User driver, ArrayList<User> passangers) {
        this.driver = driver;
        this.passangers = passangers;
    }

    public Ride() {

    }

    public Ride(User driver, ArrayList<User> passangers, String source, String destiny, Date date) {
        this.driver = driver;
        this.passangers = passangers;
        this.source = source;
        Destiny = destiny;
        this.date = date;
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


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;

    }

    public String getDestiny() {
        return Destiny;
    }

    public void setDestiny(String destiny) {
        Destiny = destiny;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
