import java.awt.image.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;

public class myJFrame extends javax.swing.JFrame {
    BufferedImage bi;
    Graphics gp;
    Graphics2D bi2d;
    int panelWidth;
    int panelHeight;

    public myJFrame() {
        initComponents();
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        this.bi = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
        this.bi2d = bi.createGraphics();
        this.gp = panel.getGraphics();
        
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        // ��������� ���������� ����������� ����� ���������� ���������
        // ������ ��� ������� 17.3.3 �����
        // ���������������� ��� � �������� ���������� ����������
        /*
        Toolkit tk = Toolkit.getDefaultToolkit();
        Map map = (Map)(tk.getDesktopProperty("awt.font.desktophints"));
        if (map != null) bi2d.addRenderingHints(map);
        */
        
        bi2d.setColor(Color.BLACK); // ������� ���� ������
        
        // ������� ������� ��������� ������
        HashMap fm = new HashMap();
        // ��������� � ������� ��������
        fm.put(TextAttribute.SIZE, 22.0f);
        fm.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        fm.put(TextAttribute.WIDTH, TextAttribute.WIDTH_EXTENDED);
        // ������� ����� ������ ������ �� ������ ������� ���������
        Font f1 = new Font(fm);
        bi2d.setFont(f1);
        bi2d.drawString("��������: BOLD EXTENDED 20pt", 20, 40);
        
        // ������ ��������� ������, ������ 12 �������
        Font f2 = new Font("Times New Roman", Font.BOLD, 12);
        bi2d.setFont(f2);
        bi2d.drawString("�������� �����, 12pt", 20, 70);
        // ����������� �����, ������ 24 ������
        Font f24 = f2.deriveFont(24.0f);
        bi2d.setFont(f24);
        bi2d.drawString("����������� �����, 24pt", 20, 95);
        
        // ������ ������ Affine Transform
        AffineTransform at = new AffineTransform();
        // �������� �������������� - ������ ������ �����
        at.shear(.4, 0);
        // ������� ����������� ����� � ��������
        Font f24af = f24.deriveFont(at);
        bi2d.setFont(f24af);
        bi2d.drawString("������������� ������, 24pt", 20, 125);
        
        // ����� �� ������ ����� ��������� fm
        HashMap asfm = fm;
        // ��������� ����� ��������: ���� ������ � ����
        asfm.put(TextAttribute.FOREGROUND, Color.RED);
        asfm.put(TextAttribute.BACKGROUND, Color.YELLOW);
        // ������� ������ ������ � ����������
        AttributedString as = new AttributedString("������ � ����������", asfm);
        // ������� �������� �������� ������
        AttributedCharacterIterator characterIterator = as.getIterator();
        // ������� ������ �� ������ ����� ��������
        bi2d.drawString(characterIterator, 20, 160);
        
        gp.drawImage(bi, 0, 0, panel);
        
        Font f = new Font("Times New Roman", Font.BOLD, 12);
        AttributedCharacterIterator.Attribute[] a = f.getAvailableAttributes();
        for (int i = 0; i < a.length; i++) System.out.println(a[i]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 587, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 229, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
