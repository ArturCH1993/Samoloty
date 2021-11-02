/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samoloty_ruch;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Seba
 */
public class Plane {

    private int state; //czy samolot leci czy wylądował? 1 leci, 0 wylądował, 2 ląduje, 3 start,4 inne sytuacje
    private int maxFuel; // ile może maxymalnie zatankować?
    private int fuel; // ile paliwa aktualnie posiada
    private int id;
    private double x;
    private double y;
    private Airport sa;//startowe
    private Airport ta;//docelowe

    public Plane() {
        state = 0;
        maxFuel = (int) (Math.random() * 200 + 800);
        fuel = maxFuel;
        id = -1;
        x = 0;
        y = 0;

    }

    public Plane(int id) {
        this.id = id;
        state = 0;
        maxFuel = (int) (Math.random() * 200 + 800);
        fuel = maxFuel;
        x = 1;
        y = 1;

    }

    public double getX() {
        return x;
    }
    
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Samolot{" + "stan=" + state + ", maxpaliwo=" + maxFuel
                + ", paliwo=" + fuel + ", identyfikator=" + id
                + ", x=" + x + ", y=" + y + '}';
    }
    
    // STARTING AIRPORT //
    public Airport getSa() {
        return sa;
    }

    public void setSa(Airport sa) {
        this.sa = sa;
    }
    // DESTINATION AIRPORT //
    public Airport getTa() {
        return ta;
    }

    public void setTa(Airport ta) {
        this.ta = ta;
    }

    public void move(){
      //ruch po przekątnej
//     if ((int)x < getTa().getX()) {
//        x++;
//     }
//      if ((int)y < getTa().getY()) {
//          y++;
//      }

    double plusX, plusY;
    double fuel = getFuel();
    System.out.println(fuel);
    double taX = getTa().getX();  // X coordinate of the destination airport
    double taY = getTa().getY(); // Y coordinate of the destination airport
       
    double distX = getTa().getX() - getSa().getX(); // 450 // distance between destination airport and starting airport on X axis
    double distY = getTa().getY() - getSa().getY(); // 150 // distance between destination airport and starting airport on Y axis

    System.out.println("taX: "+taX);
    System.out.println("taY: "+taY);
    System.out.println("plane X: "+x);
    System.out.println("plane Y: "+y);
    
    plusX = distX / 100;
    plusY = distY / 100;
    
    if ((int)x < taX) x++;
    if ((int)x > taX) x--;
    if ((int)y < taY) y++;
    if ((int)y > taY) y--;
    
    
    if(plusX > 0 && plusY > 0) fuel = fuel - plusX - plusY;
    else if(plusX > 0 && plusY < 0) fuel = fuel - plusX + plusY;
    else if(plusX < 0 && plusY > 0) fuel = fuel + plusX - plusY;
    else fuel = fuel + plusX + plusY;
    
    setFuel((int)fuel);
    
    if(x == taX && y == taY){
        System.out.println("no elo to działa");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("paliwo do pelna prosze");
            setFuel(maxFuel); // setting fuel back to max value
            Airport setHelper = getSa(); // saving starting airport value
            setSa(getTa()); // setting starting value to destination airport value
            setTa(setHelper); // setting destination airport value to setHelper which is starting airport value
    }
      
        
    }
    static double distanceBetween(double x1, double y1, double x2, double y2){
        return (Math.sqrt(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
        
    };
    
    
    
}
