import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Animal
{
    //The fields/attributes of the crab.
    private GreenfootImage image1;
    private GreenfootImage image2;
    private int wormsEaten;
    private int spawnCounter;
    
    /**
     * The constructor of the crab, which stores 2 different images
     * in the 2 variables image1 and image2. Then it sets the
     * image1 as the crab class default image.
     */
    public Crab()
    {
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);
        wormsEaten = 0;
        spawnCounter = 0;
    }
    
    public void act()
    {
        
        checkKeyPress();
        
        wonGame();
    }
    
    /**
     * Check wether we have stumbled upon a worm.
     * If we have, eat it. If not, do nothing.
     */
   
    /**
     * Checks wehter we press the key left, right or up,
     * and if we do so, turn our object degrees -4 (left) or 4 (right),
     * or move our crab forward (up).
     */
    public void checkKeyPress()
    {
        //Checks if the left key is down, then turn left with -4 degrees.
        if ( Greenfoot.isKeyDown("left") == true )
        {
            turn(-4);
        }
        //Checks if the right key is down, then turn right with 4 degrees.
        if ( Greenfoot.isKeyDown("right") == true )
        {
            turn(4);
        }
        //Checks if the up key is down, then move the crab.
        if ( Greenfoot.isKeyDown("up") == true )
        {
            move();
            switchImage();
        }
    }
    
    /**
     * Automatically switches beetwen image1 and image2, so
     * it looks like or crab is moving (simple animation).
     */
    public void switchImage()
    {
        if ( getImage() == image1 )
        {
            setImage(image2);
        } else {
            setImage(image1);
        }
    }
    
    /**
     * Add 1 new worm to the world if the crab have eaten 1 worm.
     * First we check if the spawnCounter is equal to 1, if so we add
     * a new worm in a random position to our world.
     * After that we assign 0 (zero) to the spawnCounter field, so it has
     * been reseted.
     */
    
    
    /**
     * End the game if there is a value of 15 in the wormsEaten field.
     * it will then print the winning message to the user.
     */
    public void wonGame()
    {
        if ( wormsEaten == 15 )
        {
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
            System.out.println("Great! - You have eaten 15 worms, and have therefore WON the game!");
        }
    }
}


