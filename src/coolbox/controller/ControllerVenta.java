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
import coolbox.view.FrmPanelPrincipal;
import coolbox.view.FrmVenta;
import coolbox.view.PanelCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enzo Carrión
 */
public class ControllerVenta implements ActionListener, KeyListener {
    private FrmVenta frmVenta;
    private ProductoCrud productoCrud = new ProductoCrud();
    private EmpleadoCrud empleadoCrud = new EmpleadoCrud();
    private ClienteCrud clienteCrud = new ClienteCrud();
    private DetalleVentaCrud detalleVentaCrud = new DetalleVentaCrud();
    private VentaCrud ventaCrud = new VentaCrud();
    private Empleado empleado;
    private List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("###.##");

    public ControllerVenta(FrmVenta frmVenta, Empleado empleado) {
        this.frmVenta = frmVenta;
        this.empleado = empleado;
        this.frmVenta.btnAtras.addActionListener(this);
        this.frmVenta.btnRealizarVenta.addActionListener(this);
        this.frmVenta.btnQuitar.addActionListener(this);
        this.frmVenta.txtCodigoProducto.addKeyListener(this);
        this.frmVenta.txtCliente.addKeyListener(this);
        this.frmVenta.txtImporte.addKeyListener(this);
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
            if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')&& e.getKeyChar()!=java.awt.event.KeyEvent.VK_ENTER) {
		e.consume();
	    }
            if(e.getKeyChar()==java.awt.event.KeyEvent.VK_ENTER){
                System.out.println(obtenerTotal());
                System.out.println(frmVenta.txtImporte.getText());
                System.out.println(Float.parseFloat(frmVenta.txtImporte.getText())+"");
                float vuelto = (Float.parseFloat(frmVenta.txtImporte.getText()) - obtenerTotal());
                if (vuelto >= 0) {
                    frmVenta.lvlCambio.setText("S/ " + vuelto);
                }else{
                    frmVenta.lvlCambio.setText("El monto no es suficiente");
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
                }
                else{
                    int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
                    DetalleVenta detalleVenta = new DetalleVenta();
                    detalleVenta.setCantidad(cantidad);
                    detalleVenta.setProducto(producto);
                    listaDetalleVenta.add(detalleVenta);
                    frmVenta.tblVentas.setModel(poblarTabla());
                    float subtotal=  roundFloat((obtenerTotal()*0.82f), 2);
                    float igv=roundFloat((obtenerTotal()*0.18f), 2);
                    frmVenta.lblSubtotal.setText("S/ " + subtotal);
                    frmVenta.lblIgv.setText("S/ " + igv);
                    frmVenta.lblTotal.setText("S/ " + roundFloat(obtenerTotal(), 2));
                   
                }
            }
        }
        if (e.getSource() == frmVenta.txtCliente) {
            if (e.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
                Cliente cliente = clienteCrud.buscarPorDni(frmVenta.txtCliente.getText());
                if (cliente == null) {
                    // Lanzar panel de registro de cliente
                    registrarProveedor(frmVenta.txtCliente.getText());
                    
                    // despues de registrar tambien se bloquea el txt
                    frmVenta.txtCliente.setEnabled(false);
                } else {
                    frmVenta.txtCliente.setEnabled(false);
                }
            }
        }
    }
    
    private void limpiarDatos(){
        frmVenta.lblSubtotal.setText("S/ " + (obtenerTotal() * 0.82));
        frmVenta.lblIgv.setText("S/ " + (obtenerTotal() * 0.18));
        frmVenta.lblTotal.setText("S/ " + obtenerTotal());
        frmVenta.txtCliente.setText("");
        frmVenta.txtCodigoProducto.setText("");
        frmVenta.txtImporte.setText("");
        frmVenta.lvlCambio.setText("S/ 00.00");
        
    }
    public void registrarProveedor(String dni) {
        JDialog jDialog = new JDialog(this.frmVenta, true);
        PanelCliente panelCliente = new PanelCliente();
        jDialog.add(panelCliente);
        jDialog.setSize(460, 530); // [430, 500]
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        ControllerCliente controllerCliente= new ControllerCliente(panelCliente, dni);
        jDialog.setVisible(true);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    private static float roundFloat(float f, int places) {
 
        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }
}
