import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
import java.util.*;

/**
 * 
 * @author (Adrian Espiritu, George Langroudi, Aziz Khan, Felix Giillingham)
 */

public class Spaceship extends SpaceActors
{
    int cooldown = 0;
    int counter = 0;
    int speed = 5;

    int turretCounter = 0;
    int weapon = 0;
    int maxTurrets = 20;
    int turretMath;

    double angleShift = 360;

    boolean touchingEnemy = false;
    boolean touchingAsteroid = false;
    boolean gameToEnd = false;
    boolean flag = false;
    public boolean isShieldActive = false;
    String login = "";

    Turret turretArr[] = new Turret[maxTurrets];
    World myWorld = getWorld();
    Levels levels = (Levels)myWorld;
    Grunt targetGrunt = new Grunt();
    public void act() 
    {

        if(!gameToEnd){

            if (!getWorld().getObjects(Spaceship.class).isEmpty()) {
                collectPowerUps();
                timeOut();
                shieldActive();
            }

            moveoncommand();
            hitEnemy();             
        } else {
            if(moveToCenter() == true) {
                setImage("images/spaceship_boost.png");
                setLocation(getX() + speed, getY());
                if(counter % 7 == 0)
                    speed++;
            }
        }
        /**
         * Moves spaceship. Speed defined in ()
         */
        //move(3);

        /**
         * Basic movement W, A, S, D, Space
         */

        /**
         * Moves spaceship forward
         */
        //setLocation(getX() + 1, getY());

        /**
         * @author (Aziz Khan)
         */
        // getWorld().showText(login, 100, 100);
        // if(!flag && gameToEnd){
        // ((Space)getWorld()).gameOver();
        // login = Greenfoot.ask("Enter your name");
        // flag = true;
        // }        
        //addTurret(); //uncomment for 8 turrets
    }

    /**
     * author (George Langroudi)
     * Obtains the first grunt still in existance.
     * Returns the first grunt in the world
     */
    public Grunt getTarget() {
        if (!getWorld().getObjects(Grunt.class).isEmpty() && getWorld() != null)  
        {  
            targetGrunt = getWorld().getObjects(Grunt.class).get(0);  
        }
        return targetGrunt;
    }

    /**
     * author(Felix Gillingham)
     * This class resets the weapon back to the original when the timer runs out.
     */
    public void timeOut()
    {
        World myWorld = getWorld();
        Levels levels = (Levels)myWorld;
        Weapons powerUpTimer = levels.getPowerUpTimer();
        if(powerUpTimer.poweruptimer == 0)
        {
            weapon = 0;
        }
    }    

    /**
     * Move method
     * @author (Adrian Espiritu)
     */
    
    private void moveoncommand()
    {

        if(cooldown > 0) {
            cooldown -= 1;
        }

        if(Greenfoot.isKeyDown("W")) {
            if(getY() >= 18) {
                setLocation(getX(), getY() - speed);
            }
        }
        if(Greenfoot.isKeyDown("S")) {
            if(getY() <= 430) {
                setLocation(getX(), getY() + speed);
            }
        }
        if(Greenfoot.isKeyDown("A")) {
            if(getX() >= 12) {
                setLocation(getX() - speed, getY());
            }
        }
        if(Greenfoot.isKeyDown("D")) {
            if(getX() <= 790) {
                setLocation(getX() + speed, getY());
            }
        }

        if("space".equals(Greenfoot.getKey()) && (cooldown ==0)) {
            if (weapon == 0){
                fire();
                Greenfoot.playSound("shoot1.wav");
                cooldown = 10;             
            }
            if (weapon == 1){
                doubleFire();
                Greenfoot.playSound("shoot2.wav");
                cooldown = 10;
            }
            if (weapon == 2){
                shootShotgun();
                Greenfoot.playSound("shoot3.wav");
                cooldown = 50;
            }
            if( weapon == 3) {
                shootMissile();
                Greenfoot.playSound("shoot4.wav");
                cooldown = 8;
            }
        }
    }

