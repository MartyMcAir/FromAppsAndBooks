Paint Shapes and Text of different colors and fonts

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Painter2 extends JFrame {
   private int topX, topY, width, fontSize,
      height, bottomX, bottomY, shape;
   private boolean clear, textOn, filled;
   private Color drawingColor;
   private String font;
   private JTextField text;
   private JPanel panel1, panel2, panel3, panel4;
   private JRadioButton ovalBox, rectBox, lineBox;
   private ButtonGroup shapeGroup;
   private JCheckBox fillBox;
   private JComboBox colorList, fontList, sizeList;
   private JButton clearButton;
   private String colorNames[] = { "Black", "Green", "Blue",
      "Red", "Cyan" };
   private Color colors[] = { Color.black, Color.green, Color.blue,
      Color.red, Color.cyan };
   private String fontNames[] = { "Serif", "SansSerif", "Monospaced" };
   private String sizeNames[] =  { "9", "10", "22", "72" };
   private int sizes[] = { 9, 10, 22, 72 };
   private final int OVAL = 1, LINE = 2, RECT = 3;

   private ToolWindow tools;

   // Painter2 constructor
   public Painter2()
   {
      super( "Painting Window" );
      
      addMouseListener( new MouseHandler() );

      // set defaults for painting
      drawingColor = Color.black;
      shape = OVAL;
      font = "Serif";
      fontSize = 9;

	setDefaultCloseOperation( EXIT_ON_CLOSE );
	setBackground( Color.white );
      setSize( 300, 300 );
      show();

      // create new ToolWindow
      tools = new ToolWindow();
      
   }  // end constructor

   // paint the new window.  super is not called so
   // that the previous images will not be erased.
   public void paint( Graphics g )
   {
      g.setColor( drawingColor );

      // draw text
      if ( textOn ) {
         g.setFont( new Font( font, Font.PLAIN, fontSize ) );
         g.drawString( text.getText(), topX, topY );
         textOn = false;
         return;
         
      }  // end if statement

      // set shape's top left coordinates
      if ( shape != LINE ) {
         topX = Math.min( topX, bottomX );
         topY = Math.min( topY, bottomY );
         
      }  // end if statement

      // draw filled shape
      if ( filled && shape != LINE )

         switch ( shape ) {

            case OVAL:
               g.fillOval( topX, topY,  width, height );
               break;

            case RECT:
               g.fillRect( topX, topY, width, height );
               break;
               
         }  // end switch statement

      // draw unfilled shapes
      else

         switch ( shape ) {

            case OVAL:
               g.drawOval( topX, topY,  width, height );
               break;

            case LINE:
               g.drawLine( topX, topY, bottomX, bottomY );
               break;

            case RECT:
               g.drawRect( topX, topY, width, height );
               break;
               
         }  // ens switch statement

      // clear background
      if ( clear == true ) {
         g.setColor( Color.white );
         g.fillRect( 0, 0, getSize().width, getSize().height );
         clear = false;
         
      }  // end if statement

   }  // end method paint

   // inner class for window containing GUI
   private class ToolWindow extends JFrame {

      // ToolWindow constructor
      public ToolWindow()
      {
         super( "Tool Window" );
         
         // set up to edit text
         text = new JTextField( "Text", 25 );

         text.addActionListener(

            // anonymous inner class to handle text drawing
            new ActionListener () {

               public void actionPerformed( ActionEvent event )
               {
                  textOn = true;
                  repaint();
                  
               }  // end actionPerformed method

            }  // end anonymous inner class

         ); // end call to addActionListener

         // set up to choose font
         fontList = new JComboBox( fontNames );
         fontList.setMaximumRowCount( 3 );

         fontList.addItemListener(

            // anonymous inner class to select font
            new ItemListener() {

               // change font
               public void itemStateChanged( ItemEvent event )
               {
                  font =
                     fontNames[ fontList.getSelectedIndex() ];
                  
               }  // end itemStateChanged method

            }  // end anonymous inner class

         ); // end call to addItemListener

         // set up to choose font size
         sizeList = new JComboBox( sizeNames );
         sizeList.setMaximumRowCount( 3 );

         sizeList.addItemListener(

            // anonymous inner class to select font size
            new ItemListener() {

               // change font size
               public void itemStateChanged( ItemEvent event )
               {
                  fontSize =
                     sizes[ sizeList.getSelectedIndex() ];
                  
               }  // end itemStateChanged method

            }  // end anonymous inner class

         ); // end call to addItemListener

         // set up to choose color
         colorList = new JComboBox( colorNames );
         colorList.setMaximumRowCount( 3 );

         colorList.addItemListener(

            // anonymous inner class to select color
            new ItemListener() {

               // change color
               public void itemStateChanged( ItemEvent event )
               {
                  drawingColor =
                     colors[ colorList.getSelectedIndex() ];
                  
               }  // end itemStateChanged method

            }  // end anonymous inner class

         ); // end call to addItemListener

         // set up clear button
         clearButton = new JButton( "Clear" );
         clearButton.addActionListener(
            new ClearButtonHandler() );

         // set up to choose filled
         fillBox  = new JCheckBox( "Filled" );
         FillBoxHandler fillHandle = new FillBoxHandler();
         fillBox.addItemListener( fillHandle );

         // set up to choose shapes
         ovalBox = new JRadioButton( "Oval", true );
         lineBox = new JRadioButton( "Line", false );
         rectBox = new JRadioButton( "Rectangle", false );
         RadioButtonHandler handler = new RadioButtonHandler();
         ovalBox.addItemListener( handler );
         lineBox.addItemListener( handler );
         rectBox.addItemListener( handler );
         shapeGroup = new ButtonGroup();
         shapeGroup.add(ovalBox);
         shapeGroup.add(lineBox);
         shapeGroup.add(rectBox);

         // set up GUI layout
         panel1 = new JPanel();
         panel2 = new JPanel();
         panel3 = new JPanel();
	   panel4 = new JPanel();

         panel1.setLayout( new GridLayout( 1, 4 ) );
         panel2.setLayout( new GridLayout( 1, 3 ) );
         panel3.setLayout( new FlowLayout() );
	   panel4.setLayout( new FlowLayout() );

         panel1.add( ovalBox );
         panel1.add( lineBox );
         panel1.add( rectBox );
         panel1.add( fillBox );
         panel2.add( new JScrollPane( colorList ) );
         panel2.add( new JScrollPane( fontList ) );
         panel2.add( new JScrollPane( sizeList ) );
	   panel3.add( text );
	   panel4.add( clearButton );

         Container container = getContentPane();
         container.setLayout( new FlowLayout() );
         container.add( panel1 );
         container.add( panel2 );
         container.add( panel3 );
         container.add( panel4 );

	   setDefaultCloseOperation( EXIT_ON_CLOSE );
         setSize( 350, 175 );
         setLocation( 300, 0 );
         setVisible( true );

      }  // end ToolWindow constructor

   }  // end inner class ToolWindow

   // set coordinate and dimension values
   private class MouseHandler extends MouseAdapter {

      public void mousePressed( MouseEvent event )
      {
         topX = event.getX();
         topY = event.getY();
         
      }  // end mousePressed method

      public void mouseReleased( MouseEvent event )
      {
         bottomX = event.getX();
         bottomY = event.getY();
         width = Math.abs( topX - bottomX );
         height = Math.abs( topY - bottomY );

         repaint();
         
      }  // end mouseReleased method

   }  // end inner class MouseHandler

   // clear background
   private class ClearButtonHandler implements ActionListener {

      public void actionPerformed( ActionEvent event )
      {
         clear = true;
         repaint();
         
      }  // end actionPerformed method

   }  // end inner class ClearButtonHandler

   // determine which type of shape to draw
   private class RadioButtonHandler implements ItemListener {

      public void itemStateChanged( ItemEvent event )
      {
         if ( event.getSource() == ovalBox )
            shape = OVAL;

         else if ( event.getSource() == lineBox )
            shape = LINE;

         else if ( event.getSource() == rectBox )
            shape = RECT;
         
      }  // end itemStateChanged method

   }  // end inner class RadioButtonHandler

   // determine if shape should be filled
   private class FillBoxHandler implements ItemListener {

      public void itemStateChanged( ItemEvent event )
      {
         if ( event.getStateChange() == ItemEvent.SELECTED )
            filled = true;

         else
            filled = false;
         
      }  // end ItemStateChanged method

   }  // end inner class FillBoxHandler

   // execute application
   public static void main( String args[] )
   {
      Painter2 application = new Painter2();

      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      
   }  // end main method

}  // end class Painter2
