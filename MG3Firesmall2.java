import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Firesmall2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Firesmall2 extends MG3Fire
{
   
     int fireSize = 0;
    MG3Healthbar healthbar;
    MG3Hitbar hitbar;
    long losttimehealth = 0;
    public MG3Firesmall2 ()
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
        if (System.currentTimeMillis() - this.losttimehealth > 4000)
        {
            this.healthbar.loseHealth();
            this.losttimehealth = System.currentTimeMillis();
        }// Add your action code here.
        gethit();
        removefire();
    }   
    public void gethit()
    // groene balk loopt op bij hit!
    {
        MG3Waterbeam2 mg3waterbeam2;
        mg3waterbeam2 = (MG3Waterbeam2)getOneObjectAtOffset(0,0, MG3Waterbeam2.class);
        if(mg3waterbeam2 != null){
            this.hitbar.getHit();
            this.hitbar.getHit();
        
        }   
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
                   
       if (!hitbar.hitful() == true){
           World world;
           world = getWorld();
           world.removeObject(this);
           world.removeObject(hitbar);
           world.removeObject(healthbar);
       
        }
       
    }  
}
