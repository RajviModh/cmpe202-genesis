import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public SnakeBody()
    {
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
}
