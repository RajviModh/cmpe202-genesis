import greenfoot.*;
import java.awt.Color;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blood here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blood extends Actor
{
    /**
     * Act - do whatever the Blood wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
      public int count;
    GreenfootImage blood = new GreenfootImage(Background.playerSize*2,Background.playerSize*2);

    public Blood()
    {
        draw();
    }
    
    public void act() 
    {
        // Add your action code here.
         if(Background.Paused)
        {
        }else{
            if(count>=1)
            {
                blood.scale(getImage().getWidth()-1,getImage().getHeight()-1);
            }
            if(getImage().getWidth()<=1 && getImage().getHeight()<=1)
            {
                getWorld().removeObject(this);
            }
            count++;
        }
    }    
    
    public void draw()
    {
        blood.clear();
        blood.setColor(new Color(102,0,0));
        blood.setTransparency(175);
        blood.fillOval(0,0,Background.playerSize*2,Background.playerSize*2);
        setImage(blood);
    }
}
