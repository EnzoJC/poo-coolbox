package coolbox.view;

import coolbox.model.Caja;
import coolbox.model.Cliente;
import coolbox.model.DetalleVenta;
import coolbox.model.Empleado;
import coolbox.model.Movimiento;
import coolbox.model.Operacion;
import coolbox.model.Producto;
import coolbox.model.Venta;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmVenta extends javax.swing.JFrame {
    private final Producto productoCrud = new Producto();
    private Empleado empleado;
    private final Cliente clienteCrud = new Cliente();
    private DetalleVenta detalleVentaCrud = new DetalleVenta();
    private Venta venta = new Venta();
    private Movimiento movimiento= new Movimiento();
    private Caja caja= new Caja();
    private Operacion operacion= new Operacion();
    private DefaultTableModel dtmDetalleProductos = cargarTitulos();
    private List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
    private DecimalFormat df = new DecimalFormat("###.##");
    
    public FrmVenta(Empleado empleado) {
        initComponents();
        this.setLocationRelativeTo(null);
	this.setResizable(false);
        tblVentas.setModel(dtmDetalleProductos);
        this.empleado = empleado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        btnRealizarVenta = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblIgv = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtImporte = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        lvlCambio = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVentas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Código de Prod.");

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Venta");

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("S/ 00.00");

        txtCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteKeyPressed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnRealizarVenta.setBackground(new java.awt.Color(153, 255, 153));
        btnRealizarVenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRealizarVenta.setText("Realizar Venta");
        btnRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVentaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Cliente");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Subtotal");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("IGV");

        lblIgv.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblIgv.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIgv.setText("S/ 00.00");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Total");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("S/ 00.00");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Importe");

        txtImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImporte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtImporteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImporteKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Cambio");

        lvlCambio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lvlCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lvlCambio.setText("S/ 00.00");

        btnQuitar.setBackground(new java.awt.Color(255, 153, 153));
        btnQuitar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lblIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(lvlCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnRealizarVenta)
                        .addGap(120, 120, 120)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAtras)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIgv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtImporte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lvlCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRealizarVenta)
                            .addComponent(btnQuitar))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVentaActionPerformed
        realizarVenta();
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        quitarProducto();
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyPressed
        agregarProducto(evt);
    }//GEN-LAST:event_txtCodigoProductoKeyPressed

    private void txtImporteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyTyped
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9')) {
            evt.consume();
        }
        if (venta.getListaDetalleVenta().size() > 0) {
            float vuelto = (Float.parseFloat("0" + txtImporte.getText() + Character.toString(evt.getKeyChar())) - venta.obtenerTotal());
            if (vuelto >= 0) {
                lvlCambio.setText("S/ " + vuelto);
            } else {
                lvlCambio.setText("Sin cambio");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista");
        }
    }//GEN-LAST:event_txtImporteKeyTyped

    private void txtClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteKeyPressed
        ingresarCliente(evt);
    }//GEN-LAST:event_txtClienteKeyPressed

    private void txtImporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImporteKeyPressed
        
    }//GEN-LAST:event_txtImporteKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnQuitar;
    public javax.swing.JButton btnRealizarVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblIgv;
    public javax.swing.JLabel lblSubtotal;
    public javax.swing.JLabel lblTotal;
    public javax.swing.JLabel lvlCambio;
    public javax.swing.JTable tblVentas;
    public javax.swing.JTextField txtCliente;
    public javax.swing.JTextField txtCodigoProducto;
    public javax.swing.JTextField txtImporte;
    // End of variables declaration//GEN-END:variables

    private void realizarVenta() {
        if (venta.getListaDetalleVenta().size() > 0){
            venta.setEmpleado(empleado);
            venta.setCliente(clienteCrud.buscarPorDni(txtCliente.getText()));
            venta.setTotal(venta.obtenerTotal());
            venta.create(venta);
            Venta ventaAux = venta.buscarPorId(venta.ulitmoId());
            
            for (DetalleVenta detalleVenta : listaDetalleVenta) {
                detalleVenta.setVenta(ventaAux);
                detalleVenta.getProducto().setStock(detalleVenta.getProducto().getStock()- detalleVenta.getCantidad());
                productoCrud.update(detalleVenta.getProducto());
                JOptionPane.showMessageDialog(rootPane, "ID producto: " + detalleVenta.getProducto().getId());
                JOptionPane.showMessageDialog(rootPane, "ID venta: " + detalleVenta.getVenta().getId());
                JOptionPane.showMessageDialog(rootPane, "cantidad: " + detalleVenta.getCantidad());
                detalleVentaCrud.create(detalleVenta);
            }
            JOptionPane.showMessageDialog(null, "Venta Exitosa");
            // TODO limpiar los campos y la tabla
            Movimiento movimiento;
            if(venta.obtenerTotal()>0){
                movimiento= new Movimiento(0, empleado, caja.buscarPorId(1), venta.obtenerTotal(),operacion.buscarPorId(1));
            }else{
                movimiento= new Movimiento(0, empleado, caja.buscarPorId(1), venta.obtenerTotal(),operacion.buscarPorId(2));
            }
            movimiento.create(movimiento);
//            caja.setMonto(caja.buscarPorId(1).getMonto()+movimiento.getMonto());
//            caja.update(caja);
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista");
        }
    }

    private void quitarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void agregarProducto(KeyEvent evt) {
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            int id = Integer.parseInt(txtCodigoProducto.getText());
            Producto productoNuevo = productoCrud.buscarPorId(id);
            
            if (productoNuevo == null) {
                JOptionPane.showMessageDialog(null, "El producto no existe");
            } else {
                int cantidad = 0;
                String cant = null;
                do {
                    cant = JOptionPane.showInputDialog("Ingrese la cantidad");
                } while (cant == null || cant.equals(""));
                
                cantidad = Integer.parseInt(cant);
                
                if (cantidad < productoNuevo.getStock()) {
                    for (DetalleVenta dv : listaDetalleVenta) {
                        if (dv.getProducto().getId() == productoNuevo.getId()){
                            if ((dv.getCantidad() + cantidad) < productoNuevo.getStock()){
                                dv.setCantidad(dv.getCantidad() + cantidad);
                                tblVentas.setModel(poblarTabla());
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "Con esa nueva cantidad se supera el stock");
                                return;
                            }
                        }
                    }
                    DetalleVenta dv = new DetalleVenta();
                    dv.setProducto(productoNuevo);
                    dv.setCantidad(cantidad);
                    listaDetalleVenta.add(dv);
                    
                    String[] datos= new String[4];
                    datos[0] = id + "";
                    datos[1] = dv.getProducto().getNombre();
                    datos[2] = dv.getProducto().getPrecioVenta() + "";
                    datos[3] = dv.getCantidad() + ""; 
                    dtmDetalleProductos.addRow(datos);
                    
                    venta.setListaDetalleVenta(listaDetalleVenta);
                    float subtotal = roundFloat((venta.obtenerTotal() * 0.82f), 2);
                    float igv = roundFloat((venta.obtenerTotal() * 0.18f), 2);
                    lblSubtotal.setText("S/ " + subtotal);
                    lblIgv.setText("S/ " + igv);
                    lblTotal.setText("S/ " + roundFloat(venta.obtenerTotal(), 2));
                } else {
                    JOptionPane.showMessageDialog(null, "No Hay suficiente Stock del Producto Solicitado");
                }
            }
        }
    }
    
    private float roundFloat(float f, int places) {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(f));
        bigDecimal = bigDecimal.setScale(places, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }

    private void ingresarCliente(KeyEvent evt) {
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            Cliente buscarCliente = clienteCrud.buscarPorDni(txtCliente.getText());
            if (buscarCliente == null) {
                // Lanzar panel de registro de cliente
                registrarCliente(buscarCliente);

                // despues de registrar tambien se bloquea el txt
                txtCliente.setEnabled(false);
            } else {
                txtCliente.setEnabled(false);
            }
        }
    }

    private void registrarCliente(Cliente c) {
        DialogCliente dc = new DialogCliente(this, true);
        dc.setVisible(true);
    }
    
    private DefaultTableModel cargarTitulos() {
        DefaultTableModel dtm = new DefaultTableModel();
        String[] tituloColumnas = {"ID", "Nombre", "Precio", "Cantidad"};
	for (String i : tituloColumnas) {
	    dtm.addColumn(i);
	}
        return dtm;
    }
    
    private DefaultTableModel poblarTabla(){
        DefaultTableModel dtm = new DefaultTableModel();
        String[] tituloColumnas = {"ID", "Nombre", "Precio", "Cantidad"};
	for (String i : tituloColumnas) {
	    dtm.addColumn(i);
	}
        for (DetalleVenta dv : listaDetalleVenta){
            String[] datos= new String[4];
            datos[0] = dv.getProducto().getId() + "";
            datos[1] = dv.getProducto().getNombre();
            datos[2] = dv.getProducto().getPrecioVenta() + "";
            datos[3] = dv.getCantidad() + "";
            dtm.addRow(datos);
        }
        return dtm;
    }
}
