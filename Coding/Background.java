import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
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
        setPaintOrder(Snake.class, EnemySnake.class, SnakeBody.class, EnemySnakeBody.class);
        
        World=null;
        Paused=false;
        prepareInitial();
    }
    
    private void prepareInitial(){
         SnakeBody.end_timer = 50;
         SnakeBody.shield = 0;
         
         Background.playerSize = 11;
         Background.foodSize=16;
         
    }
    
    private void prepareSnakeGame()
    {
    // This method will be used to make initial setup of the game
    }
    
    
    public void act(){
        
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
    
        public void Image()
    {
        GreenfootImage image = new GreenfootImage(getWidth(), getHeight()); 
        image.clear();
        image.setColor(new Color(204,204,204));
        image.fill();
        setBackground(image);
    }
    
    
    
    
    
}
