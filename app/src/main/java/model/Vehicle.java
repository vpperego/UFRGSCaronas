package model;

/**
 * Created by user on 6/3/2017.
 */

public class Vehicle {
    private String name;
    private String plate;
    private int maximumPasangers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getMaximumPasangers() {
        return maximumPasangers;
    }

    public void setMaximumPasangers(int maximumPasangers) {
        this.maximumPasangers = maximumPasangers;
    }
}
