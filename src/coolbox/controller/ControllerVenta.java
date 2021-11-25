/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.controller;

import coolbox.model.Cliente;
import coolbox.model.DetalleVenta;
import coolbox.model.Empleado;
import coolbox.model.Producto;
import coolbox.model.Venta;
import coolbox.model.crud.ClienteCrud;
import coolbox.model.crud.DetalleVentaCrud;
import coolbox.model.crud.EmpleadoCrud;
import coolbox.model.crud.ProductoCrud;
import coolbox.model.crud.VentaCrud;
import coolbox.view.FrmVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo Carrión
 */
public class ControllerVenta implements ActionListener, KeyListener {
    private FrmVenta frmVenta;
    private ProductoCrud productoCrud;
    private EmpleadoCrud empleadoCrud;
    private ClienteCrud clienteCrud;
    private DetalleVentaCrud detalleVentaCrud;
    private VentaCrud ventaCrud;
    private Empleado empleado;
    private List<DetalleVenta> listaDetalleVenta = new ArrayList<>();

    public ControllerVenta(FrmVenta frmVenta, Empleado empleado) {
        this.frmVenta = frmVenta;
        this.empleado = empleado;
        this.frmVenta.btnAtras.addActionListener(this);
        this.frmVenta.btnRealizarVenta.addActionListener(this);
        this.frmVenta.btnQuitar.addActionListener(this);
        this.frmVenta.txtCodigoProducto.addKeyListener(this);
        this.frmVenta.txtCliente.addKeyListener(this);
    }
    
    private DefaultTableModel poblarTabla() {
        DefaultTableModel tablaModelo =new DefaultTableModel();
        String[] headers = {"ID", "Nombre", "Precio", "Cantidad"};
	for (String i : headers) {
	    tablaModelo.addColumn(i);
	}
        
        for(DetalleVenta detalleVenta : listaDetalleVenta) {
            String[] datos= new String[5];
            datos[0] = detalleVenta.getProducto().getId() + "";
            datos[1] = detalleVenta.getProducto().getNombre();
            datos[2] = detalleVenta.getProducto().getPrecioVenta() + "";
            datos[3] = detalleVenta.getCantidad() + "";    
            tablaModelo.addRow(datos);
        }
        return tablaModelo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmVenta.btnRealizarVenta){
            Venta venta = new Venta();
            venta.setCliente(clienteCrud.buscarPorDni(frmVenta.txtCliente.getText()));
            venta.setEmpleado(empleado);
            venta.setTotal(obtenerTotal());
            venta.setId(ventaCrud.ulitmoId() + 1);
            ventaCrud.create(venta);
            
            for (DetalleVenta detalleVenta : listaDetalleVenta) {
                detalleVenta.setVenta(venta);
                detalleVentaCrud.create(detalleVenta);
            }
            JOptionPane.showMessageDialog(frmVenta, "Venta Exitosa");
            // TODO limpiar los campos y la tabla
        }
    }
    
    private float obtenerTotal() {
        float total = 0;
        for (DetalleVenta detalleVenta : listaDetalleVenta) {
            total += (detalleVenta.getCantidad() * detalleVenta.getProducto().getPrecioVenta());
        }
        return total;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == frmVenta.txtImporte){
            if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
		e.consume();
	    } else {
                float vuelto = Float.parseFloat(frmVenta.txtImporte.getText()) - obtenerTotal();
                if (vuelto > 0) {
                    frmVenta.lvlCambio.setText("S/ " + vuelto);
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == frmVenta.txtCodigoProducto) {
            if (e.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
                Producto producto = productoCrud.buscarPorId(Integer.parseInt(frmVenta.txtCodigoProducto.getText()));
                if (producto == null){
                    JOptionPane.showMessageDialog(null, "El producto no existe");
                } else {
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
                    DetalleVenta detalleVenta = new DetalleVenta();
                    detalleVenta.setCantidad(cantidad);
                    detalleVenta.setProducto(producto);
                    listaDetalleVenta.add(detalleVenta);
                    frmVenta.tblVentas.setModel(poblarTabla());
                    
                    frmVenta.lblSubtotal.setText("S/ " + (obtenerTotal() * 0.82));
                    frmVenta.lblIgv.setText("S/ " + (obtenerTotal() * 0.18));
                    frmVenta.lblTotal.setText("S/ " + obtenerTotal());
                    limpiarDatos();
                }
            }
        }
        if (e.getSource() == frmVenta.txtCliente) {
            if (e.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
                Cliente cliente = clienteCrud.buscarPorDni(frmVenta.txtCliente.getText());
                if (cliente == null) {
                    // Lanzar panel de registro de cliente
                    // despues de registrar tambien se bloquea el txt
                } else {
                    frmVenta.txtCliente.setEnabled(false);
                }
            }
        }
    }
    
    private void limpiarDatos(){
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
