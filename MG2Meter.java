import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Meter extends Actor
{
    GreenfootImage meter = new GreenfootImage("MG2Meter.png");

    public MG2Meter()
    {
        GreenfootImage img = meter;
        img.scale(img.getWidth()*3/4, img.getHeight()*3/4);
        setImage(meter);
    }

    /**
     * Act - do whatever the Meter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
