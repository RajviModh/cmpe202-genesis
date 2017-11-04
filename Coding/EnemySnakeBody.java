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
    public static int x=210;
    public static int y=210;
    public static int z=210;
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
             Body.setColor(new Color(210,210,210));
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
    if(killtimer>=125)
        {
            armour++;
            EnemySnake.Armour=1000;
            killtimer=killtimer-75;
            Announcement.statementQueue="ARMOUR UPGRADED!";
            Announcement.statementTimeQueue=100;
            Announcement.statementSizeQueue=40;
            Announcement.statementColorRQueue=210;
            Announcement.statementColorGQueue=0;
            Announcement.statementColorBQueue=0;
        }
    if(killtimer-count<=12)
        {
            if(resize<1)
            {
                resize=1;
            }
            resize--;
        }
    if(armour==0)
        {
            EnemySnake.armourEfficency=armourDiffrence+3;
            EnemySnake.Armour=1000;
            setImage(Body);
        }
    if(armour==1)
        {
            EnemySnake.armourEfficency=armourDiffrence*2+2;
            setImage(Body);
        }
    if(armour==2)
        {
            EnemySnake.armourEfficency=armourDiffrence*3+1;
            setImage(Body);
        }
    if(armour==3)
        {
            EnemySnake.armourEfficency=armourDiffrence*4;
            setImage(Body);
        }
        if(armour==4)
        {
            EnemySnake.armourEfficency=armourDiffrence*5;
            setImage(Body);
        }
        if(armour==5)
        {
            EnemySnake.armourEfficency=armourDiffrence*6;
            setImage(Body);
        }
        if(armour==6)
        {
            EnemySnake.armourEfficency=armourDiffrence*7;
            setImage(Body);
        }
        if(armour==7)
        {
            EnemySnake.armourEfficency=armourDiffrence*8;
            setImage(Body);
        }
        if(armour==8)
        {
            EnemySnake.armourEfficency=armourDiffrence*9;
            colorCount++;
        if(colorCount>=750)
            {
                x=Greenfoot.getRandomNumber(255);
                y=Greenfoot.getRandomNumber(255);
                z=Greenfoot.getRandomNumber(255);
                colorCount=0;
            }
            if(count%2==0)
            {
                Body.clear();
                Body.setColor(new Color(255,0,0));
                Body.fillOval(0, 0, Background.playerSize-2, Background.playerSize-2);
                Body.setColor(new Color(14,191,233));
                Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
                Body.setColor(new Color(x,y,z));
                Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            }else{
                Body.clear();
                Body.setColor(new Color(255,0,0));
                Body.fillOval(0, 0, Background.playerSize-2, Background.playerSize-2);
                Body.setColor(new Color(14,191,233));
                Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
                Body.setColor(new Color(x,y,z));
                Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            }
            setImage(Body);
        }
         if(armour>8)
        {
            armour=8;
        }
        if(killtimer>=125)
        {
            armour++;
            killtimer=killtimer-75;
        }
        if(killtimer-count<=Background.playerSize)
        {
            if(getImage().getHeight()<=1 && getImage().getWidth()<=1)
            {
                getWorld().removeObject(this);
            }else{
                getImage().scale(getImage().getHeight()-1, getImage().getWidth()-1);
            }
        }
        
       
}
}
