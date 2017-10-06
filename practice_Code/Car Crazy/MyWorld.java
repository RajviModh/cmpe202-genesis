import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public void selesai() 
    {
        addObject(new gameover(), getWidth()/2, getHeight()/3);
        Greenfoot.stop();
    }
    public MyWorld()
    {    
        super(1500, 600, 1); 
        setPaintOrder(redcar1.class, greencar1.class, bluecar1.class, crazycar.class, ledakan.class, gameover.class, Enemy.class);
        crazycar cc = new crazycar ();
        this.addObject(cc, 112, 301);
        cc.turn(180);
        greencar1 gc = new greencar1 ();
        this.addObject(gc, 1500, 299);
        gc.turn(90);
        bluecar1 bc = new bluecar1 ();
        this.addObject(bc, 1500, 86);
        bc.turn(90);
        redcar1 rc = new redcar1 ();
        this.addObject(rc, 1500, 519);
        rc.turn(90);
    }
}















