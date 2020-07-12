import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A shield that goes around enemies and protects them.
 * 
 * @author (Aziz Khan) 
 */
public class Aura extends Spaceship
{
    int counter = 0;
    static int duration = 650;
    Spaceship target = new Spaceship();
    EnemyHealthbar timer = new EnemyHealthbar(50, 50, 40, this, true, false);

    public void act() 
    {
        //checkCollision();
        setLocation(target.getX(), target.getY());
        counter++;
        if(counter % (duration / 50) == 0)
            timer.loseHealth(1);
        if(counter >= duration){
            Greenfoot.playSound("shield_off.wav");
            getWorld().removeObject(timer);
            getWorld().removeObject(this);
        }
    }    

    public Aura(Spaceship newTarget){
        target = newTarget;
    }

    public void destroy() {
        getWorld().removeObject(this);
    }

    public void addedToWorld(World world) {
        timer.setColor(Color.BLUE);
        //timer.setColor(new Color(26, 140, 159));
        getWorld().addObject(timer, getX(), getY() + 60);
    }
}

