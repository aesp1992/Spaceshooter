import greenfoot.*; // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * The ScoreBoard is used to display results as some text and several numbers.
 * @author (Aziz Khan)
 */
public class ScoreBoard extends Actor
{
    //public static final float FONT_SIZE = 19.0f;
    //public static final int WIDTH = 200;
    //public static final int HEIGHT = 40;
    //String prefix = "Score: ";
    int score = 0;
            
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); 
    /**
      * Update the score board.
      */
    public ScoreBoard()
    {
        update();
    }

    public void act() {
        update();
    }

    public void addScore(int whathit) {

        score = score + whathit;
    }
    
    /**
     * Make the score board image.
     */
    private void update()
    {
        //image.setColor(new Color(255,255,255, 128));
        //image.fillRect(0, 0, WIDTH, HEIGHT);
        //image.setColor(new Color(0, 0, 0, 128));
        //image.fillRect(2, 2, WIDTH-4, HEIGHT-4);
        //Font font = image.getFont();
        //font = font.deriveFont(FONT_SIZE);
        //image.setFont(font);
        //image.setColor(Color.YELLOW);
        //image.drawString(prefix + score, 10, 25);
        //
        
        setImage(new GreenfootImage("Score: " + score, 20, Color.WHITE, TRANSPARENT));
        
    }
    
    /**
     * Set Score to a specific value (Used for level switching) 
     * @author (Adrian Espiritu)
     */
    public void setScore(int value){
        
        score = value;
        
    }   
    
    /**
     * Returns score value
     * @author (Adrian Espiritu)
     */
    public int getScore() { 
        return score; 
    }
}