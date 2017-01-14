import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    MG3Hitbar hitbar;
    long losttimehealth = 0;
    public MG3Firebig1 ()
    {
        
        // @todo: random size
        this.fireSize = 3;
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
        gethit();
        removefire();
        removefiredone();
    }   
     public void gethit()
    // groene balk loopt op bij hit!
    {
        List<MG3Waterbeam2> mg3waterbeam2;
        mg3waterbeam2 = (List<MG3Waterbeam2>)getObjectsInRange(15, MG3Waterbeam2.class);
        
        // iterate via "for loop"
		for (int i = 0; i < mg3waterbeam2.size(); i++) {
			this.hitbar.getHit();
            
		}
                  
           
    }
    public void addHealthbar() {
        this.healthbar = new MG3Healthbar(40 - (this.fireSize * 10));
        getWorld().addObject(this.healthbar,getX(), getY() + 45);
    } 
    public void addHitbar() {
        this.hitbar = new MG3Hitbar();
        getWorld().addObject(this.hitbar,getX(), getY() + 55);
    } 
    public void removefire()
    {
                   
       if (!hitbar.hitful() == true){
           MiniGame3World world;
           world = (MiniGame3World)getWorld();
           world.removeObject(this);
           world.removeObject(hitbar);
           world.removeObject(healthbar);
           world.Firebig1();
        }
       
    } 
    public void removefiredone()
    {
        if (!healthbar.lifedone () == true) {
           MiniGame3World world;
           world = (MiniGame3World)getWorld();
           world.removeObject(this);
           world.removeObject(hitbar);
           world.removeObject(healthbar);
           world.lives.removeLife();
           world.Firebig1();
        
        }
    }
}



