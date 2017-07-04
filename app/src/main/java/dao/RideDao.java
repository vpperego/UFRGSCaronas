package dao;

import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

import model.Ride;
import model.User;
import model.Vehicle;

import static android.content.ContentValues.TAG;
import 	java.util.GregorianCalendar;
/**
 * Created by user on 6/3/2017.
 */

public class RideDao {
    private static ArrayList<Ride> rides;
    private static boolean isRidersInit = false;
    public RideDao() {

        if(isRidersInit==false)
        {
            rides = new ArrayList<Ride>();
            ridesHardCoded();
        }
        isRidersInit=true;
     }

    public ArrayList<Ride> searchRide(String source, String destiny)
    {
        ArrayList<Ride> matchRides = new ArrayList<Ride>();
        for(Ride ride: rides)
        {
            if(ride.getSource().equals(source) &&
                   ride.getDestiny().equals( destiny))
            {
                matchRides.add(ride);
            }
        }
        return matchRides;
    }

    public  void saveRideFromDrider(User driver,String source, String destiny,Date travelTime){

         ArrayList<User> passangers = new ArrayList<User>();


        Ride newRide = new Ride(driver,passangers,source,destiny,travelTime);
        if(rides.isEmpty()==true)
            Log.d(TAG,"ISSO NAO ERA PRA APRECER VAZIO");

        rides.add(newRide);
    }

    private void ridesHardCoded()
    {
        Vehicle car = new Vehicle("Siena","ILS3250","Cinza",2);
        Vehicle car2 = new Vehicle("Cobalt","FOE4829","Azul",1);
        Vehicle car3 = new Vehicle("Uno","DNJ5930","Vermelho",4);

        User driver = new User(0,"Antonio Silva", 3.5, car);
        User driver2 = new User(1,"Ronaldo Nunes", 2.5, car2);
        User driver3 = new User(2,"Roberto Carlos", 4.0, car3);

        ArrayList<User> p1 = new ArrayList<User>();
        ArrayList<User> p2 = new ArrayList<User>();
        ArrayList<User> p3 = new ArrayList<User>();

        p1.add(driver2);

        p2.add(driver2);
        p2.add(driver3);
  //      public Ride(User driver, ArrayList<User> passangers, Travel travel) {
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();

        Time t = new Time(0);

        GregorianCalendar gc = new GregorianCalendar();

        Date trialTime = new Date();

        gc.setTime(trialTime);


        gc.set(GregorianCalendar.HOUR_OF_DAY,11);
        gc.set(GregorianCalendar.MINUTE,8);
        d1.setTime(gc.getTime().getTime());

        gc.set(GregorianCalendar.HOUR_OF_DAY,12);
        gc.set(GregorianCalendar.MINUTE,0);
        d2.setTime(gc.getTime().getTime());

        gc.set(GregorianCalendar.HOUR_OF_DAY,13);
        gc.set(GregorianCalendar.MINUTE,10);
        d3.setTime(gc.getTime().getTime());

        Ride ride = new Ride(driver,p1,"Campus Centro","Campus Vale",d1);
        Ride ride2 = new Ride(driver2,p2,"Campus ESEFID","Campus Vale",d2);
        Ride ride3 = new Ride(driver3,p3,"Campus Vale","Campus ESEFID",d3);

        rides.add(ride);
        rides.add(ride2);
        rides.add(ride3);
    }


}
