import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
   private int num=10,d=0,w=0;
    private Snake[] snake = new Snake[num];
 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1024, 550, 1, false); 
        
        GreenfootImage image = new GreenfootImage("snake.png");
        d=(int)Math.round(1.0*image.getWidth()/num);
        w=2*d;
        
        Snake.STEP=d;
        
        for(int i=0;i<num;i++){
        snake[i]=new Snake();
        GreenfootImage img=new GreenfootImage(w,image.getHeight());
        img.drawImage(image,(int)(0.5*w-i*d),0);
        snake[i].setImage(img);
        addObject(snake[i],(int)(0.5*getWidth()+i*d)-200,(int)(0.5*getHeight()));
        if(i>0)snake[i].backtile=snake[i-1];
        if(i==num-1)snake[i].HEAD=true;
    
        }
    }
}
