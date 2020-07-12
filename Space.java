import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.*;

public class Space extends Levels
{

    private Background img1, img2;
    Spawner spawner = new Spawner(1);
    TransitionScreen startTransition = new TransitionScreen(Color.BLACK, 3, false);
    TransitionScreen newQuit = new TransitionScreen(Color.BLACK, 3, false);
    

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Space()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //super(800, 450, 1, false); //unbounded world, you can have objects positions outside the world 
        prepare();
    }

    /**
     * This act method does not run if isPaused is set to TRUE. isPaused can be used to pause any
     * class in this world.
     * 
     * @author (Adrian Espiritu)
     */
    public void act()
    {

        img1.slideAcross(2);
        img2.slideAcross(2);
        if(Greenfoot.isKeyDown("Escape")) {
            Greenfoot.setWorld(new StartScreen());
        }

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {   
        img1 = new Background(1);
        addObject(img1, getWidth()/2, getHeight()/2);

        img2 = new Background(1);
        addObject(img2, getWidth() + getWidth()/2, getHeight()/2);

        addObject(hud,getWidth()/2, 28);     
        addObject(healthbar,210,15);
        addObject(timer,590,15);
        addObject(scoreboard,getWidth()/2,38);
        addObject(lives,50,38); //Felix (adds a life counter to the screen.)
        addObject(setting,725,37);
        
        addObject(lv1,getWidth()/2, getHeight()/2);

        Spaceship spaceship = new Spaceship();
        addObject(spaceship,32,217);  

        
        addObject(spawner,677,253);
        
        newQuit.setImage("images/toquit.png");
        newQuit.setDecreasing();
        newQuit.newImage(new GreenfootImage("images/toquit.png"));
        newQuit.setDelay(250);
        addObject(newQuit, 700,425);
        startTransition.setDecreasing();
        addObject(startTransition, getWidth() / 2, getHeight() / 2);
    }

    /**
     * @author (Aziz Khan)
     * Sets world to Credit Screen when Game is over.
     */
    public void gameOver()
    {
        //removeObjects(getObjects(Lv3Grunt.class));
        Greenfoot.setWorld(new Credits());

    }    
}
