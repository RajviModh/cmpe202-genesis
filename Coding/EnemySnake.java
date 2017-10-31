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
        if(Back.players==2)
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
    
     public boolean isFoodPresent()
    {
        //Detect if the Enemy is within the location it beleives to be the food and if it intersects with the food

        if (absoluteDiff <=25 && food!=null)
        {
            return true;
        }
        return false;

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
