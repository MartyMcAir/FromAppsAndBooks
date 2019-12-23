Frame (MainFrame)

/* This is an example of a Frame that exits the application when it is asked to close itself. Applications that want that behavior for their main frame can define a subclass of this class. */
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * This is an example of a Frame that exits the application when it is
 * asked to close itself.  Applications that want that behavior for their
 * main frame can define a subclass of this class.
 * <p>
 * This class requires java 1.1 or later to work.
 */
public class MainFrame extends Frame {
    /**
     * Constructs a new MainFrame that is initially invisible.
     */
    public MainFrame() {
        this("");
    }

    /**
     * Constructs a new, initially invisible MainFrame with the specified 
     * title.
     * @param title the title for the frame
     */
    public MainFrame(String title) {
	super(title);
        // Subclass WindowAdapter instead of implement WindowListener so
        // that we only need to override one method instead of
        // implementing seven methods.
        WindowListener listener;
        listener = new WindowAdapter()
          {
              public void windowClosing(WindowEvent evt) {
                  exit();
              } // windowClosing(WindowEvent)
          };
        addWindowListener(listener);
    } // constructor(String)

    /**
     * Override this method to verify that exiting is OK before actual
     * exit.
     */
    protected void exit() {
        System.exit(0);
    } // exit()
} // class MainFrame
