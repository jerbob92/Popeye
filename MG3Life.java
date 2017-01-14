import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Life here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Life extends Actor
{
    /**
     * Act - do whatever the MG3Life wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean alive = true;
    
    public void act() 
    {
        // Add your action code here.
        if(this.getAlive())
        {
            GreenfootImage imgAlive = new GreenfootImage("MG3life.png");
            this.setImage(imgAlive);
        }
        else
        {
            GreenfootImage imgDead = new GreenfootImage("MG3Death.png");
            this.setImage(imgDead);   
        }
    }    
    
    public boolean getAlive() {
        return this.alive;
    }
    
    public void setAlive(boolean newStatus) {
        this.alive = newStatus;
    }
}

