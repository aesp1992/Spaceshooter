import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Text class that takes in parameters. Shows text according parameter.
 * 
 * @author (Adrian Espiritu)
 */

public class Text extends Actor
{

    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); 
    int counter = 0;

    boolean speech = false;

    /**
     * @author(Adrian Espiritu)
     * @editor(Felix Gillingham)
     * added more texts for my new class
     */
    public Text(int whatText) {

        if(whatText == 1) {
            setImage(new GreenfootImage("GameOver!", 50, Color.WHITE, TRANSPARENT));
        }

        if (whatText == 2) {
            setImage(new GreenfootImage("Kaboom!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 3) {
            setImage(new GreenfootImage("Dakka! Dakka!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 4) {
            setImage(new GreenfootImage("Just another Thursday in Space.", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }

        if (whatText == 5) {
            setImage(new GreenfootImage("In space, no-one can hear you suck!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 6) {
            setImage(new GreenfootImage("Maximum effort!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 7) {
            setImage(new GreenfootImage("Sorry! Except not really.", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 8) {
            setImage(new GreenfootImage("When in Space! Blow stuff up!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 9) {
            setImage(new GreenfootImage("Take that!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 10) {
            setImage(new GreenfootImage("Another one bites the dust!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 11) {
            setImage(new GreenfootImage("Die! Whoever you are!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
        
        if (whatText == 12) {
            setImage(new GreenfootImage("I wonder what's for lunch!", 20, Color.WHITE, TRANSPARENT));
            speech = true;
        }
    }

    public void act() 
    {
        if(speech = true) {
            setLocation(getX(), getY() + 1);      
            counter++;        
            if(counter == 75) {
                getWorld().removeObject(this);
            }
        }
    }    

}
