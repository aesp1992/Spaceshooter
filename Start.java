import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Start extends Buttons
{
    /**
     * Creates the Start Button that you see in the start screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */

    public Start() {
        
        setImage("images/play_1.png");

    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/play_2.png");
        else
            setImage("images/play_1.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new Difficulty("space"));             
        }
    }    
}
