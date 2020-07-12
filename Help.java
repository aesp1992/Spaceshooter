import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Help extends Buttons
{
    /**
     * Creates the Settings Button that you see in the start screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */

    public Help() {
        
        setImage("images/help1.png");

    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/help2.png");
        else
            setImage("images/help1.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new Instructions());
        }

    }       
}