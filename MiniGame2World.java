
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

/**
 * Write a description of class MiniGame2World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame2World extends World
{
    
    GameState globalGameState;
    MG2Ship ship;
    MG2Arrow arrow;

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
    
    public void setGameState(GameState gamestate) {
        this.globalGameState = gamestate;
    }
    
    public GameState getGameState() {
        return this.globalGameState;
    }
    
    private void prepare() {   
        
        MG2Quay quay = new MG2Quay();
        addObject(quay, 640,680);
        
        MG2Train train = new MG2Train();
        addObject(train,1100,620);
        
        this.ship = new MG2Ship(this);
        addObject(ship,400,615);
        
        MG2Hook hook = new MG2Hook();
        addObject(hook,450,-250);
     
        this.arrow = new MG2Arrow();
        addObject(arrow,390,295);
        
        MG2Meter meter = new MG2Meter();
        addObject(meter,390,250);
       
    }

// public getter method
    
    public MG2Arrow getArrow()
    {
        return arrow;
    }
    
    public void act()
    {
        buttonPressed();
    }
    
    public void buttonPressed()
    {
        if(Greenfoot.isKeyDown("escape")) {
            int n = JOptionPane.showConfirmDialog(null, "Do you really want to exit to the main menu?", "Exit", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                MainMenuWorld newWorld = new MainMenuWorld();
                newWorld.setGameState(this.getGameState());
                Greenfoot.setWorld(newWorld);
            }
        }     
    }
    
    public MG2Ship getShip() {
        return this.ship;
    }
    
    public void win() {
        int n = JOptionPane.showConfirmDialog(null, "You won! Do you want to go to minigame 3?", "Winner!", JOptionPane.YES_NO_OPTION);
        this.getGameState().setFinished(2, 0);
        if (n == 0) {
            MiniGame3World newWorld = new MiniGame3World();
            newWorld.setGameState(this.getGameState());
            Greenfoot.setWorld(newWorld);
        } else {
            MainMenuWorld newWorld = new MainMenuWorld();
            newWorld.setGameState(this.getGameState());
            Greenfoot.setWorld(newWorld);
        }
    }
    
    public void gameOver() {
        int n = JOptionPane.showConfirmDialog(null, "Game over! Do you want to try again?", "Game Over!", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            MiniGame2World newWorld = new MiniGame2World();
            newWorld.setGameState(this.getGameState());
            Greenfoot.setWorld(newWorld);
        } else {
            MainMenuWorld newWorld = new MainMenuWorld();
            newWorld.setGameState(this.getGameState());
            Greenfoot.setWorld(newWorld);
        }
    }
}