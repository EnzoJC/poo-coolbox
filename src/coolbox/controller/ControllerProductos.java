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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class ControllerProductos implements ActionListener,MouseListener{
    FrmProductos frmProductos;
    List<Producto> listaProductos = new ArrayList<>();
    int idProducto=0;
    
    public ControllerProductos(FrmProductos frmProductos) {
        this.frmProductos = frmProductos;
        this.listaProductos= getListaProductos();
        frmProductos.tblProductos.setModel(poblarTabla());
        frmProductos.btnGuardar.addActionListener(this);
        frmProductos.tblProductos.addMouseListener(this);
        frmProductos.btnEliminar.addActionListener(this);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmProductos.btnGuardar) {
            Producto producto = getProducto();
            boolean flag=false;
            for(Producto p: listaProductos){
                if(p.getId()==idProducto){
                    flag = true;
                    break;
                }
            }
            ProductoCrud productoCrud= new ProductoCrud();
            if(flag){
                productoCrud.update(producto);
            }else{
                
                productoCrud.create(producto);
            }  
            listaProductos= getListaProductos();
            frmProductos.tblProductos.setModel(poblarTabla());
            LimpiarDatos();
        }
        
        if(e.getSource() == frmProductos.btnEliminar){
            ProductoCrud productoCrud= new ProductoCrud();
            Producto producto = getProducto();
            productoCrud.delete(producto);
            listaProductos= getListaProductos();
            frmProductos.tblProductos.setModel(poblarTabla());
            LimpiarDatos();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == frmProductos.tblProductos){
            int id= Integer.parseInt((String) frmProductos.tblProductos.getValueAt( frmProductos.tblProductos.getSelectedRow(), 0));
            idProducto= id;
            
            frmProductos.txtNombre.setText((String) frmProductos.tblProductos.getValueAt( frmProductos.tblProductos.getSelectedRow(), 1));
            frmProductos.txtPrecioCompra.setText((String) frmProductos.tblProductos.getValueAt( frmProductos.tblProductos.getSelectedRow(), 2));
            frmProductos.txtPrecioVenta.setText((String) frmProductos.tblProductos.getValueAt( frmProductos.tblProductos.getSelectedRow(), 3));
            frmProductos.txtStock.setText((String) frmProductos.tblProductos.getValueAt( frmProductos.tblProductos.getSelectedRow(), 4));
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

    private Producto getProducto() {
       return new Producto(idProducto,
            frmProductos.txtNombre.getText(),
            Float.parseFloat(frmProductos.txtPrecioCompra.getText()),
            Float.parseFloat(frmProductos.txtPrecioVenta.getText()),
            Integer.parseInt(frmProductos.txtStock.getText()));
    }
    private void LimpiarDatos(){
         idProducto=0;
         frmProductos.txtNombre.setText("");
         frmProductos.txtPrecioCompra.setText("");
         frmProductos.txtPrecioVenta.setText("");
         frmProductos.txtStock.setText("");
    }
    
}
