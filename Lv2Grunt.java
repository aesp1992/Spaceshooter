import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The second teir of enemy, has a faster attack, faster movement and more aggressive attack patern. 
 * 
 * @author (George Langroudi) 
 * @version (07/02/2017)
 */
public class Lv2Grunt extends Grunt
{
    /**
     * Act - do whatever the Lv2Grunt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int spaceshipY = 0;
    int spaceshipX = 0;

    public void act() 
    {
        try {
            spaceshipX = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getX(); //gets Xcoordinate
            spaceshipY = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getY(); //gets Ycoordinate
        } catch(Exception e) {
            //do nothing
        }

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
            attack(125);
            checkCounter(600);
            checkDestroy();
        }
        if(state == 4) {
            if(counter == 0) {
                turnTowards(spaceshipX, spaceshipY);
            }
            move(3);
            counter++;
            if(counter % 10 == 0) {
                /*
                if (!getWorld().getObjects(Spaceship.class).isEmpty()) {
                setLocation(spaceshipX, spaceshipY + movement);
                } */

                if(counter >= 8000)
                    counter = 1;
            }
            checkDestroy();
        }

    }  
    public void attack(int rate) { //Gives the ship it's random attack chances. Lower is faster
        if(Greenfoot.getRandomNumber(rate) == 1) {
            GruntFire Shot = new GruntFire(5, 10, 2, 180);
            getWorld().addObject(Shot, getX(), getY());
        }
    }
}
