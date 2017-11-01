import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 
import java.awt.*; 
/**
 * @author (Neha Jethani) 
 */
public class SnakeBody extends Actor
{
    // Defining initial variables 
    public static int end_timer;
    public int count;
    public int new_size=Background.playerSize; 
    public static int shield;
    private int size;
    public static int shade_count;
    public static int x=210;
    public static int y=210;
    public static int z=210;
    public int shield_diffrence =2;
    GreenfootImage defaultBody = new GreenfootImage(Background.playerSize, Background.playerSize); 
    GreenfootImage Body = new GreenfootImage(Background.playerSize, Background.playerSize); 

    
    public SnakeBody()
    {
        BodyPaint();
        Image();
    }
    
    public void action() 
    {
        //Check whether background is not paused and then only proceed
        if(!Background.Paused)
        {
            Image();
            Snake_Attacked();
            count++;
        }
    }    
    
    public void Snake_Attacked()
    {
        //To handle parameters when snake is attacked
    }
    
    public void Image()
    {
        //To draw snake based on shield's value
        if(shield==0)
        {
            Snake.armourEfficency=shield_diffrence+3;
            Snake.Armour = 1000;
            setImage(Body);
        }
        else if(shield==1)
        {
            Snake.armourEfficency=shield_diffrence*2+2;
            setImage(Body);
        }
        else if(shield==2)
        {
            Snake.armourEfficency=shield_diffrence*3+1;
            setImage(Body);
        }
        else if(shield==3)
        {
            Snake.armourEfficency=shield_diffrence*4;
            setImage(Body);
        }
        else if(shield==4)
        {
            Snake.armourEfficency=shield_diffrence*5;
            setImage(Body);
        }
        else if(shield==5)
        {
            Snake.armourEfficency=shield_diffrence*6;
            setImage(Body);
        }
        else if(shield==6)
        {
            Snake.armourEfficency=shield_diffrence*7;
            setImage(Body);
        }
        else if(shield==7)
        {
            Snake.armourEfficency=shield_diffrence*8;
            setImage(Body);
        }
        if(end_timer>=120)
        {
            shield++;
            end_timer=end_timer-80;
        }
        
    }
    
    public void BodyPaint()
    {
       //This class gives different size to snake according to shield's value
       Body.setColor(new Color(0,0,0));
       Body.fillOval(0, 0, Background.playerSize, Background.playerSize);
       
       if(shield==1)
        {  
            Body.setColor(new Color(146,123,81));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
        }
        else if(shield==2)
        {
            Body.setColor(new Color(140,120,83));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
        }
       else if(shield==3)
       {
           Body.setColor(new Color(230,232,250));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
       }
       else if(shield==4)
       {
           Body.setColor(new Color(84,84,84));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
       }
       else if(shield==5)
       {
            Body.setColor(new Color(217,217,25));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
       }
       else if(shield==6)
       {
           Body.setColor(new Color(14,191,233));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
        }
        else if(shield==7)
        {
            Body.setColor(new Color(14,191,233));
            Body.drawOval(0, 0, Background.playerSize-2, Background.playerSize-2);
            Body.setColor(new Color(210,210,210));
            Body.drawOval(0, 0, Background.playerSize-1, Background.playerSize-1);
        }
       
    }
}
