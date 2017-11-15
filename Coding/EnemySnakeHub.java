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
    Armour();
    Health();
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
      Health();
      Transparent();
      Armour();
      Score();
      setImage(image);
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
    public void Health()
    {
        image.setColor(new Color(230,230,230));
        image.drawString("Health", 40, 30);
        if(EnemySnake.Health>70)
        {
            image.setColor(new Color(83,232,59));
        }
        if(EnemySnake.Health<40)
        {
            image.setColor(new Color(255,34,0));
        }
        if(EnemySnake.Health>=40&&EnemySnake.Health<=70)
        {
            image.setColor(new Color(255,231,0));
        }
        image.fillRect(15, 35, EnemySnake.Health, 15);
        image.setColor(Color.black);
        image.drawRect(15, 35, 99, 14);
    }
      public void Background()
    {
        image.setColor(new Color(0,0,0));
        image.fill();
        image.setColor(new Color(25,25,50));
        image.fillRect(10, 10, 110, 480);
    }
    public void Armour()
    {
        if(EnemySnakeBody.armour>0)
        {
            image.setColor(new Color(230,230,230));
            image.drawString("Armour", 40, 65);
            switch(EnemySnakeBody.armour)
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
                image.setColor(new Color(EnemySnakeBody.x,EnemySnakeBody.y,EnemySnakeBody.z));
                break;
            }
            image.fillRect(15, 70, Snake.Armour/10, 15);
            image.setColor(Color.black);
            image.drawRect(15, 70, 99, 14);
        }
    }
}
