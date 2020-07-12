import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PickupText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PickupText extends Actor
{
    /**
     * Act - do whatever the PickupText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int transparencyValue = 255;
    Color textColor = new Color(36, 224, 229);
    //Color.BLUE
    GreenfootImage text = new GreenfootImage("TEMP TEXT", 50, textColor, new Color(0, 0, 0, 0));
    
    public void act() 
    {
        //setImage(text);
        setLocation(getX(), getY() - 1);
        text.setTransparency(transparencyValue);
        transparencyValue -= 5;
        if(transparencyValue <= 0) {
            getWorld().removeObject(this);
        }
    }    
    
    public PickupText(String newText) {
        text = new GreenfootImage(newText, 50, textColor, new Color(0, 0, 0, 0));
        setImage(text);
    }
    
    
}
