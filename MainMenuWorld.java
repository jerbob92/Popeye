import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MainMenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenuWorld extends World
{
    
    GameState globalGameState;
    StartButton start_button_1;
    MG2StartButton start_button_2;
    MG3StartButton start_button_3;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1, false); 
        init();
        Greenfoot.start();
        
        if(this.globalGameState == null) {
            this.globalGameState = new GameState();
        }
    }
    
    private void init() {
        ExitButton exit_button = new ExitButton();
        
        this.start_button_1 = new StartButton();
        this.start_button_2 = new MG2StartButton();
        this.start_button_3 = new MG3StartButton();
                
        addObject(this.start_button_1, 400, 300);
        addObject(this.start_button_2, 400, 450);
        addObject(this.start_button_3, 400, 600);
        addObject(exit_button, 800, 300);
    }
    
    public void setGameState(GameState gamestate) {
        this.globalGameState = gamestate;
    }
    
    public GameState getGameState() {
        return this.globalGameState;
    }
    
    public void act() {
        if (!this.globalGameState.getFinished(1)) {
            this.start_button_2.setLocation(400, -450);
        } else {
            this.start_button_2.setLocation(400, 450);
        }
        
        if (!this.globalGameState.getFinished(2)) {
            this.start_button_3.setLocation(400, -600);
        } else {
            this.start_button_3.setLocation(400, 600);
        }
    }
}
