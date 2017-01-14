import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3StartButton extends StartButton
{
    /**
     * Act - do whatever the MG3StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            MainMenuWorld thisWorld = (MainMenuWorld) getWorld();
            MiniGame3World nextWorld = new MiniGame3World();
            nextWorld.setGameState(thisWorld.getGameState());
            Greenfoot.setWorld(nextWorld);
        }
    }    
}
