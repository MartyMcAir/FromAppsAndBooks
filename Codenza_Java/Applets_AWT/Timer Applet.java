Timer Applet

import java.applet.*;
import java.awt.*;

public class TimerApplet extends Applet implements Runnable
    {
     private String msg2 = new String("");
     private int secs;
     private int mins;
     private int hrs;
     private Thread clock;
     public int time =300000;
    
     public void destroy()
         {
         clock.stop();
     }
    
     public void init()
         {
         String parameter;
        
         if(clock == null)
             {
             clock = new Thread(this);
             clock.start();
         }
     }
    
     public void paint(Graphics gr)
         {
         ++secs;
         if(secs == 60)
             {
             mins++;
             secs = 0;
         }
         if(mins == 60)
             {
             hrs++;
             secs = 0;
             mins = 0;
         }
         //gr.setFont(bigFont);
         gr.setColor(Color.red);
         //gr.drawString(msg1,10,100);
         gr.drawString(" "+ hrs + " Hours " + mins + " Minutes " + secs + " Seconds", 10, 130);
         gr.drawString(msg2,10,150);
         setBackground(Color.black);
     }
    
     public void run()
         {
         while(true)
             {
             repaint();
             try
                 {
                 clock.sleep(1000);
             }
             catch(InterruptedException e)
                 {
             }
         }
     }
    
     public void start()
         {
         clock.resume();
     }
    
     public void stop()
         {
         clock.suspend();
     }
}
