package model;

/**
 * Created by user on 6/3/2017.
 */

public class Vehicle {
    private String name;
    private String plate;
    private String color;
    private int maximumPassagers;

    public  Vehicle(){

    }


    public Vehicle(String name, String plate, String color, int maximumPassagers) {
        this.name = name;
        this.plate = plate;
        this.color = color;
        this.maximumPassagers = maximumPassagers;
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
        return maximumPassagers;
    }

    public void setMaximummaximumPassagers(int maximumPassagers) {
        this.maximumPassagers = maximumPassagers;
    }
}
