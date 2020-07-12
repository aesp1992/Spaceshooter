import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The final boss of the game, has multiple phases and a shield.
 * 
 * @author (George Langroudi) 
 */
public class FinalBoss extends Grunt
{
    int numbOfTurrets = 5;
    int turretCounter = 0;
    int turretMath = 0;
    int destroyedTurrets = 0;
    int turretStartSpeed = 40;
    int counter = 0;
    int turnCounter = 0;
    int Health = 15; //should be 150
    public int remainingTurrets = 5;

    //Turret specifications
    int turretMaxHealth = 10; //The healtbar dislikes certain health values, beware. Only multiples of 10
    int turretRadius = 100;
    int turretAttackRate = 50;
    double turretAngle = 45;
    double turretSpeed = 0.01;

    double angleShift = 0;
    Grunt test = new Lv4Grunt();
    Shield bossShield = new Shield(this);
    World myWorld = getWorld();
    BossTurret turretArr[] = new BossTurret[numbOfTurrets];
    EnemyHealthbar bossHealth = new EnemyHealthbar(health, 600, 1, (Actor) this, false, true);
    TransitionScreen deathScreen = new TransitionScreen(Color.WHITE, 2);

    BossGun BossGun1 = new BossGun(this, 0.7, 25);
    BossGun BossGun2 = new BossGun(this, -0.7, 25);

    Missile playerMissile = new Missile(1, 1);
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //setLocation(500, 250);
        //setRotation(180);

