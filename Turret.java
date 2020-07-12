import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The turrets that the player can pick up. Fly around in a circle around the player.
 * 
 * @author (George Langroudi) 
 */
public class Turret extends Spaceship
{
    /**
     * Act - do whatever the Turret wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int spaceshipX = 0;
    int spaceshipY = 0;
    double angle = 45.0;
    double rotation = 0.05;
    int radius = 40;
    int x = 0;
    int y = 0;

    Spaceship parent = new Spaceship();
    Lv1Grunt targetGrunt = new Lv1Grunt();
    public void act() 
    {
        if(Greenfoot.getRandomNumber(140) == 1)
            turretShoot();
        x = spaceshipX + (int) (Math.cos(angle) * radius);
        y = spaceshipY + (int) (Math.sin(angle) * radius);
        setLocation(x, y);
        angle += rotation;
        if(getWorld().getObjects(Grunt.class).isEmpty()) {
            setRotation(0);
        }
        try {
            spaceshipX = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getX(); //gets Xcoordinate
            spaceshipY = ((Spaceship) getWorld().getObjects(Spaceship.class).get(0)).getY(); //gets Ycoordinate
            turnTowards(parent.getTarget().getX(), parent.getTarget().getY());
        } catch(Exception e) {
            //do nothing
        }
    }    

    /**
     * Initialises the turret class
     * parameters
     * 
     * int newRadius            The distance between the turret and the ship
     * double newAngle          The location around the ship the turret spawns at
     * Spaceship newParent      The ship the turret will rotate around
     */
    public Turret(int newRadius, double newAngle, Spaceship newParent) {
        radius = newRadius;
        angle = newAngle;
        parent = newParent;
    }

    /**
     * The chance for the turret to shoot.
     */
    private void turretShoot() {
        if(!getWorld().getObjects(Grunt.class).isEmpty()) {
            Fire turretFire = new Fire(8, 1, 1, getRotation());
            getWorld().addObject(turretFire, x, y);
        }
    }

    public void setAngle(double newAngle) {
        angle = newAngle;
    }

    public void setRadius(int newRadius) {
        radius = newRadius;
    }
    
    public void setRotation(double newRotation) {
        rotation = newRotation;
    }
}
