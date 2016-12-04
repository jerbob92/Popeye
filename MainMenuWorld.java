import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenuWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        init();
        Greenfoot.start();
    }
    
    private void init() {
        
        StartButton start_button = new StartButton();
        ExitButton exit_button = new ExitButton();

        addObject(start_button, 400, 300);
        addObject(exit_button, 800, 300);
    }
}
