package controllers;

import dao.VehicleDao;
import model.Vehicle;

/**
 * Created by user on 6/4/2017.
 */

public class VehicleControl {
    public Vehicle saveVehicle(String name, String plate, String color, int maximumPassagers)
    {
        Vehicle newVehicle = new Vehicle(name,plate,color,maximumPassagers);
        VehicleDao vd = new VehicleDao();
        return newVehicle;
    }
}
