import javax.swing.* ;
import java.awt.event.* ;	

class Mouse extends JFrame implements MouseMotionListener, MouseListener 	
{
	JPanel pnl = new JPanel() ;

	JTextArea txtArea = new JTextArea( 8, 38 ) ;	
	int x, y ;

	public Mouse()
	{
		super("���� Swing");
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(pnl);

		pnl.add( txtArea ) ;
		txtArea.addMouseMotionListener(this);	
		txtArea.addMouseListener(this);

		setVisible( true );
	}

	public void mouseMoved   ( MouseEvent event) { x = event.getX(); y = event.getY();	}		
	public void mouseDragged ( MouseEvent event) {	}

	public void mouseEntered ( MouseEvent event) { txtArea.setText( "������ ������ ����" );	}
	public void mousePressed ( MouseEvent event) { txtArea.append( "\n������ ������, ����� ��������� � ������� X : " + x + " Y : " + y );	}	
	public void mouseReleased( MouseEvent event) { txtArea.append( "\n������ ���� ��������") ;	}	
	public void mouseClicked ( MouseEvent event) {	}	
	public void mouseExited  ( MouseEvent event) {	}

	public static void main( String[] args )
	{
		Mouse gui = new Mouse();
	}
}
