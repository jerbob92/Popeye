import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelGauge here.
 * 
 * @author (izzmemitch) 
 * @version (January 2017)
 */
public class LevelGauge extends Actor
{
    GreenfootImage MG2Arrow = new GreenfootImage("MG2Arrow.png"); // adjust name as needed
    GreenfootImage MG2Meter = new GreenfootImage("MG2Meter.png"); // adjust name as needed
    int balance;
     
    public LevelGauge()
    {
        GreenfootImage img = MG2Meter;
        img.scale(img.getWidth()*3/4, img.getHeight()*3/4);
        img = MG2Arrow;
        img.scale(img.getWidth()/2, img.getHeight()/2);
        setImage(MG2Arrow);
    }
     
    public void addedToWorld(World world)
    {
        Gauge gauge = new Gauge();
        gauge.setImage(MG2Meter);
        world.addObject(gauge, 390,305);
    }
 
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

private class Gauge extends Actor { }
}  
   
      
