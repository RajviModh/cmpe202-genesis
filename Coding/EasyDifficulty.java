import java.awt.*; 
public class EasyDifficulty  implements State
{   
    
  public void draw(MainScreen m){
        m.image.setColor(new Color(m.easy_Dif_color_r,m.easy_Dif_color_g,m.easy_Dif_color_b));
        m.image.fillRect(75, 425, 150, 50);
        m.image.setColor(new Color(m.easy_Dif_color,m.easy_Dif_color,m.easy_Dif_color));
        m.image.fillRect(80, 430, 140, 40);
        Font font = m.image.getFont();
        font = font.deriveFont(20.0f);
        m.image.setFont(font);
        m.image.setColor(new Color(0,255,0));
        m.image.drawString("Easy", 125, 455);
  };

   
}