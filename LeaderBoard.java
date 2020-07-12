import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

/**
 * Write a description of class A here.
 * 
 * @author (Aziz) 
 * @version (2)
 */
public class LeaderBoard extends Menu implements Serializable
{
    private static final Color TRANSPARENT = new Color(0, 0, 0, 0); 

    //private score class
    class Score implements Comparable <Score>, Serializable {
        String name;
        int score;
        public Score(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() { 
            return score; 
        }

        public String getName(){
            return name;
        }

        public int compareTo(Score o) {
            int p1 = this.getScore();
            int p2 = o.getScore();
            
            if (p1 > p2) {
                return -1;
            } else if (p1 < p2){
                return 1;
            } else {
                return 0;
            }
        }

    }

    ArrayList<Score> scores = new ArrayList<Score>();

    public LeaderBoard(){        

        img1 = new Background(1);
        addObject(img1, getWidth()/2, getHeight()/2);

        img2 = new Background(1);
        addObject(img2, getWidth() + getWidth()/2, getHeight()/2);

        addObject(leaderboard_ph, getWidth()/2, getHeight()/2);

        load();            

        drawBoard();

    }

    public void drawBoard(){
        int top = 120;

        for(Score s : scores){
            //setImage(new GreenfootImage(s.getName(), 50, Color.YELLOW, TRANSPARENT, top));
            //showText(s.getName(), 100, top);
            // showText("" + s.getScore(), 150, top); 
            addObject(new ScoreRow(s.getName(), s.getScore()), 455, top);
            top += 33;

        }
        addObject(new Back(), 750, 415);
    }

    /**
     * Act - do whatever the A wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //drawBoard();
        img1.slideAcross(2);
        img2.slideAcross(2);
    }    

    public void addScore(int score) {
        String login = Greenfoot.ask("Enter Your Name");

        scores.add(new Score(login, score));
        Collections.sort(scores);
        if(scores.size() == 11) {
            scores.remove(10);
        }

        save();
        //drawBoard();
    }

    public void load(){
        try {
            FileInputStream fileIn = new FileInputStream("ScoreBoard.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            scores = (ArrayList<Score>) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i) {
            //System.out.println(i);
            return;

        }catch(ClassNotFoundException c) {
            return;
        }
    }

    public void save(){
        try {
            FileOutputStream fileOut =
                new FileOutputStream("ScoreBoard.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(scores);
            out.close();
            fileOut.close();
        }catch(IOException i) {
            //System.out.println(i);
            i.printStackTrace();
        }
    }
}
