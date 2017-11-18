import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*; 
import java.util.ArrayList;
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
    public int SingleP_color_r =0; //spr
    public int SingleP_color_g =0;
    public int SingleP_color_b =0;
    private State state;
    
    public int MultiP_color_r =0;//mpr
    public int MultiP_color_g =0;
    public int MultiP_color_b =0;
    
    public int single_player_color = 200; //spx
    public int multiple_player_color = 200;//mpx
    
    public int medium_Dif_color_r = 0; //myr
    public int medium_Dif_color_g = 0;
    public int medium_Dif_color_b = 0;
    
    public int easy_Dif_color_r = 0;// eyr
    public int easy_Dif_color_g = 0;
    public int easy_Dif_color_b = 0;
    
    public int easy_Dif_color = 0;//ex
    public int medium_Dif_color = 0;//mx
    public int hard_Dif_color = 0;//hx
    public int player_color =200;//px
    
    public int hard_Dif_color_r = 0;// hyr
    public int hard_Dif_color_g = 0;
    public int hard_Dif_color_b = 0;
    
    public int x = 0;
    public int y = 0;
    
    
    //constructor
    public MainScreen()
    {
        sketch();
    }
    
    
    public void setState(State state) {
        this.state = state;
    }
    
    public State getState() {
        return state;
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
        image.setColor(new Color(SingleP_color_r,SingleP_color_g,SingleP_color_b));
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
       image.setColor(new Color(0,0,0));
        image.fillRect(250, 500, 300, 50);
        image.setColor(new Color(player_color,player_color,player_color));
        image.fillRect(255, 505, 290, 40);
        Font font = image.getFont();
        font = font.deriveFont(20.0f);
        image.setFont(font);
        image.setColor(new Color(0,255,0));
        image.drawString("Play", 375, 532);
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
        image.setColor(new Color(SingleP_color_r,SingleP_color_g,SingleP_color_b));
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
        mouse_event();
        image();
        title(); 
        setState(new EasyDifficulty());
        state.draw(this);
        
        setState(new MediumDifficulty());
        state.draw(this);
        
        setState(new HardDifficulty());
        state.draw(this);
        
        play();
        singlePlayer();
        multiPlayer();
        message();
        setImage(image); 
    }
    
    public void mouse_event()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           boolean bStateFound = false;
            
            if(mouse.getX()>=75 &&mouse.getX()<=225 && mouse.getY()>=425 && mouse.getY()<=475)
            {
                easy_Dif_color = 100;
                setState(new EasyDifficulty());
                bStateFound = true;
                 if(mouse.getButton()==1)
                {
                    Background.difficulty=1;
                }
           
            }else{
                easy_Dif_color=200;
            }
            
             if(mouse.getX()>=320 &&mouse.getX()<=470 && mouse.getY()>=425 && mouse.getY()<=475)
            {
                medium_Dif_color=100;
                setState(new EasyDifficulty());
                bStateFound = true;
                if(mouse.getButton()==1)
                {
                    Background.difficulty=2;
                }
            }else{
                medium_Dif_color=200;
            }
            
            if(mouse.getX()>=575 &&mouse.getX()<=725 && mouse.getY()>=425 && mouse.getY()<=475)
            {
              hard_Dif_color=100;
              setState(new HardDifficulty());
                bStateFound = true;
               
                if(mouse.getButton()==1)
                {
                    Background.difficulty=3;
                }
            }else{
                hard_Dif_color=200;
            }
            
            if(bStateFound)
            state.draw(this);
            
            if(mouse.getX()>=175 &&mouse.getX()<=375 && mouse.getY()>=350 && mouse.getY()<=400)
            {
                 single_player_color=100;
                if(mouse.getButton()==1)
                {
                    Background.players=1;
                }
            }else{
                single_player_color=200;
            }
            
            if(mouse.getX()>=425 &&mouse.getX()<=625 && mouse.getY()>=350 && mouse.getY()<=400)
            {
                multiple_player_color=100;
                if(mouse.getButton()==1)
                {
                    Background.players=2;
                }
            }else{
                multiple_player_color=200;
            }
            
             if(mouse.getX()>=250 &&mouse.getX()<=550 && mouse.getY()>=500 && mouse.getY()<=550)
            {
                player_color=100;
                play();
                if(Background.players==2 && mouse.getButton()==1)
                {
                    Background.start=1;
                }
                if(Background.players==1 && Background.difficulty!=0 && mouse.getButton()==1)
                {
                    Background.start=1;
                }
                if(Background.players==0 && mouse.getButton()==1)
                {
                    message="Please select how many players";
                }
                if(Background.players==1 && Background.difficulty==0 && mouse.getButton()==1)
                {
                    message="Please select a difficulty";
                }
            }else{
                player_color=200;
            }
        }
        
         if(Background.difficulty==1)
        {
          
            medium_Dif_color_r=0;
            medium_Dif_color_g=0;
            medium_Dif_color_b=0;
            easy_Dif_color_r = 13;
            easy_Dif_color_g = 71;
            easy_Dif_color_b = 233;
            hard_Dif_color_r = 0;
            hard_Dif_color_g = 0;
            hard_Dif_color_b = 0;
           
        }
        if(Background.difficulty==2)
        {
            medium_Dif_color_r=13;
            medium_Dif_color_g=71;
            medium_Dif_color_b=233;
            easy_Dif_color_r = 0;
            easy_Dif_color_g = 0;
            easy_Dif_color_b = 0;
            hard_Dif_color_r = 0;
            hard_Dif_color_g = 0;
            hard_Dif_color_b = 0;
        }
        if(Background.difficulty==3)
        {
            medium_Dif_color_r=0;
            medium_Dif_color_g=0;
            medium_Dif_color_b=0;
            easy_Dif_color_r = 0;
            easy_Dif_color_g = 0;
            easy_Dif_color_b = 0;
            hard_Dif_color_r = 13;
            hard_Dif_color_g = 71;
            hard_Dif_color_b = 233;
        }
        if(Background.players==1)
        {
            SingleP_color_r=13;
            SingleP_color_g=71;
            SingleP_color_b=233;
            MultiP_color_r = 0;
            MultiP_color_g = 0;
            MultiP_color_b = 0;
          
        }
        if(Background.players==2)
        {
            SingleP_color_r=0;
            SingleP_color_g=0;
            SingleP_color_b=0;
            MultiP_color_r = 13;
            MultiP_color_g = 71;
            MultiP_color_b = 233;
            
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
    
   
    
  
}
