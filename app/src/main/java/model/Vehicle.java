package model;

/**
 * Created by user on 6/3/2017.
 */

public class Vehicle {
    private String name;
    private String plate;
    private String color;
    private int maximumPasangers;

    public Vehicle(String name, String plate, String color, int maximumPasangers) {
        this.name = name;
        this.plate = plate;
        this.color = color;
        this.maximumPasangers = maximumPasangers;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

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
