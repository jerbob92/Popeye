import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyList here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyList extends Actor
{
    /**
     * Act - do whatever the EnemyList wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world;
    static int i=0;
    static boolean alt = true;
    public EnemyList(){
        Enemy[] enemies;
        
    }
    
    public void act() 
    {
        // Add your action code here.
        world = getWorld();
        int random = Greenfoot.getRandomNumber(700);
        
        if((random <= 10)&&(i<=3))
        {
            Actor enemy = new Enemy();
            if(alt)
            {
                world.addObject(enemy,5,(Greenfoot.getRandomNumber(100)+100));
                alt = false;
            }
            else if(!alt)
            {
                world.addObject(enemy,5,Greenfoot.getRandomNumber(100));
                alt = true;
            }
            i++;
        }
    }    
}