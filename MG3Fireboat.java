import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Fireboat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Fireboat extends Actor
{
    private int startX = 300;
    private int startY = 300;
    
    /**
     * Act - do whatever the MG3Fireboat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        if(Greenfoot.isKeyDown("up") ) {
            move(5);
            checkObstacle();
           
        }
        if(Greenfoot.isKeyDown("down") ) {
            move(-4);
            checkObstacle2();
        }
        
        if(Greenfoot.isKeyDown("left")) {
            turn(-3);
            checkObstacle();
            checkObstacle2();
            
        }    
        if(Greenfoot.isKeyDown("right")) {
            turn(3);
            checkObstacle();
            checkObstacle2();

        }
        if(Greenfoot.isKeyDown("space")) {
            fire();

        }
        if(Greenfoot.isKeyDown("b")) {
            fire2();

        }
    } 
    
    public int getStartX() {
        return this.startX;
    }
    
    public int getStartY() {
        return this.startY;
    }
    
    /**
     * fire the cannon space.
     */
    private void fire2()
    {
        MG3Waterbeam2 mg3waterbeam2 = new MG3Waterbeam2();
        getWorld().addObject(mg3waterbeam2,getX(), getY());
        mg3waterbeam2.setRotation(getRotation());
        mg3waterbeam2.move(-20);
    }    
        /**
     * fire the cannon space.
     */
    private void fire()
    {
        MG3Waterbeam mg3waterbeam = new MG3Waterbeam();
        getWorld().addObject(mg3waterbeam,getX(), getY());
        mg3waterbeam.setRotation(getRotation());
        mg3waterbeam.move(50);
    }    
       public void checkObstacle()
    {
        Actor mg3Quay = getOneIntersectingObject(MG3Quay.class);
        if(mg3Quay != null)
        {
            move(-5);
        }
        Actor mg3Containership = getOneIntersectingObject(MG3Containership.class);
        if(mg3Containership != null)
        {
            move(-5);
        }
        Actor mg3Yacht = getOneIntersectingObject(MG3yacht.class);
        if(mg3Yacht!=null)
        {
            move(-5);
        }
    }
    public void checkObstacle2()
    {
        Actor mg3Quay = getOneIntersectingObject(MG3Quay.class);
        if(mg3Quay != null)
        {
            move(5);
        }
        Actor mg3Containership = getOneIntersectingObject(MG3Containership.class);
        if(mg3Containership != null)
        {
            move(5);
        }
        Actor mg3Yacht = getOneIntersectingObject(MG3yacht.class);
        if(mg3Yacht!=null)
        {
            move(5);
        }
    }
}



