import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Hook here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Hook extends Actor
{
    
    MG2Container draggingContainer;
    
    /**
     * Act - do whatever the MG2Hook wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        checkContainer();
        positionCurrentContainer();
        checkContainerTouchingDummy();
        checkDropContainer();
    }    
    
    public void move()
    {
        // Make sure object is between boundries.
        if(Greenfoot.isKeyDown("left") && getX() > 20) {
            move(-4);
       
            if (this.draggingContainer != null && this.draggingContainer.touchingAnotherContainer()) {
              move(4);  
            } else {
                MG2Container container = (MG2Container)getOneIntersectingObject(MG2Container.class);
                if (container != null && this.draggingContainer == null) {
                    move(4);
                }
            }
        }
        
        if(Greenfoot.isKeyDown("right") && getX() < 1260) {
            move(4);
            if (this.draggingContainer != null && this.draggingContainer.touchingAnotherContainer()) {
              move(-4);  
            } else {
                MG2Container container = (MG2Container)getOneIntersectingObject(MG2Container.class);
                if (container != null && this.draggingContainer == null) {
                    move(-4);
                }
            }
        }   
        
        if(Greenfoot.isKeyDown("down") && ((this.draggingContainer == null && getY() < 250) || (this.draggingContainer != null && getY() < 230))) {
            setRotation(90);
            move(4);
            if (this.draggingContainer != null && this.draggingContainer.touchingAnotherContainer()) {
              move(-4);  
            } else {
                MG2Container container = (MG2Container)getOneIntersectingObject(MG2Container.class);
                if (container != null && this.draggingContainer == null) {
                    move(-4);
                }
            }
        }  
        
        if(Greenfoot.isKeyDown("up") && getY() > -250) {
            setRotation(270);
            move(4);
        }
           
        // Make sure object is always properly rotated.
        setRotation(0);
    }
    
    public void checkContainer() {
        MG2Container container;
        container = (MG2Container)getOneIntersectingObject(MG2Container.class);
        if (container != null && this.draggingContainer == null && !container.isDummy()) {
            MiniGame2World world = (MiniGame2World) getWorld();
            if (world.getShip().isLastContainerInColumn(container)) {
                this.draggingContainer = container;
                world.getShip().removeContainer(this.draggingContainer);
                this.setLocation(this.draggingContainer.getX(), this.getY());   
            }
        }
    }
    
    public void positionCurrentContainer() {
        if (this.draggingContainer != null) {
            this.draggingContainer.setLocation(this.getX(), this.getY()+390);      
        }
    }
    
    public void checkContainerTouchingDummy() {
        if (this.draggingContainer != null) {
            MG2Container dummyContainer = this.draggingContainer.touchingDummyContainer();
            if (dummyContainer != null) {
                dummyContainer.setImageTransparency(255);
                dummyContainer.getTrain().driveMeAway();
                getWorld().removeObject(this.draggingContainer);
                this.draggingContainer = null;
            }
        }

    }
    
    public void checkDropContainer() {
        if(this.draggingContainer != null && Greenfoot.isKeyDown("space")) {
            MiniGame2World world = (MiniGame2World) getWorld();            
            if (getX() >= 226 && getX() <= 694) {
                int currentRow = 0;
                if (getX() >= 226 && getX() <= 343) {
                    currentRow = 0;
                }
                else if (getX() > 343 && getX() <= 460) {
                    currentRow = 1;
                }
                
                else if (getX() > 460 && getX() <= 577) {
                    currentRow = 2;
                }
                
                else if (getX() > 577 && getX() <= 694) {
                    currentRow = 3;
                }
                
                if (world.getShip().spaceAtRow(currentRow)) {
                    world.getShip().addContainer(currentRow, this.draggingContainer);
                    this.draggingContainer = null;
                }
            }
        }
    }
}
