import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Sets the difficulty to 2 (Normal) as default unless the player chooses to set a different difficulty.
 * 
 * @author (Adrian Espiritu) 
 */
public class dSetting extends Buttons
{
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); 

    int difficulty;

    public dSetting() {
        difficulty = 2; //DEFAULT NORMAL
        checkDifficulty();
    }

    public void act() 
    {
        checkDifficulty();
    }    

    public void setDifficulty(int value) {
        difficulty = value;
    }

    public void checkDifficulty(){

        if (difficulty == 1)
            setImage("images/easy_indicator.png");

        if (difficulty == 2)
            setImage("images/normal_indicator.png");

        if (difficulty == 3)
            setImage("images/hard_indicator.png");

    }

    /**
     * These methods are used by the difficulty buttons to determine what level
     * and where to take the player.
     * 
     * @author (Adrian Espiritu) 
     */

    public void takeMetoSpace(int dsetting) {
        Space s1 = new Space();
        dSetting newsetting = (dSetting)s1.getObjects(dSetting.class).get(0); //This line gets the current difficulty
        newsetting.setDifficulty(dsetting); //Passing the new difficulty
        Greenfoot.setWorld(s1); //Starting the new world with the new difficulty setting
    }

    public void takeMetoCave(int dsetting) {
        Cave c1 = new Cave();
        dSetting newsetting = (dSetting)c1.getObjects(dSetting.class).get(0); //This line gets the current difficulty
        newsetting.setDifficulty(dsetting); //Passing the new difficulty
        Greenfoot.setWorld(c1); //Starting the new world with the new difficulty setting
    }

    public void takeMetoLavaCave(int dsetting) {
        LavaCave l1 = new LavaCave();
        dSetting newsetting = (dSetting)l1.getObjects(dSetting.class).get(0); //This line gets the current difficulty
        newsetting.setDifficulty(dsetting); //Passing the new difficulty
        Greenfoot.setWorld(l1); //Starting the new world with the new difficulty setting
    }
}
