import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Instructions extends Menu
{
   
    
    Assets h2pHeader = new Assets(2);
    
    Assets W = new Assets(13);
    Assets A = new Assets(14);
    Assets S = new Assets(15);
    Assets D = new Assets(16);
    Assets SPACE = new Assets(17);
    Assets tips = new Assets(18);
    
    Back back = new Back();

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public Instructions()
    {    
        //super(800, 450, 1, false); 
        prepare();
    }

    public void act() {

        img1.slideAcross(2);
        img2.slideAcross(2);
        
    }

    public void prepare() {

        img1 = new Background(1);
        addObject(img1, getWidth()/2, getHeight()/2);

        img2 = new Background(1);
        addObject(img2, getWidth() + getWidth()/2, getHeight()/2);
        
        
        // Aziz
        addObject(h2pHeader, getWidth()/2, getHeight()/2);
        
        addObject(W,155,190);
        addObject(A,100,250);
        addObject(D,210,250);
        addObject(S,155,250);
        
        addObject(SPACE,300,250);
        
        addObject(tips,575,255);   
        
        addObject(back, 750, 415);

    }

}
