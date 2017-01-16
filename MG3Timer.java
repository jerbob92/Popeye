import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class MG3Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Timer extends Actor
{
    long startTimem3;
    long gameTime = 120;

    public MG3Timer() {
        this.startTimem3 = System.currentTimeMillis();
    }

    /**
     * Act - do whatever the MG3Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        long currentTime = System.currentTimeMillis();
        long timePassed = currentTime - this.startTimem3;
        long timeLeft = this.gameTime - (timePassed / 1000);

        // Add your action code here.
        setImage(new GreenfootImage(String.valueOf(timeLeft), 20, Color.BLACK, new Color(0, 0, 0, 0))); // Add your action code here.
        if (timeLeft <= 0) {
            MiniGame3World world;
            world = (MiniGame3World) getWorld();
            world.Win();
        }
    } 
}
