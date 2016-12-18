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
    boolean dummy;
    
    public MG2Container(boolean isDummy) {
        this.type = Greenfoot.getRandomNumber(4) + 1;
        GreenfootImage img = new GreenfootImage("MG2Container-" + this.type + ".png");
        
        this.dummy = isDummy;
        
        if (this.dummy) {
            img.setTransparency(255);
        }
        
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
