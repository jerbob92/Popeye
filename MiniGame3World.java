import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

/**
 * Write a description of class MiniGame3World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame3World extends World
{
    GameState globalGameState;

    /**
     * Constructor for objects of class MiniGame3World.
     * 
     */
    public MiniGame3World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();
    }
    
    public void setGameState(GameState gamestate) {
        this.globalGameState = gamestate;
    }
    
    public GameState getGameState() {
        return this.globalGameState;
    }
    
    private void prepare()
    {
        //add fireboat
        MG3Fireboat mg3fireboat = new MG3Fireboat();
        addObject(mg3fireboat, mg3fireboat.start_x, mg3fireboat.start_y);
        
        //add Quay buttom
        MG3Quaybuttom mg3quaybuttom = new MG3Quaybuttom();
        addObject (mg3quaybuttom, 639, 800);
        
        //add Quay top
        MG3Quaytop mg3quaytop = new MG3Quaytop();
        addObject(mg3quaytop, 639, 1);
        
        //add Crane
        MG3Crane mg3crane1 = new MG3Crane();
        MG3Crane mg3crane2 = new MG3Crane();
        MG3Crane mg3crane3 = new MG3Crane();
        addObject(mg3crane1,100,589);
        addObject(mg3crane2,300,589); 
        addObject(mg3crane3,500,589);
                
        //add buildings
        MG3Building1 mg3building1 = new MG3Building1();
        addObject(mg3building1,300,75);
        MG3Building2 mg3building2 = new MG3Building2();
        addObject(mg3building2,100,75);
        MG3Building3 mg3building3 = new MG3Building3();
        addObject(mg3building3,1000,75);
        MG3Building5 mg3building5 = new MG3Building5();
        addObject(mg3building5,1150,75);
        
        //add Ships
        MG3Containership mg3containership1 = new MG3Containership();
        addObject(mg3containership1,300,550);
        
        //add Fire
        MG3Firesmall[] mg3firesmall = new MG3Firesmall[2];
        
                      
        for(int i=0; i<mg3firesmall.length;i++)
        {
            mg3firesmall[i] = new MG3Firesmall();
            int fireX = Greenfoot.getRandomNumber(getWidth());
            int fireY = Greenfoot.getRandomNumber(getHeight());
            addObject(mg3firesmall[i], fireX, fireY);
            mg3firesmall[i].addHealthbar();
        }
        
        //add Fire
        MG3Firesmall2[] mg3firesmall2 = new MG3Firesmall2[2];
        
                      
        for(int i=0; i<mg3firesmall2.length;i++)
        {
            mg3firesmall2[i] = new MG3Firesmall2();
            int fireX = Greenfoot.getRandomNumber(getWidth());
            int fireY = Greenfoot.getRandomNumber(getHeight());
            addObject(mg3firesmall2[i], fireX, fireY);
            mg3firesmall2[i].addHealthbar();
        }
        
        this.setPaintOrder(MG3Waterbeam2.class, MG3Waterbeam.class, MG3Firesmall.class, MG3Firesmall2.class, MG3Healthbar.class, MG3Crane.class, MG3Building.class, MG3Quay.class, MG3Schips.class);
        
        
       
        
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
}


