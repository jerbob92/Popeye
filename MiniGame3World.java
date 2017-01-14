import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Write a description of class MiniGame3World here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniGame3World extends World
{
    MG3Fireobjects[] myObjectList = new MG3Fireobjects[19];
    public MG3Lives lives;       
    
    /**
     * Constructor for objects of class MiniGame3World.
     * 
     */
    public MiniGame3World()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();
        Firesmall();
        Firesmall();
        Firesmall2();
        Firesmall2();
        Firebig1();
        Firebig2();
        
    }
    private void prepare()
    {
       //add Timer
       MG3Timer mg3timer = new MG3Timer();
       addObject(mg3timer,1230,180);
        
       //add Timeleft
       MG3Timertxt mg3timertxt = new MG3Timertxt();
       addObject(mg3timertxt, 1170, 180);
       
        //add fireboat
        MG3Fireboat mg3fireboat = new MG3Fireboat();
        addObject(mg3fireboat, mg3fireboat.start_x, mg3fireboat.start_y);
        
        //add Quay buttom
        MG3Quaybuttom mg3quaybuttom = new MG3Quaybuttom();
        addObject (mg3quaybuttom, 639, 800);
        
        
        //add Quay top
        MG3Quaytop mg3quaytop = new MG3Quaytop();
        addObject(mg3quaytop, 639, 1);
        
        //add Crane
        MG3Crane mg3crane1 = new MG3Crane();
        MG3Crane mg3crane2 = new MG3Crane();
        MG3Crane mg3crane3 = new MG3Crane();
        addObject(mg3crane1,100,589);
        addObject(mg3crane2,300,589); 
        addObject(mg3crane3,500,589);
        myObjectList[0]= mg3crane1;
        myObjectList[1]= mg3crane2;
        myObjectList[2]= mg3crane3;
        
        
        //add silo
        MG3Silo mg3silo1 = new MG3Silo();
        MG3Silo mg3silo2 = new MG3Silo();
        MG3Silo mg3silo3 = new MG3Silo();
        MG3Silo mg3silo4 = new MG3Silo();
        MG3Silo mg3silo5 = new MG3Silo();
        MG3Silo mg3silo6 = new MG3Silo();
        addObject(mg3silo1,650,620);
        addObject(mg3silo2,750,650);
        addObject(mg3silo3,850,620);
        addObject(mg3silo4,950,650);
        addObject(mg3silo5,1050,620);
        addObject(mg3silo6,1150,650);
        myObjectList[3]= mg3silo1;
        myObjectList[4]= mg3silo2;
        myObjectList[5]= mg3silo3;
        myObjectList[6]= mg3silo4;
        myObjectList[7]= mg3silo5;
        myObjectList[8]= mg3silo6;
                
        //add buildings
        MG3Building1 mg3building1 = new MG3Building1();
        addObject(mg3building1,300,75);
        myObjectList[9]= mg3building1;
        MG3Building2 mg3building2 = new MG3Building2();
        addObject(mg3building2,100,75);
        myObjectList[10]= mg3building2;
        MG3Building3 mg3building3 = new MG3Building3();
        addObject(mg3building3,1000,75);
        myObjectList[11]= mg3building3;
        MG3Building4 mg3building4 = new MG3Building4();
        addObject(mg3building4,700,75);
        myObjectList[12]= mg3building4;
        MG3Building5 mg3building5 = new MG3Building5();
        addObject(mg3building5,1150,75);
        myObjectList[13]= mg3building5;
        MG3Building2 mg3building6 = new MG3Building2();
        addObject(mg3building6,550,75);
        myObjectList[14]= mg3building6;
        MG3Building1 mg3building7 = new MG3Building1();
        addObject(mg3building7,850,75);
        myObjectList[15]= mg3building7;
        
        //add Ships
        MG3Containership mg3containership1 = new MG3Containership();
        addObject(mg3containership1,100,550);
        myObjectList[16]= mg3containership1;
        MG3Containership mg3containership2 = new MG3Containership();
        addObject(mg3containership2,450,550);
        myObjectList[17]= mg3containership2;
        
        //add Fire
        MG3Firesmall[] mg3firesmall = new MG3Firesmall[2];
        
        //add Yachtquay
        MG3Yachtquay mg3yachtquay = new MG3Yachtquay();
        addObject(mg3yachtquay,1250,515);
        
        //add yacht
        MG3yacht mg3yacht = new MG3yacht();
        addObject(mg3yacht, 1215,515);
        myObjectList[18]= mg3yacht;
        
        //Add Livesg
        this.lives = new MG3Lives();
        addObject(this.lives, 0,0);
        this.lives.setupLives();
        
                                 
        this.setPaintOrder(MG3Waterbeam2.class, MG3Waterbeam.class, MG3Timer.class, MG3Life.class, MG3Firesmall2.class, MG3Firesmall.class, MG3Firebig1.class, MG3Firebig2.class, MG3Healthbar.class, MG3Hitbar.class, MG3Crane.class, MG3Building.class, MG3Quay.class, MG3Schips.class);
        
        
       
        
    }
    
   public void Win() {
        int n = JOptionPane.showConfirmDialog(null, "You won! Do you want to go to Minigame 4?", "Winner!", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            Greenfoot.setWorld(new MiniGame3World());
        } else {
            Greenfoot.setWorld(new MainMenuWorld());
        }
    }
   public void gameOver() {
        int n = JOptionPane.showConfirmDialog(null, "Game over! Do you want to try again?", "Game Over!", JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            Greenfoot.setWorld(new MiniGame3World());
        } else {
            Greenfoot.setWorld(new MainMenuWorld());
        }
    }
       
    public void Firesmall() {
        
        //add Fire
        MG3Firesmall[] mg3firesmall = new MG3Firesmall[1];                
        for(int i=0; i<mg3firesmall.length;i++)
        {
            mg3firesmall[i] = new MG3Firesmall();
            int index2 = Greenfoot.getRandomNumber(19);
            int fireX = myObjectList[index2].getX();
            int fireY = myObjectList[index2].getY();
            addObject(mg3firesmall[i], fireX, fireY);
            mg3firesmall[i].addHealthbar();
            mg3firesmall[i].addHitbar();  
                        
        }
        
    }
   public void Firesmall2() {
       //add Firesmall 2
        MG3Firesmall2[] mg3firesmall2 = new MG3Firesmall2[1];
        
                      
        for(int i=0; i<mg3firesmall2.length;i++)
        {
            mg3firesmall2[i] = new MG3Firesmall2();
            int index2 = Greenfoot.getRandomNumber(19);
            int fireX = myObjectList[index2].getX();
            int fireY = myObjectList[index2].getY();
            addObject(mg3firesmall2[i], fireX, fireY);
            mg3firesmall2[i].addHealthbar();
            mg3firesmall2[i].addHitbar();  
        }
        
    }
    public void Firebig1() {
        
        //add Firebig 1
        MG3Firebig1[] mg3firebig1 = new MG3Firebig1[1];
        
                      
        for(int i=0; i<mg3firebig1.length;i++)
        {
            mg3firebig1[i] = new MG3Firebig1();
            int index = Greenfoot.getRandomNumber(19);
            int fireX = myObjectList[index].getX();
            int fireY = myObjectList[index].getY();
            addObject(mg3firebig1[i], fireX, fireY);
            mg3firebig1[i].addHealthbar();
            mg3firebig1[i].addHitbar();  
        }
        
    }
     public void Firebig2() {
        
        //add Firebig 1
        MG3Firebig2[] mg3firebig2 = new MG3Firebig2[1];
        
                      
        for(int i=0; i<mg3firebig2.length;i++)
        {
            mg3firebig2[i] = new MG3Firebig2();
            int index = Greenfoot.getRandomNumber(19);
            int fireX = myObjectList[index].getX();
            int fireY = myObjectList[index].getY();
            addObject(mg3firebig2[i], fireX, fireY);
            mg3firebig2[i].addHealthbar();
            mg3firebig2[i].addHitbar();  
        }
        
    }
}







