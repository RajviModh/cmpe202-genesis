import java.awt.*; 
public class MediumDifficulty  implements State
{   
   
  public void draw(MainScreen m){
       m.image.setColor(new Color(m.medium_Dif_color_r,m.medium_Dif_color_g,m.medium_Dif_color_b));
        m.image.fillRect(320, 425, 150, 50);
        m.image.setColor(new Color(m.medium_Dif_color,m.medium_Dif_color,m.medium_Dif_color));
        m.image.fillRect(325, 430, 140, 40);
        Font font = m.image.getFont();
        font = font.deriveFont(20.0f);
        m.image.setFont(font);
        m.image.setColor(new Color(255,255,0));
        m.image.drawString("Medium", 360, 455);
  };
}