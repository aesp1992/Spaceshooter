import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * An object that can completely obscure the screen for transitions
 * 
 * @author (George Langroudi) 
 */
public class TransitionScreen extends Actor
{
    int counter = 0;
    int counterSpeed = 1;
    int delay = 0;

    boolean increasing = true;
    boolean onlyAscending = false;

    GreenfootImage newImage = new GreenfootImage(1000, 1000);
    /**
     * Act - do whatever the TransitionScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(delay <= 0) {
            if(counter <= 255) {
                newImage.setTransparency(counter);
            } else {
                newImage.setTransparency(255);
            }
            setImage(newImage);
            counter++;
            if(increasing) {
                counter += counterSpeed;
                if(counter >= 255 - counterSpeed) {
                    increasing = false;
                }
            } else {
                if(!onlyAscending) {
                    counter -= counterSpeed;
                    if(counter <= counterSpeed) {
                        getWorld().removeObject(this);
                    }
                }
            }
        } else {
            delay--;
        }
    }    

    public TransitionScreen(Color newColor, int newRate) {
        newImage.setColor(newColor);
        newImage.fillRect(1, 1, 1000, 1000);
        newImage.setTransparency(0); //0 transparent, 255 opaque;
        newImage.setColor(newColor);
        setImage(newImage);
        counterSpeed = newRate;
    }

    public TransitionScreen(Color newColor, int newRate, boolean onlyAscending1) {
        newImage.setColor(newColor);
        newImage.fillRect(1, 1, 1000, 1000);
        newImage.setTransparency(0); //0 transparent, 255 opaque;
        newImage.setColor(newColor);
        setImage(newImage);
        counterSpeed = newRate;
        onlyAscending = onlyAscending1;
    }

    /**
     * @author George Langroudi
     * Checks if the image has reached full opacity and begun to go transparent again.
     */
    public boolean isDecreasing() {
        return !increasing;
    }

    public void addedToWorld(World world) {
        //counter = 0;
        //increasing = true;
    }

    /**
     * Sets the screen to fully opaque and starts it fading away
     */
    public void setDecreasing() {
        counter = 255;
        increasing = false;
    }

    public void newImage(GreenfootImage setNewImage) {
        newImage = setNewImage;   
    }
    
    public void setDelay(int newDelay) {
        delay = newDelay;
    }
}
