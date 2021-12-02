package coolbox;

import coolbox.gui.FrmLogin;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Fallo al iniciar la libreria FlatLaf" + ex);
        }
        FrmLogin frmLogin = new FrmLogin();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLogin.setVisible(true);
            }
        });
    }
}
