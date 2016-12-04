import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends EnemyList
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed;
    public Enemy()
    {   //bepaald een random snelheid voor het bootje.
        this.speed = Greenfoot.getRandomNumber(2)+1;
        
    }
    public void act() 
    {
        // Add your action code here.
        move(speed);
        edgeCheck();
       
    }
    public void toHarbor()
    {   // richt het bootje naar de haven als hij 'gesleept' wordt.
        turnTowards(600,400);
    }
    public void edgeCheck()
    {
         if(isAtEdge())
         {  // Delete het bootje als hij bij de rand is.          
            World world;
            world = getWorld();
            
            world.removeObject(this);
            super.i--;
        }

    }
}