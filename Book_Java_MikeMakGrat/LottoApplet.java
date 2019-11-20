import javax.swing.*;
import java.awt.event.*;

public class LottoApplet extends JApplet implements ActionListener
{
	// ����������.
	JPanel pnl  = new JPanel();
	ClassLoader ldr = this.getClass().getClassLoader();
	java.net.URL imageURL = ldr.getResource("Lotto.png");
	ImageIcon icon = new ImageIcon( imageURL );		
	JLabel img  = new JLabel(icon);
	JTextField txt = new JTextField( "", 18 );
	JButton btn = new JButton("�������� ���������� ������");

	// ����� ����� �������.
	public void init()
	{
				
		pnl.add( img ); 
		pnl.add( txt ); 
		pnl.add( btn );
		btn.addActionListener( this );

		// ����� ����� ����.
		String bgStr = getParameter("BgColor");
		int bgHex = Integer.parseInt( bgStr, 16 );
		pnl.setBackground( new java.awt.Color( bgHex ));

		add( pnl );
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
				int r = (int) Math.ceil(Math.random() * 49) ;
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
}
