import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    GreenfootImage Arrow = new GreenfootImage("MG2Arrow.png");

    // Balance should be between -80 and 80;
    int balance = 0;

    public Arrow()
    {
        GreenfootImage img = Arrow;
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(Arrow);
    }

    public void setBalance(int balance)
    {
        if (balance >= -80 && balance <= 80) {
            this.balance = balance;   
        }
        else if (balance < -80) {
            this.balance = -80; 
        }
        else if (balance > 80) {
             this.balance = 80; 
        }
    }

    /**
     * Act - do whatever the LevelGauge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setRotation(this.balance);
    }

}  
