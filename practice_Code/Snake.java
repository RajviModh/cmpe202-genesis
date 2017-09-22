import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    //This basically enables the use of the commands below.
    public void act() 
    {
          moveAndTurn();
          eat();
    } 
    
    //This is what determines the movement of the snake in a left,right,up and down manner.
    public void moveAndTurn()
    {
        move(2);
        if (Greenfoot.isKeyDown("left"))
        {
            setRotation(180);
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setRotation(90);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setRotation(270);
        }
    }
        
    //This is what allows the snake to eat and remove a makanan while adding another makanan to the world and then activating the counter method.     
        public void eat()
        {
        Actor makanan;
        makanan = getOneObjectAtOffset(0, 0, makanan.class);
        if (makanan != null)
        {
            SnakeWorld world;
            world = (SnakeWorld) getWorld();
            world.removeObject(makanan);
            world.placemakanan(1);
            eatAmakanan();
        }        
    }     

    //This is the counter that adds a point everytime a makanan is eaten in the game.
    private void eatAmakanan()
    {
        SnakeWorld snakeWorld = (SnakeWorld) getWorld();
        Counter counter = snakeWorld.getCounter();
        counter.bumpCount(1);
    }
    }

 
    
 