    /**
     * Normal fire Effect. (cooldown 10)
     * @author (Adrian Espiritu)
     */

    private void fire()
    {
        Fire fire = new Fire(8, 1, 1, getRotation());
        getWorld().addObject(fire, getX() + 2, getY());
    }

    /**
     * Double fire Effect. (cooldown 15)
     * @author (Adrian Espiritu)
     */

    private void doubleFire()
    {
        Fire fire1 = new Fire(8, 1, 1, getRotation());
        getWorld().addObject(fire1, getX() + 2, getY() + 5);

        Fire fire2 = new Fire(8, 1, 1, getRotation());
        getWorld().addObject(fire2, getX() + 2, getY() - 5);
    }

    /**
     * Shoots a missile. (cooldown 8)
     * @author (Adrian Espiritu)
     */
    public void shootMissile() {
        Missile missile1 = new Missile(30, 7);
        getWorld().addObject(missile1, getX(), getY());
    }

    /**
     * Shotgun fire Effect. (cooldown 15)
     * @author (Adrian Espiritu)
     */

    public void shootShotgun() {
        Fire[] shotgun = new Fire[5];
        for (int i = 0; i < shotgun.length; i++)
            shotgun[i] = new Fire(15, 1, 2, getRotation());

        for (Fire shot : shotgun) {
            getWorld().addObject(shot, getX(), getY());
            shot.turn(Greenfoot.getRandomNumber(20) -10);      
        } 

        for (Fire shot : shotgun) {
            getWorld().addObject(shot, getX(), getY());
            shot.turn(Greenfoot.getRandomNumber(10) -5);      
        } 
    }

    /**
     * @author (Adrian Espiritu)
     * @editor (Felix Gillingham)
     * Added collision to the Lv3 Grunts, so they'll crash into the ship and do damage.
     * Same as the Lv1 & Lv2 ones. 
     * Made it so you get the Aura Shield after you lose a life to give a small moment of invinsibility
     * like in Sonic the Hedgehog.
     * @editor (Aziz Khan)
     * Added gameToEnd so as soon as gameOver, credits screen appears
     */

    public void hitEnemy()
    {

        Actor grunt = getOneIntersectingObject(Grunt.class);
        GruntFire enemyFire = (GruntFire) getOneIntersectingObject(GruntFire.class);
        Actor newAura = getOneIntersectingObject(AuraShield.class);
        EnemyRocket enemyRocket = (EnemyRocket) getOneIntersectingObject(EnemyRocket.class);

        Actor Lv1Enemy = getOneIntersectingObject(Lv1Grunt.class);
        Actor Lv2Enemy = getOneIntersectingObject(Lv2Grunt.class);
        Actor Lv3Enemy = getOneIntersectingObject(Lv3Grunt.class);
        Actor Lv4Enemy = getOneIntersectingObject(Lv4Grunt.class);

        Actor finalBoss = getOneIntersectingObject(FinalBoss.class);
        Actor bossTurret = getOneIntersectingObject(BossTurret.class);
        Actor bossShield = getOneIntersectingObject(Shield.class);
        Actor enemyHealth = getOneIntersectingObject(EnemyHealthbar.class);

        Aura target = new Aura(this);

        if(isShieldActive == true) {
            if(grunt != null) {
                World myWorld = getWorld();
                if (Lv3Enemy == grunt){                    
                    myWorld.removeObject(Lv3Enemy);
                }
                 if (Lv4Enemy == grunt){                    
                    myWorld.removeObject(Lv4Enemy);
                }
            }
        }

        if(isShieldActive == false) {
            if(grunt != null && grunt != finalBoss && grunt != bossTurret && grunt != bossShield && grunt != enemyHealth) {
                Explode explode = new Explode(1);

                World myWorld = getWorld();
                Levels levels = (Levels)myWorld;
                Healthbar healthbar = levels.getHealthBar();
                Lives lives = levels.getLives();

                myWorld.removeObject(grunt);
                myWorld.addObject(explode, getX(), getY());

                Greenfoot.playSound("hit.wav");

                //Hitting an enemy shot will do damage
                if(enemyFire == grunt) {
                    healthbar.loseHealth(enemyFire.getDamage());
                }
                //Hitting Enemy 1, 2 or an asteroid will do 10 damage
                if (Lv1Enemy == grunt || Lv2Enemy == grunt || Lv3Enemy == grunt) {
                    healthbar.loseHealth(10);
                    touchingEnemy = true;
                }

                if(enemyRocket == grunt) {
                    healthbar.loseHealth(5); 
                }

                //If healthbar reaches 0 but we still have lives left
                if(healthbar.health <=0 && lives.lives != 1) {
                    Greenfoot.playSound("aura.wav");
                    lives.loseLife();
                    healthbar.gainMaxHealth();
                    myWorld.addObject(target,getX()+2, getY());
                }

                //If healthbar reaches 0 and we don't have lives left
                if(healthbar.health <= 0 && lives.lives == 1) {

                    gameToEnd = true;
                    lives.loseLife();
                    GameOver gameOver = new GameOver();
                    myWorld.addObject(gameOver, myWorld.getWidth()/2, myWorld.getHeight()/2);

                    myWorld.removeObject(this);
                }
            } else {
                touchingEnemy = false;
            }
        }

    }

