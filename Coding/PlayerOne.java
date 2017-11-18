/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne  implements selectPlayerStrategy  
{
    // instance variables - replace the example below with your own
    
    


    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
  public void controls(EnemySnake s) {

		s.move(s.speed);
        s.PlayerIsActive--;
		 if(s.PlayerIsActive<=0)
            {
                if(s.aroundfood)
                {
                    s.foodCount++;
                }else{
                    s.foodCount=0;
                }
                if(s.foodCount<50)
                {
                    s.findTarget();
                    s.findTargetLocation();
                    s.faceTarget();
                }
            }
	}
}
