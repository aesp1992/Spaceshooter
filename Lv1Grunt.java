import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The basic grunt of the game, has a slow attack speed, slow movement speed and isn't actively aggressive.
 * 
 * @author (George Langroudi) 
 * @version (07/02/2017)
 */
public class Lv1Grunt extends Grunt
{
    /**
     * Act - do whatever the Lv1Grunt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act() 
    {
        World myWorld = getWorld();
        Levels levels = (Levels)myWorld;
        dSetting setting = levels.getDifficulty();
        if(state == 0) {
            enter(4, 180, 90);
        }
        if(state == 1) {
            flourish(3, 30, 3);
        }
        if(state == 2) {
            flourish(2, 90, 3);
        }
        if(state == 3) {
            slide(5, 1); 
            attack(150);
            checkCounter(600);
            checkDestroy();
        }
        if(state == 4) {
            /*
            if(counter == 0) {
            movement = Greenfoot.getRandomNumber(2) - 1;
            if(movement == 0) {
            movement = Greenfoot.getRandomNumber(2) + 1;
            }
            } */
            setDirection(650);
            move(3);
            checkDestroy();
        }

    }

    public void startFlourish(int speed){ //Animates the ships small enterance flourish
        move(speed);
        turn(2);
        counter++;
        if(counter >= 45) {
            counter = 0;
            state = 2;
        }
    }
}
