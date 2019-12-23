Fade an Image

import java.applet.*;
 import java.awt.*;
 import java.awt.image.*;
 import java.net.*;

 public class FadeImage extends Applet {
   Image   img, faded;
   int level, sign;
   MediaTracker tracker;
   AlphaFilter f;
   FilteredImageSource fis;

   public void init() {
     level = 0;
     sign =  15;
     tracker = new MediaTracker(this);
     try { 
       img = getImage(new URL(getDocumentBase(), "gumby.gif"));
       tracker.addImage(img,0);
       tracker.waitForID(0); 
       }
     catch (Exception e) {
       e.printStackTrace();
       }
     f = new AlphaFilter();
     f.setLevel(level);
     fis = new FilteredImageSource(img.getSource(), f) ;

     FadeThread ft = new FadeThread();
     ft.delayedFading(this, 20); 
     ft.start();
     }

   public void paint(Graphics g) {
     if (faded != null) {
        g.drawImage(faded,0,0,this);
        }
     }

   public void fadeIt() {
     Graphics g = this.getGraphics();
     level += sign;
     if (level < 0) {
        level=0; 
        sign = sign * -1;
        }
     if (level > 255) {
        level=255; 
        sign =  sign * -1;
      try {
        Thread.sleep(1000);
        }
      catch (Exception e) {}
        }
     f.setLevel(level);
     if (faded != null) faded.flush();
     faded = this.createImage(fis);
     tracker.addImage(faded,0);
     try { 
       tracker.waitForID(0); 
       }
     catch (Exception ex) {
       ex.printStackTrace();
       }
     repaint();
     }

   class FadeThread extends Thread {
     FadeImage fadeApplet;
     int delay; 

     public void delayedFading(FadeImage f, int delay) {
       this.fadeApplet = f;
       this.delay = delay;
       }

     public void run() {
       while (true) {
         try {
           sleep(delay);
           fadeApplet.fadeIt();
           } 
         catch (Exception e) {
           e.printStackTrace();
           }
         }
       }
     }

    class AlphaFilter extends RGBImageFilter {
      private int level;

      public AlphaFilter() { 
        canFilterIndexColorModel = true;
        }

      public void setLevel(int lev) {
        level = lev;
        }

      public int filterRGB(int x, int y, int rgb) {
        int a = level * 0x01000000;
        return (rgb &   0x00ffffff) | a;
        }
      }
 }
