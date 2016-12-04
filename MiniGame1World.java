import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniGame1World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame1World extends World
{

    /**
     * Constructor for objects of class MiniGame1World.
     * 
     */
    public MiniGame1World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ship ship = new Ship();
        EnemyList enemyList = new EnemyList();
        addObject(enemyList,0,0);
        addObject(ship,ship.start_x,ship.start_y);
        ship.setRotation(225);
    }
    
    public void act()
    {
        buttonPressed();
    }
    
    public void buttonPressed()
    {
        if(Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(new MainMenuWorld());
        }     
    }
}
