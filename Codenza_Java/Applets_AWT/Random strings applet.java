Random strings applet



import java.awt.*;
import java.applet.*;

public class RandomStrings extends Applet {

   String message;  // The message to be displayed.  This can be set in
                    // an applet param with name "message".  If no
                    // value is provided in the applet tag, then 
                    // the string "Java!" is used as the default.
   
   Font font1, font2, font3, font4, font5;  // The five fonts.
   
   public void init() {
   
      message = getParameter("message");
      if (message == null)
         message = "Java!";
         
      font1 = new Font("Serif", Font.BOLD, 14);
      font2 = new Font("SansSerif", Font.BOLD + Font.ITALIC, 24);
      font3 = new Font("Monospaced", Font.PLAIN, 20);
      font4 = new Font("Dialog", Font.PLAIN, 30);
      font5 = new Font("Serif", Font.ITALIC, 36);
      
      setBackground(Color.black);
      
   } // end init()
   
   
   public void paint(Graphics g) {
   
      int width = getSize().width;       // Get the applet's width and height.
      int height = getSize().height;
   
      for (int i = 0; i < 25; i++) {
      
          // Draw one string.  First, set the font to be one of the five
          // available fonts, at random.  
      
          int fontNum = (int)(5*Math.random()) + 1;
          switch (fontNum) {
             case 1:
                g.setFont(font1);
                break;
             case 2:
                g.setFont(font2);
                break;
             case 3:
                g.setFont(font3);
                break;
             case 4:
                g.setFont(font4);
                break;
             case 5:
                g.setFont(font5);
                break;
          } // end switch

          // Set the color to be a bright, saturated color, with a random hue.
          
          float hue = (float)Math.random();
          g.setColor( Color.getHSBColor(hue, 1.0F, 1.0F) );

          // Select the position of the string, at random.
          
          int x,y;
          x = -50 + (int)(Math.random()*(width+40));
          y = (int)(Math.random()*(height+20));

          // Draw the message.
          
          g.drawString(message,x,y);
          
      }
      
   }  // end paint()
   

}  // end class RandomStrings
