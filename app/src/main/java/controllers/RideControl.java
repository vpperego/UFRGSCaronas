package controllers;

import java.util.ArrayList;
import java.util.Date;

import dao.RideDao;
import model.Ride;
import model.User;

/**
 * Created by user on 6/3/2017.
 */

public class RideControl {
    public void save()
    {
        //TODO - implement
    }

    public ArrayList<Ride> showRides(String source, String destiny)
    {
            RideDao rd = new RideDao();
            return rd.searchRide(source,destiny);
    }

    public void saveRide(User driver, String source, String destiny){

        RideDao rd = new RideDao();
        rd.saveRideFromDrider(driver,source,destiny,new Date());


    }

}
