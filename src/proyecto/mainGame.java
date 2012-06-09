package proyecto;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;


public class mainGame extends javax.swing.JFrame {
    
    public mainGame(){
        initComponents();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new mainGame().setVisible(true);
            }
        });
        
    }
    
    private void initComponents(){
        
        homeBtn = new JButton();
        homeBtn.setIcon(new ImageIcon(getClass().getResource("/imagenes/menu1.png")));
        
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vampire WarGame");
        setMaximumSize(new java.awt.Dimension(950, 580));
        setMinimumSize(new java.awt.Dimension(950, 580));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 80));
        //getContentPane().add(new ImagePanel(new ImageIcon("resources/background.jpg").getImage()));
        pack();
        
    }
    
    /*
     * FUNCIONES
     */
    
    
    
    /*
     * FIN FUNCIONES
     */
    
    //EVENTOS
    
    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {                                     
        
    }
    
    
    private JButton homeBtn;
}

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}