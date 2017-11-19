import greenfoot.*;
import java.awt.Color;  
import java.util.Calendar;
import java.lang.Math;
/**
 * EnemySnake Class * 
 * @author Keval Shah
 * @version (a version number or a date)
 */
public class EnemySnake extends Prototype implements FactoryInterface
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
    public int targetSet;
    public int xDiff;
    public int yDiff; 
    public int locationxDiff;
    public int locationyDiff;
    public double angle;
    GreenfootImage image = new GreenfootImage(24,24); 
    GreenfootSound sound;
    int count;


    /**
     * Constructor for objects of class Enemy
     */
    public EnemySnake()
    {
       //Used to draw the Enemies image
       image.setColor(Color.RED);
        int[] xs = {0, 24, 0, 6};  
        int[] ys = {0, 12, 24, 12}; 
        image.fillPolygon(xs, ys, 4);
        image.setColor(Color.WHITE);
        image.fillOval(10, 7, 3, 4);
        image.fillOval(10, 13, 3, 4);
        setImage(image);
        PlayerIsActive=100;
        armourEfficency=0;
        Armour=0;
        armourCount=0;
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
                controls(Background.players);
                eat();
                Location();
                bodyControl();
                foodPresent();
                Life();
            }
        }  
    }
    
    @Override
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
    
    
    public void controls(int playerCount)
    {
        //Used to control the enemy snake
        // put your code here
        selectPlayerStrategy s = null;
        
        //Detect player interaction
        if(playerCount==1){
        s=new PlayerOne();
    }
    else if(playerCount==2){
        s=new PlayerTwo();
    }
    
    s.controls(this);
        
        /*if(Background.players==2)
        {
            if(Greenfoot.isKeyDown("D"))
            {`
                turn(5);
                PlayerIsActive=100;
            }
            if(Greenfoot.isKeyDown("A"))
            {
                turn(-5);
                PlayerIsActive=100;
            }
        }*/
        
        //Determine if the player is inactive
       /* if(Background.players==1)
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
        }*/
       
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
    
    @Override
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
    
    @Override
    public void determineTarget()
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
    
    @Override
    public void determineTargetLocation()
    {
    difficulty();
    if(targetSet!=1)
        {
            if(offset!=0)
            {
                if(target=="PLAYER")
                {
                    ranX= Greenfoot.getRandomNumber(offset*4)-offset*2;
                    ranY= Greenfoot.getRandomNumber(offset*4)-offset*2;
                }else{
                    ranX= Greenfoot.getRandomNumber(offset*2)-offset;
                    ranY= Greenfoot.getRandomNumber(offset*2)-offset;
                }
            }
        }
        
        if(target!=null)
        {
            if(target=="PLAYER")
            {
                Snake snake=(Snake) getWorld().getObjects(Snake.class).get(0);
                xDiff = (snake.getX()+ranX) - getX();  
                yDiff = (snake.getY()+ranY) - getY();  
                locationxDiff= getX()- snake.getX();
                locationyDiff= getY()- snake.getY();
            }
            if(target=="FOOD")
            {
                SnakeFood snakefood=(SnakeFood) getWorld().getObjects(SnakeFood.class).get(0);
                xDiff = (snakefood.getX()+ranX) - getX();  
                yDiff = (snakefood.getY()+ranY) - getY();  
                locationxDiff= getX()- snakefood.getX();
                locationyDiff= getY()- snakefood.getY();
            }
            targetSet=1;
        }
        
          angle = Math.toDegrees(Math.atan2(yDiff, xDiff));  
        angleDiff = getRotation() - (int)Math.round(angle);
        absoluteDiff = (int)Math.sqrt(xDiff*xDiff+yDiff*yDiff);
        if(targetSet==1 && absoluteDiff<30)
        {
            targetSet=0;
        }
        if(target=="PLAYER")
        {
            targetSet=0;
        }
        
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
    
    @Override
     public boolean foodPresent()
    {
        //Detect if the Enemy is within the location it beleives to be the food and if it intersects with the food

        SnakeFood snakefood = (SnakeFood) getOneIntersectingObject(SnakeFood.class);
        if (absoluteDiff <=25 && snakefood!=null)
        {
            return true;
        }
        return false;

    }
    
    @Override
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
    
    @Override
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
    
    
   
}
