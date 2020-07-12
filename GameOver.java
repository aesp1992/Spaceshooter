import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); 
    private int howLong = 0;
    
    public GameOver(){
        setImage(new GreenfootImage("GameOver!", 50, Color.YELLOW, TRANSPARENT));
     }
  
    public void act() 
    {
        howLong++;
        if(howLong > 20){
            World myWorld = getWorld();
            myWorld.removeObject(this);

            // load leader board
            LeaderBoard lb = new LeaderBoard();

    
            
            // get the currewnt score
            Levels l = (Levels)myWorld;
            ScoreBoard sb = l.getScore();
            int score = sb.getScore();            
            lb.addScore(score);
            lb.drawBoard();
            
            Greenfoot.setWorld(new LeaderBoard()); 
        }       
    }
}
