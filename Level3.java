import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates the Buttons you see in the Level Select.
 * Changes images if the user hovers on the image.
 *
 * @author (Adrian Espiritu) 
 */

public class Level3 extends Buttons
{
    public Level3() {

        setImage("images/lv3.png");

    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/lv3_hover.png");
        else
            setImage("images/lv3.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new Difficulty("lavacave"));            
        }

    }

}
