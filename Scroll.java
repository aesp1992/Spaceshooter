import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Adrian Espiritu) 
 */
public class Scroll extends Actor
{
    public void act() 
    {
        // Add your action code here.
    }

    /**
     * Default scroller for background. Moves 1 image from the left edge of the screen and back.
     * @author (Adrian Espiritu)
     */
    public void slideAcross(int speed)
    {
        //checks if X coordinate is negative
        if(getX() < -getImage().getWidth()/2) {

            //moves image from left edge to right edge of the world
            setLocation(getWorld().getWidth() + 399 - speed, getY()); 

        }
        setLocation(getX()-speed, getY());     
    }
}