import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Healthbar extends Actor
{
    int health = 10;
    int healthBarWidth = 40;
    int healthBarHeight = 10;
    int pixelsPerHealthPoint = healthBarWidth / health;
    
    /**
     * Act - do whatever the Healthbar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MG3Healthbar(int totalhealth)
    {
        this.health = totalhealth;
        this.pixelsPerHealthPoint = healthBarWidth / health;
        update();
    }
    
    public void act() 
    {
        update();// Add your action code here.
    }    
    public void update ()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health*pixelsPerHealthPoint, healthBarHeight);
    }
    
    public void loseHealth()
    {
        health--;
    }
    public boolean lifedone() {
        if (this.health < 1) {
            return false;
            }
            return true;
    }
        
}
