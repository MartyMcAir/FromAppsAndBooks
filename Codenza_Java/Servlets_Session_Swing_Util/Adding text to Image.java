Adding text to Image

public class Test extends JFrame
    {
     String s;
     ImageIcon img;
     Image image;
     JPanel p;
     JLabel label;
     JLabel text;
     public Test()
         {
         s = "Hi";
         Font f = new Font("Serif",Font.BOLD,12);
         text = new JLabel("Hi");
         text.setFont(f);
        
         MediaTracker mt = new MediaTracker(this);
         image = Toolkit.getDefaultToolkit().createImage("test.jpg");
         mt.addImage(image,0);
         try{mt.waitForID(0);}catch(InterruptedException ie){}
         int width = image.getWidth(null);
         int height = image.getHeight(null);
         BufferedImage bimg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         bimg.createGraphics().drawImage(image, 0, 0, this);
         bimg.getGraphics().setFont(f);
         bimg.getGraphics().drawString(s,250,100);
        
         img = new ImageIcon(bimg);
         label = new JLabel(img);
         p = new JPanel();
         p.add(label);
         getContentPane().add(p);
     }
     public static void main(String args[])
         {
         Test tt = new Test();
         tt.setDefaultCloseOperation(EXIT_ON_CLOSE);
         tt.setSize(750,600);
         tt.setVisible(true);
     }
}
