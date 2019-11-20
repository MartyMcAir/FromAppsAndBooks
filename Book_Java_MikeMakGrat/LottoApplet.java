import javax.swing.*;
import java.awt.event.*;

public class LottoApplet extends JApplet implements ActionListener
{
	// Компоненты.
	JPanel pnl  = new JPanel();
	ClassLoader ldr = this.getClass().getClassLoader();
	java.net.URL imageURL = ldr.getResource("Lotto.png");
	ImageIcon icon = new ImageIcon( imageURL );		
	JLabel img  = new JLabel(icon);
	JTextField txt = new JTextField( "", 18 );
	JButton btn = new JButton("Показать счастливые номера");

	// Точка входа апплета.
	public void init()
	{
				
		pnl.add( img ); 
		pnl.add( txt ); 
		pnl.add( btn );
		btn.addActionListener( this );

		// Выбор цвета фона.
		String bgStr = getParameter("BgColor");
		int bgHex = Integer.parseInt( bgStr, 16 );
		pnl.setBackground( new java.awt.Color( bgHex ));

		add( pnl );
	}

	// Обработчик событий.
	public void actionPerformed( ActionEvent event )
	{
		if( event.getSource() == btn )
		{
			// Объявление переменных.
			int[] nums = new int[50];
			String str = "";

			// Заполняем элементы 1-49 числами от 1 до 49.
			for( int i = 1; i < 50; i++ ) { nums[i] = i; }
		
			// Перемешиваем массив.
			for( int i = 1; i < 50; i++ )
			{
				int r = (int) Math.ceil(Math.random() * 49) ;
				int temp=nums[i]; nums[i]=nums[r]; nums[r]=temp;
			}

			// Отображаем с 1 по 6 элементы.
			for ( int i = 1; i < 7; i++ )
			{
				str += "  " + Integer.toString(nums[ i ]) + "  ";

			}
			txt.setText( str );
		}
	}
}
