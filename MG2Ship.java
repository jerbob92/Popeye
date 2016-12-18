import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Ship extends Actor
{
    
    MG2Container[][] containers;
    MG2Train train;
    int start_x = 310;
    int start_y = 488;
    
    public MG2Ship(World world, MG2Train train) {
        this.train = train;
        this.containers = new MG2Container[5][4];
        
        for(int i=0; i < 4; i++){
           for(int i2=0; i2 < 3; i2++){
              MG2Container container = new MG2Container(false);
              this.containers[i][i2] = container;
              
              world.addObject(container, (i*100) + this.start_x, (i2*66) + this.start_y);
           }   
        }
    }
    
    /**
     * Act - do whatever the MG2Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
