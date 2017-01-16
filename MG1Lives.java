import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG1Lives extends Actor
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private MG1Life[] lives = new MG1Life[3];
    MiniGame1World world;
    public MG1Lives()
    {  
        this.lives[0] = new MG1Life();
        this.lives[1] = new MG1Life(); 
        this.lives[2] = new MG1Life();
    }

    public void act() 
    {
        // Add your action code here.
    }   

    public void setupLives()
    {
        this.world = (MiniGame1World)getWorld();
        this.world.addObject(this.lives[0],world.getWidth()-150,50);
        this.world.addObject(this.lives[1],world.getWidth()-200,50);
        this.world.addObject(this.lives[2],world.getWidth()-250,50);
    }

    public void removeLife()
    {
        for (int i=2; i>=0;i--)
        {
            if (i == 0)
            {
                this.lives[i].setStatus(false);
                world.gameOver();
            }

            if (this.lives[i].getStatus())
            {
                this.lives[i].setStatus(false);
                break;
            }

        }

    }
}
