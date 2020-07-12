import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Normal extends dSetting
{
    /**
     * Creates the Normal Button that you see in the difficulty screen.
     * Changes images if the user hovers on the image.
     *
     * @author (Adrian Espiritu) 
     */
    
    private boolean isSpace;
    private boolean isCave;
    private boolean isLavaCave;
    
    public Normal(String where) {
        setImage("images/normal_1.png");
        
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
            setImage("images/normal_2.png");
        else
            setImage("images/normal_1.png");

        if (!isMouseDown && Greenfoot.mousePressed(this)) {

            if(isSpace){
                takeMetoSpace(2);
            }
            
            if(isCave) {
                takeMetoCave(2);
            }
            
            if(isLavaCave) {
               takeMetoLavaCave(2);
            } 
        }
        
    }   
        
}
