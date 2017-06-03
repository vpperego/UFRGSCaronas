package controllers;

import java.util.ArrayList;

import dao.RideDao;
import model.Ride;

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

}