    /**
     * This allows the player to collect Power-Ups in the world.
     * 
     * @author(Felix Gillingham)
     */
    public void collectPowerUps(){
        Actor extraLife = getOneIntersectingObject(Extralife.class);
        Actor maxHealth = getOneIntersectingObject(MaxHealth.class); 
        Actor extraScore = getOneIntersectingObject(Extrascore.class);
        Actor newWeaponShotgun = getOneIntersectingObject(NewWeaponShotgun.class);
        Actor newDoubleShot = getOneIntersectingObject(NewDoubleShot.class);
        Actor newWingman = getOneIntersectingObject(Wingman.class);
        Actor newAura = getOneIntersectingObject(AuraShield.class);
        Actor newMissile = getOneIntersectingObject(NewWeaponMissile.class);

        World myWorld = getWorld();
        Levels levels = (Levels)myWorld;
        Healthbar healthbar = levels.getHealthBar();
        Lives lives = levels.getLives();
        ScoreBoard scoreboard = levels.getScore();
        Weapons powerUpTimer = levels.getPowerUpTimer();

        Aura target = new Aura(this);

        PickupText newItem = new PickupText("NULL");

        //Get an extra life if touching the Extralife icon.
        if (extraLife != null) {
            Greenfoot.playSound("lifeup.wav");
            lives.addLife();
            myWorld.removeObject(extraLife);
            newItem = new PickupText("+1 Life");
            getWorld().addObject(newItem, getX(), getY());
        }

        //Get all the player's health back if touching the MaxHealth icon.
        if (maxHealth != null) {
            Greenfoot.playSound("lifeup.wav");
            healthbar.heal();
            myWorld.removeObject(maxHealth);
            newItem = new PickupText("+30 HP");
            getWorld().addObject(newItem, getX(), getY());
        }

        //Get an extra 20 points if touching the extraScore icon.
        if (extraScore != null) {
            Greenfoot.playSound("score.wav");
            scoreboard.addScore(20);
            myWorld.removeObject(extraScore);
            newItem = new PickupText("+20 Points");
            getWorld().addObject(newItem, getX(), getY());
        }

        /**
         * added a part that should reset the poweruptimer to full when you collect the powerup.
         */
        if (newDoubleShot != null) {
            weapon = 1;
            Greenfoot.playSound("powerup.wav");
            powerUpTimer.gainMaxPower();
            myWorld.removeObject(newDoubleShot);
            newItem = new PickupText("PEW PEW!");
            getWorld().addObject(newItem, getX(), getY());
        }

        if (newWeaponShotgun != null) {
            weapon = 2;
            Greenfoot.playSound("powerup.wav");
            powerUpTimer.gainMaxPower();
            myWorld.removeObject(newWeaponShotgun);
            newItem = new PickupText("Shotgun!");
            getWorld().addObject(newItem, getX(), getY());
        }

        if(newWingman != null) {
            Greenfoot.playSound("powerup.wav");
            addTurret();
            myWorld.removeObject(newWingman);
            newItem = new PickupText("+1 Wingman");
            getWorld().addObject(newItem, getX(), getY());
        }

        if(newAura != null){
            Greenfoot.playSound("aura.wav");
            myWorld.addObject(target, getX()+2, getY());
            myWorld.removeObject(newAura);

            newItem = new PickupText("Invincibility!");
            getWorld().addObject(newItem, getX(), getY());

        }            

        if(newMissile != null) {
            weapon = 3;
            Greenfoot.playSound("powerup.wav");
            powerUpTimer.gainMaxPower();
            myWorld.removeObject(newMissile);
            newItem = new PickupText("Explosions!");
            getWorld().addObject(newItem, getX(), getY());
        }
    }

