Finding Width and Height of an Image

import java.awt.*;
import javax.swing.*;

public class ImageXY
    {
     public static void main(String[] args)
         {
        
         Image image = Toolkit.getDefaultToolkit().getImage("test.jpg");
         ImageIcon icon = new ImageIcon(image);
         int height = icon.getIconHeight();
         int width = icon.getIconWidth();
         System.out.println("height"+height);
         System.out.println("width"+width);
     }
}
