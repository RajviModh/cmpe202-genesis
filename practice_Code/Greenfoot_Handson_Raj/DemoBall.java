import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DemoBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DemoBall extends Actor
{
    int y=0;
    int x=0;
    int gravity=2;
    /**
     * Act - do whatever the DemoBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    DemoBall()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()/6, image.getHeight()/6);
        setImage(image);
    }
    public void act() 
    {
        
       
        setLocation(getX()+x,getY()+y);
        int halfHeight = getImage().getHeight()/2;
        int halfWidth=getImage().getWidth()/2;
        int maxY = getWorld().getHeight()-halfHeight;
        if (getY() > maxY) setLocation(getX(), maxY);
        
       
        if(Greenfoot.isKeyDown("up")==true)
        {
            y=-25;
            //move(-25);
        }
        if(Greenfoot.isKeyDown("left")==true)
        {
           // x=-10;
            move(-10);
        }
        if(Greenfoot.isKeyDown("right")==true)
        {
            //x=10;
            move(10);
        }
        
        
        y=y+gravity;
    }    
}
