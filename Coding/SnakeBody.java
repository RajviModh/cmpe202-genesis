import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; 
import java.awt.*; 
/**
 * Write a description of class SnakeBody here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeBody extends Actor
{
    // Defining initial variables 
    public static int end_timer;
    public int count;
    public static int shield;
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
        // Add your action code here.
    }    
    
    public void Snake_Attacked()
    {
        //To handle parameters when snake is attacked
    }
    
    public void Image()
    {
        //To draw snake based on shield's value
        if(shield==0)
        {}
        else if(shield==1)
        {}
        else if(shield==2)
        {}
        else if(shield==3)
        {}
        else if(shield==4)
        {}
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
    }
}
