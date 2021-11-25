
package coolbox.controller;

import coolbox.model.database.Conexion;
import coolbox.view.FrmEmpleados;
import coolbox.view.FrmPanelPrincipal;
import coolbox.view.FrmProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPanel implements ActionListener{
    FrmPanelPrincipal frmPanelPrincipal;

    public ControllerPanel(FrmPanelPrincipal frmPanelPrincipal) {
        this.frmPanelPrincipal = frmPanelPrincipal;
        frmPanelPrincipal.btnProductos.addActionListener(this);
        frmPanelPrincipal.btnEmpleados.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmPanelPrincipal.btnProductos) {
            FrmProductos frmProductos= new FrmProductos();
            ControllerProductos controllerProductos = new ControllerProductos(frmProductos);
            frmProductos.setVisible(true);
        }
        if(e.getSource() == frmPanelPrincipal.btnEmpleados){
            FrmEmpleados frmEmpleados= new FrmEmpleados();
            ControllerEmpleados controllerEmpleados = new ControllerEmpleados(frmEmpleados);
            frmEmpleados.setVisible(true);
        }
    }
    
}
