import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Back extends Buttons
{
    /**
     * Creates the Back Button that you see in the difficulty screen.
     *
     * @author (Adrian Espiritu) 
     */

    public Back() {

        setImage("images/back.png"); 

    }

    public void act() 
    {

        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/back_hover.png");
        else
            setImage("images/back.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {
            Greenfoot.setWorld(new StartScreen());          
        }

    }       

}