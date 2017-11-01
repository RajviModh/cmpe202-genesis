import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
import java.util.*; 
import java.util.List; 
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
    public static int players;
    public static String World;
    public static boolean Muted;
    public static int volume;
    public String key;
    Snake player = new Snake();
    EnemySnake enemy = new EnemySnake();
    private GreenfootSound music = new GreenfootSound("background.mp3");
    

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
        Muted=false;
        prepareInitial();
    }
    
    private void prepareInitial(){
         SnakeBody.end_timer = 50;
         SnakeBody.shield = 0;
         Snake.Health = 100;
         EnemySnakeBody.armour = 0;
         Background.playerSize = 11;
         Background.foodSize=16;
         Image();
    }
    
    private void prepareSnakeGame()
    {
        Snake player = new Snake();
        EnemySnake enemy = new EnemySnake();
        List objects = getObjects(null);  
        removeObjects(objects); 
        SnakeBody.end_timer = 50;
        SnakeBody.shield = 0;
        
        Background.playerSize = 11;
        Background.foodSize=16;
        addObject(player, 400, 450);
        addObject(enemy, 400, 150);
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
       List objects = getObjects(null);  
            removeObjects(objects); 
            Paused=false;
            prepareInitial();
    }
    
        public void Image()
    {
        GreenfootImage image = new GreenfootImage(getWidth(), getHeight()); 
        image.clear();
        image.setColor(new Color(204,204,204));
        image.fill();
        setBackground(image);
    }
    
    public void Mute()
    {
        music.setVolume(volume);
        if("m".equals(key))  
        {
            if(Muted)
            {
                Muted=false;
            }else{
                Muted=true;
            }
        }
        if(Muted)
        {
            volume=0;
        }else{
            volume=50;
        }
    }
    
    public void addNew()
    {
        Snake player = new Snake();
        EnemySnake enemy = new EnemySnake();
        if("a".equals(key))
        {
            if(getObjects(Snake.class).isEmpty())
            {
                addObject(player, 400, 450);
            }
            if(getObjects(EnemySnake.class).isEmpty())
            {
                addObject(enemy, 400, 150);
            }
        }
    }
    
    
    
    
    
}
