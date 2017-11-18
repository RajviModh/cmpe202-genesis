import greenfoot.*;

/**
 * Write a description of class Announcement1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class startGame implements Chain 
{
    // instance variables - replace the example below with your own
    
    public startGame()
    {
    }

   private Chain nextInChain;
 
    public void setNext(Chain c)
    {
        nextInChain = c;
    }
    
    public void start(Announcement ann)
    {
        if (ann.getStartCount()==150)
        {
            Background.Paused=false;
            ann.start.clear();
            ann.setImage(ann.start);
            ann.initial=0;
         
        }
        else
        {
            
        }
    }
}
