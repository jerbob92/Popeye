import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG3Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Lives extends Actor
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private MG3Life[] lives = new MG3Life[3];

    MiniGame3World world;

    public MG3Lives()
    {  
        this.lives[0] = new MG3Life();
        this.lives[1]= new MG3Life(); 
        this.lives[2]= new MG3Life();
    }

    public void act() 
    {
        // Add your action code here.
    }   

    public void setupLives()
    {
        this.world = (MiniGame3World)getWorld();
        this.world.addObject(this.lives[0],world.getWidth()-50,250);
        this.world.addObject(this.lives[1],world.getWidth()-50,300);
        this.world.addObject(this.lives[2],world.getWidth()-50,350);

    }

    public void removeLife()
    {
        for (int i=2; i>=0;i--)
        {
            if (i == 0)
            {
                this.getLive(i).setAlive(false);
                world.gameOver();
            }
            if (this.getLive(i).getAlive())
            {
                this.getLive(i).setAlive(false);
                break;
            }

        }

    }

    public MG3Life getLive(int i) {
        return this.lives[i];
    }

    public MG3Life[] getLives() {
        return this.lives;
    }
}
