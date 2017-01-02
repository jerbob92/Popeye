import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Waterbeam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Waterbeam extends Actor
{
    private int life = 35;
    
    /**
     * Act - do whatever the MG3Waterbeam wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
         move(5);
        life--;
        if (life == 0)
        {
            getWorld().addObject(new MG3Splat(), getX(), getY());
            getWorld().removeObject(this);
        }
    }    
}
