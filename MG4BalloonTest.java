import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG4BalloonTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG4BalloonTest extends Actor
{
    /**
     * Act - do whatever the MG4BalloonTest wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean mouseOver = false;
    public void act() 
    {
        // Add your action code here.
        
        if (!mouseOver && Greenfoot.mouseMoved(this))
{
    setImage("balloon2.png");
    //System.out.print("1");
   
    mouseOver = true;
}
if (mouseOver && Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
{
    setImage("balloon1.png");
    //System.out.print("2");
    mouseOver = false;
}
    }    
}
