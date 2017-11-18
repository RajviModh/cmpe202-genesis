import greenfoot.*;

/**
 * Write a description of class PlayerTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerTwo implements selectPlayerStrategy  
{
    // instance variables - replace the example below with your own
    private int x;


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
  public void controls(EnemySnake s) {

		s.move(s.speed);
        s.PlayerIsActive--;
	 if(Greenfoot.isKeyDown("D"))
            {
                s.turn(5);
                s.PlayerIsActive=100;
            }
            if(Greenfoot.isKeyDown("A"))
            {
                s.turn(-5);
                s.PlayerIsActive=100;
            }
	}
}
