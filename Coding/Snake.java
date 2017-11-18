import greenfoot.*;
import java.awt.Color;  
import java.awt.Font;  
import java.util.Calendar;
import java.lang.Math;

public class Snake extends Prototype implements FactoryInterface
{
    public int speed=5;
    public int rotation=5;
    public int addTimer=2;
    public int addCounter;
    public int spacecount=0;
    public int sameActionCountRight;
    public int sameActionCountLeft;
    public int rightTurn = 9;
    public int leftTurn = 9;
    public static int SnakeIsActive;
    public int foodEaten=0;
    public int Primary;
    public static int Health;
    public static int Armour;
    public int Regeneration;
    public String target;
    public int xDiff;
    public int yDiff; 
    public int absoluteDiff;
    public int locationxDiff;
    public int locationyDiff;
    public int present;
    public double angle;
    public int angleDiff;
    public static int armourCount;
    public static int armourEfficency;
    public int nullX;
    public int nullY;
    public int killNullCount;
    GreenfootImage image = new GreenfootImage(24,24); 
    GreenfootSound sound;

    public Snake()
    {
        //Draw the Enemies image
        super();
        image.setColor(Color.BLACK);
        
        
    }

    public void act() 
    {    
        if(Background.Paused)
        {
            if(Background.World!="GAME")
            {
                mainMenu();
            }
        }else{
            if(Background.World=="GAME")
            {
                controls();
                eat();
                Location();
                bodyControl();
                foodPresent();
                Life();
            }else{
                mainMenu();
            }
        }
    }    

    public void mainMenu()
    {
        move(speed);
        Location();
        bodyControl();
        nullTarget();
        faceTarget();
        Snake player = (Snake) getOneIntersectingObject(Snake.class);
        if(player!=null)
        {
            Blood blood = new Blood();
            getWorld().addObject(blood,getX(),getY());
        }
        killNullCount++;
        if(killNullCount>=1000)
        {
            getWorld().removeObject(this);
        }
    }

    public void nullTarget()
    {
        if(xDiff<=20&&yDiff<=20)
        {
            nullX=Greenfoot.getRandomNumber(600)+100;
            nullY=Greenfoot.getRandomNumber(75)+175;
        }
        xDiff = nullX - getX();  
        yDiff = nullY - getY();  
        locationxDiff= getX()- nullX;
        locationyDiff= getY()- nullY;
        angle = Math.toDegrees(Math.atan2(yDiff, xDiff));  
        angleDiff = getRotation() - (int)Math.round(angle);
        absoluteDiff = (int)Math.sqrt(xDiff*xDiff+yDiff*yDiff);
        if(angleDiff<0)
        {
            angleDiff=angleDiff+360;
        }
        if(angleDiff>360)
        {
            angleDiff=angleDiff-360;
        }
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
    
    @Override
    public void determineTarget()
    {
        //Determine what the primary target is
        if(getWorld().getObjects(EnemySnake.class).isEmpty())
        {
            target="FOOD";
        }else{
            if(Primary>=1)
            {
                target="ENEMY";
                Primary--;
            }else{
                target="FOOD";
            }
        }
    }
    
    @Override
    public boolean foodPresent()
    {
        //Detect if the EnemySnake is within the location it beleieves to be the food and if it intersects with the food
        SnakeFood food = (SnakeFood) getOneIntersectingObject(SnakeFood.class);
        if (absoluteDiff <=25 && food!=null)
        {
            return true;
        }
        return false;
    }

    @Override
    public void determineTargetLocation()
    {
        //calculate needed variables
        if(target!=null)
        {
            if(target=="ENEMY")
            {
                EnemySnake enemy=(EnemySnake) getWorld().getObjects(EnemySnake.class).get(0);
                xDiff = enemy.getX() - getX();  
                yDiff = enemy.getY() - getY();  
                locationxDiff= getX()- enemy.getX();
                locationyDiff= getY()- enemy.getY();
            }
            if(target=="FOOD")
            {
                SnakeFood food=(SnakeFood) getWorld().getObjects(SnakeFood.class).get(0);
                xDiff = food.getX() - getX();  
                yDiff = food.getY() - getY();  
                locationxDiff= getX()- food.getX();
                locationyDiff= getY()- food.getY();
            }
            angle = Math.toDegrees(Math.atan2(yDiff, xDiff));  
            angleDiff = getRotation() - (int)Math.round(angle);
            absoluteDiff = (int)Math.sqrt(xDiff*xDiff+yDiff*yDiff);
        }
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

    public void bodyControl()
    {
        //Add new body segments on a timer
        addCounter++;
        if(addCounter==addTimer)
        {
            SnakeBody playerbody = new SnakeBody();
            getWorld().addObject(playerbody, getX(), getY());
            addCounter=0;
        }
    }
    
    
    public void controls()
    {
        move(speed);
        SnakeIsActive--;
        //Detect player interaction
        if(Greenfoot.isKeyDown("right"))
        {
            turn(5);
            SnakeIsActive=100;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-5);
            SnakeIsActive=100;
        }
        //Determine if the player is inactive
        if(Background.players==0)
        {
            if(SnakeIsActive<=0)
            {
                determineTarget();
                determineTargetLocation();
                faceTarget();
            }
        }
    }

    @Override
    public void eat()
    {
        //Remove the food and calculate the rewards
        SnakeFood food = (SnakeFood) getOneIntersectingObject(SnakeFood.class);
        if (food != null) {
            sound = new GreenfootSound ("eat.mp3");
            sound.setVolume(Background.volume);
            sound.play();
            foodEaten++;
            Health=Health+10;
            SnakeBody.end_timer=SnakeBody.end_timer+15;
            SnakeHub.score+=15;
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
    public void Life()
    {
        //Health regeneration
        Regeneration++;
        if(Regeneration==50)
        {
            Health=Health+1;
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
        //EnemySnake interaction
        EnemySnake enemy = (EnemySnake) getOneIntersectingObject(EnemySnake.class);
        EnemySnakeBody enemybody = (EnemySnakeBody) getOneIntersectingObject(EnemySnakeBody.class);
        if (enemy != null)
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
            SnakeBody.end_timer=1;
            getWorld().removeObject(this);
        }
    }
    
    
 
}
