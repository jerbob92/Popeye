import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG1Ship extends Actor
{
    
    private int startX = 640;
    private int startY = 475;
    private boolean movingBack = false;
    
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
    
    public int getStartX() {
        return this.startX;
    }
    
    public int getStartY() {
        return this.startY;
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
            turnTowards(this.startX, this.startY);
            move(4);
            if(getY() >= this.startY) {
                setLocation(this.startX, this.startY);
                turn(180);
                this.movingBack = false;
            }
        }
    }
    
    public void turnCheck()
    {
        /*checkt of de sleepboot op het beginpunt staat. */
        if(getX() == this.startX && getY() == this.startY) {
            this.movingBack = false;
            turn();
        }       
    }
    
    public void reset()
    {
         /*Checkt of het schip verplaatst is. Zo ja: beweegt hem terug naar de
           startpositie. */
       if(((getY() != this.startY || getX() != this.startX) && !Greenfoot.isKeyDown("up")) || isAtEdge()) {
            this.movingBack = true;
       }
    }

    public void tow()//'sleept' een tanker naar de haven
    {
      MG1Enemy enemy;
      enemy = (MG1Enemy)getOneObjectAtOffset(0,0, MG1Enemy.class);
      if(enemy != null && !enemy.hasTarget()){
          World world;
          world = getWorld();
          
          enemy.toHarbor();
          
          MG1Ship ship = new MG1Ship();
          world.addObject(ship, this.startX, this.startY);
          ship.setRotation(225);
          world.removeObject(this);
        }   
    }
    
    public void privateBoatCheck()//Botsing met een private ship?
    {
      MG1PrivateBoat privateBoat = (MG1PrivateBoat) getOneObjectAtOffset(0,0, MG1PrivateBoat.class);
      if(privateBoat != null && !privateBoat.isExploded()){
          this.movingBack = true;
          MiniGame1World world = (MiniGame1World) getWorld();
          world.getLives().removeLife();
          privateBoat.explode();
      }   
    }
}