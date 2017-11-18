import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FactorySnakeEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FactorySnakeEnemy extends Actor
{
    public FactoryInterface getObject(String name)
    {
        if(name.equalsIgnoreCase("Snake")){
            return new Snake();
        }
        else if(name.equalsIgnoreCase("EnemySnake"))
        {
            return new EnemySnake();
        }
        
        return null;
    }
}
