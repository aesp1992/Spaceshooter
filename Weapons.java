import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the superclass, so all our powerup subclasses call upon the methods in this class.
 * 
 * @author (Felix Gillingham) 
 * @version (16/02/2017)
 */
public class Weapons extends Powerups
{
    /**
     * This initialises the counter to 0
     */
    int counter = 0;

    int poweruptimer = 0;
    int powerupBarWidth = 375;
    int powerupBarHeight = 10;
    int pixelBypowerUp = (int)powerupBarWidth/375;

    
    public void act() 
    {
        drawPowerUpBar();
    }   

    /**
     * This class allows the powerup
     */
    public void moveObj(int speed) {
        counter++;
        move(speed * -1);
    }

    /**
     * Draws the attributes of the PowerUp Bar.
     * 
     * @author (Adrian Espiritu)
     */

    public void drawPowerUpBar()
    {
        setImage(new GreenfootImage(powerupBarWidth + 2, powerupBarHeight + 2));
        GreenfootImage myPowerUpBar = getImage();

        myPowerUpBar.setColor(Color.WHITE);
        myPowerUpBar.drawRect(0, 0, powerupBarWidth + 1, powerupBarHeight +1);
        
        myPowerUpBar.setColor(Color.BLUE);  
        myPowerUpBar.fillRect(1, 1, poweruptimer*pixelBypowerUp, powerupBarHeight);
        
        if(poweruptimer >= 1 && poweruptimer <= 375)
        loseTime();
        
    }

    /**
     * This refills powerup bar to max.
     * 
     * @author (Adrian Espiritu)
     */

    public void gainMaxPower()
    {
        poweruptimer = 375;
    }   

    /**
     * poweruptimer loses time by the specified amount
     * 
     * @author (Adrian Espiritu)
     */

    public void loseTime()
    {       
        poweruptimer = poweruptimer - 1; 
    }

}

