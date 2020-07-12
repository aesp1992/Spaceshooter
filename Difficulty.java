import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Difficulty extends Menu
{

    Easy easy_1 = new Easy("space");
    Easy easy_2 = new Easy("cave");
    Easy easy_3 = new Easy("lavacave");
    
    Normal normal_1 = new Normal("space");
    Normal normal_2 = new Normal("cave");
    Normal normal_3 = new Normal("lavacave");
    
    Hard hard_1 = new Hard("space");
    Hard hard_2 = new Hard("cave");
    Hard hard_3 = new Hard("lavacave");
     
    Back back = new Back();
    Assets diff = new Assets(1);

    /**
     * Constructor for objects of class StartScreen.
     * @author (Adrian Espiritu)
     */
    public Difficulty(String where)
    {    
        //super(800, 450, 1, false); 
        prepare();
        
        if(where == "space"){
            addEasy1Button();
        }
        if(where == "cave"){
            addEasy2Button();
        }
        if(where == "lavacave"){
            addEasy3Button();
        }
        
        
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

        addObject(diff, getWidth()/2, getHeight()/2);
                      
        addObject(back, 750, 415);

    }
    
    public void addEasy1Button() {
        
        addObject(easy_1, getWidth()/2, getHeight()/2 - 50);
        addObject(normal_1, getWidth()/2, getHeight()/2 + 25);
        addObject(hard_1, getWidth()/2, getHeight()/2 + 105);
    
    }
    
    public void addEasy2Button() {
        
        addObject(easy_2, getWidth()/2, getHeight()/2 - 50);
        addObject(normal_2, getWidth()/2, getHeight()/2 + 25);
        addObject(hard_2, getWidth()/2, getHeight()/2 + 105);
    
    }
    
    public void addEasy3Button() {
        
        addObject(easy_3, getWidth()/2, getHeight()/2 - 50);
        addObject(normal_3, getWidth()/2, getHeight()/2 + 25);
        addObject(hard_3, getWidth()/2, getHeight()/2 + 105);
    
    }

}
