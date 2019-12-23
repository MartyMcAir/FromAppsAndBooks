Display time in Applet

class AppletTimer
    {
     javax.swing.Timer timer;
     String s;
     SimpleDateFormat timef = new SimpleDateFormat("HH:mm");
     //private Launch ll = new Launch();
    
     //public AppletTimer(final Applet ap)
     public AppletTimer(final JTextField tf)
         {
             timer = new javax.swing.Timer(1000, new ActionListener() {
                 public void actionPerformed(ActionEvent e) {
                 s = timef.format(new Date(System.currentTimeMillis()));
                 //ap.showStatus(s);
                 tf.setText(s);
             }
         });
         timer.start();
     }
}
And in ur applet create a JTextField and use like this
in the init() method

JTextField jtf = new JTextField();
new AppletTimer(jtf);
