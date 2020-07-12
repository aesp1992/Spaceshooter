import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LvSelect extends Buttons
{
    /**
     * Creates the Start Button that you see in the start screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */

    public LvSelect() {
        
        setImage("images/lv_select.png");

    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/lv_select_hover.png");
        else
            setImage("images/lv_select.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new LevelSelect());             
        }
    }    
}
