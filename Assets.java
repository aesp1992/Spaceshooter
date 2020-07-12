import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Assets class that takes in parameters. Shows image according parameter.
 * 
 * @author (Adrian Espiritu) 
 */
public class Assets extends Actor
{
    int counter = 0;
    boolean isLevelIndicator = false;

    public Assets(int whatAsset) {

        if (whatAsset == 1) {
            setImage("images/difficulty.png");   
        }
        if (whatAsset == 2) {
            setImage("images/h2p.png");   
        }
        if (whatAsset == 3) {
            setImage("images/help.png");   
        }
        if (whatAsset == 4) {
            setImage("images/credits.png");   
        }
        if (whatAsset == 5) {
            setImage("images/welcome.png");   
        }
        if (whatAsset == 6) {
            setImage("images/keys.png");   
        }
        if (whatAsset == 7) {
            setImage("images/space.jpg");   
        }
        if (whatAsset == 8) {
            setImage("images/signature.png");   
        }
        if (whatAsset == 9) {
            setImage("images/Level_1.png"); 
            isLevelIndicator = true;
        }
        if (whatAsset == 10) {
            setImage("images/Level_2.png");
            isLevelIndicator = true;
        }
        if (whatAsset == 11) {
            setImage("images/Level_3.png");
            isLevelIndicator = true;
        }
        if (whatAsset == 12) {
            setImage("images/HUD.png");   
        }
        if (whatAsset == 13) {
            setImage("images/w.png");   
        }
        if (whatAsset == 14) {
            setImage("images/a.png");   
        }
        if (whatAsset == 15) {
            setImage("images/s.png");   
        }
        if (whatAsset == 16) {
            setImage("images/d.png");   
        }
        if (whatAsset == 17) {
            setImage("images/space.png");   
        }
        if (whatAsset == 18) {
            setImage("images/tips.png");   
        }
        if (whatAsset == 19) {
            setImage("images/level_select.png");   
        }
        if (whatAsset == 20) {
            setImage("images/leaderboard.png");   
        }
        if (whatAsset == 21) {
            setImage("images/leaderboard_ph.png");   
        }
        if (whatAsset == 22) {
            setImage("images/toquit.png");   
        }
        if (whatAsset == 23) {
            setImage("images/f12cred.png");   
        }
    }

    /**
     * Act - do whatever the Assets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        removeMe();
    }

    public void removeMe()
    {
        if(isLevelIndicator) {
            counter++;
            if(counter >= 125){
                getWorld().removeObject(this);
            }

        }
    }
}
