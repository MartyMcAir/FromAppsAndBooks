Panel (Tiled Panel)



import java.awt.*;

import java.util.*;

import java.lang.*;



public class TiledPanel extends Panel {

    Image image;

    int i_width, i_height, p_width, p_height;

    Dimension of_panel;

    int v_off;

    int h_off;

    

    /* Constructors */

    public TiledPanel() {

        image = null;

       } // Constructor()

    

    public TiledPanel(Image i) {

        image = i;

    } // Constructor(Image)





    /* painting the background of the panel */

    public void paint(Graphics g) {

        if (image != null) {

            i_width = image.getWidth(this);

            i_height = image.getHeight(this);

            of_panel = this.size();

            p_width = of_panel.width;

            p_height = of_panel.height;

            v_off = 0;

            h_off = 0;

            int vloop = p_height/i_height + 1;

            int hloop = p_width/i_width + 1;

            // Need this to get the image into memory or something

            // It's really really slow any other way I tried it

            // This works and it doesn't harm anything

            

            g.drawImage(image,0,0,this);

            

            // Do the tile effect

            for (int i=0;i<vloop;i++) {

               
for (int j=0;j<hloop;j++) {

                   
g.drawImage(image,h_off,v_off,this);

                   
h_off = h_off + i_width;

               
} // for

               
v_off = v_off + i_height;

               
h_off = 0;

            } // for

        } // if

    } // paint(Graphics)

} // class TiledPanel
