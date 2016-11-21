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
        
        StartButton start_button = new StartButton("Start");
        int padding = 30;
        int button_height = start_button.getHeight() + padding;
        int center = (getHeight()-button_height)/2;
        int amount_of_buttons = 2;
        int start_height = center - ((button_height * amount_of_buttons) / 2);
       
        // Get button height + padding.
        addObject(start_button, ((getWidth()-start_button.getWidth())/2) + start_button.getWidth() / 2, start_height);
        
        start_height = start_height + button_height;
        
        ExitButton exit_button = new ExitButton("Exit");
        addObject(exit_button, ((getWidth()-exit_button.getWidth())/2) + exit_button.getWidth() / 2, start_height);
    }
}
