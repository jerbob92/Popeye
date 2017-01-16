import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Splat2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Splat2 extends MG3Waterbeam2
{
    private int life = 1;

    /**
     * Act - do whatever the MG3Splat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        life--;
        getWorld().removeObject(this);
    }    
}
