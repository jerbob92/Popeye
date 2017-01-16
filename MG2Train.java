import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Train here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Train extends Actor
{
    MG2Container dummyContainer; 
    boolean drivingAway = false;
    boolean drivingBack = false;

    /**
     * Act - do whatever the MG2Train wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        driveAway();
        driveBack();
        positionContainer();
        refreshDummy();
    }   

    public void refreshDummy() {
        MiniGame2World world = (MiniGame2World)getWorld();
        if (this.dummyContainer == null && world.getShip() != null) {
            this.dummyContainer = new MG2Container(true, this, world);
            getWorld().addObject(this.dummyContainer, -1000, -1000);     
        }  
    }

    public void driveBack() {
        if (this.drivingBack) {
            move(-2);
        }

        if (this.drivingBack && this.getX() < 1100) {
            this.drivingBack = false;
        }
    }

    public void driveAway() {
        if (this.drivingAway) {
            move(2);
        }

        if (this.drivingAway && this.getX() > 1500) {
            this.drivingAway = false;
            this.drivingBack = true;
            getWorld().removeObject(this.dummyContainer);
            this.dummyContainer = null;
        }
    }

    public void positionContainer() {
        if (this.dummyContainer != null) {
            this.dummyContainer.setLocation(this.getX()-70, this.getY()-25);     
        }
    }

    public void driveMeAway() {
        this.drivingAway = true;
        this.drivingBack = false;
    }
}
