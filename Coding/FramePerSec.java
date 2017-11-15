import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class FramePerSec here.
 * 
 * @author (Team Genesis) 
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
    private long prevTime;
    private double frames;
    private double maxFrames;
    private double minFrames;
    
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
               if(frames>maxFrames || maxFrames==0)
            {
                maxFrames=frames;
            }
            if(frames<minFrames || minFrames==0)
            {
                minFrames=frames;
            }
            
        }
    }
    
    private void setFPS(Long value)
    {
        frames = value;
        updateImage(value.toString());
    }
    
    private void setFPS(Double value)
    {
        frames = value;
        updateImage(value.toString());
    }
    
    public void act() 
    {
        // Add your action code here.
        acts_Count++;
        if (mode == Mode.REALTIME) {
            long gap = System.currentTimeMillis() - prevTime;
            if(gap != 0 && acts_Count%updateFreq == 0) {
                acts_Count = 0;
                setFPS((1.0 /gap) *1000.0);
            }
            prevTime = System.currentTimeMillis();
        } else if (mode == Mode.AVERAGE) {
            long curTime = System.currentTimeMillis();
            if(curTime >= prevTime +1000) {
                setFPS(acts_Count);
                prevTime = curTime;
                acts_Count = 0;
            }
        }
        FPSextremes();
    }    
    
    public double getFPS()
    {
        return frames;
    }
    
     private final void updateImage(String value)
    {
        getImage().clear();
        GreenfootImage txt = new GreenfootImage(prefix +value, 16, textColor, null);
        getImage().drawImage(txt, 1, 1);
    }
}
