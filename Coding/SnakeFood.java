import greenfoot.*;
import java.awt.Color;  
import java.awt.Font;  
import java.util.Calendar;  

public class SnakeFood extends Actor
{

    public static int x;
    public static int y;
    int a;

    public SnakeFood()
    {
        draw();
    }

    public void act() 
    {
        if(Background.Paused)
        {
        }else{
            Snake snake = (Snake) getOneIntersectingObject(Snake.class);
            EnemySnake enemy = (EnemySnake) getOneIntersectingObject(EnemySnake.class);
            SnakeBody snakebody = (SnakeBody) getOneIntersectingObject(SnakeBody.class);
            EnemySnakeBody enemysnakebody = (EnemySnakeBody) getOneIntersectingObject(EnemySnakeBody.class);
            if (snakebody != null) {
                setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()-300)+150, Greenfoot.getRandomNumber(getWorld().getHeight()-300)+150);
            }
            if (enemysnakebody != null) {
                setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()-300)+150, Greenfoot.getRandomNumber(getWorld().getHeight()-300)+150);
            }
            if (snake != null || enemy != null) {
                SnakeFood snakefood = new SnakeFood();
                getWorld().addObject(snakefood, Greenfoot.getRandomNumber(getWorld().getWidth()-300)+150, Greenfoot.getRandomNumber(getWorld().getHeight()-300)+150);
                getWorld().removeObject(this);
            }
        }
    }

    public void draw()
    {
        GreenfootImage image = new GreenfootImage(Background.foodSize,Background.foodSize); 
        image.setColor(Color.RED);
        image.fillOval(0,0,Background.foodSize,Background.foodSize);
        image.setColor(Color.BLACK);
        image.drawOval(0,0,Background.foodSize-1,Background.foodSize-1);
        setImage(image); 
    }

    public void locationCheck()
    {
    }
}
