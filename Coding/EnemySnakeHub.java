import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
import java.awt.Font;  

/**
 * Write a description of class EnemySnakeHub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySnakeHub extends Actor
{
    /**
     * Act - do whatever the EnemySnakeHub wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static int score;
    public int trans;
    GreenfootImage image = new GreenfootImage(120,500);
    
    public EnemySnakeHub(){
    getImage().clear();
    Background();
    Score();
    setImage(image); 
    }
    
    public void act() 
    {
        // Add your action code here.
      Background.World="GAME";
        Build();
    }  
     public void Build()
    {
        
      getImage().clear();
      Background();
      Score();
    }
     public void Transparent()
    {
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
        image.setColor(new Color(230,230,230));
        image.fillRect(15, 470, 100, 15);
        image.setColor(new Color(255,255,0));
        image.drawRect(15, 470, 99, 14);
        image.setColor(new Color(0,0,0));
        image.drawString("Xp: " + score, 20, 482);
    }
      public void Background()
    {
        image.setColor(new Color(0,0,0));
        image.fill();
        image.setColor(new Color(25,25,50));
        image.fillRect(10, 10, 110, 480);
    }
}
