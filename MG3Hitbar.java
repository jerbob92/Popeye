import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MG3Hitbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Hitbar extends Actor
{
    int hit = 1;
    int hitBarWidth = 40;
    int hitBarHeight = 10;
    int totalhit = 1;
    
    public MG3Hitbar()
    {
        this.hit = totalhit;
        update();
    }
    public void act() 
    {
        update();// Add your action code here.
    } 
    public void update ()
    {
        setImage(new GreenfootImage(hitBarWidth + 2, hitBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, hitBarWidth + 1, hitBarHeight + 1);
        myImage.setColor(Color.GREEN);
        myImage.fillRect(1, 1, hit, hitBarHeight);
    }
    
    public void getHit()
    {
        hit++;
    }  
    public boolean hitful() {
        if (this.hit >= 39) {
            return false;
            }
            return true;
    }
        
}



