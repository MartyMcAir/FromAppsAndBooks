import javax.swing.*;

class Labels extends JFrame 
{
	JPanel pnl = new JPanel();

	ClassLoader ldr = this.getClass().getClassLoader();
	ImageIcon duke = new ImageIcon( ldr.getResource("duke.png") );

	//ImageIcon duke = new ImageIcon( "duke.png" );
	
	JLabel lbl1 = new JLabel( duke ) ;
	JLabel lbl2 = new JLabel( "Дюк - талисман технологии Java." ) ;
	JLabel lbl3 = new JLabel( "Дюк", duke, JLabel.CENTER ) ;

	public Labels()
	{
		super("Swing Window");
		setSize( 500,200 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		add(pnl);

		lbl3.setHorizontalTextPosition(JLabel.CENTER);
		lbl3.setVerticalTextPosition(JLabel.BOTTOM);
		

		lbl1.setToolTipText( "Дюк - талисман Java" ) ;
		
		pnl.add( lbl1 ) ;
		pnl.add( lbl2 ) ;
		pnl.add( lbl3 ) ;

		setVisible( true );
	}

	public static void main ( String[] args )
	{
		Labels gui = new Labels();
	} 
}
