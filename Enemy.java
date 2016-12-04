import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends EnemyList
{
    int speed;
    boolean atHarbor;
    EnemyList enemyList;
    Crane target;
    
    public Enemy(EnemyList enemyList)
    {
        this.enemyList = enemyList;
        this.atHarbor = false;
        this.speed = 1;
        this.target = null;
    }
    
    public EnemyList getEnemyList() {
        return this.enemyList;
    }
    
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (!this.atHarbor) {
            move(speed);
            edgeCheck();
        }  
    }
    
    public boolean hasTarget() {
        if (this.target == null) {
            return false;
        }
        
        return true;
    }
    
    public void toHarbor()
    {   // richt het bootje naar de kraan als hij 'gesleept' wordt.
        this.target = this.getEnemyList().currentCrane();
        this.getEnemyList().incrementCrane();
        
        System.out.println(this.target.getX());
        System.out.println(this.target.getY());
        
        int dx = this.target.getX() - getX();  
        int dy = this.target.getY() - getY();  
        double angle = Math.toDegrees(Math.atan2(dy, dx));  
        int x = (int) angle;
        setRotation (getRotation() + x);
    }
    
    public void edgeCheck()
    {
        // Kijk of de boot bij de kraan staat.
        Crane crane;
        crane = (Crane)getOneObjectAtOffset(0,0, Crane.class);
        if(crane != null) {
            
            world = getWorld();
            // Boot is bij de kade, zet stil en richt goed.
            this.atHarbor = true;
            setRotation(0); 
            setLocation(crane.getX(), crane.getY()-30);
        }
    }
}