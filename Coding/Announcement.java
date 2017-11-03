import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    }    
    
    public void initiate()
    {
        //This method will have code for initiating sounds
    }
}
