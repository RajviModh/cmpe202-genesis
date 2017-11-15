import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class FramePerSec here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FramePerSec extends Actor
{
    public enum Mode {AVERAGE, REALTIME}   
    public static final Mode mode = Mode.AVERAGE;
    private static final Color textColor = Color.BLACK;
    private long acts_Count;
    private static final String prefix = "FramePerSec: ";
    private static final int updateFreq = 20;
    private int nCount;
    
    public FramePerSec()
    {
        acts_Count = 0;
        setImage(new GreenfootImage(150, 16));
        GreenfootImage image = getImage();
        updateImage("-");
    }
    
        public void FPSextremes()
    {
        nCount++;
        if(nCount>100)
        {

            
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public double getFPS()
    {
        return 0.00;
    }
    
     private final void updateImage(String value)
    {
        getImage().clear();
        GreenfootImage txt = new GreenfootImage(prefix +value, 16, textColor, null);
        getImage().drawImage(txt, 1, 1);
    }
}
