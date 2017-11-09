import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
import greenfoot.MouseInfo;
/**
 * MainScreen will hve options for selecting player options and difficulty level.
 * 
 * @author (Divyang Soni) 
 */
public class MainScreen extends Actor
{
    /**
     * Act - do whatever the MainScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage(800,600);
    public String message;
    public int waitCount;
    public int color_r =0;
    public int color_g =0;
    public int color_b =0;
    public int single_player_color = 200;
    public int multiple_player_color = 200;
    //constructor
    public MainScreen()
    {
        sketch();
    }
    
    public void act() 
    {
        Background.World="MAINSCREEN";
        sketch();
        waiting();
    }  
    
    public void waiting(){
        waitCount++;
        if(waitCount>=100)
        {
            Snake player = new Snake();
            getWorld().addObject(player, 30, 300);
            waitCount=0;
        }
    }
    
      public void singlePlayer()
    {
        image.setColor(new Color(color_r,color_g,color_b));
        image.fillRect(175, 350, 200, 50);
        image.setColor(new Color(single_player_color,single_player_color,single_player_color));
        image.fillRect(180, 355, 190, 40);
        Font font = image.getFont();
        font = font.deriveFont(20.0f);
        image.setFont(font);
        image.setColor(new Color(0,0,255));
        image.drawString("Single Player", 220, 380);
    }
    
    public void play()
    {
       
    }
    
        public void title()
    {
        image.setColor(new Color(255,255,255));
        Font font = image.getFont();
        font = font.deriveFont(42.0f);
        image.setFont(font);
        image.drawString("Crazy Snake Project", 250, 100);
    }
    
    public void multiPlayer()
    {
        image.setColor(new Color(color_r,color_g,color_b));
        image.fillRect(425, 350, 200, 50);
        image.setColor(new Color(multiple_player_color,multiple_player_color,multiple_player_color));
        image.fillRect(430, 355, 190, 40);
        Font font = image.getFont();
        font = font.deriveFont(20.0f);
        image.setFont(font);
        image.setColor(new Color(255,0,0));
        image.drawString("Muliplayer", 482, 380);
    }
    
    public void sketch()
    {
         getImage().clear();
         setImage(image); 
    }
    
    public void mouse_event()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
            if(mouse.getX()>=75 &&mouse.getX()<=225 && mouse.getY()>=425 && mouse.getY()<=475)
            {
            // difficulty easy
            }
            
             if(mouse.getX()>=320 &&mouse.getX()<=470 && mouse.getY()>=425 && mouse.getY()<=475)
            {
               // difficulty midium
            }
            
            if(mouse.getX()>=575 &&mouse.getX()<=725 && mouse.getY()>=425 && mouse.getY()<=475)
            {
               //difficulty high
            }
            
            if(mouse.getX()>=175 &&mouse.getX()<=375 && mouse.getY()>=350 && mouse.getY()<=400)
            {
                //single player
            }
            
            if(mouse.getX()>=425 &&mouse.getX()<=625 && mouse.getY()>=350 && mouse.getY()<=400)
            {
               //multiple player
            }
            
             if(mouse.getX()>=250 &&mouse.getX()<=550 && mouse.getY()>=500 && mouse.getY()<=550)
            {
                // start the game
            }
        }
    }
    
    
    public void message()
    {
        if(message=="Please select how many players" && Background.players==0)
        {
            image.setColor(new Color(212,0,0));
            Font font = image.getFont();
            font = font.deriveFont(12.0f);
            image.setFont(font);
            image.drawString("Please select how many players", 305, 497);
        }
        if(message=="Please select a difficulty" && Background.players==1 && Background.difficulty==0)
        {
            image.setColor(new Color(212,0,0));
            Font font = image.getFont();
            font = font.deriveFont(12.0f);
            image.setFont(font);
            image.drawString("Please select a difficulty", 330, 497);
        }
    }
    
     public void image()
    {
        image.setColor(Color.black);
        image.fillRect(20, 20, 760, 560);
        image.setColor(new Color(25,25,50));
        image.fillRect(30, 30, 740, 540);
    }
    
    public void easy()
    {
       
    }

    public void medium()
    {
       
    }

    public void hard()
    {
       
    }
}
