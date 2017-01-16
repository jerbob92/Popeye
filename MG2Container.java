import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Container here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Container extends Actor
{

    int type;
    boolean dummy;
    MG2Train train;

    public MG2Container(boolean isDummy, MG2Train train, MiniGame2World world) {
        this.train = train;
        this.type = Greenfoot.getRandomNumber(4) + 1;
        GreenfootImage img = new GreenfootImage("MG2Container-" + this.type + ".png");
        this.setImage(img);

        this.dummy = isDummy;

        if (this.dummy) {
            MG2Container randomContainer = world.getShip().getRandomContainer();
            if (randomContainer != null) {
                this.type = randomContainer.getType();
                img = new GreenfootImage("MG2Container-" + this.type + ".png");
                this.setImage(img);
            } else {
                world.win();
            }
            this.setImageTransparency(125);
        }
    }

    /**
     * Act - do whatever the MG2Container wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    

    public void setImageTransparency(int transparency) {
        GreenfootImage img = this.getImage();
        img.setTransparency(transparency);
        this.setImage(img);
    }

    public boolean isDummy() {
        return this.dummy;
    }

    public int getType() {
        return this.type;
    }

    public MG2Train getTrain() {
        return this.train;
    }

    public MG2Container touchingDummyContainer() {
        MG2Container container;
        container = (MG2Container)getOneIntersectingObject(MG2Container.class);
        if (container != null && container.isDummy() && this.getType() == container.getType()) {
            return container;
        }

        return null;
    }

    public boolean touchingAnotherContainer() {
        MG2Container container;
        container = (MG2Container)getOneIntersectingObject(MG2Container.class);
        if (container != null && !container.isDummy()) {
            return true;
        }
        return false;
    }
}
