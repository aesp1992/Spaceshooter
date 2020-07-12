import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Adrian Espiritu, George Langroudi)
 */

public class Grunt extends SpaceActors
{
    int state = 0; //Controlls what actions the ship is currently performing. Must be controlled in the code.
    int counter = 0; //Counter can be used to time duration of actions.
    int movement = 0; //Can be used to control vertical movement, if this ship has a linear exit path.
    int spaceshipX = 0;
    int spaceshipY = 0;
    int health = 1;

    public void act() 
    {
    }

    /**
     * @author (George Langroudi)
     * Moves the ship forward as it enters
     * paramaters
     * 
     * @int speed       The speed the ship moves at as it enters
     * @int angle       The angle the ship enters at (180 is pointing directly to the left)
     * @int distance    The distance the ship moves during it's enterance
     */
    public void enter(int speed, int angle, int distance) { //Gives the ship it's burst of speed on enterance. 
        if(counter == 0) {
            turn(angle);
        }
        move(speed);
        counter++;
        if(counter >= distance) {
            counter = 0;
            state++;
        }
    }

    /**
     * @author (George Langroudi)
     * begins the ships rotating flourish animation
     * parameters
     * 
     * @int speed       The speed the ship moves as it flourishes
     * @int turnDist    The number of times it rotstes
     * @int turnAngle   The angle it rotates each time it rotates
     */
    public void flourish(int speed, int turnDist, int turnAngle){ //Animates the ships small enterance flourish
        move(speed);
        turn(turnAngle);
        counter++;
        if(counter >= turnDist) {
            counter = 0;
            state++;
        }
    }

    /**
     * @author (George Langroudi)
     * Moves the ship across the screen
     * parameters
     * 
     * int speed        The speed the spaceship moves as it slides (Lower is faster, 5 default)
     * int direction    Controls if the ship moves up or down and the speed (1 is up, -1 is down)
     */
    public void slide(int speed, int direction) { //Animates the ships small movements once it's done animating. Lower is faster.
        if(counter % speed == 0)
            setLocation(getX(), getY() - direction);
        counter++;
    }

    /**
     * @author (George Langroudi)
     * Gives the ship a random chance to shoot
     * parameters
     * 
     * int rate         The chance of the ship attacking (Lower is higher, default 75)
     */
    public void attack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        World myWorld = getWorld();
        Levels levels = (Levels)myWorld;
        dSetting setting = levels.getDifficulty();
        if (setting.difficulty == 1) {
            rate /= 4;
            rate *= 5;
        }
        if (setting.difficulty == 3) {
            rate /= 4;
            rate *= 3;
        }
        if(Greenfoot.getRandomNumber(rate) == 1) {
            GruntFire Shot = new GruntFire(2, 10, 1, 180);
            getWorld().addObject(Shot, getX(), getY());
        }
    }

    /**
     * @author (George Langroudi)
     * Lets grunts check if they should move to the next state based on a parameter
     * parameter
     * 
     * @value           The amount of ticks before the ship will change to it's next state
     */
    public void checkCounter(int value) {
        if(counter >= value) {
            counter = 0;
            state++;
        }
    }

    /**
     * @author (Adrian Espiritu)
     * checks if the ship is at the edge of the world, and destroys it if it is.
     */
    public void checkDestroy() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }

    /**
     * @author (George Langroudi)
     * Sets the ship on a path towards the left of the screen at a random height
     * parameters
     * 
     * @range           The range of heights the ship could possibly go to
     */
    public void setDirection(int range) {
        if(counter == 0) {
            turnTowards(0, getY() + (Greenfoot.getRandomNumber(range) - Greenfoot.getRandomNumber(range)));
        }
        counter++;
    }

    /**
     * @author (George Langroudi, Adrian Espiritu)
     * Points the ship towards the player
     */
    public void targetShip() {
        try {
            spaceshipX = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getX(); //gets Xcoordinate
            spaceshipY = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getY(); //gets Ycoordinate
        } catch(Exception e) {
            //do nothing
        }
        turnTowards(spaceshipX, spaceshipY);        
    }
}
