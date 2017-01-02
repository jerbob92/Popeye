import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Firebig1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Firebig1 extends MG3Fire
{
    int fireSize = 0;
    MG3Healthbar healthbar;
    long losttimehealth = 0;
    public MG3Firebig1 ()
    {
        
        // @todo: random size
        this.fireSize = 2;
        this.losttimehealth = System.currentTimeMillis();

    }
    /**
     * Act - do whatever the Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (System.currentTimeMillis() - this.losttimehealth > 2000)
        {
            this.healthbar.loseHealth();
            this.losttimehealth = System.currentTimeMillis();
        }// Add your action code here.
        
    }   
    
    public void addHealthbar() {
        this.healthbar = new MG3Healthbar(40 - (this.fireSize * 10));
        getWorld().addObject(this.healthbar,getX(), getY() + 45);
    } 
    
}


