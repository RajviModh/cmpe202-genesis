import greenfoot.*;
  
  
import java.util.Calendar;
import java.lang.Math;
/**
 * EnemySnake Class * 
 * @author Keval Shah
 * @version (a version number or a date)
 */
public class EnemySnake extends Actor
{
    // instance variables - replace the example below with your own
    private int x;
    public static int PlayerIsActive=100;
    public int absoluteDiff;
    public int speed=5;
    public String target;
    public int angleDiff;
    public static int offset;
    public static int Health;
    public static int Armour;
    public static int armourCount;
    public static int armourEfficency;
    public boolean aroundfood;
    public int foodCount;
    public int ranX;
    public int ranY;
    public int addTimer=2;
    public int addCounter;
    public int foodEaten=0;
    public int Primary;
    public int Regeneration;
    
    GreenfootSound sound;


    /**
     * Constructor for objects of class Enemy
     */
    public EnemySnake()
    {
       //Used to draw the Enemies image
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public void act(){
    //main method which calls other methods to perform various operations
       if(Background.Paused)
        {
        }else{
            if(Background.World=="GAME")
            {
                aroundFood();
                controls();
                eat();
                Location();
                bodyControl();
                isFoodPresent();
                Life();
            }
        }  
    }
    
    public void bodyControl()
    {
        //Add new body segments on a timer
        addCounter++;
        if(addCounter==addTimer)
        {
            EnemySnakeBody enemysnakebody = new EnemySnakeBody();
            getWorld().addObject(enemysnakebody, getX(), getY());
            addCounter=0;
        }
    }
    public void controls()
    {
        //Used to control the enemy snake
        // put your code here
        move(speed);
        PlayerIsActive--;
        //Detect player interaction
        if(Background.players==2)
        {
            if(Greenfoot.isKeyDown("D"))
            {
                turn(5);
                PlayerIsActive=100;
            }
            if(Greenfoot.isKeyDown("A"))
            {
                turn(-5);
                PlayerIsActive=100;
            }
        }
        
        //Determine if the player is inactive
        if(Background.players==1)
        {
            if(PlayerIsActive<=0)
            {
                if(aroundfood)
                {
                    foodCount++;
                }else{
                    foodCount=0;
                }
                if(foodCount<50)
                {
                    findTarget();
                    findTargetLocation();
                    faceTarget();
                }
            }
        }
       
    }
      public void aroundFood()
    {
         SnakeFood snakefood=(SnakeFood) getWorld().getObjects(SnakeFood.class).get(0);
        if(getX()- snakefood.getX()<=100 && getX()- snakefood.getX()>=-100 && getY()- snakefood.getY()<=100 && getY()- snakefood.getY()>=-100 && target=="FOOD")
        {
            aroundfood=true;
        }else{
            aroundfood=false;
        }
        
    }
    
     public void eat()
    {
        //Called when the snake eats the food
         SnakeFood snakefood = (SnakeFood) getOneIntersectingObject(SnakeFood.class);
        if (snakefood != null) {
            sound = new GreenfootSound ("eat.mp3");
            sound.setVolume(Background.volume);
            sound.play();
            foodEaten++;
            Health+=10;
            EnemySnakeBody.killtimer=EnemySnakeBody.killtimer+15;

            if(Health>50)
            {
                if(foodEaten%5==0)
                {
                    Primary=200;
                }
            }
        }
    }
    
     public void findTarget()
    {
        //Determine the Target Food 
              if(getWorld().getObjects(Snake.class).isEmpty())
        {
            target="FOOD";
        }else{
            if(Primary>=1)
            {
                target="PLAYER";
                Primary--;
            }else{
                target="FOOD";
            }
        }
       
    }
    
    public void findTargetLocation()
    {
    difficulty();
    }
    
    public void difficulty()
    {
        if(Background.difficulty==1)
        {
            offset=50;
        }
        if(Background.difficulty==2)
        {
            offset=35;
        }
        if(Background.difficulty==3)
        {
            offset=1;
        }
    }
    
     public boolean isFoodPresent()
    {
        //Detect if the Enemy is within the location it beleives to be the food and if it intersects with the food

        //if (absoluteDiff <=25 && food!=null)

        if (absoluteDiff <=25)
        {
            return true;
        }
        return false;

    }
    public void faceTarget()
    {
        if(target!=null)
        {   
            //Rationalize the needed angle
            if(angleDiff<0)
            {
                angleDiff=angleDiff+360;
            }
            if(angleDiff>360)
            {
                angleDiff=angleDiff-360;
            }
            //Turn to the needed angle
            if(angleDiff>180)
            {
                turn(5);
            }else{
                if(angleDiff<=180 && angleDiff!=0)
                {
                    turn(-5);
                }
            } 
        }
    }    
    
    public void Life()
    {
       //Handles the XP points, health and life bars 
       
       //Health regeneration
        Snake snake = (Snake) getOneIntersectingObject(Snake.class);
        SnakeBody snakebody = (SnakeBody) getOneIntersectingObject(SnakeBody.class);
        Regeneration++;
        if(Regeneration==50)
        {
            Health+=1;
            Regeneration=0;
        }
        if(Health>100)
        {
            Health=100;
        }
        //Rationalize the health
        if(Health<0)
        {
            Health=0;
        }
        //Enemy interaction
        if (snake != null)
        {
            if(Armour>0)
            {
                armourCount++;
                Armour--;
                if(armourCount>=armourEfficency)
                {
                    Health--;
                    armourCount=0;
                }
            }else{
                Health--;
            }
        }
        if(Health<=0)
        {
            EnemySnakeBody.killtimer=1;
            getWorld().removeObject(this);
        }
    }
    
    public void Location()
    {
        //Move the snake to the inverse side of the screen if on edge
       if(getX()>800)
        {
            setLocation(0,getY());
        }
        if(getX()<0)
        {
            setLocation(800,getY());
        }
        if(getY()>400)
        {
            setLocation(getX(),0);
        }
        if(getY()<0)
        {
            setLocation(getX(),600);
        }
     }
   
}
