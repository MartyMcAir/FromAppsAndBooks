import javax.swing.* ;
import java.awt.event.* ;	

class Messages extends JFrame implements ActionListener
{
	JPanel pnl = new JPanel() ;

	JButton btn1 = new JButton( "Показать информационное сообщение" ) ;	
	JButton btn2 = new JButton( "Показать предупреждение" ) ;
	JButton btn3 = new JButton( "Показать сообщение об ошибке" ) ;

	public Messages()
	{
		super( "Окно Swing" );
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(pnl);

		pnl.add( btn1 ) ;			
		pnl.add( btn2 ) ;
		pnl.add( btn3 ) ;
		
		btn1.addActionListener(this);		
		btn2.addActionListener(this);
		btn3.addActionListener(this);
	
		setVisible( true );
	}

	public void actionPerformed( ActionEvent event )
	{
		if( event.getSource() == btn1) 
		JOptionPane.showMessageDialog( this,"Информация...","Диалоговое сообщение",JOptionPane.INFORMATION_MESSAGE );	
		
		if( event.getSource() == btn2)
		JOptionPane.showMessageDialog( this,"Предупреждение...","Диалоговое сообщение",JOptionPane.WARNING_MESSAGE);	
		
		if( event.getSource() == btn3)
		JOptionPane.showMessageDialog( this,"Ошибка...","Диалоговое сообщение",JOptionPane.ERROR_MESSAGE);	
	}

	public static void main( String[] args )
	{
		Messages gui = new Messages();
	}
}
