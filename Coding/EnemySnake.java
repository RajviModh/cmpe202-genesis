import greenfoot.*;
import java.awt.Color;  
import java.awt.Font;  
import java.util.Calendar;
import java.lang.Math;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemySnake extends Actor
{
    // instance variables - replace the example below with your own
    private int x;
    public static int PlayerIsActive=100;
    public int absoluteDiff;
    public int speed=5;
    public String target;
    public int angleDiff;
    public static int offset;
    public static int Health;
    public static int Armour;
    public static int armourCount;
    public static int armourEfficency;
    public boolean aroundfood;
    public int foodCount;
    public int ranX;
    public int ranY;

    /**
     * Constructor for objects of class Enemy
     */
    public EnemySnake()
    {
       //Used to draw the Enemies image
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public void act(){
    //main method which calls other methods to perform various operations
    
    }
    public void controls()
    {
        //Used to control the enemy snake
        // put your code here
        move(speed);
        PlayerIsActive--;
        //Detect player interaction
        if(Background.players==2)
        {
            if(Greenfoot.isKeyDown("D"))
            {
                turn(5);
                PlayerIsActive=100;
            }
            if(Greenfoot.isKeyDown("A"))
            {
                turn(-5);
                PlayerIsActive=100;
            }
        }
       
    }
      public void aroundFood()
    {
        
        
    }
    
     public void eat()
    {
        //Called when the snake eats the food
    }
    
     public void findTarget()
    {
        //Determine the Target Food 
       
    }
    
    public void difficulty()
    {
        if(Background.difficulty==1)
        {
            offset=50;
        }
        if(Background.difficulty==2)
        {
            offset=35;
        }
        if(Background.difficulty==3)
        {
            offset=1;
        }
    }
    
     public boolean isFoodPresent()
    {
        //Detect if the Enemy is within the location it beleives to be the food and if it intersects with the food

        //if (absoluteDiff <=25 && food!=null)

        if (absoluteDiff <=25)
        {
            return true;
        }
        return false;

    }
    public void faceTarget()
    {
        if(target!=null)
        {   
            //Rationalize the needed angle
            if(angleDiff<0)
            {
                angleDiff=angleDiff+360;
            }
            if(angleDiff>360)
            {
                angleDiff=angleDiff-360;
            }
            //Turn to the needed angle
            if(angleDiff>180)
            {
                turn(5);
            }else{
                if(angleDiff<=180 && angleDiff!=0)
                {
                    turn(-5);
                }
            } 
        }
    }    
    
    public void Life()
    {
       //Handles the XP points, health and life bars 
    }
    
    public void Location()
    {
        //Move the snake to the inverse side of the screen if on edge
       if(getX()>100)
        {
            setLocation(0,getY());
        }
        if(getX()<0)
        {
            setLocation(800,getY());
        }
        if(getY()>400)
        {
            setLocation(getX(),0);
        }
        if(getY()<0)
        {
            setLocation(getX(),600);
        }
     }
   
}
