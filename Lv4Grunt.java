import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * The Level 3 Grunt enemies
 * 
 * @author (George Langroudi) 
 */
public class Lv4Grunt extends Grunt
{
    /**
     * Act - do whatever the Lv4Grunt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int moveCount;
    public void act() 
    {
        World myWorld = getWorld();
        Levels levels = (Levels)myWorld;
        dSetting setting = levels.getDifficulty();
        if(state == 0) {
            enter(7, 90, 50);
        }
        if(state == 1) {
            flourish(4, 27, -10);
        }
        if(state == 2) {
            slide(1, 2);
            if(counter >= 100) {
                state++;
                moveCount++;
                counter = 0;
            }
        }
        if(state == 3) {
            slide(1, 1);
            setLocation(getX() - 2, getY());
            if(counter >= 7) {
                state++;
                counter = 0;
            }
        }
        if(state == 4) {
            setLocation(getX() - 2, getY());
            counter++;
            if(counter >= 7) {
                state++;
                counter = 0;
            }
        }
        if(state == 5) {
            slide(1, -1);
            setLocation(getX() - 2, getY());
            if(counter >= 7) {
                state++;
                counter = 0;
            }
        }
        if(state == 6) {
            slide(1, -2);
            if(counter >= 100) {
                state++;
                moveCount++;
                counter = 0;
            }
        }
        if(state == 7) {
            slide(1, -1);
            setLocation(getX() - 2, getY());
            if(counter >= 7) {
                state++;
                counter = 0;
            }
        }
        if(state == 8) {
            setLocation(getX() - 2, getY());
            counter++;
            if(counter >= 7) {
                state++;
                counter = 0;
            }
        }
        if(state == 9) {
            slide(1, 1);
            setLocation(getX() - 2, getY());
            if(counter >= 7) {
                state = 2;
                counter = 0;
            }
            if(moveCount >= 8) {
                state = 10;
            }
        }
        if(state == 10) {
            targetShip();
            move(6);
        }
        if(state >= 2 && state <= 9) {
            targetShip();
            attack(80);
        }
        //rocketAttack(1);
    }  
    
    /**
     * @author George Langroudi
     * Gives the ship a chance of shooting a missile
     * parameters
     * 
     * int rate         The chance of shooting a missile, lower is faster.
     */
    public void rocketAttack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        if(Greenfoot.getRandomNumber(rate) == 0) {
            EnemyRocket Shot = new EnemyRocket(40, 3);
            getWorld().addObject(Shot, getX(), getY());
        }
    }
    
    /**
     * @author George Langroudi
     * Gives the ship a chance of shooting a shot
     * parameters
     * 
     * int rate         The chance of shooting a shot, lower is faster.
     */
    public void attack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        if(Greenfoot.getRandomNumber(rate) == 1) {
            GruntFire Shot = new GruntFire(8, 10, 4, getRotation());
            getWorld().addObject(Shot, getX(), getY());
        }
    }
}


