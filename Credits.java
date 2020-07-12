import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditScreen here.
 * @author (Aziz Khan) 
 * @version (1)
 */
public class Credits extends Menu
{ 
    Assets credits = new Assets(4);
    Back back = new Back();
    private int counter = 0;
    /**
     * Constructor for objects of class CreditScreen.
     * 
     */
    public Credits()
    {
        prepare();
        addObject(credits, getWidth()/2 + 25, getHeight() + 250);
       
    }
    
    /**
     * Write a description of class CreditScreen here.
     * @author (Aziz Khan)
     * Scrolling action, -1 is going up; at <-20 it stops.
     * Uses level1background.
     */
    public void act() 
    {
        credits.setLocation(credits.getX(), credits.getY()-1);
        if(credits.getY()<-20){
           // Greenfoot.stop();
           
           counter++;
           if(counter == 225) {
                Greenfoot.setWorld(new StartScreen());
            }
        }
                
    }
        
    public void prepare() {

        img1 = new Background(1);
        addObject(img1, getWidth()/2, getHeight()/2);

        img2 = new Background(1);
        addObject(img2, getWidth() + getWidth()/2, getHeight()/2);
        
        addObject(back, 750, 415);

    }
}
