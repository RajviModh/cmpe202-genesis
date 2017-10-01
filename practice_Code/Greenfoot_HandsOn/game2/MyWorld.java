    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    private int numslice=20,d=0,w=0;
    private Fish[][] fish=new Fish[1][numslice];
    public MyWorld()
    {    
       
        super(1024, 550, 1, false); 
        GreenfootImage image = new GreenfootImage("dolphin.png");
        d=(int)Math.round(1.0*image.getWidth()/numslice);
        w=2*d;
        
        Fish.STEP=d;
        
        for(int i=0;i<fish.length;i++)
        {
            int dxo=0; //Greenfoot.getRandomNumber(getWidth());
            int dyo=0; //Greenfoot.getRandomNumber(getHeight());
            for(int j=0;j<numslice;j++)
            {
                GreenfootImage img = new GreenfootImage(w,image.getHeight());
                img.drawImage(image,(int)(0.5*d-j*d),0);
                fish[i][j]=new Fish();
                fish[i][j].setImage(img);
                addObject(fish[i][j],(int)(0.5*getHeight()+j*d-dxo),(int)(0.5*getHeight()+dyo));
                if(j==numslice-1)fish[i][j].HEAD=true;
                if(j>0)fish[i][j].backtile=fish[i][j-1];
            }
        }
    }
}
