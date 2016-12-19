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
    
    MG2Ship ship;

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
        
        MG2Quay quay = new MG2Quay();
        addObject(quay, 640,680);
        
        MG2Train train = new MG2Train();
        addObject(train,1100,620);
        
        this.ship = new MG2Ship(this, train);
        addObject(ship,400,615);
        
        MG2Hook hook = new MG2Hook();
        addObject(hook,450,-250);
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
                Greenfoot.setWorld(new MainMenuWorld());
            }
        }     
    }
    
    public MG2Ship getShip() {
        return this.ship;
    }
    
    public void win() {
        int n = JOptionPane.showConfirmDialog(null, "You won! Do you want to play again?", "Winner!", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            Greenfoot.setWorld(new MiniGame2World());
        } else {
            Greenfoot.setWorld(new MainMenuWorld());
        }
    }
}
