import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Easy extends dSetting
{
    /**
     * Creates the Easy Button that you see in the difficulty screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */

    private boolean isSpace;
    private boolean isCave;
    private boolean isLavaCave;

    public Easy(String where) {

        setImage("images/easy_1.png");

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
            setImage("images/easy_2.png");
        else
            setImage("images/easy_1.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {

            if(isSpace){
                takeMetoSpace(1);
            }
            
            if(isCave) {
                takeMetoCave(1);
            }
            
            if(isLavaCave) {
               takeMetoLavaCave(1);
            } 
        }

    }

}
