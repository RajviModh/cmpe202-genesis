import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * This class defines a crab. Crabs live on the beach. They like sand worms 
 * (very yummy, especially the green ones).
 */
public class Crab extends Animal

{
    int food = 10;
    boolean animation = true;
    
    
          public void act() {   
                  if(food == 0)
                        {
                            getWorld().addObject(new gewonnen(), 430, 430);
                            Greenfoot.stop();


                        }
   {
        
                                
                                
         if ( canSee(worm.class) )
           { 
               eat(worm.class);
               food--;
               
            }
            
            
       
            if (Greenfoot.isKeyDown("left"))
                          { 
                              moveback();
                          }
                            
       
                            if (Greenfoot.isKeyDown("up"))
                                  {
                                     turn(10);
                                  }
       
       
                                      if (Greenfoot.isKeyDown("right"))
                                            {
                                               move();
                                            }
                            
                                              if (Greenfoot.isKeyDown("down"))
                                                    {
                                                       turn(-10);
                                                    }
      
       
        if (atWorldEdge()) {turn(15);}
        
       
    
        
        
        
                          if (animation)
                             {
                               setImage("crab.png"); 
                               animation = false;  
                             }
        
                                
                                       else 
                                         {
                                          setImage("crab2.png"); 
                                          animation = true;
                                         }
                                         

                          
        
   }
}
}


