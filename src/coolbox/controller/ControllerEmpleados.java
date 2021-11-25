/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.controller;

import coolbox.model.Empleado;
import coolbox.model.Producto;
import coolbox.model.crud.EmpleadoCrud;
import coolbox.model.crud.ProductoCrud;
import coolbox.view.FrmEmpleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alexa
 */
public class ControllerEmpleados implements ActionListener,MouseListener {
    FrmEmpleados frmEmpleados;
    List<Empleado> listaEmpleados = new ArrayList<>();
    int idEmpleado=0;
    
    public ControllerEmpleados(FrmEmpleados frmEmpleados) {
        this.frmEmpleados = frmEmpleados;
        this.listaEmpleados= getListaEmpleados();
        frmEmpleados.tblEmpleados.setModel(poblarTabla());
        frmEmpleados.btnGuardar.addActionListener(this);
        frmEmpleados.tblEmpleados.addMouseListener(this);
        frmEmpleados.btnEliminar.addActionListener(this);
        frmEmpleados.btnLimpiar.addActionListener(this);
    }
    private List<Empleado> getListaEmpleados() {
        EmpleadoCrud empleadoCrud = new EmpleadoCrud();
        return empleadoCrud.read();
    }

    private DefaultTableModel poblarTabla() {
        DefaultTableModel TablaModelo =new DefaultTableModel();
        String[] headers = {"ID", "Nombre", "Apellidos", "dni", "Usuario","Contraseña"};
	for (String i : headers) {
	    TablaModelo.addColumn(i);
	}    
        for(Empleado emp:listaEmpleados){
            String[] datos= new String[6];
            datos[0] = emp.getId()+"";
            datos[1] = emp.getNombres();
            datos[2] = emp.getApellidos()+"";
            datos[3] = emp.getDni()+"";
            datos[4] = emp.getUsuario()+"";
            datos[5] = emp.getContrasenia()+"";    
            TablaModelo.addRow(datos);
        }
        return TablaModelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmEmpleados.btnGuardar) {
            Empleado empleado = getEmpleado();
            boolean flag=false;
            for(Empleado emp: listaEmpleados){
                if(emp.getId()==idEmpleado){
                    flag = true;
                    break;
                }
            }
            EmpleadoCrud empleadoCrud= new EmpleadoCrud();
            if(flag){
                empleadoCrud.update(empleado);
            }else{
                
                empleadoCrud.create(empleado);
            }  
            listaEmpleados= getListaEmpleados();
            frmEmpleados.tblEmpleados.setModel(poblarTabla());
            LimpiarDatos();
        }
        if(e.getSource() == frmEmpleados.btnEliminar){
            EmpleadoCrud empleadoCrud= new EmpleadoCrud();
            Empleado empleado = getEmpleado();
            empleadoCrud.delete(empleado);
            listaEmpleados= getListaEmpleados();
            frmEmpleados.tblEmpleados.setModel(poblarTabla());
            LimpiarDatos();
        }
         if(e.getSource() == frmEmpleados.btnLimpiar){
             LimpiarDatos();
         }
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == frmEmpleados.tblEmpleados){
            int id= Integer.parseInt((String) frmEmpleados.tblEmpleados.getValueAt( frmEmpleados.tblEmpleados.getSelectedRow(), 0));
            idEmpleado= id;
            
            frmEmpleados.txtNombres.setText((String) frmEmpleados.tblEmpleados.getValueAt( frmEmpleados.tblEmpleados.getSelectedRow(), 1));
            frmEmpleados.txtApellidos.setText((String) frmEmpleados.tblEmpleados.getValueAt( frmEmpleados.tblEmpleados.getSelectedRow(), 2));
            frmEmpleados.txtDni.setText((String) frmEmpleados.tblEmpleados.getValueAt( frmEmpleados.tblEmpleados.getSelectedRow(), 3));
            frmEmpleados.txtUsuario.setText((String) frmEmpleados.tblEmpleados.getValueAt( frmEmpleados.tblEmpleados.getSelectedRow(), 4));
            frmEmpleados.txtContrasenia.setText((String) frmEmpleados.tblEmpleados.getValueAt( frmEmpleados.tblEmpleados.getSelectedRow(), 5));
        }
         
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }

    private void LimpiarDatos() {
        idEmpleado=0;
        frmEmpleados.txtNombres.setText("");
        frmEmpleados.txtApellidos.setText("");
        frmEmpleados.txtDni.setText("");
        frmEmpleados.txtUsuario.setText("");
        frmEmpleados.txtContrasenia.setText("");
    }

    private Empleado getEmpleado() {
        return new Empleado(idEmpleado,
            frmEmpleados.txtNombres.getText(),
            frmEmpleados.txtApellidos.getText(),
            frmEmpleados.txtDni.getText(),
            frmEmpleados.txtUsuario.getText(),
            frmEmpleados.txtContrasenia.getText());
    }

    
    
    
}
