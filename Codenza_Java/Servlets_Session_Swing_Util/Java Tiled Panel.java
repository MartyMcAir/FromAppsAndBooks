Java Tiled Panel

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

    public class JTiledPanel extends JPanel {
    private Image tileimage;
    private int tilewidth;
    private int tileheight;
    private Rectangle rb;
    private Insets ri;
    
    /**
    * Create a JTiledPanel with the given image.
    * The tile argument may be null, you can set it later
    * with setTileImage(). Note that a JTiledPanel is
    * always opaque.
    */
        public JTiledPanel(Image tile) {
        super();
        setTileImage(tile);
        setOpaque(true);
        rb = new Rectangle(0,0,1,1);
        ri = new Insets(0,0,0,0);
    }
    
    /**
    * Create a JTiledPanel with the given image and
    * layout manager and double buffering status.
    * Either or both of the first two arguments
    * may be null.
    */
    public JTiledPanel(Image tile, LayoutManager mgr, boolean isDB)
        {
        super(mgr, isDB);
        setTileImage(tile);
        setOpaque(true);
        rb = new Rectangle(0,0,1,1);
        ri = new Insets(0,0,0,0);
    }
    
    /**
    * Get the current tiling image, or null if there
    * isn't any right now.
    */
    public Image getTileImage() { return tileimage; }
    
        public void setTileImage(Image tile) {
        tileimage = tile;
        tilewidth = 0;
        tileheight = 0;
    }
    
    /**
    * Paint this component
    */
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
            if (tileimage != null && tilewidth <= 0) {
            tileheight = tileimage.getHeight(this);
            tilewidth = tileimage.getWidth(this);
        }
            if (tileimage != null && tilewidth > 0) {
            Color bg = getBackground();
            getBounds(rb);
            Insets riv = getInsets(ri);
            rb.translate(riv.left, riv.top);
            rb.width -= (riv.left + riv.right);
            rb.height -= (riv.top + riv.bottom);
            Shape ccache = g.getClip();
            g.clipRect(rb.x, rb.y, rb.width, rb.height);
            int xp, yp;
                for(yp = rb.y; yp < rb.y + rb.height; yp += tileheight) {
                    for(xp = rb.x; xp < rb.x + rb.width; xp += tilewidth) {
                    g.drawImage(tileimage, xp, yp, bg, this);
                }
            }
            g.setClip(ccache);
        }
    }
    
    /**
    * Small main to do a self-test. Tiles with a image file
    * name taken from the command line. For example, if you
    * have a directory named images and an image in it
    * named tile1.gif then you would run this test
    * main as java JTiledPanel images/tile1.gif.
    */
        public static void main(String [] args) {
            if (args.length == 0) {
            System.out.println("Usage: java JTiledPanel imagefile");
            System.exit(0);
        }
        JFrame f = new JFrame("Test JTiledPanel " + args[0]);
        ImageIcon ic = new ImageIcon(args[0]);
        JTiledPanel jtp = new JTiledPanel(ic.getImage());
        jtp.setBorder(BorderFactory.createMatteBorder(3,4,5,6,Color.green));
        jtp.add(new JButton("Press Me!"));
        jtp.add(new JButton("Press Me Too!"));
        f.getContentPane().add(jtp, BorderLayout.CENTER);
        f.setSize(350,290);
        f.show();
            f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                System.exit(0);
        } });
    }
}
