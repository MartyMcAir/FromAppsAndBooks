Demonstrating CardLayout

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;

 public class CardDeck extends JFrame implements ActionListener
 {
	 private CardLayout cardManager;
	 private JPanel deck;
	 private JButton controls[];
	 private String names[] = { "First card", "Next card", "Previous card", "Last card" };

	 public CardDeck()
	 {
		 super( "CardLayout " );

		 Container c = getContentPane();

		 // create the JPanel with CardLayout
		 deck = new JPanel();
		 cardManager = new CardLayout();
		 deck.setLayout( cardManager );

		 // set up card1 and add it to JPanel deck
		 JLabel label1 = new JLabel( "card one", SwingConstants.CENTER );
		 JPanel card1 = new JPanel();
		 card1.add( label1 );
		 deck.add( card1, label1.getText() ); // add card to deck

		 // set up card2 and add it to JPanel deck
		 JLabel label2 = new JLabel( "card two", SwingConstants.CENTER );
		 JPanel card2 = new JPanel();

		 card2.setBackground( Color.yellow );
		 card2.add( label2 );
		 deck.add( card2, label2.getText() ); // add card to deck

		 // set up card3 and add it to JPanel deck
		 JLabel label3 = new JLabel( "card three" );
		 JPanel card3 = new JPanel();
		 card3.setLayout( new BorderLayout() );
		 card3.add( new JButton( "North" ), BorderLayout.NORTH );
		 card3.add( new JButton( "West" ), BorderLayout.WEST );
		 card3.add( new JButton( "East" ), BorderLayout.EAST );
		 card3.add( new JButton( "South" ), BorderLayout.SOUTH );
		 card3.add( label3, BorderLayout.CENTER );

		 deck.add( card3, label3.getText() ); // add card to deck

		 // create and layout buttons that will control deck
		 JPanel buttons = new JPanel();
		 buttons.setLayout( new GridLayout( 2, 2 ) );
		 controls = new JButton[ names.length ];

		 for ( int i = 0; i < controls.length; i++ )
		 {
			 controls[ i ] = new JButton( names[ i ] );
			 controls[ i ].addActionListener( this );
			 buttons.add( controls[ i ] );
		 }

		 // add JPanel deck and JPanel buttons to the applet
		 c.add( buttons, BorderLayout.WEST );
		 c.add( deck, BorderLayout.EAST );

		 setSize( 450, 200 );
		 show();
	 }

	 public void actionPerformed( ActionEvent e )
	 {
		 if ( e.getSource() == controls[ 0 ] )
			 cardManager.first( deck ); // show first card
		 else if ( e.getSource() == controls[ 1 ] )
			 cardManager.next( deck ); // show next card
		 else if ( e.getSource() == controls[ 2 ] )
			 cardManager.previous( deck ); // show previous card
		 else if ( e.getSource() == controls[ 3 ] )
			 cardManager.last( deck ); // show last card
	 }

	 public static void main( String args[] )
	 {
		 CardDeck cardDeckDemo = new CardDeck();

		 cardDeckDemo.addWindowListener( new WindowAdapter()
		 {
			 public void windowClosing( WindowEvent e )
			 {
				 System.exit( 0 );
			 }
		 } );
	 }
 }
