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
        
    }

     
}
