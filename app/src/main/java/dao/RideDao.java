package dao;

import java.util.ArrayList;
import java.util.Date;

import model.Ride;
import model.Travel;
import model.User;
import model.Vehicle;

/**
 * Created by user on 6/3/2017.
 */

public class RideDao {
    private ArrayList<Ride> rides;

    public RideDao() {
        ridesHardCoded();
    }

    public ArrayList<Ride> searchRide(String source, String destiny)
    {
        ArrayList<Ride> matchRides = new ArrayList<Ride>();
        for(Ride ride: rides)
        {
            if(ride.getTravel().getSource() == source && ride.getTravel().getDestiny() == destiny)
            {
                matchRides.add(ride);
            }
        }
        return matchRides;
    }

    private void ridesHardCoded()
    {

        Vehicle car = new Vehicle("Siena","ILS3250","Cinza",2);
        Vehicle car2 = new Vehicle("Cobalt","FOE4829","Azul",1);
        Vehicle car3 = new Vehicle("Uno","DNJ5930","Red",4);

        User driver = new User(0,"Antonio Silva", 3.5, car);
        User driver2 = new User(1,"Ronaldo Nunes", 2.5, car2);
        User driver3 = new User(2,"Roberto Carlos", 4.0, car3);

        Travel t1 = new Travel("Campus Centro","Campus Vale",new Date());
        Travel t2 = new Travel("Campus ESEFID","Campus Vale",new Date());
        Travel t3 = new Travel("Campus Vale","Campus ESEFID",new Date());

        ArrayList<User> p1 = new ArrayList<User>();
        ArrayList<User> p2 = new ArrayList<User>();
        ArrayList<User> p3 = new ArrayList<User>();

        p1.add(driver2);

        p2.add(driver2);
        p2.add(driver3);
  //      public Ride(User driver, ArrayList<User> passangers, Travel travel) {

        Ride ride = new Ride(driver,p1,t1);
        Ride ride2 = new Ride(driver2,p2,t2);
        Ride ride3 = new Ride(driver3,p3,t3);

        rides.add(ride);
        rides.add(ride2);
        rides.add(ride3);
    }
}
