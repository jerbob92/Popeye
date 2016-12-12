import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Life extends Actor
{
    /**
     * Act - do whatever the Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean alive = true;
    public void act() 
    {
        // Add your action code here.
        if(alive)
        {
            GreenfootImage imgAlive = new GreenfootImage("HeartL.png");
            this.setImage(imgAlive);
        }
        if(!alive)
        {
            GreenfootImage imgDead = new GreenfootImage("HeartD.png");
            this.setImage(imgDead);   
        }
    }    
}
