import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends Menu
{
    Start start = new Start();
    Help help = new Help();
    Quit quit = new Quit();
    LvSelect lvselect = new LvSelect();
    Assets welcome = new Assets(5);
    Assets signature = new Assets(8);
    Assets f12cred = new Assets(23);
    lBoard lboard = new lBoard();
  
    boolean isPlaying = false;

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        //super(800, 450, 1, false); 
        prepare();
    }

    public void act() {
        
        img1.slideAcross(2);
        img2.slideAcross(2);
        
        if(Greenfoot.isKeyDown("F12")) {
            Greenfoot.setWorld(new Credits());
        }
        
    }
    
    public void prepare() {

        img1 = new Background(1);
        addObject(img1, getWidth()/2, getHeight()/2);

        img2 = new Background(1);
        addObject(img2, getWidth() + getWidth()/2, getHeight()/2);

        addObject(welcome, getWidth()/2, getHeight()/2);
        addObject(start, getWidth()/2, getHeight()/2 - 50);        
        addObject(help, getWidth()/2, getHeight()/2); 
        addObject(lvselect, getWidth()/2, getHeight()/2 + 50);     
        addObject(quit, getWidth()/2, getHeight()/2 + 100);
        addObject(f12cred, getWidth()/2, getHeight()/2 + 130);        
        addObject(signature, 205, 415);
        addObject(lboard, 700, 395);
       

    }

}
