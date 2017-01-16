import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MG2Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG2Ship extends Actor
{

    private MG2Container[][] containers;
    private int startX = 310;
    private int startY = 625;

    public MG2Ship(World world) {
        this.containers = new MG2Container[4][5];

        for(int i= 0; i < 4; i++){
            for(int i2=0; i2 < 5; i2++){

                if (i2 >= 3) {
                    this.containers[i][i2] = null;
                } else {
                    MG2Container container = new MG2Container(false, null, (MiniGame2World)world);
                    this.containers[i][i2] = container;

                    world.addObject(container,  this.startX + (i*100), this.startY - (i2*66));   
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

    public int getStartX() {
        return this.startX;
    }

    public int getStartY() {
        return this.startY;
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

        ((MiniGame2World)getWorld()).getArrow().setBalance(this.calculateBalance()); 
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
        container.setLocation(this.startX + (i*100), this.startY - (containersInRow*66));
        ((MiniGame2World)getWorld()).getArrow().setBalance(this.calculateBalance()); 
    }

    public int calculateBalance() {
        int balance = 0;
        for(int i=0; i < this.containers.length; i++){
            balance += getRowBalance(i);
        }

        return balance;
    }

    public int getRowBalance(int i) {
        int balance = 0;
        for(int i2=0; i2 < this.containers[i].length; i2++){
            if (this.containers[i][i2] != null) {
                switch (i) {
                    case 0: 
                    balance -= 20;
                    break;
                    case 1: 
                    balance -= 12;
                    break;
                    case 2: 
                    balance += 12;
                    break;
                    case 3: 
                    balance += 20;
                    break;
                    default:
                    // This should never happen. We only have 4 rows.
                    break;
                }
            }          
        }

        return balance;
    }

    public boolean isLastContainerInColumn(MG2Container container) {
        for(int i=0; i < this.containers.length; i++){
            boolean foundContainer = false;
            int myIndex = 0;
            int lastIndex = 0;
            for(int i2=0; i2 < this.containers[i].length; i2++){
                if (this.containers[i][i2] == container) {
                    foundContainer = true;
                    myIndex = i2;
                }

                if (this.containers[i][i2] != null) {
                    lastIndex = i2;
                }
            }

            if(foundContainer && myIndex == lastIndex) {
                return true;    
            }
        }

        return false;
    }
}
