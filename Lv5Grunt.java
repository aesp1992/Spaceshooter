import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Level 5 Grunt enemies
 * 
 * @author (George Langroudi) 
 */
public class Lv5Grunt extends Grunt
{
    /**
     * Act - do whatever the Lv5Grunt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int moveCount;
    int HP = 5;
    public int finalX = 0;
    public int finalY = 0;

    EnemyHealthbar gruntHealth = new EnemyHealthbar(HP, 30, 30, (Actor) this, true, false);
        
    
    public void act() 
    {
        switch(state) {
            case 0:
            enter(7, 0, 30);
            break;
            case 1:
            flourish(4, 15, -6);
            break;
            case 2:
            flourish(4, 30, 6);
            break;
            case 3:
            if(counter % 2 == 0)
                rocketBurst(1);
            if(counter >= 10) {
                state++; counter = 0;
            }
            counter++;
            break;
            case 4:
            flourish(4, 30, 6);
            break;
            case 5:
            flourish(4, 30, -6);
            break;
            case 6:
            if(counter % 2 == 0)
                rocketBurst(1);
            if(counter >= 10) {
                state++; counter = 0;
            }
            counter++;
            break;
            case 7:
            flourish(4, 15, -6);
            break;
            case 8:
            state = 1;
            break;
        }

        World myWorld = getWorld();
        Explode explode = new Explode(1);
        if(gruntHealth.isDestroyed()) {
            myWorld.addObject(explode, finalX, finalY);
            getWorld().removeObject(gruntHealth);
            getWorld().addObject(new Explode(2), getX(), getY());
            if(Greenfoot.getRandomNumber(2) == 0) 
                powerupChance();
             
           Levels levels = (Levels)myWorld;
           ScoreBoard scoreboard = levels.getScore();
           dSetting dsetting = levels.getDifficulty();
           
           if (dsetting.difficulty == 1) {
                    scoreboard.addScore(25);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(50);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(100);
                }  
           Greenfoot.playSound("enemy_explode.wav");          
           getWorld().removeObject(this);
        }
    }

    /**
     * @author (Felix Gillingham)
     */
    public void powerupChance(){

        World myWorld = getWorld();
        Extrascore extrascore = new Extrascore();
        Extralife extralife = new Extralife();
        MaxHealth maxhealth = new MaxHealth();
        NewWeaponShotgun newWeaponShotgun = new NewWeaponShotgun();
        NewWeaponMissile newWeaponMissile = new NewWeaponMissile();
        NewDoubleShot newDoubleShot = new NewDoubleShot();
        Wingman newWingman = new Wingman();
        AuraShield newShield = new AuraShield();

        switch(Greenfoot.getRandomNumber(37)){
            case 0:  
            myWorld.addObject(extralife, getX(), getY());
            break;
            case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8:
            case 9: case 10: case 11: case 12: case 13: case 14: case 15: case 16:
            myWorld.addObject(extrascore, getX(), getY());
            break;
            case 17: case 18:
            myWorld.addObject(maxhealth, getX(), getY());
            break;
            case 20: case 21: case 22: case 23: case 24:
            myWorld.addObject(newWeaponShotgun, getX(), getY());
            break;
            case 25: case 26: case 27: case 28: case 29:
            myWorld.addObject(newDoubleShot, getX(), getY());
            break;
            case 30:
            myWorld.addObject(newWingman, getX(), getY());
            break;
            case 31:
            myWorld.addObject(newShield, getX(), getY());
            break;
            case 32: case 33: case 34: case 35: case 36:
            myWorld.addObject(newWeaponMissile, getX(), getY());
            break;
            default:
            myWorld.addObject(extrascore, getX(), getY());
            break;
        }
    }

    public void addedToWorld(World world) {
        turn(90);
        getWorld().addObject(gruntHealth, getX(), getY());
    }

    public void takeDamage(int takeDamage) {
        gruntHealth.loseHealth(takeDamage);
    }

    public void rocketAttack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        if(Greenfoot.getRandomNumber(rate) == 0) {
            EnemyRocket Shot = new EnemyRocket(40, 3);
            getWorld().addObject(Shot, getX(), getY());
        }
    }

    public void rocketBurst(int rate) { //shoots x amount of rockets
        for(int x = 0; x <= rate; x++) {
            EnemyRocket Shot = new EnemyRocket(40, 3);
            getWorld().addObject(Shot, getX(), getY());
        }
    }

    public void attack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        if(Greenfoot.getRandomNumber(rate) == 1) {
            GruntFire Shot = new GruntFire(8, 10, 4, getRotation());
            getWorld().addObject(Shot, getX(), getY());
        }
    }
}

