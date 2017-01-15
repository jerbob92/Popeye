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
      int balance;
      
public Arrow()
{
        GreenfootImage img = Arrow;
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(Arrow);
       
}
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
   
public void setBalance(int balance)
{
    balance = balance;
   
}
 
 /**
     * Act - do whatever the LevelGauge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
public void act()
{
    
   if (balance*30 > getRotation()) turn(1);
   if (balance*30 < getRotation()) turn(-1);
   
     // Add your action code here.
}


}  
