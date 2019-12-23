Try running a CGI-BIN script from within Java

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;

/**
 * Try running a CGI-BIN script from within Java.
 */
public class TryCGI extends Applet implements ActionListener {
	protected Button goButton;

	public void init() {
		add(goButton = new Button("Go for it!"));
		goButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		try {
			URL myNewURL = new URL("http://server/cgi-bin/credit");

			// debug...
			System.out.println("URL = " + myNewURL);

			// "And then a miracle occurs..."
			getAppletContext().showDocument(myNewURL);

		} catch (Exception err) {
			System.err.println("Error!\n" + err);
			showStatus("Error, look in Java Console for details!");
		}
	}
}
/*
<APPLET CODE="TryCGI" WIDTH=100 HEIGHT=30>
<P>If you can see this, you need to get a Java-powered(tm) Web Browser
before you can watch for real.
</APPLET>
*/
