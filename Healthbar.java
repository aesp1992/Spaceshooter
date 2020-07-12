import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Adrian Espiritu)
 */

public class Healthbar extends Actor
{
    int health = 125; //this is your health <3
    int healthBarWidth = 375;
    int healthBarHeight = 10;
    int pixelByHealthbar = (int)healthBarWidth/health;
    
    public void act() 
    {
        drawHealthbar();
    }

    /**
     * Draws the attributes of the Healthbar.
     * 
     * @author (Adrian Espiritu)
     */

    public void drawHealthbar()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myHealthbar = getImage();

        myHealthbar.setColor(Color.WHITE);
        myHealthbar.drawRect(0, 0, healthBarWidth + 1, healthBarHeight +1);

        myHealthbar.setColor(Color.RED);
        myHealthbar.fillRect(1, 1, health*pixelByHealthbar, healthBarHeight);
    }

    /**
     * Health goes down by the specified parameter.
     * 
     * @author (Adrian Espiritu)
     */

    public void loseHealth(int whathit)
    {
        health = health - whathit;
    }

    /**
     * Health goes back to full.
     * 
     * @author (Felix Gillingham)
     */
    public void gainMaxHealth()
    {

        health = 125;
    }

    /**
     * This method adds +25 to health.
     * 
     * @author (Adrian Espiritu)
     */
    public void heal()
    {

        if (health >= 95) {
            health = 125;
        } else {
            health = health + 30;
        }
    }

    /**
     * Set Health to a specific value (Used for level switching)
     * 
     * @author (Adrian Espiritu)
     */
    public void setHealth(int value){

        health = value;

    }   

    
}