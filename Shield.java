import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A shield that goes around enemies and protects them.
 * 
 * @author (George Langroudi) 
 */
public class Shield extends Grunt
{
    /**
     * Act - do whatever the Shield wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Grunt target = new Grunt();
    public void act() 
    {
        setLocation(target.getX(), target.getY());
    }    

    public Shield(Grunt newTarget){
        target = newTarget;
    }

    public void destroy() {
        getWorld().removeObject(this);
    }
}
