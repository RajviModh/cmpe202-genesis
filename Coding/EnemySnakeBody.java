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
    public static int killtimer;
    public int count;
    public int resize=Background.playerSize;
    public static int armour;
    private int size;
    public int bloodcount;
    public static int colorCount;
    public int armourDiffrence;
    GreenfootImage Body = new GreenfootImage(Background.playerSize, Background.playerSize);
    
   public void EnemySnakebody()
    {
        //Constructor creation for EnemySnakeBody
        DrawImages();
        Image();
    }
    public void act() 
    {
       
        if(Background.Paused)
        {
        }else{
            Image();
        } 
    }

    public void DrawImages()
    {
        Body.setColor(new Color(255,0,0));
        Body.fillOval(0, 0, Background.playerSize, Background.playerSize);
        switch(armour)
        {
            case 0:
            break;
            //Leather
            case 1:
            Body.setColor(new Color(146,123,81));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
             //Bronze
            case 2:
            Body.setColor(new Color(140,120,83));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
            //Silver
            case 3:
            Body.setColor(new Color(230,232,250));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
            //Steel
            case 4:
            Body.setColor(new Color(84,84,84));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
            //Gold
            case 5:
            Body.setColor(new Color(217,217,25));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
            //Diamond
            case 6:
            Body.setColor(new Color(14,191,233));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
            //Crystal
            case 7:
            Body.setColor(new Color(14,191,233));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            break;
    } 
     
}


public void Image()
{
    if(Background.players==1)
        {
    switch (Background.difficulty)
            {
                case 1:
                armourDiffrence=1;
                break;
                case 2:
                armourDiffrence=2;
                break;
                case 3:
                armourDiffrence=3;
                break;
            }
    }
    else{
            armourDiffrence=2;
        }
}
}
