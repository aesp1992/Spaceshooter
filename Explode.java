import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Adrian Espiritu, George Langroudi, Aziz Khan, Felix Giillingham)
 */

public class Explode extends SpaceActors
{
    private int counter = 0;
    private int animationVal = 0;
    private int speed = 1;
    /**
     * Act - do whatever the Explode wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        switch(animationVal) {
            case 0:
            setImage("images/explode_1.png");
            break;
            case 1:
            setImage("images/explode_2.png");
            break;
            case 2:
            setImage("images/explode_3.png");
            break;
            case 3:
            setImage("images/explode_4.png");
            break;
            case 4:
            setImage("images/explode_5.png");
            break;
            case 5:
            setImage("images/explode_6.png");
            break;
        }
        if(counter >= 6 * speed){
            getWorld().removeObject(this);
        }
        counter++;
        animationVal = counter / speed;
    }
    
    public Explode(int newSpeed) {
        speed = newSpeed;
    }
}