import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MainScreen will hve options for selecting player options and difficulty level.
 * 
 * @author (Divyang Soni) 
 */
public class MainScreen extends Actor
{
    /**
     * Act - do whatever the MainScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage(800,600);
    public String message;
    
    //constructor
    public MainScreen()
    {
        sketch();
    }
    
    public void act() 
    {
        Background.World="MAINSCREEN";
        sketch();
        
    }    
    
    public void sketch()
    {
        
    }
    
    public void mouse_event()
    {
        //This class will have buttons for selecting game options
    }
}
