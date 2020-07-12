import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Extralife here.
 * 
 * @author (Felix Gillingham) 
 * @version (17/02/2017)
 */
public class Extralife extends Powerups
{
    /**
     * This calls the method from the Powerups class, allowing the Extralife to move across the screen.
     * The smaller the number, the faster it moves.
     */
    public void act() 
    {
        moveObj(5);
    }    
}
