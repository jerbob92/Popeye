import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lives here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lives extends Actor
{
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Life[] lives = new Life[3];
    //Life life1 = new Life();
    MiniGame1World world;
    public Lives()
    {  
        //this.world = (MiniGame1World) getWorld(); 
        this.lives[0] = new Life();
        this.lives[1]= new Life(); 
        this.lives[2]= new Life();
        //setupLives();
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
                lives[i].alive = false;
                world.gameOver();
            }
            if (this.lives[i].alive)
            {
                lives[i].alive = false;
                break;
            }
           
        }
        
    }
}
