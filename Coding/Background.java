import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    public static int playerSize;
    public static int foodSize;
    public static boolean Paused;
    public static int start;
    public static int difficulty;
    public static String World;
    

    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        super(800, 600, 1,false); 
        start=0;
        World=null;
        Paused=false;
        
    }
    
    private void prepareSnakeGame()
    {
    // This method will be used to make initial setup of the game
    }
    
    
    public void react(){
        
        if(start==1)
        {
            prepareSnakeGame();
            start=0;
        }
    }
    
    public void Pause(){
        String key = Greenfoot.getKey();  
        if ("p".equals(key))  
        {
            if(Paused)
            {
                Paused=false;
            }else{
                Paused=true;
            }
        }
        
        // logic to pause the game should bewritten here
        
    }
    
    public void reset()
    { 
       // method to reset the game
    }
    
    
    
    
    
    
}
