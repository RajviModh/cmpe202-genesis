import greenfoot.*;
import greenfoot.*;
import java.util.*; 
import java.awt.*; 
import java.util.Calendar; 
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemySnakeBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySnakeBody extends Actor
{
    /**
     * Act - do whatever the EnemySnakeBody wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public static int armour;
    GreenfootImage Body = new GreenfootImage(Background.playerSize, Background.playerSize);
    
   public void EnemySnakebody()
    {
        //Constructor creation for EnemySnakeBody
        DrawImages();
    }
    public void act() 
    {
        // Add your action code here.
    }

    public void DrawImages()
    {
        Body.setColor(new Color(255,0,0));
        switch(armour)
        {
            case 0:
            break;
            //Leather
            case 1:
            Body.setColor(new Color(146,123,81));
            break;
             //Bronze
            case 2:
            Body.setColor(new Color(140,120,83));
            break;
            //Silver
            case 3:
            Body.setColor(new Color(230,232,250));
            break;
            //Steel
            case 4:
            Body.setColor(new Color(84,84,84));
            break;
            //Gold
            case 5:
            Body.setColor(new Color(217,217,25));
            break;
            //Diamond
            case 6:
            Body.setColor(new Color(14,191,233));
            break;
            //Crystal
            case 7:
            Body.setColor(new Color(14,191,233));
            break;
    } 
   
}
}