        switch(state){
            case 0: //First glide past
            move(10);
            if(counter >= 180) {
                state++; counter = 0;
                setLocation(80, -250);
                setRotation(60);
            }
            break;
            case 1: //second glide past
            move(10);
            if(counter >= 180) {
                state++; counter = 0;
                setLocation(1000, 250);
                setRotation(180);
            }
            break;
            case 2: //Boss actually enters
            move(4);
            if(counter >= 100) {
                state++; counter = 0;
            }
            break;
            case 3: //The ship begins to dodge upwards and downwards
            if(getY() <= 400) {
                setLocation(getX(), getY() + 3);
            } else {
                state++;
            }
            break;
            case 4:
            if(getY() >= 100) {
                setLocation(getX(), getY() - 3);
            } else {
                state--;
                if(counter >= 400) {
                    state = 5;
                    if(counter >= 1300) {
                        state = 7;
                        counter = 0;
                    }
                }
            }
            break;
            case 5:
            if(getY() <= 400) {
                setLocation(getX(), getY() + 2);
            } else {
                state++;
            }
            break;
            case 6:
            if(getY() >= 100) {
                setLocation(getX(), getY() - 2);
            } else {
                state--;
                if(counter >= 900) {
                    state = 3;
                }
            }
            break;
            case 7: //The ship dashes off again
            if(getRotation() >= 100) {
                turn(-1);
            }
            move(counter / 5);
            if(counter >= 120) {
                setRotation(310);
                setLocation(300, 500);
                counter = 0;
                state = 0;
            }
            break;
            case 8: //If the ship's shield is destroyed, the ship twists left and right
            turn(3);
            if(counter >= 10) {
                counter = 0;
                turnCounter++;
                state++;
            }
            if(turnCounter >= 6) {
                state = 10;
                counter = 0;
            }
            break;
            case 9:
            turn(-3);
            if(counter >= 20) {
                counter = 0;
                turnCounter++;
                state++;
            }
            if(turnCounter >= 6) {
                state = 10;
                counter = 0;
            }
            break;
            case 10:
            turn(3);
            if(counter >= 20) {
                counter = 0;
                turnCounter++;
                state--;
            }
            if(turnCounter >= 7) {
                state = 11;
                counter = 0;
            }
            break;
            case 11: //After the twisting animation completes, the boss flies off screen
            if(getRotation() >= 100) {
                turn(-1);
            }
            move(counter / 5);
            if(counter >= 100) {
                counter = 0;
                state++;
                bossHealth = new EnemyHealthbar(60, 600, 1, (Actor) this, false, true);
                getWorld().addObject(bossHealth, 395, 443);
                setLocation(850, 10);
            }
            break;
            case 12: //The boss begines phase 2, shoots rockets all over the screen.
            if(counter % 5 == 0 && counter >= 30) {             
                rocketBurst(0);
                setLocation(getX(), getY() + 10);
                if(counter % 20 == 0)
                    Greenfoot.playSound("shoot4.wav");
            }
            if(counter >= 250) {
                setLocation(850, 100);
                setRotation(180);
                counter = 0;
                state = 13;
            }
            break;
            case 13: //The boss moves back onto the screen.
            move(7);  
            if(counter > 20) {
                state++;
                counter = 0;
            }
            break;
            case 14:
            targetShip();
            if(counter >= 40) {
                counter = 0;
                state++;
            }
            break;
            case 15:
            if(counter <= 10) {
                attack(1);                
                if(counter == 1)
                    Greenfoot.playSound("boss_laser.wav");                    
            }
            if(counter > 10) {
                if(100 - getRotation() > 8) {
                    if(getRotation() > 100) {
                        turn(-8);
                    }
                } else {
                    setRotation(100);
                }
            }
            if(counter >= 24 && getRotation() == 100) {
                move(8);
                if(counter > 55) {
                    state++;
                    counter = 0;
                }
            }
            break;
            case 16:
            targetShip();
            if(counter >= 40) {
                counter = 0;
                state++;
            }
            break;
            case 17: 
            if(counter <= 10) {
                attack(1);                
                if(counter == 1)
                    Greenfoot.playSound("boss_laser.wav");                    
            }
            if(counter > 10) {
                if(getRotation() - 240 > 8) {
                    if(getRotation() < 240) {
                        turn(8);
                    }
                } else {
                    setRotation(240);
                }
            }
            if(counter >= 24 && getRotation() == 240) {
                move(8);
                if(counter > 55) {
                    state++;
                    counter = 0;
                }
            }
            break;
            case 18:
            targetShip();
            if(counter >= 40) {
                counter = 0;
                state++;
            }
            break;
            case 19:
            if(counter <= 10) {
                attack(1);                
                if(counter == 1)
                    Greenfoot.playSound("boss_laser.wav");                    
            }
            if(counter > 10) {
                if(100 - getRotation() > 8) {
                    if(getRotation() > 100) {
                        turn(-8);
                    }
                } else {
                    setRotation(100);
                }
            }
            if(counter >= 24 && getRotation() == 100) {
                move(8);
                if(counter > 55) {
                    state++;
                    counter = 0;
                }
            }
            break;
            case 20:
            targetShip();
            if(counter >= 40) {
                counter = 0;
                state++;
            }
            break;
            case 21: 
            if(counter <= 10) {
                attack(1);                
                if(counter == 1)
                    Greenfoot.playSound("boss_laser.wav");                    
            }
            if(counter > 10) {
                if(100 - getRotation() > 8) {
                    if(getRotation() > 0) {
                        turn(-8);
                    }
                } else {
                    setRotation(0);
                }
            }
            if(counter >= 24 && getRotation() == 0) {
                move(8);
                if(counter > 75) {
                    state = 12;
                    counter = 0;
                    setLocation(850, 10);
                    setRotation(180);
                }
            }
            break;
            case 22:
            turn(counter / 50);
            if(counter % (20 - (counter / 30)) == 0) {
                Greenfoot.playSound("enemy_explode.wav");
                getWorld().addObject(new Explode(4), getX() + (Greenfoot.getRandomNumber(50) - 25), getY() + (Greenfoot.getRandomNumber(50) - 25));
                //setRotation(Greenfoot.getRandomNumber(360));
                turn(counter / 4);
                if(counter >= 400) {
                    counter = 0;
                    state = 23;
                }
            }
            if((counter + 10) % (20 - (counter / 30)) == 0) {
                if(counter % 15 == 0)
                    Greenfoot.playSound("enemy_explode.wav");
                getWorld().addObject(new Explode(4), getX() + (Greenfoot.getRandomNumber(50) - 25), getY() + (Greenfoot.getRandomNumber(50) - 25));
            }
            break;
            case 23:
            if(counter == 1) {
                World myWorld = getWorld();
                Levels levels = (Levels)myWorld;
                ScoreBoard scoreboard = levels.getScore();
                dSetting dsetting = levels.getDifficulty();

                if (dsetting.difficulty == 1) {
                    scoreboard.addScore(500);
                }
                else if (dsetting.difficulty == 2) {
                    scoreboard.addScore(1000);
                }
                else if (dsetting.difficulty == 3) {
                    scoreboard.addScore(2000);
                }  

                deathScreen = new TransitionScreen(Color.WHITE, 3);
                getWorld().addObject(deathScreen, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                Greenfoot.playSound("boss_explode_last.wav");
            }
            if(deathScreen.isDecreasing()) {
                //GreenfootImage transparent = new GreenfootImage(0,0);
                setImage(new GreenfootImage(1,1));
                getWorld().removeObject(bossHealth);
                getWorld().removeObject(BossGun1);
                getWorld().removeObject(BossGun2);
                getWorld().removeObject(this);
            } else {
                turn(counter + 400 / 4);
                if(counter % 3 == 0) {
                    if(counter % 15 == 0)
                        Greenfoot.playSound("enemy_explode.wav");
                    getWorld().addObject(new Explode(4), getX() + (Greenfoot.getRandomNumber(50) - 25), getY() + (Greenfoot.getRandomNumber(50) - 25));
                }
            }
            break;
        } 

        //attack(5);
        if(state >= 8 && state <= 11) {
            if(counter <= 400) {
                if(counter % 15 == 0)
                    Greenfoot.playSound("enemy_explode.wav");
                if(counter %5 == 0) {
                    if(counter %5 == 0) {
                        if(counter % 15 == 0)
                            Greenfoot.playSound("enemy_explode.wav");
                        getWorld().addObject(new Explode(4), getX() + (Greenfoot.getRandomNumber(50) - 25), getY() + (Greenfoot.getRandomNumber(50) - 25));
                    }
                }
            }
        }
        // if(state >= 12) {
        // checkDamage();
        // }
        if(checkTurret() && state < 12) {
            getWorld().removeObject(bossShield);
        }
        if(state >= 1 && state <= 7 && remainingTurrets <= 0) {
            state = 8;
            turnCounter = 0;
            counter = 0;
        }
        if(bossHealth.getHealth() <= 0 && state <= 21 && state >= 12) {
            state = 22;
            counter = 0;
        }

        counter++;
    }

