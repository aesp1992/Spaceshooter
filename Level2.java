import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates the Buttons you see in the Level Select.
 * Changes images if the user hovers on the image.
 *
 * @author (Adrian Espiritu) 
 */

public class Level2 extends Buttons
{
    public Level2() {

        setImage("images/lv2.png");

    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/lv2_hover.png");
        else
            setImage("images/lv2.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
           Greenfoot.setWorld(new Difficulty("cave"));          
        }

    }

}
