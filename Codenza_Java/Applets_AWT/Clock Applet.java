Clock Applet

import java.applet.*;
import java.awt.*;
import java.util.Date;

public class ClockApplet extends Applet implements Runnable {
	Thread timerThread;

	/* Applet Lifestyle Methods */
	public void start() {
		timerThread = new Thread(this, "Clock");
		timerThread.start();
	}
	public void stop() {
		if (timerThread == null)
			return;
		timerThread.stop();
		timerThread = null;
	}
 
	/* Runnable interface method */
	public void run() {
		while (timerThread != null) {
			repaint();	// request a redraw
			try {
				timerThread.sleep(1000);
			} catch (InterruptedException e){ /* do nothing*/ }
		}
	}

	/* AWT method */ 
	public void paint(Graphics g) {
		Date d = new Date();
		g.drawString(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds(), 1, 10);
	}
}
/*
<APPLET CODE="ClockApplet.class" WIDTH=60 HEIGHT=12>
(which you cant see until you get a Java-powered browser!)
</APPLET>
*/
