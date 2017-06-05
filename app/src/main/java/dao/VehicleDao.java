package dao;

import java.util.ArrayList;

import model.Vehicle;

/**
 * Created by user on 6/4/2017.
 */

public class VehicleDao {
    private static ArrayList<Vehicle> vehicles;

    public  VehicleDao()
    {
        vehicles = new ArrayList<Vehicle>();
    }

    public void saveVehicle(Vehicle newVehicle){
        vehicles.add(newVehicle);
    }

}

