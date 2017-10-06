import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class crazycar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class crazycar extends Actor
{
    public crazycar()
    {    
        GreenfootImage image = getImage();  
        image.scale(150, 100);
        setImage(image);
    } 
    public void act() 
    {
    if(Greenfoot.isKeyDown("right"))
      {
        setLocation(getX()+4,getY());
       }
    if(Greenfoot.isKeyDown("left"))
    {
        setLocation(getX()-4,getY());
    }
    if (Greenfoot.isKeyDown("down"))
      {
          setLocation(getX(),getY()+4); 
        }
    if (Greenfoot.isKeyDown("up"))
      {
         setLocation(getX(),getY()-4);  
        }
    if(isTouching(Enemy.class)){
            getWorld().addObject(new ledakan(),getX(),getY());
            ((MyWorld)getWorld()).selesai();
            greencar1 gc = new greencar1();
            getWorld().removeObject(gc);
            redcar1 rc = new redcar1();
            getWorld().removeObject(rc);
            bluecar1 bc = new bluecar1();
            getWorld().removeObject(bc);
            getWorld().removeObject(this);
        }
    }    
}









