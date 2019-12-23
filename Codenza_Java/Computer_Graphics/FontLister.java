FontLister

package com.ack.gui.awt.geometry;

import java.awt.*;

public class FontLister {

  public static void main( String[] argv ) {
    Font fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
    for( int i = 0; i < fonts.length; i++ ) {
      System.out.println( i + " font=" + fonts[i] );
    }
    Font myFont = fonts[2].deriveFont( Font.BOLD, 32 );
  }
}
