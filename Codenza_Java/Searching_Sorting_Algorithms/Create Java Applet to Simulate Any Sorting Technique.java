// This is a java program to create an applet to simulate a sorting technique. This applet demonstrates Bubble Sort.


import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;

@SuppressWarnings("deprecation")
class ExplainBox extends Canvas
{
    private static final long serialVersionUID = 1L;
    static final int marginX = 6;
    static final int marginY = 3;
    String text = "";

    public ExplainBox()
    {
        setFont(new Font("TimesRoman", Font.PLAIN, 12));
    }

    public void setText(String text)
    {
        this.text = text;
        invalidate();
    }

    public void validate()
    {
        FontMetrics metrics = getFontMetrics(getFont());
        int baseLine = metrics.getAscent();
        int lineHeight = baseLine + metrics.getDescent();
        int width = metrics.stringWidth(text);
        Point corner = location();
        reshape(corner.x, corner.y, width + 2 * marginX, lineHeight + 2
                * marginY);
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.black);
        Dimension size = size();
        g.drawRect(0, 0, size.width - 1, size.height - 1);
        FontMetrics metrics = getFontMetrics(getFont());
        g.drawString(text, marginX, marginY + metrics.getAscent());
    }

    public boolean mouseExit(Event event, int x, int y)
    {
        return true;
    }
}

@SuppressWarnings("deprecation")
class CodePanel extends Panel
{
    private static final long serialVersionUID = 1L;
    static final int marginX = 15;
    static final int marginY = 20;
    static final int offsetX = 1;
    static final int offsetY = 1;
    static final int none = -1;
    String code[]; // Array to hold the source code
    String explainations[]; // Array to hold the explaination of source code
    Font font = new Font("TimesRoman", Font.PLAIN, 16);
    int lineHeight;
    int baseLine;
    int maxWidth = 0;
    int highlightedLine = none;
    ExplainBox explaination = new ExplainBox();
    Applet applet;

    public CodePanel(String code[], String explainations[], Applet applet)
    {
        this.code = code;
        this.explainations = explainations;
        this.applet = applet;
        setBackground(Color.white); // Set the background of code panel to be
        // white
        explaination.setBackground(Color.lightGray);
        explaination.setForeground(Color.lightGray);
        add(explaination);
        explaination.hide(); // Hide explaination until the code line is clicked
    }

    public Dimension preferredSize()
    {
        return new Dimension(280, 300);
    }

    public void addNotify()
    {
        super.addNotify();
        setFont(font);
        FontMetrics metrics = getFontMetrics(font);
        baseLine = metrics.getAscent();
        lineHeight = baseLine + metrics.getDescent();
        for (int i = 0; i < code.length; i++)
            {
                maxWidth = Math.max(maxWidth, metrics.stringWidth(code[i]));
            }
    }

    public void paint(Graphics g)
    {
        int y = marginY + baseLine;
        for (int i = 0; i < code.length; i++, y += lineHeight)
            {
                setBackground(Color.white);
                g.drawString(code[i], marginX, y);
            }
        highlightLine(highlightedLine);
    }

    public void reset()
    {
        if (highlightedLine != none)
            {
                colorLine(highlightedLine, Color.white);
            }
        highlightedLine = none;
    }

    public void highlightLine(int line)
    {
        if (highlightedLine != none)
            {
                colorLine(highlightedLine, Color.white);
            }
        highlightedLine = line;
        if (highlightedLine != none)
            {
                colorLine(highlightedLine, Color.pink);
            }
    }

    public void colorLine(int line, Color color)
    {
        Graphics g = getGraphics();
        int y = marginY + line * lineHeight;
        g.setColor(color);
        g.fillRect(0, y, size().width - 1, lineHeight);
        g.setColor(Color.black);
        g.drawString(code[line], marginX, y + baseLine);
    }

    public boolean mouseExit(Event event, int x, int y)
    {
        explaination.hide();
        validate();
        return true;
    }

