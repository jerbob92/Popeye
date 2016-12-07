import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrivateBoat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PrivateBoat extends EnemyList
{
    /**
     * Act - do whatever the PrivateBoat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(2);
        edgeCheck();
    }    
    
     public void edgeCheck() {
        if (isAtEdge()) {
          MiniGame1World world;
          world = (MiniGame1World) getWorld();
          world.removeObject(this);
        }
    }
}