    /**
     * @author George Langroudi
     * Sets up the Boss for it's introduction, spawns it's shield and adds it's first turrets.
     */

    public void addedToWorld(World world) {
        for(int x = numbOfTurrets; x >= 1; x--){
            addTurret();
        }
        organiseTurrets();
        getWorld().addObject(bossShield, getX() + 2, getY());
        setRotation(310);
        setLocation(300, 500);
        playerMissile = null;
        getWorld().addObject(BossGun1, getX(), getY());
        getWorld().addObject(BossGun2, getX(), getY());
    } 

    /**
     * @author George Langroudi
     * Speeds up remaining turrets if there are fewer left, and returns a bool if there are no turrets left
     */
    public boolean checkTurret() { //speeds up turrets if less are left, and checks if there are any turrets remaining
        remainingTurrets = numbOfTurrets;
        for(BossTurret x : turretArr) {
            if(x.getHealth() <= 0) {
                remainingTurrets--;
            }
        }
        if(remainingTurrets < numbOfTurrets){
            for(int x = 0; x < numbOfTurrets; x++) {
                try {
                    turretArr[x].setSpeed(0.01);
                } catch (Exception e) {
                    //do nothing
                }
            }
        }
        if(remainingTurrets <= 0) {
            return true;
        }
        return false;
    } 

