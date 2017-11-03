import greenfoot.*;
import greenfoot.Color;
import greenfoot.Font;
   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (Genesis) 
 * @version (10.26.17)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage(24,24); 
    GreenfootSound sound;
    
    public int rotation=5;
    public int speed=5;
    
    public int addCounter;
    public int addTimer=2;
    
    public int sameActionCountLeft;
    public int sameActionCountRight;
    
    public int spacecount=0;
    
    public int leftTurn = 9;
    public int rightTurn = 9;
    
    public int foodEaten=0;
    
    public static int PlayerIsActive;
    
    public static int Health;
    public int Primary;
    
    public int Regeneration;
    public static int Armour;
    
    public String target;
    
    public int yDiff;
    public int xDiff;
    public int locationyDiff; 
    public int locationxDiff;
   
    public int absoluteDiff;
    
    public int present;
    
    public int angleDiff;
    public double angle;
    
    public static int armourEfficency;
    public static int armourCount;
    
    public int nullY;
    public int nullX;
    public int killNullCount;
    
    //initialize player in game
    public Snake()  
    {
        image.setColor(Color.BLACK);
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
    
    //to be implemented for checking state of game whether paused or on
    public void act() 
    {
        // Add your action code here.
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
        
    }
    
    //logic for snake eating food and changes to be made afterwards
    public void eat()
    {

    }
    
    //for checking presence of food
    public boolean foodPresent()
    {
        return true ;
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

    //logic for health checking and regaining or losing based on position
    //and enemy interaction.
    public void Life()
    {
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
        
        //when player snake touches the enemy or vice versa
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
            //SnakeBody.killtimer=1; //dependency to be added in SnakeBody class
            getWorld().removeObject(this);
        }
        
        
    }

    //logic for controlling the snake
    public void controls()
    {
        move(speed);
        PlayerIsActive--;
        //Detect player interaction
        if(Greenfoot.isKeyDown("right"))
        {
            turn(5);
            PlayerIsActive=100;
        }
        if(Greenfoot.isKeyDown("left"))
        {
            turn(-5);
            PlayerIsActive=100;
        }
        //Determine if the player is inactive
        if(Background.players==0)
        {
            if(PlayerIsActive<=0)
            {
                determineTarget();
                determineTargetLocation();
                faceTarget();
            }
        }
    }
    
    //for adding segments on the timer
    public void bodyControl()
    {
        addCounter++;
        if(addCounter==addTimer)
        {
            SnakeBody playerbody = new SnakeBody();
            getWorld().addObject(playerbody, getX(), getY());
            addCounter=0;
        }
    }
    
    // logic for determining edges and set appropriate changes
    public void Location()
    {
        //to move snake to other side of screen if it hits the edge
         if(getX()>800)
        {
            setLocation(0,getY());
        }
        if(getX()<0)
        {
            setLocation(800,getY());
        }
        if(getY()>600)
        {
            setLocation(getX(),0);
        }
        if(getY()<0)
        {
            setLocation(getX(),600);
        }
    }
    
    public void determineTarget()
    {
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
     
    public void determineTargetLocation()
    {
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
                //to be implemented
                
            }
            angle = Math.toDegrees(Math.atan2(yDiff, xDiff));  
            angleDiff = getRotation() - (int)Math.round(angle);
            absoluteDiff = (int)Math.sqrt(xDiff*xDiff+yDiff*yDiff);
        }
    }
    
    
     
}
