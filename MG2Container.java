import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Container extends Actor
{
    
    int type;
    
    public MG2Container() {
        this.type = Greenfoot.getRandomNumber(4) + 1;
        GreenfootImage img = new GreenfootImage("MG2Container-" + this.type + ".png");
        this.setImage(img);
        
    }
    
    /**
     * Act - do whatever the MG2Container wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
