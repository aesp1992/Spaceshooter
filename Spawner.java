
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The class that generates enemies in the level. Enemies numbers will not be dynamic
 * 
 * @author (George Langroudi) 
 */
public class Spawner extends Actor
{
    private boolean isSpace;
    private boolean isCave;
    private boolean isLavaCave;

    int timer = 0;

    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int spawnerArray[][] = {

            {1050, 150, 250, 0, 36, 8, 1},
            {1100, 200, 25, 0, 36, 8, 1},            
            {1025, 150, 250, 0, 36, 8, 1},
            {1075, 200, 25, 0, 36, 8, 1},

            {1050, 160, 250, 0, 36, 8, 1},
            {1100, 210, 25, 0, 36, 8, 2},            
            {1025, 160, 250, 0, 36, 8, 1},
            {1075, 210, 25, 0, 36, 8, 2},

            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            //===============================//

            {1050, 150, 250, 0, 36, 8, 1},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 1},

            {1050, 160, 250, 0, 36, 8, 2},
            {1100, 210, 25, 0, 36, 8, 1},            
            {1025, 160, 250, 0, 36, 8, 1},
            {1075, 210, 25, 0, 36, 8, 2},

            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            //===============================//

            {800, -100, 250, 0, 36, 9, 3},
            {750, -75, 25, 0, 36, 9, 3},
            {1050, 175, 250, 0, 36, 9, 2},

            {800, -100, 350, 0, 36, 9, 3},
            {1075, 175, 25, 0, 36, 9, 2},
            {700, -75, 350, 0, 36, 9, 3},

            {800, -100, 250, 0, 36, 9, 3},
            {750, -75, 25, 0, 36, 9, 3},
            {1050, 175, 250, 0, 36, 9, 2},

