import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
import java.util.*; 
import java.util.List; 
/**
 * Write a description of class Background here.
 * 
 * @author (Divyang Soni) 
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
        setPaintOrder(Snake.class, EnemySnake.class, SnakeBody.class, EnemySnakeBody.class, SnakeFood.class, SnakeHub.class);
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
         EnemySnakeBody.killtimer = 50;
         EnemySnake.Health=100;
         
         Background.playerSize = 11;
         Background.foodSize=16;
         
         MainScreen mainscreen = new MainScreen();
         addObject(mainscreen, 400, 300);
         FramePerSec fps = new FramePerSec();
         addObject(fps, 80, 10);
         Image();
    }
    
    private void prepareSnakeGame()
    {
        Snake player = new Snake();
        EnemySnake enemy = new EnemySnake();
        Announcement announce = new Announcement();
   
        SnakeFood sfood = new SnakeFood();
        FramePerSec fps = new FramePerSec();
        SnakeHub snakehub = new SnakeHub();
        EnemySnakeHub enemyhub = new EnemySnakeHub();
        
        List objects = getObjects(null);  
        removeObjects(objects); 
        
        SnakeBody.end_timer = 50;
        SnakeBody.shield = 0;
        Snake.Health = 100;
        
        EnemySnakeBody.killtimer=50;
        EnemySnakeBody.armour=0;
        EnemySnake.Health=100;
        Background.playerSize = 11;
        Background.foodSize=16;
        SnakeHub.score=0;
        EnemySnakeHub.score=0;
        
        addObject(player, 400, 450);
        addObject(enemy, 400, 150);
        addObject(announce, 400, 300);
        addObject(sfood, 600, 300);
        addObject(snakehub, 60, 300);
        addObject(enemyhub, 740, 300);
        addObject(fps, 80, 10);
        Announcement.initial=1;
        
    // This method will be used to make initial setup of the game
    }
    
    
    public void act(){
        
        if(start==1)
        {
            prepareSnakeGame();
            start=0;
        }
        Mute();
        music.playLoop();
        reset();
        announce();
        Pause();
    }
    
    public void Pause(){
        key = Greenfoot.getKey();  
        if ("p".equals(key))  
        {
            if(Paused)
            {
                Paused=false;
            }else{
                Paused=true;
            }
        }
         if(Paused)
        {
            Announcement.statementTime=0;
            Announcement.statementQueue="Game Paused";
            Announcement.statementTimeQueue=1;
            Announcement.statementSizeQueue=48;
            Announcement.statementColorRQueue=210;
            Announcement.statementColorGQueue=0;
            Announcement.statementColorBQueue=0;
        }
        
    }
    
    public void reset()
    { 
       if("r".equals(key))
       {
            List objects = getObjects(null);  
            removeObjects(objects); 
            Paused=false;
            prepareInitial();
       }
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
    public void announce()
    {
        if(World=="GAME")
        {
            if(getObjects(Snake.class).isEmpty())
            {
                Announcement.statementQueue="Red Snake Wins!";
                Announcement.statementTimeQueue=100;
                Announcement.statementSizeQueue=48;
                Announcement.statementColorRQueue=210;
                Announcement.statementColorGQueue=0;
                Announcement.statementColorBQueue=0;
                if ("v".equals(key))  
                {
                    SnakeBody.end_timer=50;
                    SnakeBody.shield=0;
                    Snake.Health=100;
                    addObject(player, 400, 450);
                }
            }
            if(getObjects(EnemySnake.class).isEmpty())
            {
                Announcement.statementQueue="Black Snake Wins!";
                Announcement.statementTimeQueue=100;
                Announcement.statementSizeQueue=48;
                Announcement.statementColorRQueue=0;
                Announcement.statementColorGQueue=0;
                Announcement.statementColorBQueue=0;
                if ("v".equals(key))  
                {
                    EnemySnakeBody.killtimer=50;
                    EnemySnakeBody.armour=0;
                    EnemySnake.Health=100;
                    addObject(enemy, 400, 150);
                }
            }
        }
    }
    
    
    
    
}
