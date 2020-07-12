import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreRow here.
 * 
 * @author (Aziz) 
 * @version (2)
 */
public class ScoreRow extends Actor
{

    public ScoreRow(String name, int score)       
    {      
        GreenfootImage img = new GreenfootImage (500, 25); 
        
        float fontSize = 20f; //set it to what ever your need
        Font font = img.getFont().deriveFont(fontSize);
        img.setFont(font);
        img.setColor(Color.WHITE);    
        img.drawString(name, 0, 20); 
        img.drawString(""+score, 380, 20); 
        setImage(img);  
        
    }

    public void act() 
    {

    }    

}
