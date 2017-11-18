import java.awt.*; 
public class HardDifficulty   implements State
{   
   
  public void draw(MainScreen m){
       m.image.setColor(new Color(m.hard_Dif_color_r,m.hard_Dif_color_g,m.hard_Dif_color_b));
       m.image.fillRect(575, 425, 150, 50);
       m.image.setColor(new Color(m.hard_Dif_color,m.hard_Dif_color,m.hard_Dif_color));
       m.image.fillRect(580, 430, 140, 40);
       Font font = m.image.getFont();
       font = font.deriveFont(20.0f);
       m.image.setFont(font);
       m.image.setColor(new Color(255,0,0));
       m.image.drawString("Hard", 630, 455);
  };
}
