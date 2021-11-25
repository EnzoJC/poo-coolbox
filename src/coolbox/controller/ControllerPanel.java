
package coolbox.controller;

import coolbox.model.Empleado;
import coolbox.model.database.Conexion;
import coolbox.view.FrmAsistencia;
import coolbox.view.FrmEmpleados;
import coolbox.view.FrmPanelPrincipal;
import coolbox.view.FrmProductos;
import coolbox.view.FrmVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPanel implements ActionListener{
    FrmPanelPrincipal frmPanelPrincipal;
    Empleado empleado;
    public ControllerPanel(FrmPanelPrincipal frmPanelPrincipal,Empleado empleado) {
        this.frmPanelPrincipal = frmPanelPrincipal;
        this.empleado=empleado;
        frmPanelPrincipal.btnProductos.addActionListener(this);
        frmPanelPrincipal.btnEmpleados.addActionListener(this);
        frmPanelPrincipal.btnVenta.addActionListener(this);
        frmPanelPrincipal.btnAsistencia.addActionListener(this);
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
        if(e.getSource() == frmPanelPrincipal.btnVenta){
            FrmVenta frmVenta= new FrmVenta();
            ControllerVenta controllerVenta = new ControllerVenta(frmVenta,empleado);
            frmVenta.setVisible(true);
        }
        if(e.getSource() == frmPanelPrincipal.btnAsistencia){
            FrmAsistencia frmAsistencia = new FrmAsistencia();
            ControllerAsistencia controllerAsistencia = new ControllerAsistencia(frmAsistencia, empleado);
            frmAsistencia.setVisible(true);
        }
    }
    
}
