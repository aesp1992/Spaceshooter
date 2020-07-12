import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The missiles that the enemies shoot out. 
 * 
 * @author (George Langroudi) 
 */
public class EnemyRocket extends Grunt
{
    int randMovement = 0;
    int randDuration = 0;
    int counter = 0;
    int randDurationMath = 40;
    int randMovementMath = 5;
    public void act() 
    {
        if(counter <= randDuration) {
            setLocation(getX(), getY() + randMovement);
        }
        if(counter <= 25) {
            setLocation(getX() - 2, getY());
        }
        if(counter > 25) {
            turn(Greenfoot.getRandomNumber(3) - 1);
            move(10);
        }
        counter++;
        if(getX() <= -20) {
            getWorld().removeObject(this);
        }
    }    
    
    /**
     * @author George Langroudi
     * Initialises the class
     * Parameters
     * 
     * int newMovementMath      The range of the possible random number used for movement
     * int newDurationMath      The range of the possible distance a rocket will move up or down
     *                          before shooting forward
     */
    public EnemyRocket(int newDurationMath, int newMovementMath) {
        randMovementMath = newMovementMath;
        randDurationMath = newDurationMath;
    }

    /**
     * @author George Langroudi
     * When the Rocket is added to the world, generates the random numbers it will use
     * for it's movement. 
     */
    public void addedToWorld(World world) {
        randDuration = Greenfoot.getRandomNumber(randDurationMath);
        randMovement = Greenfoot.getRandomNumber(randMovementMath) - (randMovementMath / 2);
        setRotation(180);
        if(randDuration < 7)
            randDuration = 12;
        if(randMovement == 0)
            randMovement = Greenfoot.getRandomNumber(randMovementMath) - (randMovementMath / 2);
        if(randMovement == 0)
            randMovement = -1;
    }
}
