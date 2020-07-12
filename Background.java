import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets Image according to parameter sent.
 *
 * @author (Adrian Espiritu) 
 */

public class Background extends Scroll
{
        
    public Background(int whichLayer) {

        if(whichLayer == 1) {
            setImage("images/lv1bg.jpg");
        }
        
        //Level 3 Layers
        if(whichLayer == 2) {
            setImage("images/layer_0.png");
        }
        if(whichLayer == 3) {
            setImage("images/layer_1.png");
        }
        if(whichLayer == 4) {
            setImage("images/layer_2.png");
        }
        if(whichLayer == 5) {
            setImage("images/layer_3.png");
        }
        
        //Level 2 Layers
        if(whichLayer == 6) {
            setImage("images/1layer_0.png");
        }
        if(whichLayer == 7) {
            setImage("images/1layer_1.png");
        }
        if(whichLayer == 8) {
            setImage("images/1layer_2.png");
        }
        if(whichLayer == 9) {
            setImage("images/1layer_3.png");
        }
        if(whichLayer == 10) {
            setImage("images/1layer_4.png");
        }
    
    }

    public void act() 
    {
        // Add your action code here.
    }    

}
