Parameters info

import java.applet.*;
import java.awt.*;

/** Null Demo, just demonstrates getParameterInfo() and getAppletInfo() */
public class ParmInfoDemo extends Applet {

	/** Init routine: set a font, initialize UI components. */
	public void init() {
		setLayout(new FlowLayout());

		String psize = getParameter("fontsize"); 
		if (psize == null) psize = "12";
		System.out.println("Fontsize is " + psize);
		Font f = new Font("Helvetica", Font.PLAIN,
			Integer.parseInt(psize));
		Label l = new Label("Font Demo");
		l.setFont(f);
		add(l);
	}

	/** Return information about this applet. */
	public String getAppletInfo() {
		return "ParmInfoDemo Applet, Version 0\n" +
			;
	}

	/** Return list of allowable parameters. */
	public String[][] getParameterInfo() {
		String param_info[][] = {
			{"fontsize",    "10-20",    "Size of font"},
		};
		return param_info;
	}
}
/*
<APPLET CODE="ParmInfoDemo.class" WIDTH=300 HEIGHT=60>
	<PARAM NAME="fontsize" VALUE="20">
	<P>You need Java to view this!</P>
</APPLET>
*/
