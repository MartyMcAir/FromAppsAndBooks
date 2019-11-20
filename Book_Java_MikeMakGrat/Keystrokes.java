import javax.swing.*;
import java.awt.event.* ;	

class Keystrokes extends JFrame implements KeyListener 
{
	JPanel pnl = new JPanel();

	JTextField field  = new JTextField( 38 ) ;	
	JTextArea txtArea = new JTextArea( 5, 38 ) ;

	public Keystrokes()
	{
		super( "���� Swing" );
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(pnl);
		
		pnl.add( field );	
		pnl.add( txtArea );
		
		field.addKeyListener( this ) ; 
	
		setVisible( true );
	}

	public void keyPressed( KeyEvent event )	
	{
		txtArea.setText("������ �������") ;
	}

	public void keyTyped( KeyEvent event )	
	{
		txtArea.append("\n������ : " + event.getKeyChar()) ;
	}
	
	public void keyReleased( KeyEvent event )	
	{
		int keyCode = event.getKeyCode();
		txtArea.append( "\n��� ������� : " + keyCode );
		txtArea.append( "\n����� ������� : " + event.getKeyText(keyCode));
	}


	public static void main ( String[] args )
	{
		Keystrokes gui = new Keystrokes();
	} 
}

