import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (George Langroudi)
 * Modified from the original Healthbar Class by Adrian Espiritu
 */

public class EnemyHealthbar extends Actor
{
    int health = 50; //default health, reasigned when initiated
    int healthBarWidth = 400;   //width of the healthbar
    int healthBarStart = 1;
    int healthBarHeight = 10;   //Height of the healthbar
    int pixelByHealthbar = healthBarStart/health;  //how wide the healthbar is
    int yDisplacement = 60; //how offset the healthbar should be from the Actor it's attached to

    Color barColor = Color.RED;

    boolean animate = false;
    boolean track = true;
    Actor target = new Grunt();

    /**
     * @author George Langroudi
     */
    public void act() 
    {
        if(animate) {
            animateHealthbar();
            if(healthBarStart < healthBarWidth) {
                healthBarStart += 4;
            } else {
                animate = false;
            }
        } else {
            drawHealthbar();
        }
        if(track) {
            try{
                setLocation(target.getX(), target.getY() + yDisplacement);
            } catch(Exception e) {
                getWorld().removeObject(this);
            }
        }
    }

    /**
     * Initialises the healthbar
     * @author George Langroudi
     * Parameters
     * 
     * @int totalHealth         The amount of health this object will have
     * @int newWidth            The width of the new healthbar
     * @Grunt newTarget         The object this healthbar will represent
     */
    public EnemyHealthbar(int totalHealth, int newWidth, int newDisplacement, Actor newTarget, boolean newTrack, boolean newAnimate) {
        health = totalHealth;
        healthBarWidth = newWidth;
        target = newTarget;
        yDisplacement = newDisplacement;
        pixelByHealthbar = (int)healthBarWidth/health;
        track = newTrack;
        animate = newAnimate;
    }

    /**
     * Draws the attributes of the CopyOfHealthbar.
     * 
     * @author (Adrian Espiritu)
     */

    public void drawHealthbar()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myHealthbar = getImage();

        myHealthbar.setColor(Color.WHITE);
        myHealthbar.drawRect(0, 0, healthBarWidth + 1, healthBarHeight +1);

        myHealthbar.setColor(barColor);
        myHealthbar.fillRect(1, 1, health*pixelByHealthbar, healthBarHeight);
    }

    /**
     * Animates the healthbar when it is brought into the world.
     */
    public void animateHealthbar()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myHealthbar = getImage();

        if(healthBarStart * 2 < healthBarWidth) {
            myHealthbar.setColor(Color.WHITE);
            myHealthbar.drawRect(0, 0, (healthBarStart * 2) + 1, healthBarHeight +1);
        } else {
            myHealthbar.setColor(Color.WHITE);
            myHealthbar.drawRect(0, 0, healthBarWidth + 1, healthBarHeight +1);
        }

        myHealthbar.setColor(Color.RED);
        myHealthbar.fillRect(1, 1, healthBarStart, healthBarHeight);
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

    public boolean isDestroyed(){
        return health <= 0;
    }

    public void refresh() {
        healthBarStart = 1;
    }

    public int getHealth() {
        return health;
    }

    public void setColor(Color newColor) {
        barColor = newColor;
    }
}
