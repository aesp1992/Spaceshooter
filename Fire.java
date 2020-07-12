import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * 
 * @author (Adrian Espiritu, Felix Giillingham)
 * @editor (George Langroudi)
 * 
 */

public class Fire extends Spaceship
{
    int speed = 8;
    public int damage = 1; 
    public int finalX = 1;
    public int finalY = 1;
    public int spaceshipX = 0;
    public int spaceshipY = 0;
    World myWorld = getWorld();

    public void act() 
    {
        enemyContact();
        try {
            finalX = getX();
            finalY = getY();

            spaceshipX = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getX(); //gets Xcoordinate
            spaceshipY = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getY(); //gets Ycoordinate

            if(this == null){
                finalX = 800;
                finalY = 450;
            }

        } catch (Exception E) {
            finalX = 0;
            finalY = 0;

            spaceshipX = 0;
            spaceshipY = 0;
        }

    }

    public Fire(int newSpeed, int newDamage, int newSprite, int newAngle) {
        speed = newSpeed;
        damage = newDamage;
        setRotation(newAngle);
        switch(newSprite) {
            case 1:
            setImage("images/fire_default.png");
            break;
            case 2:
            setImage("images/default_shotgun.png");
            if(getRotation() > 300) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(4) - 1);
            }
            if(getRotation() < 100) {
                setRotation(getRotation() + Greenfoot.getRandomNumber(4) - 6);
            }
            break;
            default:
            setImage("images/fire_default");
            break;
        }
    }

    /**
     * author (Felix Gillingham)
     * The chance that the ship will say something when an enemy is destroyed.
     */

    public void speechChance(){
        World myWorld = getWorld();
        int whichText = Greenfoot.getRandomNumber(12);
        while(whichText <= 1) 
            whichText = Greenfoot.getRandomNumber(12);
        Text testText = new Text(whichText);
        myWorld.addObject(testText, spaceshipX, spaceshipY);
    }

    /**
     * @author (Felix Gillingham)
     * This is the chance that an enemy will drop a power-up when they are destroyed.
     */
    public void powerUpChance(){

        Extrascore extrascore = new Extrascore();
        Extralife extralife = new Extralife();
        MaxHealth maxhealth = new MaxHealth();
        NewWeaponShotgun newWeaponShotgun = new NewWeaponShotgun();
        NewWeaponMissile newWeaponMissile = new NewWeaponMissile();
        NewDoubleShot newDoubleShot = new NewDoubleShot();
        Wingman newWingman = new Wingman();
        AuraShield newShield = new AuraShield();

        try {
            switch(Greenfoot.getRandomNumber(39)){
                case 0:  
                getWorld().addObject(extralife, finalX, finalY);
                break;
                case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8:
                case 9: case 10: case 11: case 12: case 13: case 14: case 15: case 16:
                getWorld().addObject(extrascore, finalX, finalY);
                break;
                case 17: case 18:
                getWorld().addObject(maxhealth, finalX, finalY);
                break;
                case 20: case 21: case 22: case 23: case 24:
                getWorld().addObject(newWeaponShotgun, finalX, finalY);
                break;
                case 25: case 26: case 27: case 28: case 29:
                getWorld().addObject(newDoubleShot, finalX, finalY);
                break;
                case 30: case 31: case 32:
                getWorld().addObject(newWingman, finalX, finalY);
                break;
                case 33:
                getWorld().addObject(newShield, finalX, finalY);
                break;
                case 34: case 35: case 36: case 37: case 38:
                getWorld().addObject(newWeaponMissile, finalX, finalY);
                break;
                default:
                getWorld().addObject(extrascore, finalX, finalY);
                break;
            }
        } catch (Exception E) {
            //do nothing
        }
    }

    /**
     * @author (Adrian Espiritu)
     * @editor (Felix Gillingham)
     * Added Level 3, 4 & 5 grunts so that they can be hit and destroyed by the spaceship's shots.
     * @editor (George Langroudi)
     */
    public void enemyContact() {
        move(speed);

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

        Actor extraLife = getOneIntersectingObject(Extralife.class);
        Actor extraScore = getOneIntersectingObject(Extrascore.class);
        Actor maxHealth = getOneIntersectingObject(MaxHealth.class); 
        Actor newWeaponShotgun = getOneIntersectingObject(NewWeaponShotgun.class);
        Actor newDoubleShot = getOneIntersectingObject(NewDoubleShot.class);

        World myWorld = getWorld();
        Explode explode = new Explode(1);
        Levels levels = (Levels)getWorld();
        ScoreBoard scoreboard = levels.getScore();
        dSetting dsetting = levels.getDifficulty();

        if (isAtEdge())
            myWorld.removeObject(this);

        if(grunt != null && grunt != enemyFire && grunt != enemyRocket)
        {

            if(grunt1 == grunt)
            {
                myWorld.removeObject(grunt1);
                Greenfoot.playSound("enemy_explode.wav");
                myWorld.addObject(explode, finalX, finalY);
                if(Greenfoot.getRandomNumber(10) == 0) 
                    powerUpChance();                                        
                if(Greenfoot.getRandomNumber(30) == 0)
                    speechChance(); 

                if (dsetting.difficulty == 1) {
                    scoreboard.addScore(5);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(10);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(20);
                }
            }

            if(grunt2 == grunt)
            {
                myWorld.addObject(explode, finalX, finalY);
                Greenfoot.playSound("enemy_explode.wav");
                if(Greenfoot.getRandomNumber(8) == 0) 
                    powerUpChance();
                if(Greenfoot.getRandomNumber(30) == 0)
                    speechChance(); 
                if (dsetting.difficulty == 1) {
                    scoreboard.addScore(10);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(20);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(40);
                }
                myWorld.removeObject(grunt2);
            }

            if(grunt3 == grunt)
            {
                myWorld.removeObject(grunt3);
                myWorld.addObject(explode, finalX, finalY);
                Greenfoot.playSound("enemy_explode.wav");
                if(Greenfoot.getRandomNumber(6) == 0) 
                    powerUpChance();
                if(Greenfoot.getRandomNumber(30) == 0)
                    speechChance(); 
                if (dsetting.difficulty == 1) {
                    scoreboard.addScore(15);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(30);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(60);
                }
            }

            if(grunt4 == grunt)
            {
                myWorld.addObject(explode, finalX, finalY);
                Greenfoot.playSound("enemy_explode.wav");
                if(Greenfoot.getRandomNumber(4) == 0) 
                    powerUpChance();

                if(Greenfoot.getRandomNumber(30) == 0)
                    speechChance(); 
                if (dsetting.difficulty == 1) {
                    scoreboard.addScore(20);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(40);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(80);
                }
                myWorld.removeObject(grunt4);
            }

            if(grunt5 == grunt)
            {
                // myWorld.addObject(explode, finalX, finalY);
                // if(Greenfoot.getRandomNumber(2) == 0) 
                // powerUpChance();
                // scoreboard.addScore(25);
                grunt5.takeDamage(damage);
            }

            if(bossTurret == grunt) {
                bossTurret.takeDamage(damage);
            }

            if(boss == grunt) {
                boss.takeDamage(damage);
            }

            if(enemyHealthbar != grunt) { //the more I use this, the less I get how it works
                myWorld.removeObject(this);
            }
        }
    }

    public void destroy() {
        myWorld.removeObject(this);
    }
}

