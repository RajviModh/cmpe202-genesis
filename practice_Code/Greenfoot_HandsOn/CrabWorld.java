import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
   
    private int addLobsters = 0;
    
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        //Creates the Crabworld with x=560, y=560 and resolution = 1.
        super(560, 560, 1);
        populateWorld();
    }
    public void populateWorld()
    {
        //Add 1 object of the Crab class at the spicific location: x=280 and y=280 (in the center).
        addObject( new Crab(), 280, 280);
        //Add 3 objects of the Lobster class randomly into the world.
        while (addLobsters < 3)
        {
            addObject( new Lobster(), Greenfoot.getRandomNumber(540), Greenfoot.getRandomNumber(540));
            addLobsters++;
        }
        //Add 10 objects of the Worm class randomly into the world.
        
    }
}