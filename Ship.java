import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
       
       
        
      
        
        turnCheck();        
        move();
        reset();
        tow();
        //aimLine();
        //test();
        
    }/*################ACT################*/
    public void turn()
    {
        /*Zorgt ervoor dat het schip kan draaien. 0 is compleet naar rechts,
           180 is compleet naar links*/
        if(Greenfoot.isKeyDown("a"))
        {
            if(getRotation()>= 182 || getRotation() <= 0){turn(-3);}
            else if (getRotation() == 181){/*niets*/}
        }
        if(Greenfoot.isKeyDown("d"))
        {
            if(getRotation()>= 180 && getRotation() <= 358){turn(3);}
            else if(getRotation() == 359){/*niets*/}            
        }
        //aimLine();
    }
    public void move()
    {
        /*Beweegt het schip vooruit.*/
        if(Greenfoot.isKeyDown("w")){move(4);}
    }
    public void turnCheck()
    {
        /*checkt of de sleepboot op het beginpunt staat. */
        if(getX() == 300 && getY() == 335){turn();}       
    }
    public void reset()
    {
         /*Checkt of het schip verplaatst is. Zo ja: beweegt hem terug naar de
           startpositie. */
       if((((getY() != 335) && Greenfoot.isKeyDown("w") != true)|| isAtEdge()))
       {
            turnTowards(300,335);
            move(4);
            if(getX() == 300 && getY() == 335)
            {
                setRotation(270);
            }
        
        }
    }

    public void tow()//'sleept' een tanker naar de haven
    {
      Enemy enemy;
      enemy = (Enemy)getOneObjectAtOffset(0,0, Enemy.class);
      if(enemy != null){
          World world;
          world = getWorld();
          
          enemy.toHarbor();
          
          Ship ship = new Ship();
          world.addObject(ship,300,335);
          ship.setRotation(225);
          world.removeObject(this);
        }   
    }
}