    /**
     * @author George Langroudi
     * Adds turrets to the spaceship
     */
    public void addTurret() {
        if(turretCounter <= maxTurrets - 1) {
            Turret turret = new Turret(50, 0.005, this);
            turretArr[turretCounter] = turret;
            getWorld().addObject(turret, getX() + 2, getY());
            organiseTurrets();
            turretCounter++;
        }
    }

    /**
     * @author George Langroudi
     * Goes through previously generated turrets and makes sure they are
     * all equally spaced. Organised higher numbers of turrets into concentric circles.
     */
    public void organiseTurrets() {
        angleShift = Math.PI * 2;
        turretMath = turretCounter;
        /*if(turretCounter > 0) {
        angleShift /= turretMath + 1;
        for(int y = 0 ; y <= turretCounter; y++) {
        turretArr[y].setAngle(angleShift * y);
        turretArr[y].setRadius(40 + (4 * turretCounter));
        }
        } */

        if(turretCounter > 0) {
            if(turretCounter <= 1) {
                angleShift /= turretMath + 1;
                for(int y = 0 ; y <= turretCounter; y++) {
                    turretArr[y].setAngle(angleShift * y);
                    turretArr[y].setRadius(40 + (4 * turretCounter));
                }
            } else {
                angleShift /= turretMath - 1;
                for(int y = 0 ; y <= turretCounter; y++) {
                    if(y <= 1) {
                        if(y == 1) {
                            turretArr[y].setAngle((Math.PI * 2) / 2);
                        } else {
                            turretArr[y].setAngle(Math.PI * 2);
                        }
                        turretArr[y].setRadius(30);
                    } else {
                        turretArr[y].setAngle(angleShift * y);
                        turretArr[y].setRadius(60);
                        turretArr[y].setRotation(-0.03);
                    }
                }
            }
        }
    }

    /**
     * @author George Langroudi
     * Calculates how far appart the turrets should be
     */
    public double checkRadius() {
        double angleShift = Math.PI * 2;
        if(turretCounter >= 0) {
            angleShift /= turretCounter;
        }
        return angleShift;
    }

    public void shieldActive() {
        if(getWorld().getObjects(Aura.class).size() != 0) {
            isShieldActive = true;
        } else {
            isShieldActive = false;
        }
    }

    /**
     * @author George Langroudi
     * Tells the ship that the level has ended.
     */
    public void endLevel() {
        gameToEnd = true;
    }

    /**
     * @author George Langroudi
     * Moves the spaceship towards the center of the screen.
     * 
     * Returns true if at center of the screen, false if anything else.
     */
    public boolean moveToCenter() {
        if(getY() != getWorld().getHeight() /2) {
            if(getY() > getWorld().getHeight() / 2) {
                if(getY() - getWorld().getHeight() <= 3) {
                    setLocation(getX(), getY() - 1);
                }
                setLocation(getX(), getY() - 3);
            }
            if(getY() < getWorld().getHeight() / 2) {
                if(getWorld().getHeight() - getY() <= 3) {
                    setLocation(getX(), getY() + 1);
                }
                setLocation(getX(), getY() + 3);
            }
            return false;
        }
        return true;
    }
}
