import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Level 3 Grunt enemies
 * 
 * @author (George Langroudi) 
 */
public class Lv3Grunt extends Grunt
{
    /**
     * Act - do whatever the Lv3Grunt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(state == 0) {
            enter(4, 135, 30); //third value's default was 12
        }
        if(state == 1) {
            flourish(3, 45, -3);
        }
        if(state == 2) {
            flourish(2, 60, -3);
        }
        if(state == 3) {
            slide(-5, -1); 
            attack(250);
            checkCounter(600);
            checkDestroy();
        }
        if(state == 4) {           
            targetShip();
            move(8);
            checkDestroy();
            if(counter <= 800) {
                move(3);
            }
            if(counter > 800 && counter <= 1600) {
                move(6);
            }
            if(counter > 1600) {
                move(9);
            }
        }
    }    

    /**
     * Gives the ship it's random attack chances. Lower is faster
     * parameters
     * 
     * int rate             The chance the ship has of attacking. Lower is faster
     */
    public void attack(int rate) { 
        if(Greenfoot.getRandomNumber(rate) == 1) {
            GruntFire Shot = new GruntFire(5, 15, 3, 180);
            getWorld().addObject(Shot, getX(), getY());
        }
    }
}

