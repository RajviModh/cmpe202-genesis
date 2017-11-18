import greenfoot.*;

/**
 * Write a description of class Announcement1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Announcement3 implements Chain 
{
    // instance variables - replace the example below with your own
    
    public Announcement3()
    {
    }

   private Chain nextInChain;
 
    public void setNext(Chain c)
    {
        nextInChain = c;
    }
    
    public void start(Announcement ann)
    {
        if (ann.getStartCount()==100)
        {
            ann.sound = new GreenfootSound ("1.mp3");
            ann.sound.play();
            ann.start.clear();
            ann.start.drawString("1",15,40);
            ann.setImage(ann.start);
        }
         else
        {
            nextInChain.start(ann);
 
        }
        
    }
}
