import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossGun extends Grunt
{
    /**
     * Act - do whatever the BossGun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x = 0;
    int y = 0;

    int targetX = 0;
    int targetY = 0;

    double angle = 0;
    double shift = 0;
    int radius = 20;
    int counter = 0;
    
    Actor target;
    public void act() 
    {
        targetX = target.getX();
        targetY = target.getY();
        angle = ((double) target.getRotation() / 57) + shift;; //Im not going to lie, I don't know why this number works but it works well
        x = targetX + (int) (Math.cos(angle) * radius);
        y = targetY + (int) (Math.sin(angle) * radius);
        setLocation(x, y);
        setRotation(target.getRotation());
    }    

    public BossGun(Actor newTarget, double newShift, int newRadius) {
        target = newTarget;
        shift = newShift;
        radius = newRadius;
    }

    public void shoot() {
        GruntFire Shot = new GruntFire(8, 20, 4, getRotation());
        getWorld().addObject(Shot, getX(), getY());
    }
}
