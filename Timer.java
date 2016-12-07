import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    long startTime;
    long gameTime = 300;
    
    public Timer() {
         this.startTime = System.currentTimeMillis();
    }
    
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - this.startTime;
        long timeLeft = this.gameTime - (timePassed / 1000);
        
        // Add your action code here.
        setImage(new GreenfootImage(String.valueOf(timeLeft), 20, Color.BLACK, new Color(0, 0, 0, 0)));
        
        if (timeLeft <= 0) {
            MiniGame1World world;
            world = (MiniGame1World) getWorld();
            world.Win();
        }
    }    
}
