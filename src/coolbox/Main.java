package coolbox;

import coolbox.view.FrmLogin;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Fallo al iniciar la libreria FlatLaf" + ex);
        }
        FrmLogin frmLogin = new FrmLogin();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLogin.setVisible(true);
            }
        });
    }
}