    /**
     * @author George Langroudi
     * Adds turrets to the spaceship
     */
    public void addTurret() {
        if(turretCounter <= numbOfTurrets) {
            BossTurret turret = new BossTurret(turretMaxHealth, turretAttackRate, turretRadius, turretAngle, turretSpeed, this);
            turretArr[turretCounter] = turret;
            getWorld().addObject(turret, getX() + 2, getY());
            organiseTurrets();
            turretCounter++;
        }
    }

    /**
     * @author George Langroudi
     * Goes through previously generated turrets and makes sure they are
     * all equally spaces
     */
    public void organiseTurrets() {
        angleShift = Math.PI * 2;
        turretMath = turretCounter;
        if(turretCounter > 0) {
            angleShift /= turretMath;
            for(int y = 0 ; y < turretCounter; y++) {
                turretArr[y].setAngle(angleShift * y);
                turretArr[y].setRadius(80 + (4 * turretCounter));
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

    //public void turretDies() {
    //    remainingTurrets--;
    //}

    // /**
    // * @author George Langroudi
    // * Checks if the boss has been hit by a missile, and loses 2HP if it has.
    // */
    // public void checkDamage() {
    // playerMissile = (Missile) getOneIntersectingObject(Missile.class);
    // if(playerMissile != null) {
    // bossHealth.loseHealth(2);
    // playerMissile.destroy();
    // playerMissile = null;
    // }
    // }

    /**
     * @author George Langroudi
     * Reduces the Boss' HP
     * Parameters
     * 
     * int takeDamage       The amount of HP to reduce the boss' health by
     */
    public void takeDamage(int takeDamage) {
        bossHealth.loseHealth(takeDamage);
    }

    /**
     * George Langroudi
     * Gives the boss a chance to shoot a missile
     * Parameters
     * 
     * int rate         The chance of shooting a missile. Lower is faster.
     */
    public void rocketAttack(int rate) { //Gives the ship it's random attack chances. Lower is faster
        if(Greenfoot.getRandomNumber(rate) == 0) {
            EnemyRocket Shot = new EnemyRocket(40, 3);
            EnemyRocket Shot2 = new EnemyRocket(40, 3);
            getWorld().addObject(Shot, getX(), getY() + 30);
            getWorld().addObject(Shot2, getX(), getY() - 30);
        }
    }

    /**
     * @Author George Langroudi
     * Shoots a given number of missiles in a quick burst
     * Parameters
     * 
     * int rate         The number of missiles to shoot
     */
    public void rocketBurst(int rate) { //shoots x amount of rockets
        for(int x = 0; x <= rate; x++) {
            EnemyRocket Shot = new EnemyRocket(40, 3);
            getWorld().addObject(Shot, getX(), getY());
        }
    }

    /**
     * @author George Langroudi
     * Shoots 2 shots out of the ship using a random chance
     * parameters
     * 
     * int rate         The chance of the ship shooting, lower is faster.
     */
    public void attack(int rate) { //Gives the ship it's random attack chances. Lower is faste
        if(Greenfoot.getRandomNumber(rate) == 0) {
            BossGun1.shoot();
            BossGun2.shoot();
        }
    }

    public boolean smoothTurn(int angle) {
        if(angle - getRotation() <= 3) {
            if(360 - getRotation() <= 180) {
                turn(3);
            } else {
                turn(-3);
            }
        } else {
            if(360 - getRotation() <= 180) {
                turn(1);
            } else {
                turn(-1);
            }
        }

        if(getRotation() == angle) 
            return true;
        return false;
    }
}

