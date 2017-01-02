import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameState extends Actor
{
    boolean[] finished;
    int[] scores;
    
    public GameState () {
        this.finished = new boolean[4];
        this.scores = new int[4];
    }
    
    public void setFinished(int game, int score) {
        this.finished[game-1] = true;
        this.scores[game-1] = score;
    }
    
    public boolean getFinished(int game) {
        return this.finished[game-1];
    }
    
    public int getScore(int game) {
        return this.scores[game-1];
    }
    
    /**
     * Act - do whatever the GameState wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
