import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;
/**
 * Write a description of class Announcer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Announcement extends Actor 
{
    //declaring initial variables
   
    public static String statement;
    public static String statementQueue;
    public static int statementTime;
    public static int statementTimeQueue;
    public static int statementColor;
    public static int statementColorQueue;
    public static int statementSize;
    public static int statementSizeQueue;
    public static int statementColorR;
    public static int statementColorRQueue;
    public static int statementColorG;
    public static int statementColorGQueue;
    public static int statementColorB;
    public static int statementColorBQueue;
    public static int statementPriority;
    public static int statementPriorityQueue;
    public int statementTimer;
    public static int initial;
    public int startCount=0;
    GreenfootImage start = new GreenfootImage(50,50);
    GreenfootSound sound;
    
    //Constructor for announcement class
    public Announcement()
    {
        getImage().clear();
        initial=0;
    }
    
    
    /**
     * Act - do whatever the Announcer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        statementTimer++;
        if(statementTimer>=statementTime)
        {
            initiate();
        }
        if(statementPriorityQueue<statementPriority)
        {
            initiate();
        }
        if(initial==1)
        {
            start();
        }else{
            Perform();
        }
        sound.setVolume(Background.volume);
    }    
    
    public void initiate()
    {
        //This method will have code for initiating sounds
        statement=statementQueue;
        statementQueue=null;
        statementTime=statementTimeQueue;
        statementTimeQueue=0;
        statementSize=statementSizeQueue;
        statementSizeQueue=0;
        statementColorR=statementColorRQueue;
        statementColorRQueue=0;
        statementColorG=statementColorGQueue;
        statementColorGQueue=0;
        statementColorB=statementColorBQueue;
        statementColorBQueue=0;
        statementPriority=statementPriorityQueue;
        statementPriorityQueue=1000;
        statementTimer=0;
    }
    
    public void Perform()
    {
      // this method will have code for announcements
      if(statement!=null && statementTime!=0 && statementSize!=0)
        {
            setImage(new GreenfootImage(statement, statementSize, new Color(statementColorR, statementColorG, statementColorB), new Color(0, 0, 0, 0)));
        }else{
            getImage().clear();
        }
    }
    
   public int getStartCount()
   {
       return startCount;
    }
    
   public void start()
    {
       Background.Paused=true;
       //startCount++;
       Font font = new Font("Calibri",Font.PLAIN, 40);
       start.setFont(font);
       start.setColor(new Color(210,0,0));
       
       //
       
       /*if(startCount==1)
        {
            //code to add different sounds
            sound = new GreenfootSound ("3.mp3");
            sound.play();
            start.clear();
            start.drawString("3",15,40);
            setImage(start);
        }
        if(startCount==50)
        {
            sound = new GreenfootSound ("2.mp3");
            sound.play();
            start.clear();
            start.drawString("2",15,40);
            setImage(start);
        }
        if(startCount==100)
        {
            sound = new GreenfootSound ("1.mp3");
            sound.play();
            start.clear();
            start.drawString("1",15,40);
            setImage(start);
        }*/
        
        if(startCount==150)
        {
            Background.Paused=false;
            start.clear();
            setImage(start);
            initial=0;
        }
    }
}