    public boolean mouseUp(Event event, int x, int y)
    {
        int line = (y - marginY) / lineHeight;
        if ((line <= explainations.length) || (explainations[line].equals("")))
            {
                explaination.setText(explainations[line]);
                explaination.setBackground(Color.lightGray);
                explaination.validate();
                explaination.show();
            }
        else
            {
                explaination.hide();
            }
        validate();
        explaination.move(marginX + offsetX, marginY + offsetY + (line + 1)
                          * lineHeight);
        return true;
    }
}

@SuppressWarnings("deprecation")
class Algorithm extends Thread
{
    CodePanel codeDisplay; // Code Panel
    static int granularity; // Granularity Level
    SortingApplet applet; // Bubble Sort Applet
    Animation animation; // Animation Canvas
    public static int indexi = 0; // Loop Index
    public static int indexj = 0; // Loop Index
    public static int flag = -1;

    public Algorithm(CodePanel codeDisplay, int granularity, SortingApplet applet,
                     Animation animation)
    {
        this.codeDisplay = codeDisplay;
        this.applet = applet;
        Algorithm.granularity = granularity;
        this.animation = animation;
    }

    void setGranularity(int granularity)
    {
        Algorithm.granularity = granularity;
    }

    public void run()
    {
        int line = 0; // Line Number
        visualize(line, 2); // Visualize current line
        indexi = SortingApplet.SourceData.length - 1; // Set loop index value
        Algorithm.flag = 1; // Set execution status
        animation.repaint(); // Refresh animation canvas
        int forLoopLine1 = line; // Mark the line # of first for loop
        while (true)
            {
                if (!(indexi >= 1))
                    break;
                visualize(++line, 2);
                indexj = 0;
                animation.repaint();
                int forLoopLine2 = line; // Mark the line # of second for loop
                while (true)
                    {
                        if (!(indexj <= (indexi - 1)))
                            break;
                        visualize(++line, 2);
                        animation.repaint();
                        if (SortingApplet.SourceData[indexj] > SortingApplet.SourceData[indexj + 1])
                            {
                                // switch the two array elements
                                visualize(++line, 2);
                                int temp = SortingApplet.SourceData[indexj];
                                animation.repaint();
                                visualize(++line, 2);
                                SortingApplet.SourceData[indexj] = SortingApplet.SourceData[indexj + 1];
                                animation.repaint();
                                visualize(++line, 2);
                                SortingApplet.SourceData[indexj + 1] = temp;
                                animation.repaint();
                            }
                        line = forLoopLine2; // Set line # to be the second for loop
                        visualize(line, 1);
                        animation.repaint();
                        indexj++;
                    }
                line = forLoopLine1; // Set line # to be the first for loop
                visualize(line, 1);
                indexi--;
                animation.repaint();
            }
        Algorithm.flag = -1; // After execution finished, set flag back to -1
        animation.repaint();
        try
            {
                sleep(1000);
            }
        catch (Exception e)
            {
            }
        applet.sortButton.setLabel("  Sort  ");
        applet.sortButton.disable();
        applet.stopButton.disable();
        applet.resetButton.enable();
        visualize(0, 0); // After execution finished, highlight the first line
        applet.finished();
    }

    void visualize(int line, int level)
    {
        codeDisplay.highlightLine(line); // Highlight the current line
        codeDisplay.repaint();
        if (level > granularity)
            {
                try
                    {
                        sleep(300);
                    }
                catch (Exception e)
                    {
                    }
                ;
            }
        else
            {
                suspend();
            }
    }
}

@SuppressWarnings("deprecation")
class Animation extends Panel
{
    private static final long serialVersionUID = 1L;
    int dX = 30; // starting position for x coordinate
    int dBar = 15; // width of bar
    int dUnit = 15; // unit height
    int dDis = 20; // distance between bars
    Image offImage; // Offscreen Image
    Graphics offG; // Offscreen Graphics
    Font font = new Font("TimesRoman", Font.PLAIN, 14);

    public Animation()
    {
        repaint();
    }

    public Dimension preferredSize()
    {
        return new Dimension(320, 300);
    }

    public Dimension minimumSize()
    {
        return preferredSize();
    }

