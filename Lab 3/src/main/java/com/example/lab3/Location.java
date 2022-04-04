package com.example.lab3;

public class Location {
private String Place;
private int coordinateX;
private int coordinateY;
private boolean gas;


    public Location(String place, int coordinateX, int coordinateY, boolean gas) {
        this.Place = place;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.gas = gas;
    }
    public Location() {
    this.Place=null;
    this.gas = false;
    }

    public String getPlace() {
        return Place;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public boolean isGas() {
        return gas;
    }


    public void setPlace(String place) {
        Place = place;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }
}
