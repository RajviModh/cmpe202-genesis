import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class greencar1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class greencar1 extends Enemy
{
    public greencar1()
    {    
        GreenfootImage image = getImage();  
        image.scale(100, 150);
        setImage(image);
    } 
    public void act() 
    {
    setLocation(getX()-7,getY()); 
    if(getX()==0) 
        {
            setLocation(1500,getY());
        } 
    }    
}
