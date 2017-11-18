import greenfoot.*; 
import java.awt.Color; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Prototype here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Prototype extends Actor implements Cloneable
{
    /**
     * Act - do whatever the Prototype wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     GreenfootImage image = new GreenfootImage(24,24); 
     public static int SnakeIsActive;
     public static int Armour;
     public static int armourCount;
     public static int armourEfficency;
     public int angleDiff;
     public String target;
    
    public Prototype()
    {
        int[] xs = {0, 24, 0, 6};  
        int[] ys = {0, 12, 24, 12}; 
        image.fillPolygon(xs, ys, 4);
        image.setColor(Color.WHITE);
        image.fillOval(10, 7, 3, 4);
        image.fillOval(10, 13, 3, 4);
        setImage(image); 
        SnakeIsActive=100;
        armourEfficency=0;
        Armour=0;
        armourCount=0;
        
    }
    
    public void Location(){
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
    
   
    
    public Object clone() {
      Object clone = null;
      
      try {
         clone = super.clone();
         
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      
      return clone;
   }
}
