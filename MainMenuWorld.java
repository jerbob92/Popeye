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
    StartButton startButton1;
    MG2StartButton startButton2;
    MG3StartButton startButton3;
    
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
        ExitButton exitButton = new ExitButton();
        
        this.startButton1 = new StartButton();
        this.startButton2 = new MG2StartButton();
        this.startButton3 = new MG3StartButton();
                
        addObject(this.startButton1, 400, 300);
        addObject(this.startButton2, 400, 450);
        addObject(this.startButton3, 400, 600);
        addObject(exitButton, 800, 300);
    }
    
    public void setGameState(GameState gamestate) {
        this.globalGameState = gamestate;
    }
    
    public GameState getGameState() {
        return this.globalGameState;
    }
    
    public void act() {
        if (!this.globalGameState.getFinished(1)) {
            this.startButton2.setLocation(400, -450);
        } else {
            this.startButton2.setLocation(400, 450);
        }
        
        if (!this.globalGameState.getFinished(2)) {
            this.startButton3.setLocation(400, -600);
        } else {
            this.startButton3.setLocation(400, 600);
        }
    }
}
