import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MG3Firebig2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MG3Firebig2 extends MG3Fire
{
    public MG3Firebig2() {
        super(2000);   
    }

    public void gethit()
    // groene balk loopt op bij hit!
    {
        List<MG3Waterbeam> mg3waterbeam;
        mg3waterbeam = (List<MG3Waterbeam>)getObjectsInRange(15, MG3Waterbeam.class);

        // iterate via "for loop"
        for (int i = 0; i < mg3waterbeam.size(); i++) {
            this.hitbar.getHit();

        }    
    }

    public void recreate(MiniGame3World world) {
        world.Firebig2();
    }
}

