import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Hard extends dSetting
{
    /**
     * Creates the Hard Button that you see in the difficulty screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */

    private boolean isSpace;
    private boolean isCave;
    private boolean isLavaCave;

    public Hard(String where) {
        setImage("images/hard_1.png");

        if(where == "space"){
            isSpace = true;
        }

        if(where == "cave"){
            isCave = true;
        }

        if(where == "lavacave"){
            isLavaCave = true;
        }
    }

    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
            isMouseHover = Greenfoot.mouseMoved(this);

        if(isMouseHover)    
            setImage("images/hard_2.png");
        else
            setImage("images/hard_1.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {

            if(isSpace){
                takeMetoSpace(3);
            }

            if(isCave) {
                takeMetoCave(3);
            }

            if(isLavaCave) {
                takeMetoLavaCave(3);
            } 
        }

    }

}
