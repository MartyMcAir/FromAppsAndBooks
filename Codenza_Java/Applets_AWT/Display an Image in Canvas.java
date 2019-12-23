Display an Image in Canvas

import java.awt.*;
import java.awt.image.*;

     public class ImageCanvas extends Canvas {
     Image image;
    
         public ImageCanvas(String name) {
         MediaTracker media = new MediaTracker(this);
         image = Toolkit.getDefaultToolkit().getImage(name);
         media.addImage(image, 0);
             try {
             media.waitForID(0); 
         }
         catch (Exception e) {}
     }
    
         public ImageCanvas(ImageProducer imageProducer) {
         image = createImage(imageProducer);
     }
    
         public void paint(Graphics g) {
         g.drawImage(image, 0,0, this);
     }
    
         public static void main(String argv[]) {
             if (argv.length < 1) {
             System.out.println
             ("usage: ImageCanvas.class [image file name]");
             System.exit(0);
         }
         Frame frame = new Frame(argv[0]);
         frame.setLayout(new BorderLayout());
         frame.add("Center", new ImageCanvas(argv[0]));
         frame.resize(400,400);
         frame.show();
     }
}
