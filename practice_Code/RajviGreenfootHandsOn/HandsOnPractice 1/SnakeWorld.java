import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SnakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld extends World
{
    private makanan  makanan1;
    private Counter theCounter;

    
    //This shows what runs as the game starts.
    public SnakeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //setBackground("Black.jpg");
        prepare();
        placemakanan(1);
        theCounter = new Counter();
        addObject(theCounter, 40, 340);
    }
    
    
    //This is a method so that the snake can retrieve the value of the counter.
        public Counter getCounter()
    {
        return theCounter;
    }

    
    //This adds Objects to the world
    private void prepare()
    {
        Snake snake = new Snake();
        addObject(snake, 183, 205);        
    }   
    
    

    /*untuk memutar lagu
    {
       Greenfoot.playSound("skrillex.mp3");
    }*/
    
    
    //untuk membuat letak makanan secara acak.
        public void placemakanan(int amountOfmakanan)
    {
        for (int i = 0; i < amountOfmakanan; i++)
        {
            addObject(new makanan(), Greenfoot.getRandomNumber(499)+1,  Greenfoot.getRandomNumber(419)+1);
        }     
    } 
    
}

