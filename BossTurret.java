import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The turrets that rotate around the Final Boss
 * 
 * @author (George Langroudi) 
 */
public class BossTurret extends Grunt
{
    int spaceshipX = 0;
    int spaceshipY = 0;
    int radius = 100;
    int x = 0;
    int y = 0;
    int attackRate = 800;

    boolean isDestroyed = false;

    double turretSpeed = 0.005;
    double angle = 45.0;

    EnemyHealthbar turretHealth = new EnemyHealthbar(10, 60, 45, this, true, false);
    Actor target = new Grunt();
    World myWorld = getWorld();
    Explode explode = new Explode(1);
    Fire enemyFire = new Fire(8, 1, 1, getRotation());
    public void act() 
    {
        x = spaceshipX + (int) (Math.cos(angle) * radius);
        y = spaceshipY + (int) (Math.sin(angle) * radius);
        setLocation(x, y);
        angle += turretSpeed;
        try {
            spaceshipX = ((FinalBoss) getWorld().getObjects(FinalBoss.class).get(0)).getX(); //gets Xcoordinate
            spaceshipY = ((FinalBoss) getWorld().getObjects(FinalBoss.class).get(0)).getY(); //gets Ycoordinate
        } catch(Exception e) {
            //do nothing
        }
        targetShip();
        attack(attackRate);
        if(turretHealth.isDestroyed()) {
            Greenfoot.playSound("enemy_explode_2.wav");
            
            World myWorld = getWorld();
            Levels levels = (Levels)myWorld;
            ScoreBoard scoreboard = levels.getScore();
            dSetting dsetting = levels.getDifficulty();
           
           if (dsetting.difficulty == 1) {
                    scoreboard.addScore(100);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(200);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(500);
                }  
            
            isDestroyed = true;              
            getWorld().removeObject(turretHealth);
            getWorld().addObject(explode, getX(), getY());
            getWorld().removeObject(this);
        }
    }    

    /**
     * Adds the healthbar to the world when the turret is added to the world
     */
    public void addedToWorld(World world) {
        getWorld().addObject(turretHealth, getX(), getY());
    }

    /**
     * Initialises the class
     * parameters
     * 
     * int health               The health the new turret will have
     * int newAttackRate        The speed the turret will shoot at
     * int newRadius            How far away the turret will be from it's target
     * double newAngle          The location around the target the turret will spawn at
     * double newSpeed          How fast the turret will rotate around it's target
     * Actor newTarget          The actor the turret belongs to and revolves around
     */
    public BossTurret(int health, int newAttackRate, int newRadius, double newAngle, double newSpeed, Actor newTarget) {
        radius = newRadius;
        angle = newAngle;
        turretSpeed = newSpeed;
        target = newTarget;
        turretHealth = new EnemyHealthbar(health, 60, 45, this, true, false);
        attackRate = newAttackRate;
    }

    public void setAngle(double newAngle) {
        angle = newAngle;
    }

    public void setSpeed(double newSpeed) {
        turretSpeed = newSpeed;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }

    /**
     * Gives the turret it's chance to shoot. This chance will be changed depending
     * on the difficulty. Higher difficulty makes shooting faster.
     * parameters
     * 
     * int rate             The chance of the turret shooting. Lower is faster.
     */
    public void attack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        World myWorld = getWorld();
        Levels levels = (Levels) myWorld;
        dSetting setting = levels.getDifficulty();
        if (setting.difficulty == 1) {
            rate /= 4;
            rate *= 5;
        }
        if (setting.difficulty == 3) {
            rate /= 4;
            rate *= 2;
        }
        if(Greenfoot.getRandomNumber(rate) == 1) {
            GruntFire Shot = new GruntFire(2, 10, 4, getRotation());
            getWorld().addObject(Shot, getX(), getY());
        }
    }

    public void takeDamage(int takeDamage) {
        turretHealth.loseHealth(takeDamage);
    }

    public int getHealth() {
        return turretHealth.getHealth();
    }

    public void destroy() {
        getWorld().removeObject(turretHealth);
        turretHealth = null;
        getWorld().removeObject(this);
    }
}
