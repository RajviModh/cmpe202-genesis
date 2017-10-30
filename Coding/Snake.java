import greenfoot.*;
import java.awt.Color;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (Genesis) 
 * @version (10.26.17)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage(24,24); 
    GreenfootSound sound;
    
    public int rotation=5;
    public int speed=5;
    
    public int addCounter;
    public int addTimer=2;
    
    public int sameActionCountLeft;
    public int sameActionCountRight;
    
    public int spacecount=0;
    
    public int leftTurn = 9;
    public int rightTurn = 9;
    
    public int foodEaten=0;
    
    public static int PlayerIsActive;
    
    public static int Health;
    public int Primary;
    
    public int Regeneration;
    public static int Armour;
    
    public String target;
    
    public int yDiff;
    public int xDiff;
    public int locationyDiff; 
    
    public int absoluteDiff;
    
    public int present;
    
    public int angleDiff;
    public double angle;
    
    public static int armourEfficency;
    public static int armourCount;
    
    public int nullY;
    public int nullX;
    public int killNullCount;
    
    //initialize player in game
    public Snake()  
    {
        image.setColor(Color.BLACK);
        int[] xs = {0, 24, 0, 6};  
        int[] ys = {0, 12, 24, 12}; 
        image.fillPolygon(xs, ys, 4);
        image.setColor(Color.WHITE);
        image.fillOval(10, 7, 3, 4);
        image.fillOval(10, 13, 3, 4);
        setImage(image); 
    }
    
    //to be implemented for checking state of game whether paused or on
    public void act() 
    {
        // Add your action code here.
        if(Background.Paused)
        {
            if(Background.World!="GAME")
            {
                mainMenu();
            }
        }else{
            if(Background.World=="GAME")
            {
                controls();
                eat();
                Location();
                bodyControl();
                foodPresent();
                Life();
            }else{
                mainMenu();
            }
        }
    } 
    
    public void mainMenu()
    {
        
    }
    
    //logic for snake eating food and changes to be made afterwards
    public void eat()
    {

    }
    
    //for checking presence of food
    public boolean foodPresent()
    {
        return true ;
    }

    //logic for health checking and regaining or losing based on position
    //and enemy interaction.
    public void Life()
    {
    
    }

    //logic for controlling the snake
    public void controls()
    {
    
    }
    
    //for adding segments on the timer
    public void bodyControl()
    {
        
    }
    
    // logic for determining edges and set appropriate changes
    public void Location()
    {
        //to move snake to other side of screen if it hits the edge
         if(getX()>800)
        {
            setLocation(0,getY());
        }
        if(getX()<0)
        {
            setLocation(800,getY());
        }
        if(getY()>600)
        {
            setLocation(getX(),0);
        }
        if(getY()<0)
        {
            setLocation(getX(),600);
        }
    }

     
}
