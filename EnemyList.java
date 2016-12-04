import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyList extends Actor
{
    /**
     * Act - do whatever the EnemyList wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world;
    int i;
    boolean alt;
    Crane[] cranes;
    int currentCrane;
    
    public EnemyList(){
        this.currentCrane = 0;
        this.i = 0;
        this.alt = false;
    }
    
    public void setCranes(Crane[] cranes) {
        this.cranes = cranes;
    }
    
    public Crane currentCrane() {
        return this.cranes[this.currentCrane];
    }
    
    public int currentCraneI() {
        return this.currentCrane;
    }
    
    public void incrementCrane() {
        this.currentCrane++;
    }
    
    public void act() 
    {
        // Add your action code here.
        world = getWorld();
        Actor enemy;
        if (this.i == 0) {
            enemy = new Enemy(this);
            world.addObject(enemy,5,(Greenfoot.getRandomNumber(100)+100));
            this.i++;
        }
        
        if(i < this.cranes.length && Greenfoot.getRandomNumber(5000) < 10){
            enemy = new Enemy(this);
            if(alt) {
                world.addObject(enemy,5,(Greenfoot.getRandomNumber(100)+200));
                alt = false;
            } else {
                world.addObject(enemy,5,Greenfoot.getRandomNumber(100)+100);
                alt = true;
            }
            this.i++;
        }
    }    
}