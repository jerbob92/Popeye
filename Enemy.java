import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends EnemyList
{
    int speed = 1;
    boolean atHarbor = false;
    EnemyList enemyList;
    public Enemy(EnemyList enemyList)
    {
        this.enemyList = enemyList;
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
    public void toHarbor()
    {   // richt het bootje naar de kraan als hij 'gesleept' wordt.
        Crane currentCrane = this.getEnemyList().currentCrane();
        
        //System.out.println(currentCrane);
        
        this.getEnemyList().incrementCrane();
        turnTowards(currentCrane.getX() - (currentCrane.getImage().getWidth() / 2), currentCrane.getY());
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
            turnTowards(0, world.getHeight() - 145);
            setLocation(crane.getX(), crane.getY()-30);
        }
    }
}