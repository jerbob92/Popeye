import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Meter extends Actor
{
   GreenfootImage Meter = new GreenfootImage("MG2Meter.png");
    
    
    public Meter()
    {
        GreenfootImage img = Meter;
        img.scale(img.getWidth()*3/4, img.getHeight()*3/4);
        setImage(Meter);
       
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
