import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Quit extends Buttons
{
    /**
     * Creates the Quit Button that you see in the start screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */

    public Quit() {
        
        setImage("images/quit_1.png");
        
    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/quit_2.png");
        else
            setImage("images/quit_1.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            
            System.exit(0);

        }

    }      
}
