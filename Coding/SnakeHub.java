import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeHub here.
 * 
 * @author (Genesis) 
 * @version (11.07.2017)
 */
public class SnakeHub extends Actor
{
    /**
     * Act - do whatever the SnakeHub wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public SnakeHub()
    {
        //constructor to initialize everything related to player snake 
        //armour, score, health and background
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    public void Transparent()
    {
        //setting transparency and changing appearance changes as per requirement in game.
    }
    
    public void Score()
    {
        //show player score
        image.setColor(new Color(230,230,230));
        image.fillRect(5, 470, 100, 15);
        image.setColor(new Color(255,255,0));
        image.drawRect(5, 470, 99, 14);
        image.setColor(new Color(0,0,0));
        image.drawString("Xp: " + score, 10, 482);
    }
    
    public void Armour()
    {
        //player snake armour 
    }
    
    public void Health()
    {
        //show health
    }
    
    public void Background()
    {
        //background appearance
        image.setColor(new Color(255,255,255));
        image.fill();
        image.setColor(new Color(25,25,50));
        image.fillRect(0, 10, 110, 480);
    }
    
    
}
