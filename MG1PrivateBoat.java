import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PrivateBoat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG1PrivateBoat extends MG1EnemyList
{

    long removeAt;
    boolean exploded = false;
    GifImage gifImage;

    public MG1PrivateBoat() {
        this.gifImage = new GifImage("explosion.gif");

        GreenfootImage img = new GreenfootImage("ship4.png");
        this.setImage(img);
    }

    /**
     * Act - do whatever the PrivateBoat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!this.exploded) {
            move(2);
            edgeCheck();
        } else {
            if (System.currentTimeMillis() > this.removeAt) {
                World world;
                world = getWorld();
                world.removeObject(this);
            } else {
                this.setImage(this.gifImage.getCurrentImage());
            }
        }
    }    

    public void edgeCheck() {
        if (isAtEdge()) {
            MiniGame1World world;
            world = (MiniGame1World) getWorld();
            world.removeObject(this);
        }
    }

    public void explode() {
        this.setImage(gifImage.getCurrentImage());
        this.exploded = true;
        this.removeAt = System.currentTimeMillis() + 700;
    }

    public boolean isExploded() {
        return this.exploded;
    }
}
