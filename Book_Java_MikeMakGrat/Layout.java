import javax.swing.* ;
import java.awt.*;

class Layout extends JFrame
{
	Container contentPane = getContentPane();

	JPanel pnl = new JPanel();
	JPanel grid = new JPanel(new GridLayout(2,2));

	public Layout()
	{
		super( "���� Swing" );
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );		
 
    		pnl.add(new JButton("��") ); 
    		pnl.add(new JButton("���") );
		pnl.add(new JButton("������") );
 
    		grid.add(new JButton("1")); 
    		grid.add(new JButton("2")); 
    		grid.add(new JButton("3")); 
    		grid.add(new JButton("4")); 

		contentPane.add("North", pnl ); 
    		contentPane.add("Center", grid ); 
    		contentPane.add("West",new JButton("�����")); 

		setVisible( true );
	}
	

	public static void main( String[] args ) 
	{
		Layout gui = new Layout() ;
	}	
}
