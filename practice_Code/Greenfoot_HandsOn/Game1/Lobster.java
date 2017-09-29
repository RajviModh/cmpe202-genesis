import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Lobsters like to eat crabs.
 * 
 * @author Martin Rohwedder 
 * @version 14. september 2010
 */
public class Lobster  extends Animal
{
    /**
     * Act - lets lobsters look for crabs to eat.
     */
    public void act()
    {
        move();
        lookForCrab();
        randomTurn();
        turnAtEdge();
    }
    
    /**
     * Check wether we have stumbled upon a crab.
     * If we have, eat it. If not, do nothing.
     */
    public void lookForCrab()
    {
        if ( canSee(Crab.class) )
        {
            eat(Crab.class);
            Greenfoot.playSound("au.wav");
            Greenfoot.stop();
        }
    }
    
    /**
     * Turns the lobster in a random direction, with random degrees.
     */
    public void randomTurn()
    {
        if ( Greenfoot.getRandomNumber(100) < 10 )
        {
            turn(Greenfoot.getRandomNumber(90)-45);
        }
    }
    
    /**
     * Turns the Lobster if it reach the edge of the crabworld.
     */
    public void turnAtEdge()
    {
        if ( atWorldEdge() )
        {
            turn(17);
        }
    }
}