    public void update(Graphics g)
    {
        paint(g);
    }

    public void paint(Graphics g)
    {
        Dimension d = size();
        if (offImage == null)
            {
                offImage = createImage(d.width, d.height);
                offG = offImage.getGraphics();
                offG.setFont(font);
            }
        offG.setColor(Color.yellow); // Set background of Animation Canvas to be
        // yellow
        offG.fillRect(0, 0, d.width, d.height); // Draw background
        offG.setColor(Color.blue); // Set color for bars to be blue
        int x = 40; // x coordinate of the bar position
        for (int i = 0; i < SortingApplet.SourceData.length; i++, x = x + dDis
                + dBar)
            {
                if (((i == Algorithm.indexj) || (i == Algorithm.indexj + 1))
                        && (Algorithm.flag == 1))
                    {
                        offG.setColor(Color.green); // Use green color to indicate the
                        // bars being compared currently
                    }
                else if (((i > Algorithm.indexi) && (Algorithm.flag == 1))
                         || ((Algorithm.indexi == 0) && (Algorithm.indexj == 1) && (Algorithm.flag == -1)))
                    {
                        offG.setColor(Color.black); // Use black color to indicate bars
                        // that are already sorted
                    }
                offG.fillRect(x, 180 - SortingApplet.SourceData[i] * dUnit, dBar,
                              SortingApplet.SourceData[i] * dUnit); // fill bars
                offG.setColor(Color.blue); // Reset color to be blue
                offG.drawString("" + i, x + 7, 25); // Draw the current index value
                // of i
                offG.drawString("" + SortingApplet.SourceData[i], x + 7, 40);
            }
        offG.drawString("Index:", 5, 25);
        offG.drawString("Value:", 5, 40);
        offG.drawString("I:", 5, 205);
        offG.drawString("J:", 5, 230);
        offG.drawString("J+1:", 5, 255);
        if (Algorithm.indexi != 0)
            offG.drawString("i", 40 + 9 + Algorithm.indexi * (dDis + dBar), 205);
        if (Algorithm.indexj < Algorithm.indexi)
            {
                offG.drawString("j", 40 + 9 + Algorithm.indexj * (dDis + dBar), 230);
                offG.drawString("j+1", 40 + 7 + (Algorithm.indexj + 1)
                                * (dDis + dBar), 255); // Mark the current j+1 position
            }
        g.drawImage(offImage, 0, 0, this);
    }
}

