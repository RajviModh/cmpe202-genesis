import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemoWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoWorld extends World
{

    /**
     * Constructor for objects of class DemoWorld.
     * 
     */
    public DemoWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        
        DemoBall demoball=new DemoBall();
        addObject(demoball,getWidth()-350, getHeight()-60);
        
        
    }
}
