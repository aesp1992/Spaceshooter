import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelSelect extends Menu
{
    Level1 lv1 = new Level1();
    Level2 lv2 = new Level2();
    Level3 lv3 = new Level3();
    
    Assets lselect = new Assets(19);
    Back back = new Back();
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public LevelSelect()
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
        
        addObject(lselect, getWidth()/2, getHeight()/2);      
        
        addObject(lv1, getWidth()/2, getHeight()/2 - 50);
        addObject(lv2, getWidth()/2, getHeight()/2 + 25);
        addObject(lv3, getWidth()/2, getHeight()/2 + 105);
        
        addObject(back, 750, 415);
      
    }

}

