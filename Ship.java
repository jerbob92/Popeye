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
    
    public int start_x = 640;
    public int start_y = 475;
    boolean movingBack = false;
    
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turnCheck();        
        move();
        reset();
        privateBoatCheck();
        tow();
        
    }

    public void turn()
    {
        /*Zorgt ervoor dat het schip kan draaien. 0 is compleet naar rechts,
           180 is compleet naar links*/
        if(Greenfoot.isKeyDown("left") && !this.movingBack) {
            int newRotation = getRotation() - 3;
            if(newRotation > 184) {
                setRotation(newRotation);
            }
        }
        
        if(Greenfoot.isKeyDown("right") && !this.movingBack) {
            int newRotation = getRotation() + 3;
            if(newRotation < 356) {
                setRotation(newRotation);
            }
            
       }
    }
    
    public void move()
    {
        /*Beweegt het schip vooruit.*/
        if(Greenfoot.isKeyDown("up") && !this.movingBack) {
            move(4);
        }
        
        if (this.movingBack) {
            turnTowards(this.start_x,this.start_y);
            move(4);
            if(getY() >= this.start_y) {
                setLocation(this.start_x, this.start_y);
                turn(180);
                this.movingBack = false;
            }
        }
    }
    
    public void turnCheck()
    {
        /*checkt of de sleepboot op het beginpunt staat. */
        if(getX() == this.start_x && getY() == this.start_y) {
            this.movingBack = false;
            turn();
        }       
    }
    
    public void reset()
    {
         /*Checkt of het schip verplaatst is. Zo ja: beweegt hem terug naar de
           startpositie. */
       if((((getY() != this.start_y || getX() != this.start_x) && !Greenfoot.isKeyDown("up")) || isAtEdge())) {
            this.movingBack = true;
       }
    }

    public void tow()//'sleept' een tanker naar de haven
    {
      Enemy enemy;
      enemy = (Enemy)getOneObjectAtOffset(0,0, Enemy.class);
      if(enemy != null && !enemy.hasTarget()){
          World world;
          world = getWorld();
          
          enemy.toHarbor();
          
          Ship ship = new Ship();
          world.addObject(ship, this.start_x, this.start_y);
          ship.setRotation(225);
          world.removeObject(this);
        }   
    }
    
    public void privateBoatCheck()//Botsing met een private ship?
    {
      PrivateBoat private_boat;
      private_boat = (PrivateBoat)getOneObjectAtOffset(0,0, PrivateBoat.class);
      if(private_boat != null){
          if (!private_boat.isExploded()) {
            this.movingBack = true;
            MiniGame1World world;
            world = (MiniGame1World) getWorld();
            world.lives.removeLife();
            private_boat.explode();
          }
      }   
    }
}