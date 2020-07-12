import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Cave extends Levels
{

    private Background img1, img2;
    private Background img3, img4;
    private Background img5, img6;
    private Background img7, img8;
    private Background img9, img00;
    Spawner spawner2 = new Spawner(2);
    TransitionScreen startTransition = new TransitionScreen(Color.BLACK, 3, false);
    TransitionScreen newQuit = new TransitionScreen(Color.BLACK, 3, false);
    
    /**
     * Constructor for objects of class Cave.
     * 
     */
    public Cave()
    {    
        //super(800, 450, 1, false); 
        prepare();
    }

    public void prepare()
    {
        img1 = new Background(6);
        addObject(img1, getWidth()/2, getHeight()/2);
        img2 = new Background(6);
        addObject(img2, getWidth() + getWidth()/2, getHeight()/2);

        img3 = new Background(7);;
        addObject(img3, getWidth()/2, getHeight()/2);
        img4 = new Background(7);;
        addObject(img4, getWidth() + getWidth()/2, getHeight()/2);

        img5 = new Background(8);
        addObject(img5, getWidth()/2, getHeight()/2);
        img6 = new Background(8);
        addObject(img6, getWidth() + getWidth()/2, getHeight()/2);

        img7 = new Background(9);
        addObject(img7, getWidth()/2, getHeight()/2);
        img8 = new Background(9);
        addObject(img8, getWidth() + getWidth()/2, getHeight()/2);

        img9 = new Background(10);
        addObject(img9, getWidth()/2, getHeight()/2);
        img00 = new Background(10);
        addObject(img00, getWidth() + getWidth()/2, getHeight()/2);

        addObject(hud,getWidth()/2, 28);     
        addObject(healthbar,210,15);
        addObject(timer,590,15);
        addObject(scoreboard,getWidth()/2,38);
        addObject(lives,50,38); //Felix (adds a life counter to the screen.)
        addObject(setting,725,37);
        
        addObject(lv2,getWidth()/2, getHeight()/2);

        Spaceship spaceship = new Spaceship();
        addObject(spaceship,32,217);
        
        addObject(spawner2,677,253);
        
        newQuit.setImage("images/toquit.png");
        newQuit.setDecreasing();
        newQuit.newImage(new GreenfootImage("images/toquit.png"));
        newQuit.setDelay(250);
        addObject(newQuit, 700,425);
        
        startTransition.setDecreasing();
        addObject(startTransition, getWidth() / 2, getHeight() / 2);
    }

    public void act()
    {

        img3.slideAcross(1);
        img4.slideAcross(1);

        img5.slideAcross(2);
        img6.slideAcross(2);

        img7.slideAcross(3);
        img8.slideAcross(3);

        img9.slideAcross(5);
        img00.slideAcross(5);
        
         if(Greenfoot.isKeyDown("Escape")) {
            Greenfoot.setWorld(new StartScreen());
        }
    }

}
