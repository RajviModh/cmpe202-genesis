import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lobster  extends Animal
{
    /**
     * Act - do whatever the lobster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if (canSee(Crab.class))
           { 
               eat(Crab.class);
               Greenfoot.playSound("au.wav");
               getWorld().addObject(new gameover(), 430, 430);
               Greenfoot.stop();
            }
            
       
        move();
      
       if (atWorldEdge()) {turn(95);}
      
    }    
    
}