@SuppressWarnings("deprecation")
public class SortingApplet extends Applet
{
    private static final long serialVersionUID = 1L;
    // Source code for Bubble Sort Algorithm
    String code[] = { "  for ( int i = n - 1; i >= 1; i-- )        ",
                      "      for ( int j = 0; j <= i - 1; j++ )    ",
                      "          if ( data [j] > data[j+1] ) {     ",
                      "             int temp = data [j];           ",
                      "             data [j] = data [j+1];         ",
                      "             data [j+1] = temp;             ",
                      "          }                                 "
                    };
    // Explaination for each line of code
    String pseudoCode[] =
    {
        "go through elements of 'data' from last to 1 index",
        "go through elements of 'data' from 0 to i index",
        "to compare data [j] and data [j+1]",
        "before swap, remember data [j]", "assign data [j] = data [j+1]",
        "assign data [j+1] the original value of data [j]",
        "end of if statement"
    };
    public static int SourceData[] = { 7, 4, 5, 1, 8, 3, 6, 2 };
    public static int normalData[] = { 7, 4, 5, 1, 8, 3, 6, 2 };
    public static int bestData[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
    public static int worstData[] = { 8, 7, 6, 5, 4, 3, 2, 1 };
    Button sortButton = new Button("   Sort   "); // sort Button
    Button stopButton = new Button("   Stop   "); // stop Button
    Button resetButton = new Button("   Reset  "); // reset Button
    int choice = 0; // choice index
    Choice dataChoice = new Choice(); // choice of different data sets
    String dataLabels[] = { "normal case", "best case", "worst case" };
    int granularity = 0; // granularity index
    Choice granularityChoice = new Choice(); // choice of different granularity
    String granularityLabels[] = { "entire sort", "next swap", "next line" }; // granularity
    // labels
    private Panel controlPanel = new Panel();
    CodePanel codeDisplay = new CodePanel(code, pseudoCode, this);
    Algorithm algorithm = null;
    Animation animation = new Animation();

    public void init()
    {
        setLayout(new BorderLayout()); // Set the panle to be border layout
        add("West", codeDisplay);
        add("East", animation);
        add("South", controlPanel);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Set
        // codepanel
        // to be
        // flowlayout
        controlPanel.add(sortButton); // Add sort button
        controlPanel.add(stopButton); // Add stop button
        stopButton.disable(); // At the beginning, stop button is disabled
        controlPanel.add(resetButton); // Add reset button
        resetButton.disable(); // At the beginning, resuet button is disabled
        controlPanel.add(dataChoice); // Add data choice menu
        for (int i = 0; i < dataLabels.length; i++)
            {
                dataChoice.addItem(dataLabels[i]); // Set label for each menu items
            }
        controlPanel.add(granularityChoice); // Add granularity choice menu
        for (int i = 0; i < granularityLabels.length; i++)
            {
                granularityChoice.addItem(granularityLabels[i]); // Set label for
                // each menu items
            }
    }

    public void finished()
    {
        algorithm = null;
    }

    public boolean action(Event event, Object what)
    {
        if (event.target == sortButton)
            {
                if (granularity == 0)
                    sortButton.disable();
                else
                    sortButton.setLabel("Continue");
                resetButton.disable(); // Once sorting begins, reset Button is
                // disabled
                stopButton.enable(); // stop Button is enabled
                if (algorithm == null)
                    {
                        algorithm = new Algorithm(codeDisplay, granularity, this,
                                                  animation);
                        algorithm.start(); // Start the Bubble Sort Algorithm
                    }
                else
                    {
                        algorithm.resume(); // Continue the Bubble Sort Algorithm
                    }
            }
        else if (event.target == stopButton)
            {
                // stop Button is clicked
                algorithm.stop(); // Stop the Bubble Sort Algorithm
                sortButton.disable(); // Disable the sort Button
                stopButton.disable(); // Disable the stop Button
                resetButton.enable(); // Enable the reset Button
                finished(); // Applet finished
            }
        else if (event.target == resetButton)
            {
                // reset Button is clicked
                finished(); // Applet finished
                sortButton.setLabel("  Sort  "); // Set sort Button label
                sortButton.enable();
                stopButton.disable();
                resetDataArray(); // Recover the data array to its initial value
                // based on the dataChoice menu
                Algorithm.flag = -1; // Reset flag to initial value
                animation.repaint(); // Refresch the animation canvas
            }
        else if (event.target == dataChoice)
            {
                // If dataChoice menu is changed
                choice = dataChoice.getSelectedIndex();
            }
        else if (event.target == granularityChoice)
            {
                // If granularityChoice menu is changed
                granularity = granularityChoice.getSelectedIndex();
                if (algorithm != null)
                    {
                        algorithm.setGranularity(granularity); // Set the granularity to
                        // be the new value in
                        // the menu
                    }
            }
        else
            {
                return false;
            }
        return true;
    }

    public void resetDataArray()
    {
        // Reset loop index to its initial value
        Algorithm.indexi = 0;
        Algorithm.indexj = 0;
        if (choice == 0)
            {
                // "Normal Case" is selected
                // Reset the source data to be the normal case
                for (int i = 0; i < normalData.length; i++)
                    {
                        SourceData[i] = normalData[i];
                    }
            }
        else if (choice == 1)
            {
                // "Best Case" is selected
                // Reset the source data to be the best case
                for (int i = 0; i < bestData.length; i++)
                    {
                        SourceData[i] = bestData[i];
                    }
            }
        else if (choice == 2)
            {
                // "Worst Case" is selected
                // Reset the source data to be the worst case
                for (int i = 0; i < worstData.length; i++)
                    {
                        SourceData[i] = worstData[i];
                    }
            }
    }
}

/*
