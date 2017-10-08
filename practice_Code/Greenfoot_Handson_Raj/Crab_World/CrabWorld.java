import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */

        
    public CrabWorld() 
    {
        super(860, 860, 1);
        addObject(new Crab(), 300, 300);
        addObject(new lobster(), 200, 200);
        
        
        
        
        int w;
        for (w=0; w<10; w++) {
            int x = Greenfoot.getRandomNumber(800);
            int y = Greenfoot.getRandomNumber(800);
            addObject(new worm(), x, y);
            
            
        }
    }
}