import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniGame2World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame2World extends World
{

    /**
     * Constructor for objects of class MiniGame2World.
     * 
     */
    public MiniGame2World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false); 
        prepare();
    }
    
    private void prepare() {
        MG2Ship ship = new MG2Ship(this);
        addObject(ship,400,615);
    }
}
