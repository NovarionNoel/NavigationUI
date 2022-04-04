package com.example.lab3;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Helicopter {

    private double FuelCapacity;
    private double CurrentFuel;
    private int MPG;
    private Location current;
    DecimalFormat df= new DecimalFormat("0.00");

    public Helicopter(double FuelCapacity, int MPG, Location current)
    {
    this.current=current;
    this.FuelCapacity=FuelCapacity;
    CurrentFuel= FuelCapacity;
    this.MPG= MPG;
    }
    public void setCurrentFuel(double currentFuel) {
        CurrentFuel = currentFuel;
    }
    public void setFuelCapacity(double fuelCapacity) {
        FuelCapacity = fuelCapacity;
    }
    public void setMPG(int MPG) {
        this.MPG = MPG;
    }
    public void setCurrent(Location current) {
        this.current = current;
    }

    public String Refuel()
    {
        if (current.isGas()==true)
     {
         this.CurrentFuel = this.FuelCapacity;
         return "You've topped up your tank. Choose where you'd like to fly next.";
     }

        else
        {
        return "No gas station here. Choose where you'd like to fly next.";
        }
    }

     public String Travel(Location destination)
    {   double a=Math.pow((this.current.getCoordinateX() - destination.getCoordinateX()),2);
        double b=Math.pow((this.current.getCoordinateY() - destination.getCoordinateY()),2);
        double c=Math.sqrt((a+b));
        if (c<=this.CurrentFuel*this.MPG)
        {
            this.current=destination;
            this.CurrentFuel= this.CurrentFuel-(c/this.MPG);
            return this.toString();

        }
        else {
         return "Uh oh, you don't have enough fuel to fly there. Try another location!";
        }

    }

    public boolean AmIStuck(ArrayList<Location> check)
    {
        boolean x =true;
        for (int i=0;i<check.size(); i++)
        {
            double a=Math.pow((this.current.getCoordinateX() - check.get(i).getCoordinateX()),2);
            double b=Math.pow((this.current.getCoordinateY() - check.get(i).getCoordinateY()),2);
            double c=Math.sqrt((a+b));
            if(c<=this.CurrentFuel*this.MPG && this.current.getPlace().compareTo(check.get(i).getPlace())!=0)
            {
                x= false;
            }
        }

        return x;
    }

    public double getFuelCapacity() {
        return FuelCapacity;
    }

    public double getCurrentFuel() {
        return CurrentFuel;
    }

    public int getMPG() {
        return MPG;
    }

    public Location getCurrent() {
        return current;
    }

    @Override
    public String toString() {
        return "Your helicopter is in " + this.current.getPlace()+". Do you want to refuel?";
    }
}