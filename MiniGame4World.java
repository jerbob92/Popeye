import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniGame4World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame4World extends World
{

    /**
     * Constructor for objects of class MiniGame4World.
     * 
     */
    public MiniGame4World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false);
        init();
    }
    public void init(){
        addObject(new MG4Kade(),650,800);
        addObject(new MG4Container(),-250,500);
        addObject(new MG4BalloonTest(),200,200);
    }
    
}
