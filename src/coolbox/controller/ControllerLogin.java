package coolbox.controller;

import coolbox.model.crud.EmpleadoCrud;
import coolbox.model.database.Conexion;
import coolbox.view.FrmLogin;
import coolbox.view.FrmPanelPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControllerLogin implements ActionListener {
    private FrmLogin frmLogin;

    public ControllerLogin(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        frmLogin.btnLogin.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmLogin.btnLogin) {
            Conexion.getConexion();
            if (frmLogin.txtUsuario.getText().equals("admin") && frmLogin.txtContrasenia.getText().equals("admin")){
                FrmPanelPrincipal frmPanelPrincipal = new FrmPanelPrincipal();
                EmpleadoCrud empleadoCrud = new EmpleadoCrud();
                ControllerPanel controllerPanel = new ControllerPanel(frmPanelPrincipal,empleadoCrud.buscarPorId(1));
                frmLogin.dispose();
                frmPanelPrincipal.setVisible(true);
            } else {
                FrmPanelPrincipal frmPanelPrincipal = new FrmPanelPrincipal();
               // ControllerPanel controllerPanel = new ControllerPanel(frmPanelPrincipal);
                frmLogin.dispose();
                /*frmPanelPrincipal.btnProductos.setVisible(false);
                frmPanelPrincipal.btnEmpleados.setVisible(false);
                frmPanelPrincipal.btnAsistencia.setVisible(false);*/
                frmPanelPrincipal.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "Fallo al iniciar la libreria FlatLaf" + ex);
        }
        FrmLogin frmLogin = new FrmLogin();
        ControllerLogin controllerLogin = new ControllerLogin(frmLogin);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmLogin.setVisible(true);
            }
        });
    }
}
