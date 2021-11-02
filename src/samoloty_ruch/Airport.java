/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samoloty_ruch;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Seba
 */
public class Airport {
    int idAirport;
    int x;
    int y;
    int availability;
    
    ArrayList <Plane> hangar = new ArrayList <>();

    public Airport(int idAirport) {
        this.idAirport = idAirport+1;
        x = (int) (Math.random()*800);
        y = (int) (Math.random()*600);
        availability = 1;
        int planesQuantity = (int) (Math.random()*5 + 5);
        
        
        
//        Plane S1;
//        S1 = new Plane();
//        System.out.println("S1"+S1);
        for(int i=0; i<planesQuantity; i++){
            Plane S1 = new Plane(i);
            hangar.add(S1); //dodanie obiektu S1 do kontenera hangar typu ArrayList
            GUISymulacja.ghangar.add(S1); // dodanie obiektu S1 do globalnego statycznego kontenera
        System.out.println("S1"+S1);
        }
    }

    Airport(int idAirport, JPanel jPanel1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.idAirport = idAirport;
        x = (int) (Math.random()*(jPanel1.getWidth()-50));
        y = (int) (Math.random()*(jPanel1.getHeight()-50));
        availability = 1;
        int planesQuantity = (int) (Math.random()*5 + 5);
        
        boolean isOk = true;
        
        for(Airport a: GUISymulacja.gAirports){
            if((x>=a.getX() && x<=a.getX()+50) && (y>=a.getY() && y<=a.getY()+50)){
                isOk = false;
                break;
            }
        }
        
        do{
            x = (int) (Math.random()*(jPanel1.getWidth()-50));
            y = (int) (Math.random()*(jPanel1.getHeight()-50));
            
            isOk = true;
        
            for(Airport a: GUISymulacja.gAirports){
                if((x>=a.getX() && x<=a.getX()+50) && (y>=a.getY() && y<=a.getY()+50)){
                    isOk = false;
                    break;
                }
            }
        }while(isOk == false);
    
        
        
//        Plane S1;
//        S1 = new Plane();
//        System.out.println("S1"+S1);
/*        for(int i=0; i<planesQuantity; i++){
            Plane S1 = new Plane(i);
            hangar.add(S1); //dodanie obiektu S1 do kontenera hangar typu ArrayList
            GUISymulacja.ghangar.add(S1); // dodanie obiektu S1 do globalnego statycznego kontenera
        System.out.println("S1"+S1);
        }*/
    }

    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public ArrayList<Plane> getHangar() {
        return hangar;
    }

    public void setHangar(ArrayList<Plane> hangar) {
        this.hangar = hangar;
    }
    
    double distanceBetween(Airport Airport1){
        return (Math.sqrt(x - Airport1.x)*(x-Airport1.x)+(y-Airport1.y)*(y-Airport1.y));
    };

    @Override
    public String toString() {
        
        return "Airport{" + "idAirport=" + idAirport + ", x=" + x + ", y=" + y + 
                ", availability=" + availability + ", hangar=" + hangar + '}' ;
    }
    
    
    
    
}
