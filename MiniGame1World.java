import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

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
        // Create a new world with 1280*720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
                // Add quay.
        Quay quay = new Quay();
        addObject(quay,640,680);
        
        // Add cranes.
        Crane crane1 = new Crane();
        Crane crane2 = new Crane();
        Crane crane3 = new Crane();
        Crane crane4 = new Crane();
        Crane crane5 = new Crane();
        Crane crane6 = new Crane();
        addObject(crane1,100,655);
        addObject(crane2,300,655);        
        addObject(crane3,500,655);
        addObject(crane4,700,655);
        addObject(crane5,900,655);
        addObject(crane6,1100,655);
        
        // Add containers.
        Containers containers1 = new Containers();
        Containers containers2 = new Containers();
        Containers containers3 = new Containers();
        Containers containers4 = new Containers();
        Containers containers5 = new Containers();
        Containers containers6 = new Containers();
        addObject(containers1,30,680);
        addObject(containers2,230,680);
        addObject(containers3,430,680);
        addObject(containers4,630,680);
        addObject(containers5,830,680);
        addObject(containers6,1030,680);
        
        this.setPaintOrder(Crane.class, Containers.class, Enemy.class, Quay.class);

        Crane[] cranes = new Crane[] { crane1, crane2, crane3, crane4, crane5, crane6 };
       
        Ship ship = new Ship();
        EnemyList enemyList = new EnemyList();
        enemyList.setCranes(cranes);
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
            int n = JOptionPane.showConfirmDialog(null, "Do you really want to exit to the main menu?", "Exit", JOptionPane.YES_NO_OPTION);
            if (n == 0) {
                Greenfoot.setWorld(new MainMenuWorld());
            }
        }     
    }
}
