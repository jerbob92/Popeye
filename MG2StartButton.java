import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2StartButton extends StartButton
{
    /**
     * Act - do whatever the MG2StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            MainMenuWorld thisWorld = (MainMenuWorld) getWorld();
            MiniGame2World nextWorld = new MiniGame2World();
            nextWorld.setGameState(thisWorld.getGameState());
            Greenfoot.setWorld(nextWorld);
        }
    }    
}
