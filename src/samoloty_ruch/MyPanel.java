/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samoloty_ruch;

import java.awt.Graphics;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
 

/**
 *
 * @author Seba
 */
public class MyPanel extends JPanel{
    
    public void paint(Graphics g){
        super.paint(g);
        
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.black);
        for (Airport Airport1:GUISymulacja.gAirports){
            g.drawRect(Airport1.getX(), Airport1.getY(), 50, 50);
        }
        for(Plane p:GUISymulacja.ghangar){
                    g.fillOval((int)p.getX(), (int)p.getY(), 5, 5);
        }
    }
    
}
class Timer extends Thread{
JPanel jPanel1;



    Timer(JPanel jPanel1)
    {
        this.jPanel1= jPanel1;
    }
    
    public void run (){
        while (true){
            try {
                System.out.println("zegar tyka");
                sleep (25);
                for(Plane p:GUISymulacja.ghangar){
                    p.move();
                }
                jPanel1.repaint();
                        
                        
                        
                        
            } catch (InterruptedException ex) {
                Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (GUISymulacja.startAnimation == false)
            {//zegar zatrzymany 
                System.out.println("zegar zatrzymany");
                break; 
            }}
    }
}
        
