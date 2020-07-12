import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Powerups extends Actor
{
    /**
     * This initialises the counter to 0
     */
    int counter = 0;

    public void act() 
    {

    }

    /**
     * This class allows the powerup
     */
    public void moveObj(int speed) {
        counter++;
        move(speed * -1);
    }

}
