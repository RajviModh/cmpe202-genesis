import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int STEP=0;
    public boolean HEAD=false;
    public Snake backtile;
    
    private double targetx=0, targety=0;
    private double posx,posy;
    
    public void addedToWorld(World Latar)
    {
        posx=targetx=getX();
        posy=targety=getY();
    }
    
    private int norm180(int a)
    {
        while(a<-180){
            a+=360;
        }
        while(a>180){
            a-=360;
        }
        return a;
    }
    private int norm360(int a)
    {
        while(a<0){
            a+=360;
        }
        while(a>360){
            a-=360;
        }
        return a;
    }
    
    private int getDirection(int sudut1,int sudut2)
    {
        int a=norm180(sudut2)-norm180(sudut1);
        int b=norm360(sudut2)-norm360(sudut1);
        return Math.abs(a)<Math.abs(b)?a:b;
    }
    
    public void move(){
           double rx=targetx-posx;
           double ry=targety-posy;
           double r=Math.sqrt(rx*rx+ry*ry);
           if(r>STEP)
           {
               double angle=Math.atan2(ry,rx)*180.0/Math.PI;
               double direction=getDirection(getRotation(),(int)angle);
              
               int bts=20;
               if(Math.abs(direction)>bts)direction=(direction<0)?-bts:bts;
               
               int px=(int)posx;
               int py=(int)posy;
               
               angle=getRotation()+direction;
               
               posx+=STEP*Math.cos(angle*Math.PI/180);
               posy+=STEP*Math.sin(angle*Math.PI/180);
               setLocation((int)posx,(int)posy);
               setRotation((int)angle);
               updateTile(px,py);
            }
    }
    
    
    public void updateTile(int px,int py)
    {
        if(backtile==null)return;
        int ax=backtile.getX();
        int ay=backtile.getY();
        
        double rx=px-ax;
           double ry=py-ay;
           double angle=Math.atan2(ry,rx);
           backtile.setLocation(px,py);
            backtile.setRotation((int)angle);
            backtile.updateTile(ax,ay);
    }
    
    public void act() 
    {
        if(HEAD){
        if(Greenfoot.mouseMoved(null)){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        targetx=mouse.getX();
        targety=mouse.getY();
        }
        move();
        
        }
        
        // Add your action code here.
    }    
}
