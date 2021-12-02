package coolbox.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import coolbox.model.Caja;
import coolbox.model.Cliente;
import coolbox.model.DetalleVenta;
import coolbox.model.Empleado;
import coolbox.model.Movimiento;
import coolbox.model.Operacion;
import coolbox.model.Producto;
import coolbox.model.Venta;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmVenta extends javax.swing.JFrame {
    private final Producto productoCrud = new Producto();
    private Empleado empleado;
    private final Cliente clienteCrud = new Cliente();
    private DetalleVenta detalleVentaCrud = new DetalleVenta();
    private Venta venta = new Venta();
    private Movimiento movimiento= new Movimiento();
    private Caja cajaCrud= new Caja();
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
        if (txtCodigoProducto.getText().length() > 0 && txtCliente.getText().length() > 0){
            realizarVenta();
        }
    }//GEN-LAST:event_btnRealizarVentaActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (tblVentas.getSelectedRow() >= 0){
            int id = Integer.parseInt((String) tblVentas.getValueAt(tblVentas.getSelectedRow(), 0));
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas quitar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION){
                quitarProducto(id);
            }
        }
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
        if (evt.getKeyChar() == java.awt.event.KeyEvent.VK_ENTER) {
            ingresarCliente();
        }
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
                detalleVenta.getProducto().setStock(detalleVenta.getProducto().getStock() - detalleVenta.getCantidad());
                productoCrud.update(detalleVenta.getProducto());
                detalleVentaCrud.create(detalleVenta);
            }
            
            JOptionPane.showMessageDialog(null, "Venta Exitosa");
            // TODO limpiar los campos y la tabla
            Movimiento movimiento;
            if(venta.obtenerTotal()>0){
                movimiento= new Movimiento(0, empleado, cajaCrud.buscarPorId(1), venta.obtenerTotal(), operacion.buscarPorId(1));
            }else{
                movimiento= new Movimiento(0, empleado, cajaCrud.buscarPorId(1), venta.obtenerTotal(), operacion.buscarPorId(2));
            }
            movimiento.create(movimiento);
            Caja caja = cajaCrud.buscarPorId(1);
            caja.setMonto(caja.getMonto() + movimiento.getMonto());
            cajaCrud.update(caja);
            
            generarComprobante(listaDetalleVenta, ventaAux);
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos en la lista");
        }
    }

    private void quitarProducto(int id) {
        for (int i = 0; i < listaDetalleVenta.size(); i++) {
            if (listaDetalleVenta.get(i).getProducto().getId() == id) {
                listaDetalleVenta.remove(i);
                break;
            }
        }
        tblVentas.setModel(poblarTabla());
        float subtotal = roundFloat((venta.obtenerTotal() * 0.82f), 2);
        float igv = roundFloat((venta.obtenerTotal() * 0.18f), 2);
        lblSubtotal.setText("S/ " + subtotal);
        lblIgv.setText("S/ " + igv);
        lblTotal.setText("S/ " + roundFloat(venta.obtenerTotal(), 2));
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

    private void ingresarCliente() {
        Cliente buscarCliente = clienteCrud.buscarPorDni(txtCliente.getText());
        if (buscarCliente == null) {
            // Lanzar panel de registro de cliente
            registrarCliente(buscarCliente);
        } else {
            txtCliente.setEnabled(false);
        }
    }

    private void registrarCliente(Cliente c) {
        DialogCliente dc = new DialogCliente(this, true);
        dc.setVisible(true);
        if (!dc.isDisplayable()) {
            txtCliente.setEnabled(true);
            txtCliente.setText("");
        }
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
    
    private void generarComprobante(List<DetalleVenta> lista, Venta v) {
        Document documento = new Document();
        Rectangle dimensioneHoja = new Rectangle(226, 283);
        documento.setPageSize(dimensioneHoja);
        documento.setMargins(7, 7, 7, 7);
        
        try{
            PdfWriter.getInstance(documento , new FileOutputStream("text.pdf"));
            Font fuenteTitulo = new Font(Font.FontFamily.COURIER, 10);
            Font fuenteCuerpo = new Font(Font.FontFamily.COURIER, 6);
            
            Paragraph titulo1 = new Paragraph();
            titulo1.setAlignment(Paragraph.ALIGN_CENTER);
            titulo1.setFont(fuenteTitulo);
            titulo1.setLeading(0.0f, 1.0f);
            titulo1.add("C O O L B O X");
            
            Paragraph titulo2 = new Paragraph();
            titulo2.setAlignment(Paragraph.ALIGN_CENTER);
            titulo2.setFont(fuenteCuerpo);
            titulo2.setLeading(0.0f, 1.0f);
            titulo2.add("RASH PERU S.A.C.");
            
            Paragraph titulo3 = new Paragraph();
            titulo3.setAlignment(Paragraph.ALIGN_CENTER);
            titulo3.setFont(fuenteCuerpo);
            titulo3.setLeading(0.0f, 1.0f);
            titulo3.add("AV SALAVERRY 3310 - LIMA-LIMA-MAGDALENA DEL MAR");
            
            Paragraph titulo4 = new Paragraph();
            titulo4.setAlignment(Paragraph.ALIGN_CENTER);
            titulo4.setFont(fuenteCuerpo);
            titulo4.setLeading(0.0f, 1.0f);
            titulo4.add("RUC: 20378890161");
            
            Paragraph titulo5 = new Paragraph();
            titulo5.setAlignment(Paragraph.ALIGN_CENTER);
            titulo5.setFont(fuenteCuerpo);
            titulo5.setLeading(0.0f, 1.0f);
            titulo5.add("AV. AMERICA NORTE 1245 -INT. 1");
            
            Paragraph titulo6 = new Paragraph();
            titulo6.setAlignment(Paragraph.ALIGN_CENTER);
            titulo6.setFont(fuenteCuerpo);
            titulo6.setLeading(0.0f, 1.0f);
            titulo6.add("7 DENTRO DEL C.C.-TRUJILLO-TRU");
            
            Paragraph titulo7 = new Paragraph();
            titulo7.setAlignment(Paragraph.ALIGN_CENTER);
            titulo7.setFont(fuenteCuerpo);
            titulo7.setLeading(0.0f, 1.0f);
            titulo7.add("JILLO-LA LIBERTAD");
            
            Paragraph titulo8 = new Paragraph();
            titulo8.setAlignment(Paragraph.ALIGN_CENTER);
            titulo8.setFont(fuenteCuerpo);
            titulo8.setLeading(0.0f, 1.0f);
            titulo8.add("TELF: (044) 600060");
            
            Paragraph titulo9 = new Paragraph();
            titulo9.setAlignment(Paragraph.ALIGN_CENTER);
            titulo9.setFont(fuenteTitulo);
            titulo9.setLeading(0.0f, 1.0f);
            titulo9.add("FACTURA ELECTRÓNICA");
            
            Paragraph titulo10 = new Paragraph();
            titulo10.setAlignment(Paragraph.ALIGN_CENTER);
            titulo10.setFont(fuenteTitulo);
            titulo10.setLeading(0.0f, 1.0f);
            titulo10.add("BV01-00" + v.getId());
            
            Paragraph titulo11 = new Paragraph();
            titulo11.setAlignment(Paragraph.ALIGN_LEFT);
            titulo11.setFont(fuenteCuerpo);
            titulo11.setLeading(0.0f, 1.0f);
            titulo11.add("FECHA DE EMISIÓN: " + LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear());
            titulo11.add("  HORA: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond());
            
            Paragraph titulo12 = new Paragraph();
            titulo12.setAlignment(Paragraph.ALIGN_LEFT);
            titulo12.setFont(fuenteCuerpo);
            titulo12.setLeading(0.0f, 1.0f);
            titulo12.add("COD.  PRODUCTO                     CANT.   PRECIO UNIT.");
            
            Paragraph pie1 = new Paragraph();
            pie1.setAlignment(Paragraph.ALIGN_CENTER);
            pie1.setFont(fuenteCuerpo);
            pie1.setLeading(0.0f, 1.0f);
            pie1.add("Autorizado mediante resolución Nro.0180050001610/SUNAT\n" +
                    "Representación impresa de la Factura Electrónica\n" +
                    "Este documento puede ser validado en www.coolbox.pe");
            
            Paragraph pie2 = new Paragraph();
            pie2.setAlignment(Paragraph.ALIGN_CENTER);
            pie2.setFont(fuenteCuerpo);
            pie2.setLeading(0.0f, 1.0f);
            pie2.add("TODO CAMBIO O DEVOLUCIÓN DE PRODUCTO SERÁ DENTRO DE\n" +
                    "LOS 07 DÍAS DE REALIZADA LA COMPRA, CON SUS ACCESORIOS\n" +
                    "Y EMPAQUE COMPLETOS, SIN SEÑALES DE USO.\n" +
                    "DESCARGUE NUESTRA POLÍTICA DE CAMBIO O DEVOLUCIONES Y\n" +
                    "GARANTÍA DEL PRODUCTO EN WWW.COOLBOX.PE");
            
            Paragraph subtotal = new Paragraph();
            subtotal.setAlignment(Paragraph.ALIGN_LEFT);
            subtotal.setFont(fuenteCuerpo);
            subtotal.setLeading(0.0f, 1.0f);
            subtotal.add("SUBTOTAL:                                      S/ " + roundFloat(v.getTotal() * 0.82f, 2)); 
            
            Paragraph igv = new Paragraph();
            igv.setAlignment(Paragraph.ALIGN_LEFT);
            igv.setFont(fuenteCuerpo);
            igv.setLeading(0.0f, 1.0f);
            igv.add("IGV:                                           S/ " + roundFloat(v.getTotal() * 0.18f, 2)); 
            
            Paragraph total = new Paragraph();
            total.setAlignment(Paragraph.ALIGN_LEFT);
            total.setFont(fuenteCuerpo);
            total.setLeading(0.0f, 1.0f);
            total.add("TOTAL:                                           S/ " + roundFloat(v.getTotal(), 2));
            
            Paragraph raya = new Paragraph();
            raya.setAlignment(Paragraph.ALIGN_CENTER);
            raya.setFont(fuenteCuerpo);
            raya.setLeading(0.0f, 1.0f);
            raya.add("__________________________________________________________");
            
            documento.open();
            documento.add(titulo1);
            documento.add(titulo2);
            documento.add(titulo3);
            documento.add(titulo4);
            documento.add(titulo5);
            documento.add(titulo6);
            documento.add(titulo7);
            documento.add(titulo8);
            documento.add(titulo9);
            documento.add(titulo10);
            documento.add(titulo11);
            documento.add(raya);
            documento.add(titulo12);
            documento.add(raya);
            for (DetalleVenta dv : lista) {
                Paragraph detalle = new Paragraph();
                detalle.setAlignment(Paragraph.ALIGN_LEFT);
                detalle.setFont(fuenteCuerpo);
                detalle.setLeading(0.0f, 1.0f);
                detalle.add(dv.getProducto().getId() + "       " + 
                            dv.getProducto().getNombre() + "          " + dv.getCantidad() + "            " + 
                            dv.getProducto().getPrecioVenta());
                documento.add(detalle);
            }
            documento.add(new Paragraph("\n"));
            documento.add(raya);
            documento.add(subtotal);
            documento.add(igv);
            documento.add(total);
            BarcodeQRCode qr = new BarcodeQRCode("BV01-00" + v.getId(), 1, 1, null);
            Image qrImagen = qr.getImage();
            qrImagen.scaleAbsolute(40, 40);
            qrImagen.setAbsolutePosition(80, 15);
            documento.add(qrImagen);
            documento.add(raya);
            documento.add(pie1);
            documento.add(new Paragraph(""));
            documento.add(pie2);
            
            documento.close();
            Desktop.getDesktop().open(new File("text.pdf"));
        } catch(DocumentException | FileNotFoundException de) {
            JOptionPane.showMessageDialog(rootPane, de.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
    }
}
