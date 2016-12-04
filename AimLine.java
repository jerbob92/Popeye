import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class AimLine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AimLine extends Actor
{
    /**
     * Act - do whatever the AimLine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AimLine(int x,int y)
    {
        
      GreenfootImage image = new GreenfootImage(600,400); 
      image.setColor(Color.BLACK);
      image.drawLine(300,335,x,y);
      setImage(image);
      
    }
    public void act() 
    { 
    }    
}