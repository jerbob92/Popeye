import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Train here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Train extends Actor
{
    MG2Container dummyContainer; 
    
    public void addDummy() {
              this.dummyContainer = new MG2Container(false);
              this.getWorld().addObject(this.dummyContainer, this.getY() + 100, this.getX()+100);    
    }
    
    /**
     * Act - do whatever the MG2Train wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
