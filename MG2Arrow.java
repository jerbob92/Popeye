import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Arrow extends Actor
{
    GreenfootImage arrow = new GreenfootImage("MG2Arrow.png");

    // Balance should be between -80 and 80;
    int balance = 0;
    boolean blinking = false;
    boolean blink_switch = false;
    long blinkTimer;

    public MG2Arrow()
    {
        GreenfootImage img = arrow;
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(arrow);
        this.blinkTimer = System.currentTimeMillis();
    }

    public void setBalance(int balance)
    {
        if (balance >= -80 && balance <= 80) {
            this.balance = balance;   
            
            if (balance <= -50) {
               this.blinking = true; 
            }
            else if (balance >= 50) {
                this.blinking = true; 
            }
            else {
                this.blinking = false; 
            }
           
        }
        else if (balance < -80) {
            this.balance = -80; 
            ((MiniGame2World)getWorld()).gameOver();
        }
        else if (balance > 80) {
             this.balance = 80; 
             ((MiniGame2World)getWorld()).gameOver();
        }
    }

    /**
     * Act - do whatever the LevelGauge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setRotation(this.balance);
        
        if (this.blinking) {
            long currentTime = System.currentTimeMillis();
            long timePassed = currentTime - this.blinkTimer;
            
            if (timePassed > 500) {
                if (this.blink_switch) {
                    this.blink_switch = false;
                    this.setTransparency(255);
                } else {
                    this.blink_switch = true;
                    this.setTransparency(100);
                }
                
                this.blinkTimer = System.currentTimeMillis();
            }
        } else {
            this.setTransparency(255);
        }
    }

    public void setTransparency(int transparency) {
        GreenfootImage img = this.getImage();
        img.setTransparency(transparency);
        this.setImage(img);
    }
}  
