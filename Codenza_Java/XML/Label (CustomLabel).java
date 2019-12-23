Label (CustomLabel)


import java.awt.*;


/**
* This class implments a label control by subclassing Canvas.
*/

public class CustomLabel extends
Canvas {

    
private String text; // The text to be displayed.

    
private Insets margins; // determines size of margins

    
private FontMetrics fm; // metrics for current font



    /**

    * Construct a CustomLabel object that displays the specified text.

    * @param text text to be displayed.

    */

    
public CustomLabel(String text) {

        this.text = text;

        margins = new Insets(4,4,4,4);

    } // setText(String)

    


    /**

    * Sets the font for this object.

    */

    
public void setFont(Font f) {

        super.setFont(f);

        fm = getFontMetrics(f);

    } // setFont(Font)

    


    /**

    * Notifies the Component that it has been added to a container

    * and if a peer is required, it should be created.

    * This method should be called by Container.add, and not by user

    * code directly.

    * @see #removeNotify

    */

    
public void addNotify() {

        super.addNotify();

        fm = getFontMetrics(getFont());

    } // addNotify()



    /**

    * Returns the minimum size that this component must be to paint

    * itself properly.

    */

    
public Dimension minimumSize() {

        int width = margins.left + fm.stringWidth(text) + margins.right;

        int height = margins.top + fm.getHeight() + margins.bottom;

        return new Dimension(width, height);

    } // minimumSize()

    


    /**

    * Returns the preferred size for this component.

    */

    
public Dimension preferredSize() {

        return minimumSize();

    } // preferredSize()

    


    /**

    * Paint this label.

    */

    
public void paint(Graphics g) {

        super.paint(g);

        g.setFont(getFont());

        g.setColor(getForeground());

        g.drawString(text, margins.left, margins.top+fm.getHeight());

    } // paint(Graphics)

    


    /**

    * Get the text displayed by this object.

    */

    
public String getText() {

        return text;

    } // getText()

    


    /**

    * Set the text displayed by this object.

    * @param text text to be displayed.

    */    

    
public void setText(String text) {

        this.text = text;

    } // setText(String)

} // class CustomLabel
