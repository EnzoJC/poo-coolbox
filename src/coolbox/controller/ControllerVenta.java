/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.controller;

import coolbox.model.Caja;
import coolbox.model.Cliente;
import coolbox.model.DetalleVenta;
import coolbox.model.Empleado;
import coolbox.model.Movimiento;
import coolbox.model.Producto;
import coolbox.model.Venta;
import coolbox.model.crud.CajaCrud;
import coolbox.model.crud.ClienteCrud;
import coolbox.model.crud.DetalleVentaCrud;
import coolbox.model.crud.EmpleadoCrud;
import coolbox.model.crud.MovimientoCrud;
import coolbox.model.crud.OperacionCrud;
import coolbox.model.crud.ProductoCrud;
import coolbox.model.crud.VentaCrud;
import coolbox.view.FrmPanelPrincipal;
import coolbox.view.FrmVenta;
import coolbox.view.PanelCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class ControllerVenta implements ActionListener, KeyListener, MouseListener{
    private FrmVenta frmVenta;
    private ProductoCrud productoCrud = new ProductoCrud();
    private EmpleadoCrud empleadoCrud = new EmpleadoCrud();
    private ClienteCrud clienteCrud = new ClienteCrud();
    private DetalleVentaCrud detalleVentaCrud = new DetalleVentaCrud();
    private VentaCrud ventaCrud = new VentaCrud();
    private MovimientoCrud movimientoCrud= new MovimientoCrud();
    private CajaCrud cajaCrud= new CajaCrud();
    private OperacionCrud operacionCrud= new OperacionCrud();   
    private Empleado empleado;
    private List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
    private int idSeleccionado=0;
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
        this.frmVenta.tblVentas.addMouseListener(this);
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
                detalleVenta.getProducto().setStock( detalleVenta.getProducto().getStock()- detalleVenta.getCantidad());
                productoCrud.update(detalleVenta.getProducto());
                detalleVentaCrud.create(detalleVenta);
            }
            JOptionPane.showMessageDialog(frmVenta, "Venta Exitosa");
            // TODO limpiar los campos y la tabla
            Movimiento movimiento;
            if(obtenerTotal()>0){
                movimiento= new Movimiento(0, empleado, cajaCrud.buscarPorId(1), obtenerTotal(),operacionCrud.buscarPorId(1));
            }else{
                movimiento= new Movimiento(0, empleado, cajaCrud.buscarPorId(1), obtenerTotal(),operacionCrud.buscarPorId(2));
            }
            movimientoCrud.create(movimiento);
            Caja caja=cajaCrud.buscarPorId(1);
            caja.setMonto(caja.getMonto()+movimiento.getMonto());
            System.out.println("monto "+caja.getMonto());
            cajaCrud.update(caja);
            limpiarDatos();
            
        }
        if (e.getSource() == frmVenta.btnQuitar){  
            for(int i=0;i<listaDetalleVenta.size();i++){      
                if(listaDetalleVenta.get(i).getProducto().getId()== idSeleccionado){
                    listaDetalleVenta.remove(i);
                    break;
                }
            }
            frmVenta.tblVentas.setModel(poblarTabla());
            float subtotal=  roundFloat((obtenerTotal()*0.82f), 2);
            float igv=roundFloat((obtenerTotal()*0.18f), 2);
            frmVenta.lblSubtotal.setText("S/ " + subtotal);
            frmVenta.lblIgv.setText("S/ " + igv);
            frmVenta.lblTotal.setText("S/ " + roundFloat(obtenerTotal(), 2));
        }
        if (e.getSource() == frmVenta.btnAtras){  
            this.frmVenta.dispose();       
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
            if (e.getSource() == frmVenta.txtImporte){
                if ((e.getKeyChar() < '0' || e.getKeyChar() > '9')&& e.getKeyChar()!=java.awt.event.KeyEvent.VK_ENTER) {
                    e.consume();
                }
                if(e.getKeyChar()==java.awt.event.KeyEvent.VK_ENTER){
                   
                    float vuelto = (Float.parseFloat(frmVenta.txtImporte.getText()) - obtenerTotal());
                    if (vuelto >= 0) {
                        frmVenta.lvlCambio.setText("S/ " + vuelto);
                    }else{
                        frmVenta.lvlCambio.setText("El monto no es suficiente");
                    }
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
                    if(cantidad<= producto.getStock()){           
                        boolean flag=false;
                        for(DetalleVenta dv: listaDetalleVenta){
                            if(dv.getProducto().getId()== producto.getId()){
                                dv.setCantidad(dv.getCantidad()+ cantidad);
                                flag = true;
                                break;
                            }
                        }

                        if(!flag){
                            DetalleVenta detalleVenta = new DetalleVenta();
                            detalleVenta.setCantidad(cantidad);
                            detalleVenta.setProducto(producto);
                            listaDetalleVenta.add(detalleVenta);
                        }

                        frmVenta.tblVentas.setModel(poblarTabla());
                        float subtotal=  roundFloat((obtenerTotal()*0.82f), 2);
                        float igv=roundFloat((obtenerTotal()*0.18f), 2);
                        frmVenta.lblSubtotal.setText("S/ " + subtotal);
                        frmVenta.lblIgv.setText("S/ " + igv);
                        frmVenta.lblTotal.setText("S/ " + roundFloat(obtenerTotal(), 2));
                        frmVenta.txtCodigoProducto.setText("");
                    }else{
                        JOptionPane.showMessageDialog(frmVenta, "No Hay suficiente Stock del Producto Solicitado");
                    }
                }
            }
        }
        if (e.getSource() == frmVenta.txtCliente) {
            if (e.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER){
                Cliente cliente = clienteCrud.buscarPorDni(frmVenta.txtCliente.getText());
                if (cliente == null) {
                    registrarProveedor(frmVenta.txtCliente.getText());                 
                    frmVenta.txtCliente.setEnabled(false);
                } else {
                    frmVenta.txtCliente.setEnabled(false);
                }
            }
        }
    }
    
    private void limpiarDatos(){
        frmVenta.txtCliente.setText("");
        frmVenta.txtCliente.setEnabled(true);
        frmVenta.txtCodigoProducto.setText("");
        frmVenta.txtImporte.setText("");
        frmVenta.lblSubtotal.setText("S/ " + (obtenerTotal() * 0.82));
        frmVenta.lblIgv.setText("S/ " + (obtenerTotal() * 0.18));
        frmVenta.lblTotal.setText("S/ " + obtenerTotal());
        frmVenta.lvlCambio.setText("S/ 00.00");
        listaDetalleVenta= new ArrayList<>();
        frmVenta.tblVentas.setModel(poblarTabla());
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

    @Override
    public void mouseClicked(MouseEvent e) {
        
         if(e.getSource() == frmVenta.tblVentas){
            idSeleccionado= Integer.parseInt((String) frmVenta.tblVentas.getValueAt( frmVenta.tblVentas.getSelectedRow(), 0));
             System.out.println(idSeleccionado);
            
            
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
}
