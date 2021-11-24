/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.controller;

import coolbox.model.Producto;
import coolbox.model.db.ProductoCrud;
import coolbox.view.FrmProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexa
 */
public class ControllerProductos {
    FrmProductos frmProductos;
    List<Producto> listaProductos = new ArrayList<>();
    
    public ControllerProductos(FrmProductos frmProductos) {
        this.frmProductos = frmProductos;
        this.listaProductos= getListaProductos();
        frmProductos.tblProductos.setModel(poblarTabla());
        this.frmProductos.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto producto = new Producto(0,
                        frmProductos.txtNombre.getText(),
                        Float.parseFloat(frmProductos.txtPrecioCompra.getText()),
                        Float.parseFloat(frmProductos.txtPrecioVenta.getText()),
                        Integer.parseInt(frmProductos.txtStock.getText()));
                ProductoCrud productoCrud= new ProductoCrud();
                productoCrud.create(producto);
                listaProductos= getListaProductos();
                frmProductos.tblProductos.setModel(poblarTabla());
                
            }
        });
    }

    private DefaultTableModel poblarTabla() {
        DefaultTableModel TablaModelo =new DefaultTableModel();
        String[] headers = {"ID", "Nombre", "precio_compra", "precio_venta", "stock"};
	for (String i : headers) {
	    TablaModelo.addColumn(i);
	}    
        for(Producto prod:listaProductos){
            String[] datos= new String[5];
            datos[0] = prod.getId()+"";
            datos[1] = prod.getNombre();
            datos[2] = prod.getPrecioCompra()+"";
            datos[3] = prod.getPrecioVenta()+"";
            datos[4] = prod.getStock()+"";    
            TablaModelo.addRow(datos);
        }
        return TablaModelo;
    }

    private List<Producto> getListaProductos() {
        ProductoCrud productoCrud = new ProductoCrud();
        return productoCrud.read();
    }
    
}
