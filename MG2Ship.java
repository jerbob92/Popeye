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
    int start_y = 625;
    
    public MG2Ship(World world, MG2Train train) {
        this.train = train;
        this.containers = new MG2Container[4][5];
        
        for(int i= 0; i < 4; i++){
           for(int i2=0; i2 < 5; i2++){
               
              if (i2 >= 3) {
                  this.containers[i][i2] = null;
              } else {
                  MG2Container container = new MG2Container(false, null, (MiniGame2World)world);
                  this.containers[i][i2] = container;
                  
                  world.addObject(container,  this.start_x + (i*100), this.start_y - (i2*66));   
              }
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
    
    public MG2Container getRandomContainer() {
        MG2Container[] allContainers = new MG2Container[100];
        int currentIndex = 0;
        
        for(int i=0; i < this.containers.length; i++){
           for(int i2=0; i2 < this.containers[i].length; i2++){
              if (this.containers[i][i2] != null) {
                allContainers[currentIndex] = this.containers[i][i2];  
                currentIndex++;
              }
           }   
        }
        
        if (currentIndex > 0) {
            int randomIndex = Greenfoot.getRandomNumber(currentIndex);
            return allContainers[randomIndex];
        }

        return null;
    }
    
    public void removeContainer(MG2Container container) {
         for(int i=0; i < this.containers.length; i++){
           for(int i2=0; i2 < this.containers[i].length; i2++){
              if (this.containers[i][i2] != null && container == this.containers[i][i2]) {
                  this.containers[i][i2] = null;
                  break;
              }
           }   
        }
    }
    
    public boolean spaceAtRow(int i) {
        int containersInRow = 0;
        for(int i2=0; i2 < this.containers[i].length; i2++){
              if (this.containers[i][i2] != null) {
                  containersInRow++;
              }
        }  
        
        if (containersInRow == 5) {
            return false;
        }
        
        return true;
    }
    
    public void addContainer(int i, MG2Container container) {
        int containersInRow = 0;
        for(int i2=0; i2 < this.containers[i].length; i2++){
              if (this.containers[i][i2] != null) {
                  containersInRow++;
              }
        }  
       
        this.containers[i][containersInRow] = container;
        container.setLocation(this.start_x + (i*100), this.start_y - (containersInRow*66));
    }
}