            {800, -100, 350, 0, 36, 9, 3},
            {1075, 175, 25, 0, 36, 9, 2},
            {700, -75, 350, 0, 36, 9, 3}};

    int Lv2Spawner[][] = {
            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            {800, -100, 250, 0, 36, 12, 3},
            {750, -100, 500, 0, 36, 12, 3},
            {1025, 175, 25, 0, 36, 9, 2},
            {1150, 200, 25, 0, 36, 9, 2},

            {1000, 150, 250, 0, 36, 8, 2},
            {1050, 200, 25, 0, 36, 8, 2},            
            {975, 150, 250, 0, 36, 8, 2},
            {1025, 200, 25, 0, 36, 8, 2},

            {750, -100, 250, 0, 36, 12, 3},
            {700, -100, 25, 0, 36, 12, 3},
            {975, 175, 25, 0, 36, 9, 2},
            {1100, 200, 25, 0, 36, 9, 2},

            //===============================//    

            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            {600, -75, 25, 0, 36, 6, 4},

            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            {600, -75, 25, 0, 36, 6, 4},

            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            {600, -75, 25, 0, 36, 6, 4},

            //===============================// 

            {750, -75, 250, 0, 36, 11, 4},
            {650, -25, 0, 0, 36, 7, 4},
            {550, 25, 0, 0, 36, 5, 4},
            {450, 50, 0, 0, 36, 3, 4}};

    int Lv3Spawner[][] = {

            {1050, 150, 250, 0, 36, 8, 2},
            {1100, 200, 25, 0, 36, 8, 2},            
            {1025, 150, 250, 0, 36, 8, 2},
            {1075, 200, 25, 0, 36, 8, 2},

            {700, 10, 200, 0, 36, 2, 5},

            {1050, 150, 1000, 0, 36, 8, 2},
            {750, -100, 25, 0, 36, 11, 3},            
            {975, 150, 250, 0, 36, 8, 2},
            {675, -100, 25, 0, 36, 11, 3},

            {700, 10, 500, 0, 36, 2, 5},

            {750, -75, 750, 0, 36, 11, 4},
            {650, -25, 0, 0, 36, 7, 4},
            {550, 25, 0, 0, 36, 5, 4},
            {450, 50, 0, 0, 36, 3, 4},

            {700, 10, 500, 0, 36, 2, 5},

            {750, -75, 500, 0, 36, 11, 4},
            {650, -25, 0, 0, 36, 7, 4},
            {550, 25, 0, 0, 36, 5, 4},
            {450, 50, 0, 0, 36, 3, 4},

            {450, 50, 300, 0, 36, 1, 6}};

    //===============================// 

    int counter = 0;
    int state = 0;
    int arrStage = 0;

    boolean isEnemyOnScreen;

    int lvlength = 0;

    TransitionScreen endScreen = new TransitionScreen(Color.BLACK, 2, true);

    /**
     * Spawns the appropriate spawner array according the
     * parameter passed.
     *
     * @author (Adrian Espiritu)
     */

    public Spawner(int whatLevel) {
        if (whatLevel == 1) {
            spawnerArray = spawnerArray;
            lvlength = spawnerArray.length;
            isSpace = true;
        }
        if (whatLevel == 2) {
            spawnerArray = Lv2Spawner;
            lvlength = Lv2Spawner.length;
            isCave = true;
        }
        if (whatLevel == 3) {
            spawnerArray = Lv3Spawner;
            lvlength = Lv3Spawner.length;
            isLavaCave = true;
        }
    }

    public void addedToWorld(World world) {
        //setLocation(-40, -40);
        setImage(new GreenfootImage(1, 1));
    }

    public void act() 
    {

        if(state == 0 && arrStage <= spawnerArray.length - 1) {
            pause(spawnerArray[arrStage][2]);
            setLocation(spawnerArray[arrStage][0], spawnerArray[arrStage][1]); //doesn't like if you give it a number slightly higher than the length of the array
        }
        if(state == 1) {
            spawnGrunt(spawnerArray[arrStage][3], spawnerArray[arrStage][4], spawnerArray[arrStage][5], spawnerArray[arrStage][6]);
        }
        if(state != 0 && state != 1) {
            state = 0;
            setLocation(-20, -20);
        }

        if(arrStage == lvlength && getWorld().getObjects(Grunt.class).isEmpty()) { //Checks if the level is over and changes to the next level
            if(timer == 50) {
                getWorld().getObjects(Spaceship.class).get(0).endLevel();
            }
            if(timer <= 370) {
                if(timer == 230) {
                    endScreen = new TransitionScreen(Color.BLACK, 3, true);
                    getWorld().addObject(endScreen, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                }
            } else {
                nextLevel();
            }
            timer++;
        }
    }    

    /**
     * Parameters
     * int x = How much to shift the X value every time an enemy spawns
     * int y = The height difference between each enemy
     * int number = The number of enemies to spawn
     * int difficulty = The enemy to spawn. Each enemy has a different value. 1 is Lv1Grunt, 2 is Lv2Grunt.
     * 
     * @author (George Langroudi) 
     */
    void spawnGrunt(int x, int y, int number, int difficulty) {
        if(counter <= number) {
            Grunt enemy = new Lv1Grunt();
            switch(difficulty) {
                case 1:
                enemy = new Lv1Grunt();
                break;
                case 2:
                enemy = new Lv2Grunt();
                break;
                case 3:
                enemy = new Lv3Grunt();
                break;
                case 4:
                enemy = new Lv4Grunt();
                break;
                case 5:
                enemy = new Lv5Grunt();
                break;
                case 6:
                enemy = new FinalBoss();
                break;
                default:
                enemy = new Lv1Grunt();
                break;
            }
            getWorld().addObject(enemy, getX(), getY());
            if(counter % 2 == 0) {
                setLocation(getX() + x, getY() + y);
            } else {
                setLocation(getX() -x, getY() + y);
            }
            counter++;
        } 
        if(counter >= number) {
            counter = 0;
            arrStage++;
            state--;
            setLocation(getWorld().getWidth() + 30, getWorld().getHeight() + 30);
        }
    }

    /**
     * Pauses the counter for a set amount of time.
     * parameters
     * 
     * int length           How many ticks to wait before resetting the counter.
     */
    void pause(int length) {
        if(counter >= length) {
            counter = 0;
            state++;
        }
        counter++;
    }

    /**
     * Gets current value of lives, health, score and difficulty to pass to the
     * next level.
     *
     * @author (Adrian Espiritu)
     */

    public void nextLevel() {
        World myWorld = getWorld();
        Levels levels = (Levels)myWorld;
        Lives lives = levels.getLives();
        ScoreBoard scoreboard = levels.getScore();
        Healthbar healthbar = levels.getHealthBar();
        dSetting difficulty = levels.getDifficulty();

        if (isSpace == true) {
            Cave c1 = new Cave();

            Lives carryLife = (Lives)c1.getObjects(Lives.class).get(0);        
            carryLife.setLives(lives.lives);

            ScoreBoard carryScore = (ScoreBoard)c1.getObjects(ScoreBoard.class).get(0);        
            carryScore.setScore(scoreboard.score);

            Healthbar carryHealth = (Healthbar)c1.getObjects(Healthbar.class).get(0);        
            carryHealth.setHealth(healthbar.health);

            dSetting carryDifficulty = (dSetting)c1.getObjects(dSetting.class).get(0);        
            carryDifficulty.setDifficulty(difficulty.difficulty);

            Greenfoot.setWorld(c1);
        }

        if (isCave == true) {
            LavaCave l1 = new LavaCave();

            Lives carryLife = (Lives)l1.getObjects(Lives.class).get(0);        
            carryLife.setLives(lives.lives);

            ScoreBoard carryScore = (ScoreBoard)l1.getObjects(ScoreBoard.class).get(0);        
            carryScore.setScore(scoreboard.score);

            Healthbar carryHealth = (Healthbar)l1.getObjects(Healthbar.class).get(0);        
            carryHealth.setHealth(healthbar.health);

            dSetting carryDifficulty = (dSetting)l1.getObjects(dSetting.class).get(0);        
            carryDifficulty.setDifficulty(difficulty.difficulty);

            Greenfoot.setWorld(l1);
        }
        
        if(isLavaCave == true) {
            getWorld().removeObject(this);

            // load leader board
            LeaderBoard lb = new LeaderBoard();

            // get the currewnt score
            Levels l = (Levels)myWorld;
            ScoreBoard sb = l.getScore();
            int score = sb.getScore();            
            lb.addScore(score);
            lb.drawBoard();
            
            Greenfoot.setWorld(new LeaderBoard()); 
        }
    }

    /**
     * Checks if there is still enemies on screen.
     *
     * @author (Adrian Espiritu)
     */

    public void enemyOnScreen() {
        if(getWorld().getObjects(Grunt.class).size() !=0){
            isEnemyOnScreen = true;
        } else {
            isEnemyOnScreen = false;
        }
    }

}
