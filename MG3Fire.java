import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Fire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Fire extends Actor
{
    int fireSize = 0;
    MG3Healthbar healthbar;
    MG3Hitbar hitbar;
    long losttimehealth = 0;
    long healthloseinterval = 0;
    
    public MG3Fire (long healthloseinterval)
    {
        this.fireSize = 3;
        this.losttimehealth = System.currentTimeMillis();
        this.healthloseinterval = healthloseinterval;
    }
    
    /**
     * Act - do whatever the MG3Fire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (System.currentTimeMillis() - this.losttimehealth > this.healthloseinterval)
        {
            this.healthbar.loseHealth();
            this.losttimehealth = System.currentTimeMillis();
        }
       
        gethit();
        removefire();
        removefiredone();
    }    
    
    public void gethit()
    {   
         throw new UnsupportedOperationException();
    }
    
    public void addHealthbar() {
        this.healthbar = new MG3Healthbar(40 - (this.fireSize * 10));
        getWorld().addObject(this.healthbar,getX(), getY() + 35);
    } 
    public void addHitbar() {
        this.hitbar = new MG3Hitbar();
        getWorld().addObject(this.hitbar,getX(), getY() + 45);
    } 
    
    public void removefire()
    {
                   
       if (!hitbar.hitful()){
           MiniGame3World world;
           world = (MiniGame3World)getWorld();
           world.removeObject(this);
           world.removeObject(hitbar);
           world.removeObject(healthbar);
           recreate(world);
        }
       
    } 
    public void removefiredone()
    {
        if (!healthbar.lifedone ()) {
           MiniGame3World world;
           world = (MiniGame3World)getWorld();
           world.removeObject(this);
           world.removeObject(hitbar);
           world.removeObject(healthbar);
           world.getLives().removeLife();
           recreate(world);
        }
    }
    
    public void recreate(MiniGame3World world) {
         throw new UnsupportedOperationException();
    }
}
