import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class lBoard extends Buttons
{
    /**
     * Creates the Leaderboard Button that you see in the start screen.
     *
     * @author (Adrian Espiritu) 
     */

    public lBoard() {
       
        setImage("leaderboard_ss.png"); 
        
    }

    public void act() 
    {
       
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/leaderboard_s.png");
        else
            setImage("images/leaderboard_ss.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new LeaderBoard());
        }

    }       

}
