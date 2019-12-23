Load an audio clip and play it

 import java.applet.*;
 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;

 public class LoadAudioAndPlay extends JApplet
 {
	 private AudioClip sound1, sound2, currentSound;
	 private JButton playSound, loopSound, stopSound;
	 private JComboBox chooseSound;

	 // load the image when the applet begins executing
	 public void init()
	 {
		 Container c = getContentPane();
		 c.setLayout( new FlowLayout() );

		 String choices[] = { "Welcome", "Hi" };
		 chooseSound = new JComboBox( choices );
		 chooseSound.addItemListener( new ItemListener()
		 {
			 public void itemStateChanged( ItemEvent e )
			 {
				 currentSound.stop();

				 currentSound = chooseSound.getSelectedIndex() == 0 ? sound1 : sound2;
			 }
		 });
		 c.add( chooseSound );

		 ButtonHandler handler = new ButtonHandler();
		 playSound = new JButton( "Play" );
		 playSound.addActionListener( handler );
		 c.add( playSound );
		 loopSound = new JButton( "Loop" );
		 loopSound.addActionListener( handler );
		 c.add( loopSound );
		 stopSound = new JButton( "Stop" );
		 stopSound.addActionListener( handler );
		 c.add( stopSound );

		 sound1 = getAudioClip( getDocumentBase(), "welcome.wav" );
		 sound2 = getAudioClip( getDocumentBase(), "hi.au" );
		 currentSound = sound1;
	 }

	 // stop the sound when the user switches Web pages
	 // (i.e., be polite to the user)
	 public void stop()
	 {
		 currentSound.stop();
	 }

	 private class ButtonHandler implements ActionListener
	 {
		 public void actionPerformed( ActionEvent e )
		 {
			 if ( e.getSource() == playSound )
				 currentSound.play();
			 else if ( e.getSource() == loopSound )
				 currentSound.loop();
			 else if ( e.getSource() == stopSound )
				 currentSound.stop();
		 }
	 }
 }
