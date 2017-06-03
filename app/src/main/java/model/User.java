package model;

/**
 * Created by user on 6/3/2017.
 */

public class User {
    private int id;
    private String name;
    private double score;
    private Vehicle vehicle;

    public User(int id, String name, double score, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
