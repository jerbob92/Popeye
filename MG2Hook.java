import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Hook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Hook extends Actor
{
    /**
     * Act - do whatever the MG2Hook wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
    }    
    
    public void move()
    {
        if(Greenfoot.isKeyDown("left") && getX() > 20) {
            move(-4);
        }
        
        if(Greenfoot.isKeyDown("right") && getX() < 1260) {
            move(4);
        }   
        
        if(Greenfoot.isKeyDown("down") && getY() < 290) {
            setRotation(90);
            move(4);
        }  
        
        if(Greenfoot.isKeyDown("up") && getY() > -250) {
            setRotation(270);
            move(4);
        }  
        
        System.out.println(getY());
            
        setRotation(0);
    }
}
