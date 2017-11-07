import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
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
        image.setColor(new Color(single_player_color,single_player_color,spxsingle_player_color);
        image.fillRect(180, 355, 190, 40);
        Font font = image.getFont();
        font = font.deriveFont(20.0f);
        image.setFont(font);
        image.setColor(new Color(0,0,255));
        image.drawString("Single Player", 220, 380);
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
}
