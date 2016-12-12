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
    long harborArriveTime;
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
            moveToHarbor();
            move(speed);
            edgeCheck();
            substractLifeCheck();
        } else {
            viewPortCheck();
            long elapsedTime = System.currentTimeMillis() - this.harborArriveTime;
            if (elapsedTime / 1000 > 5) {
                move(speed);
            }
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
    }
    
    public void moveToHarbor() {
        if (this.target != null) {
            int target_x = this.target.getX();
            int target_y = this.target.getY()-50;
            
            turnTowards(target_x, target_y);
        }
    }
    
    public void edgeCheck()
    {
        // Kijk of de boot bij de kraan staat.
        Crane crane;
        crane = (Crane)getOneObjectAtOffset(0,0, Crane.class);
        if (crane != null) {
            // Boot is bij de kraan, zet stil en richt goed.
            this.atHarbor = true;
            this.harborArriveTime = System.currentTimeMillis();
            setRotation(0); 
            setLocation(crane.getX(), crane.getY()-30);
            this.target.setFinished(true);
        }
    }
    
    public void viewPortCheck() {
        if (isAtEdge()) {
          
          MiniGame1World world;
          world = (MiniGame1World) getWorld();
          world.removeObject(this);
        }
    }
    
    public void substractLifeCheck() {
        if (isAtEdge()) {
          i=0;  
          MiniGame1World world;
          world = (MiniGame1World) getWorld();
          world.lives.removeLife();
          world.removeObject(this);

        }
    }
}