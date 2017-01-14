import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MG3Firesmall2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Firesmall2 extends MG3Fire
{
    
    public MG3Firesmall2() {
        super(4000);   
    }
   
    public void gethit()
    // groene balk loopt op bij hit!
    {
        List<MG3Waterbeam2> mg3waterbeam2;
        mg3waterbeam2 = (List<MG3Waterbeam2>)getObjectsInRange(25, MG3Waterbeam2.class);
        
        // iterate via "for loop"
		for (int i = 0; i < mg3waterbeam2.size(); i++) {
			this.hitbar.getHit();
            
		}
    }
    
    public void recreate(MiniGame3World world) {
        world.Firesmall2();
    }
}

