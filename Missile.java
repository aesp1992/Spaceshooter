import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (George Langroudi) 
 * @editor (Felix Gillingham)
 * Added the hitEnemy method and set the damage to two.
 * @version (09/03/2017)
 */
public class Missile extends Spaceship
{
    int randMovement = 0;
    int randDuration = 0;
    int counter = 0;
    int randDurationMath = 40;
    int randMovementMath = 5;
    public int damage = 2; 
    public int finalX = 0;
    public int finalY = 0;

    boolean destroyed = false;
    /**
     * @author (George Langroudi) 
     */
    public void act() 
    {
        if(counter <= randDuration) {
            setLocation(getX(), getY() + randMovement);
        }
        if(counter <= 25) {
            setLocation(getX() + 2, getY());
        }
        if(counter > 25) {
            turn(Greenfoot.getRandomNumber(3) - 1);
            move(10);
        }
        try {
            finalX = getX();
            finalY = getY();
        } catch (Exception E) {
            //do nothing
        }
        hitEnemy();
        counter++;
        if(!destroyed) {
            if(getX() > getWorld().getWidth() + 20 && counter > 20) {
                destroyed = true;
                getWorld().removeObject(this);
            }
        }
    }    

    /**
     * @author (George Langroudi) 
     */
    public Missile(int newDurationMath, int newMovementMath) {
        randMovementMath = newMovementMath;
        randDurationMath = newDurationMath;
    }

    /**
     * @author (George Langroudi) 
     */
    public void addedToWorld(World world) {
        randDuration = Greenfoot.getRandomNumber(randDurationMath);
        randMovement = Greenfoot.getRandomNumber(randMovementMath) - (randMovementMath / 2);
        setRotation(0);
        if(randDuration < 7)
            randDuration = 12;
        if(randMovement == 0)
            randMovement = Greenfoot.getRandomNumber(randMovementMath) - (randMovementMath / 2);
        if(randMovement == 0)
            randMovement = -1;
    } 

    /**
     * @author (Felix Gillingham)
     * 
     * This class checks if the missile is touching an enemy and will deal damage.
     */

    public void hitEnemy(){
        Actor grunt = getOneIntersectingObject(Grunt.class);
        Actor grunt1 = getOneIntersectingObject(Lv1Grunt.class);
        Actor grunt2 = getOneIntersectingObject(Lv2Grunt.class);
        Actor grunt3 = getOneIntersectingObject(Lv3Grunt.class);
        Actor grunt4 = getOneIntersectingObject(Lv4Grunt.class);
        Lv5Grunt grunt5 = (Lv5Grunt) getOneIntersectingObject(Lv5Grunt.class);
        Actor enemyFire = getOneIntersectingObject(GruntFire.class);
        Actor enemyRocket = getOneIntersectingObject(EnemyRocket.class);
        Actor enemyHealthbar = getOneIntersectingObject(EnemyHealthbar.class);

        FinalBoss boss = (FinalBoss) getOneIntersectingObject(FinalBoss.class);
        BossTurret bossTurret = (BossTurret) getOneIntersectingObject(BossTurret.class);

        World myWorld = getWorld();
        Explode explode = new Explode(1);
        Levels levels = (Levels)getWorld();
        ScoreBoard scoreboard = levels.getScore();

        if(grunt != null && grunt != enemyFire && grunt != enemyRocket)
        {
            destroyed = true;
            if(grunt1 == grunt)
            {
                myWorld.removeObject(grunt1);
                Greenfoot.playSound("enemy_explode.wav");
                myWorld.addObject(explode, finalX, finalY);
                scoreboard.addScore(5);
            }

            if(grunt2 == grunt)
            {
                Greenfoot.playSound("enemy_explode.wav");
                myWorld.addObject(explode, finalX, finalY);
                scoreboard.addScore(10);
                myWorld.removeObject(grunt2);
            }

            if(grunt3 == grunt)
            {
                Greenfoot.playSound("enemy_explode.wav");
                myWorld.removeObject(grunt3);
                myWorld.addObject(explode, finalX, finalY);
                scoreboard.addScore(15);
            }

            if(grunt4 == grunt)
            {
                Greenfoot.playSound("enemy_explode.wav");
                myWorld.addObject(explode, finalX, finalY);
                scoreboard.addScore(20);
                myWorld.removeObject(grunt4);
            }

            if(grunt5 == grunt)
            {
                // myWorld.addObject(explode, finalX, finalY);
                // scoreboard.addScore(25);
                grunt5.takeDamage(damage);
            }

            if(bossTurret == grunt) {
                bossTurret.takeDamage(damage);
            }

            if(boss == grunt) {
                boss.takeDamage(damage);
            }

            if(enemyHealthbar != grunt) { //the more I use this, the less I get how it works :)
                myWorld.removeObject(this);
            }
        }
    }

    /**
     * @author (George Langroudi) 
     */

    public void destroy() {
        myWorld.removeObject(this);
    }
}
