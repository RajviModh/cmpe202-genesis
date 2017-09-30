import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fish extends Actor
{
    private double posx,posy,targetx,targety;
    
    public static int STEP=10;
    public boolean HEAD=false; 
    public Fish backtile;
    
    public void addedToWorld(World Latar)
    {
        posx=targetx=getX();
        posy=targety=getY();
    }
   
    private int norm180(int a){
        while(a<-180)
        {
            a+=360;
        }
        while(a>180)
        {
            a-=360;
        }
        return a;
    }   
    
       private int norm360(int a){
        while(a<0)
        {
            a+=360;
        }
        while(a>360)
        {
            a-=360;
        }
        return a;
    }
    
    public int getDirection(int sudut1,int sudut2)
    {
        int a=norm180(sudut2)-norm180(sudut1);
        int b=norm360(sudut2)-norm360(sudut1);
        return Math.abs(a)<Math.abs(b)?a:b;
    }
    
    
    private void newTarget()
    {
        targetx=Greenfoot.getRandomNumber(getWorld().getWidth());
        targety=Greenfoot.getRandomNumber(getWorld().getHeight());
    }
    
    public void updateTile(int xo,int yo)
    {
        if(backtile==null)return;
        int ax=backtile.getX(),ay=backtile.getY();
        backtile.setLocation(xo,yo);
        backtile.updateTile(ax,ay);
    }
    
    public void act() 
    {
        if(HEAD){
        double rx=targetx-posx;
        double ry=targety-posy;
        double r =Math.sqrt(rx*rx+ry*ry);
        if(r>20){
            double angle=Math.atan2(ry,rx)*180.0/Math.PI;
            int direction=getDirection(getRotation(),(int)angle);
            int bts=10;
            if(Math.abs(direction)>bts)
            {
                direction=(direction<0)?-bts:bts;
            }
            angle=getRotation()+direction;
            int xo=getX(),yo=getY();
            posx+=STEP*Math.cos(angle*Math.PI/180);
            posy+=STEP*Math.sin(angle*Math.PI/180);
            setLocation((int)posx,(int)posy);
            setRotation((int)angle);
            updateTile(xo,yo);
        }else newTarget();  
    }    
}
}
