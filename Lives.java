import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class starts us off with the amount of lives we have and when we lose one.
 * 
 * @author (Felix Gillingham) 
 * @version (05/02/2017)
 */
public class Lives extends Actor
{
    int lives = 3;
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); 

    
    public Lives()
    {
        createLives();
    }
    
    /**
     * Act - do whatever the Lives wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        createLives();
    }    

    public void createLives(){
        setImage(new GreenfootImage("Lives: " + lives, 20, Color.WHITE, TRANSPARENT));
    }

    /**
     * Decrease the amount of lives we have.
     * 
     * Felx Gillingham
     */
    public void loseLife(){
        lives--;
    }
    
    /**
     * Increase the amount of lives we have.
     * 
     * Felx Gillingham
     */
    public void addLife(){
        lives++;
    }
    
    /**
     * Set Lives to a specific value (Used for level switching)
     * 
     * @author (Adrian Espiritu)
     */
    public void setLives(int value){
        
        lives = value;
        
    }   
    
}
