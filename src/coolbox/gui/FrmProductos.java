package coolbox.gui;

import coolbox.model.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmProductos extends javax.swing.JFrame {
    private List<Producto> listaProductos = new ArrayList<>();
    private final Producto productoCrud = new Producto();
    private DefaultTableModel dtmProductos;
    
    public FrmProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
	this.setResizable(false);
        listaProductos = productoCrud.read();
        dtmProductos = poblarTabla();
        tblProductos.setModel(dtmProductos);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Gestión de Productos");

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Precio de compra");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Precio de venta");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Stock");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(301, 301, 301)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnEliminar))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Si se selecciona una fila de la tabla, entrara en modo "actualizar producto"
        // sino solo entrara como "registrar producto"
        if (tblProductos.getSelectedRow() >= 0){
            int id = Integer.parseInt((String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 0));
            actualizarProducto(id);
        } else {
            guardarProducto();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblProductos.getSelectedRow() >= 0){
            int id = Integer.parseInt((String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 0));
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas borrar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION){
                eliminarProducto(id);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        txtNombre.setText((String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 1));
        txtPrecioCompra.setText((String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 2));
        txtPrecioVenta.setText((String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 3));
        txtStock.setText((String) tblProductos.getValueAt(tblProductos.getSelectedRow(), 4));
        btnGuardar.setText("Actualizar");
    }//GEN-LAST:event_tblProductosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void guardarProducto() {
        // Creando nuevo producto con los datos ingresados del formulario
        Producto productoNuevo = new Producto(txtNombre.getText(), 
                Float.parseFloat(txtPrecioCompra.getText()), 
                Float.parseFloat(txtPrecioVenta.getText()), 
                Integer.parseInt(txtStock.getText()));
          
        // Recorriendo la lista de productos para saber si el producto que se quiere registrar ya existe en la base de datos
        for (Producto p : listaProductos) {
            // Si el producto existe muestra un mensaje y se sale del metodo (return;)
            if (p.getNombre().equals(productoNuevo.getNombre())) {
                JOptionPane.showMessageDialog(null, "Este producto ya existe"); 
                return;
            }
        }
        // En caso el producto a registrar si sea completamente nuevo se procede 
        // a asignarle un id a partir del ultimo id del ultimo  producto en la base de datos
        productoNuevo.setId(listaProductos.size() + 1);
        listaProductos.add(productoNuevo); // Luego se procede a insertarlo a la lista de productos
        productoCrud.create(productoNuevo); // Se inserta ese nuevo producto a la base de datos
        // Se procede a agregar el nuevo producto al DefaultTableModel, este esta ligado
        // a la tabla del formulario, por lo que tambien se actualizara en la tabla del formulario
        JOptionPane.showMessageDialog(rootPane, productoNuevo.getId());
        String[] datos = new String[5];
        datos[0] = productoNuevo.getId() + "";
        datos[1] = productoNuevo.getNombre();
        datos[2] = productoNuevo.getPrecioCompra()+ "";
        datos[3] = productoNuevo.getPrecioVenta() + "";
        datos[4] = productoNuevo.getStock()+ "";
        dtmProductos.addRow(datos);
        limpiarCampos();
    }
    
    private void eliminarProducto(int id) {
       Producto productoEliminar = productoCrud.buscarPorId(id);
       if (productoEliminar != null) {
           for (int i = 0; i < listaProductos.size(); i++) {
               if (listaProductos.get(i).getId() == productoEliminar.getId()) {
                   productoCrud.delete(productoEliminar);
                   listaProductos.remove(i);
               }
           }
            tblProductos.setModel(poblarTabla());
            limpiarCampos();
       }
    }
    
    private void actualizarProducto(int id){
        Producto productoAux = productoCrud.buscarPorId(id);
        if (productoAux != null){          
            productoAux.setId(id);
            productoAux.setNombre(txtNombre.getText());
            productoAux.setPrecioCompra(Float.parseFloat(txtPrecioCompra.getText()));
            productoAux.setPrecioVenta(Float.parseFloat(txtPrecioVenta.getText()));
            productoAux.setStock(Integer.parseInt(txtStock.getText()));
            productoCrud.update(productoAux);
            
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getId() == productoAux.getId())
                    listaProductos.set(i, productoAux);
            }
            tblProductos.setModel(poblarTabla());
            btnGuardar.setText("Guardar");
            limpiarCampos();
        }
    }
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        txtStock.setText("");
        btnGuardar.setText("Guardar");
        tblProductos.clearSelection();
    }
    
    private DefaultTableModel poblarTabla(){     
        DefaultTableModel dtm = new DefaultTableModel();
        String[] tituloColumnas = {"ID", "Nombre", "Precio de Compra" , "Precio de Venta", "Stock"};
	for (String i : tituloColumnas)
	    dtm.addColumn(i);
        for(Producto p : listaProductos){
            String[] datos = new String[5];
            datos[0] = p.getId() + "";
            datos[1] = p.getNombre();
            datos[2] = p.getPrecioCompra() + "";
            datos[3] = p.getPrecioVenta() + "";
            datos[4] = p.getStock() + "";
            dtm.addRow(datos);
        }
        return dtm;
    }
}
