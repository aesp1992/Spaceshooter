import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Levels extends World
{

    Healthbar healthbar = new Healthbar();
    ScoreBoard scoreboard = new ScoreBoard();
    Lives lives = new Lives();
    Weapons timer = new Weapons();
    dSetting setting = new dSetting();
    
    Assets lv1 = new Assets(9);
    Assets lv2 = new Assets(10);
    Assets lv3 = new Assets(11);    
    Assets hud = new Assets(12);
    Assets toquit = new Assets(22);    

    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        super(800, 450, 1, false); 
    }

    /**
     * Returns the current Score
     * 
     * @author (Aziz Khan)
     */
    public ScoreBoard getScore() {
        return scoreboard;
    }

    /**
     * Returns the current Healthbar
     * 
     * @author (Adrian Espiritu)
     */
    public Healthbar getHealthBar() {
        return healthbar;
    }

    /**
     * Returns the current Lives
     * 
     * @author (Felix Gillingham)
     */
    public Lives getLives() {
        return lives;
    }
    
    /**
     * Returns the current Lives
     * 
     * @author (Adrian Espiritu)
     */
    public Weapons getPowerUpTimer() {
        return timer;
    }
    
    /**
     * Returns the current Difficulty Setting
     * 
     * @author (Adrian Espiritu)
     */
    public dSetting getDifficulty() {
        return setting;
    }

}
