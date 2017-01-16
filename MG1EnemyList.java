import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG1EnemyList extends Actor
{
    /**
     * Act - do whatever the EnemyList wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world;
    int i;
    boolean alt;
    boolean privateBoatAlt;
    MG1Crane[] cranes;
    int currentCrane;

    public MG1EnemyList(){
        this.currentCrane = 0;
        this.i = 0;
        this.alt = true;
        getImage().setTransparency(0);
    }

    public void setCranes(MG1Crane[] cranes) {
        this.cranes = cranes;
    }

    public MG1Crane currentCrane() {
        return this.cranes[this.currentCrane];
    }

    public int currentCraneI() {
        return this.currentCrane;
    }

    public void incrementCrane() {
        this.currentCrane++;

        if (this.currentCrane >= this.cranes.length) {
            this.currentCrane = 0;
        }
    }

    public void act() 
    {
        // Add your action code here.
        world = getWorld();
        Actor enemy;
        if (this.i == 0) {
            enemy = new MG1Enemy(this);
            world.addObject(enemy, 5, Greenfoot.getRandomNumber(100)+100);
            this.i++;
        }

        if(Greenfoot.getRandomNumber(5000) < 10){
            enemy = new MG1Enemy(this);
            if(alt) {
                world.addObject(enemy, 5, Greenfoot.getRandomNumber(100)+200);
                alt = false;
            } else {
                world.addObject(enemy, 5, Greenfoot.getRandomNumber(100)+100);
                alt = true;
            }
            this.i++;
        }

        if(Greenfoot.getRandomNumber(2000) < 10){
            MG1PrivateBoat privateBoat = new MG1PrivateBoat();
            if(privateBoatAlt) {
                world.addObject(privateBoat, 5, Greenfoot.getRandomNumber(100)+200);
                privateBoatAlt = false;
            } else {
                world.addObject(privateBoat, 5, Greenfoot.getRandomNumber(100)+100);
                privateBoatAlt = true;
            }
        }
    }
}