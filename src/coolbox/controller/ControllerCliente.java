/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.controller;

import coolbox.model.Cliente;
import coolbox.model.crud.ClienteCrud;
import coolbox.view.PanelCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alexa
 */
public class ControllerCliente implements ActionListener {
    PanelCliente panelCliente;

    public ControllerCliente(PanelCliente panelCliente,String dni) {
        this.panelCliente = panelCliente;
        panelCliente.txtDni.setText(dni);
        panelCliente.btnAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelCliente.btnAgregar) {
            Cliente cliente= new Cliente(0, 
                    panelCliente.txtNombres.getText(),
                    panelCliente.txtApellidos.getText(),
                    panelCliente.txtDireccion.getText(), 
                    panelCliente.txtDni.getText(),
                    panelCliente.txtTelefono.getText(),
                    panelCliente.txtCorreo.getText());
            ClienteCrud clienteCrud = new ClienteCrud();
            clienteCrud.create(cliente);
        }
    }
    
    
    
}
