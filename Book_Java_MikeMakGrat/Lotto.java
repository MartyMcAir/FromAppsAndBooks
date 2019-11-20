import javax.swing.*;
import java.awt.event.*;

public class Lotto extends JFrame implements ActionListener
{
	// ����������.
	ClassLoader ldr = this.getClass().getClassLoader();
	java.net.URL iconURL = ldr.getResource("Lotto.png");
	ImageIcon icon 	= new ImageIcon( iconURL );		
	JLabel img  	= new JLabel(icon);	
	JTextField txt 	= new JTextField( "", 18 );
	JButton btn 	= new JButton( "�������� ���������� ������" );
	JPanel pnl  	= new JPanel();

	// �����������.
	public Lotto()
	{
		super( "���������� Lotto " ); 
		setSize( 260,200 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );		
		pnl.add( img ); 
		pnl.add( txt ); 
		pnl.add( btn );
		btn.addActionListener( this );
		add( pnl ); 
		setVisible( true );
	}

	// ���������� �������.
	public void actionPerformed( ActionEvent event )
	{
		if( event.getSource() == btn )
		{
			// ���������� ����������.
			int[] nums = new int[50];
			String str = "";

			// ��������� �������� 1-49 ������� �� 1 �� 49.
			for( int i = 1; i < 50; i++ ) { nums[i] = i; }
		
			// ������������ ������.
			for( int i = 1; i < 50; i++ )
			{
				int r = (int) Math.ceil( Math.random() * 49 );
				int temp=nums[i]; nums[i]=nums[r]; nums[r]=temp;
			}

			// ���������� � 1 �� 6 ��������.
			for ( int i = 1; i < 7; i++ )
			{
				str += "  " + Integer.toString(nums[ i ]) + "  ";

			}
			txt.setText( str );
		}
	}

	// ����� �����.
	public static void main ( String[] args )
	{
		Lotto lotto = new Lotto();
	} 
}

