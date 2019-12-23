ComboBox Demo

 // Using a JComboBox to select an image to display.
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class ComboBoxTest extends JFrame {
 private JComboBox images;
 private JLabel label;
 private String names[] =
 { "bug1.gif", "bug2.gif",
 "travelbug.gif", "buganim.gif" };
 private Icon icons[] =
 { new ImageIcon( names[ 0 ] ),
 new ImageIcon( names[ 1 ] ),
 new ImageIcon( names[ 2 ] ),
 new ImageIcon( names[ 3 ] ) };

 public ComboBoxTest()
 {
 super( "Testing JComboBox" );

 Container c = getContentPane();
 c.setLayout( new FlowLayout() );

 images = new JComboBox( names );
 images.setMaximumRowCount( 3 );

 images.addItemListener(
 new ItemListener() {
 public void itemStateChanged( ItemEvent e )
 {
 label.setIcon(
 icons[ images.getSelectedIndex() ] );
 }
 }
 );

 c.add( images );

 label = new JLabel( icons[ 0 ] );
 c.add( label );

 setSize( 350, 100 );
 show();
 }

 public static void main( String args[] )
 {
 ComboBoxTest app = new ComboBoxTest();

 app.addWindowListener(
 new WindowAdapter() {
 public void windowClosing( WindowEvent e )
 {
 System.exit( 0 );
 }
 }
 );
 }
}
