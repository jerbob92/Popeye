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

    private GameState globalGameState;
    private MG1Lives lives;

    /**
     * Constructor for objects of class MiniGame1World.
     * 
     */
    public MiniGame1World()
    {    
        // Create a new world with 1280*720 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();

        if(this.globalGameState == null) {
            this.globalGameState = new GameState();
        }
    }

    public void setGameState(GameState gamestate) {
        this.globalGameState = gamestate;
    }

    public GameState getGameState() {
        return this.globalGameState;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Add timer.
        MG1Timer timer = new MG1Timer();
        addObject(timer,1250,50);

        //add Timeleft
        MG1Timertxt mg3timertxt = new MG1Timertxt();
        addObject(mg3timertxt, 1200, 50);

        // Add quay.
        MG1Quay quay = new MG1Quay();
        addObject(quay,640,680);

        // Add cranes.
        MG1Crane crane1 = new MG1Crane();
        MG1Crane crane2 = new MG1Crane();
        MG1Crane crane3 = new MG1Crane();
        MG1Crane crane4 = new MG1Crane();
        MG1Crane crane5 = new MG1Crane();
        MG1Crane crane6 = new MG1Crane();
        addObject(crane1,100,655);
        addObject(crane2,300,655);        
        addObject(crane3,500,655);
        addObject(crane4,700,655);
        addObject(crane5,900,655);
        addObject(crane6,1100,655);

        // Add containers.
        MG1Containers containers1 = new MG1Containers();
        MG1Containers containers2 = new MG1Containers();
        MG1Containers containers3 = new MG1Containers();
        MG1Containers containers4 = new MG1Containers();
        MG1Containers containers5 = new MG1Containers();
        MG1Containers containers6 = new MG1Containers();
        addObject(containers1,30,680);
        addObject(containers2,230,680);
        addObject(containers3,430,680);
        addObject(containers4,630,680);
        addObject(containers5,830,680);
        addObject(containers6,1030,680);

        //Add Livesg
        this.lives = new MG1Lives();
        addObject(this.lives, 0,0);
        this.lives.setupLives();

        this.setPaintOrder(MG1Crane.class, MG1Containers.class, MG1Enemy.class, MG1Quay.class);

        MG1Crane[] cranes = new MG1Crane[] { crane1, crane2, crane3, crane4, crane5, crane6 };

        MG1Ship ship = new MG1Ship();
        MG1EnemyList enemyList = new MG1EnemyList();
        enemyList.setCranes(cranes);
        addObject(enemyList,0,0);
        addObject(ship, ship.getStartX(), ship.getStartY());
        ship.setRotation(225);
    }

    public void act()
    {
        buttonPressed();
    }

    public void gameOver() {
        int n = JOptionPane.showConfirmDialog(null, "Game over! Do you want to try again?", "Game Over!", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            MiniGame1World newWorld = new MiniGame1World();
            newWorld.setGameState(this.getGameState());
            Greenfoot.setWorld(newWorld);
        } else {
            MainMenuWorld newWorld = new MainMenuWorld();
            newWorld.setGameState(this.getGameState());
            Greenfoot.setWorld(newWorld);
        }
    }

    public void Win() {
        int n = JOptionPane.showConfirmDialog(null, "You won! Do you want to go to Minigame 2?", "Winner!", JOptionPane.YES_NO_OPTION);
        this.getGameState().setFinished(1, 0);
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

    public MG1Lives getLives() {
        return this.lives;
    }
}
