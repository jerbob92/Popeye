import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG1Enemy extends MG1EnemyList
{
    private int speed;
    private boolean atHarbor;
    private long harborArriveTime;
    private MG1EnemyList enemyList;
    private MG1Crane target;

    public MG1Enemy(MG1EnemyList enemyList)
    {
        GreenfootImage img = new GreenfootImage("containership.png");
        this.setImage(img);

        this.enemyList = enemyList;
        this.atHarbor = false;
        this.speed = 1;
        this.target = null;
    }

    public MG1EnemyList getEnemyList() {
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
            turnTowards(this.target.getX(), this.target.getY()-50);
        }
    }

    public void edgeCheck()
    {
        // Kijk of de boot bij de kraan staat.
        MG1Crane crane;
        crane = (MG1Crane)getOneObjectAtOffset(0,0, MG1Crane.class);
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
            world.getLives().removeLife();
            world.removeObject(this);

        }
    }
}