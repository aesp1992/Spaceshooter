import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class gruntFire here.
 * 
 * @author (George Langroudi) 
 */
public class GruntFire extends Grunt
{
    int damage = 0;
    int speed = -8;
    int angle = 0;
    boolean rotate = true;
    public void act() {
        if(rotate) {
            turn(angle);
            rotate = false;
        }
        move(speed);
        Actor player = getOneIntersectingObject(Spaceship.class);
        if (isAtEdge()) 
        {
            getWorld().removeObject(this);
        }   
    } 

    /**
     * class initialiser
     * 
     * parameters
     * @setDamage       sets the shots damage value
     * @setSpeed        sets the speed at which the shot shoots
     * @setSprite       sets the sprite that the shot will use;
     */
    public GruntFire(int setDamage, int setSpeed, int setSprite, int setAngle){
        damage = setDamage;
        speed = setSpeed;
        angle = setAngle;
        switch(setSprite) {
            case 1:
            setImage("images/lv1fire.png");
            break;
            case 2:
            setImage("images/lv2fire.png");
            break;
            case 3:
            setImage("images/lv3fire.png");
            break;
            case 4:
            setImage("images/lv5fire.png");
            break;
            default:
            setImage("images/lv1fire");
            break;
        }
    }
    
    /**
     * Returns the damage value the shot has, so the Spaceship can see how much
     * damage it should take. 
     */
    public int getDamage() {
        return damage;
    }
}

