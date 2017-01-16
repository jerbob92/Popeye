import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class MG2Oponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Oponent extends Actor
{    
    long startTimem3;
    long containers = 12;

    public MG2Oponent() {
        this.startTimem3 = System.currentTimeMillis();
    }

    /**
     * Act - do whatever the MG3Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if (Greenfoot.getRandomNumber(10000) < 15) {
            this.containers--;
        }

        setImage(new GreenfootImage("Aantal containers tegenstander: " + String.valueOf(this.containers), 20, Color.BLACK, new Color(0, 0, 0, 0)));
        if (this.containers <= 0) {
            ((MiniGame2World)getWorld()).gameOver();
        }
    } 
}
