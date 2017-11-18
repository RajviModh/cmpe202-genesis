import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class SnakeHub here.
 * 
 * @author (Genesis) 
 * @version (11.07.2017)
 */
public class SnakeHub extends Actor
{
    /**
     * Act - do whatever the SnakeHub wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int score;
    public int trans;
    GreenfootImage image = new GreenfootImage(120,500);
    
    public SnakeHub()
    {
        //constructor to initialize everything related to player snake 
        //armour, score, health and background
        getImage().clear();
        Background();
        Health();
        Armour();
        Score();
        setImage(image); 
    }
    
    public void Build()
    {
        getImage().clear();
        Background();
        Health();
        Transparent();
        Armour();
        Score();
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
        Background.World="GAME";
        Build();
    }
    
    public void Transparent()
    {
        //setting transparency and changing appearance changes as per requirement in game.
        Snake player = (Snake) getOneIntersectingObject(Snake.class);
        EnemySnake enemy = (EnemySnake) getOneIntersectingObject(EnemySnake.class);
        SnakeBody playerbody = (SnakeBody) getOneIntersectingObject(SnakeBody.class);
        EnemySnakeBody enemybody = (EnemySnakeBody) getOneIntersectingObject(EnemySnakeBody.class);
        SnakeFood food = (SnakeFood) getOneIntersectingObject(SnakeFood.class);
        if(playerbody!=null || enemybody!=null)
        {
            trans=200;
        }
        if(food!=null || player!=null || enemy!=null)
        {
            trans=100;
        }
        if(food==null && player==null && enemy==null && playerbody==null && enemybody==null)
        {
            trans=255;
        }
        image.setTransparency(trans);
    }
    
    public void Score()
    {
        //show player score
        image.setColor(new Color(230,230,230));
        image.fillRect(5, 470, 100, 15);
        image.setColor(new Color(255,255,0));
        image.drawRect(5, 470, 99, 14);
        image.setColor(new Color(0,0,0));
        image.drawString("Xp: " + score, 10, 482);
    }
    
    public void Armour()
    {
        //player snake armour 
        if(SnakeBody.shield>0)
        {
            image.setColor(new Color(230,230,230));
            image.drawString("Armour", 30, 65);
            switch(SnakeBody.shield)
            {
                case 1:
                image.setColor(new Color(146,123,81));
                break;
                case 2:
                image.setColor(new Color(140,120,83));
                break;
                case 3:
                image.setColor(new Color(230,232,250));
                break;
                case 4:
                image.setColor(new Color(84,84,84));
                break;
                case 5:
                image.setColor(new Color(217,217,25));
                break;
                case 6:
                image.setColor(new Color(14,191,233));
                break;
                case 7:
                image.setColor(new Color(160,210,210));
                break;
                case 8:
                image.setColor(new Color(SnakeBody.x,SnakeBody.y,SnakeBody.z));
                break;
            }
            image.fillRect(5, 70, Snake.Armour/10, 15);
            image.setColor(Color.black);
            image.drawRect(5, 70, 99, 14);
        }
    }
    
    public void Health()
    {
        //show health
        image.setColor(new Color(230,230,230));
        image.drawString("Health", 30, 30);
        if(Snake.Health>70)
        {
            image.setColor(new Color(83,232,59));
        }
        if(Snake.Health<40)
        {
            image.setColor(new Color(255,34,0));
        }
        if(Snake.Health>=40&&Snake.Health<=70)
        {
            image.setColor(new Color(255,231,0));
        }
        image.fillRect(5, 35, Snake.Health, 15);
        image.setColor(Color.black);
        image.drawRect(5, 35, 99, 14);
    }
    
    public void Background()
    {
        //background appearance
        image.setColor(new Color(255,255,255));
        image.fill();
        image.setColor(new Color(25,25,50));
        image.fillRect(0, 10, 110, 480);
    }
    
    
}
