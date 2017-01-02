import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG4Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG4Container extends Actor
{
    /**
     * Act - do whatever the MG4Container wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    boolean setup = false;
    public void act() 
    {
        // Add your action code here.
        if (getX() != 500){
          move(3);  
        }
        if(getX() == 500 && !setup){
            setup = true;
            setup();
        }
    } 
    public void setup(){
        //int i = 0;
        for (int i = 0; i<30; i++){
            World mg4world = (MiniGame4World) getWorld();
            mg4world.addObject(new MG4BalloonTest(),240+Greenfoot.getRandomNumber(500),400+Greenfoot.getRandomNumber(200));
        }
        
        
    }
}
