package coolbox.gui;

import coolbox.model.Caja;
import coolbox.model.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmCajas extends javax.swing.JFrame {
    private final Caja cajaCrud = new Caja();
    private List<Caja> listaCajas = new ArrayList<>();
    private DefaultTableModel dtmCajas;
    /**
     * Creates new form FrmCajas
     */
    public FrmCajas() {
        initComponents();
        this.setLocationRelativeTo(null);
	this.setResizable(false);
        listaCajas = cajaCrud.read();
        tblCajas.setModel(poblarTabla());
        txtId.setText((listaCajas.size()+1)+"");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCajas = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRealizarDep = new javax.swing.JButton();
        txtRealizarDep = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Cajas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Monto");

        tblCajas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCajas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCajasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCajas);

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

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRealizarDep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRealizarDep.setText("Realizar Deposito");
        btnRealizarDep.setEnabled(false);
        btnRealizarDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarDepActionPerformed(evt);
            }
        });

        txtRealizarDep.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRealizarDep)
                        .addGap(18, 18, 18)
                        .addComponent(txtRealizarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRealizarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRealizarDep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(btnLimpiar)
                            .addComponent(btnEliminar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCajasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCajasMouseClicked
        txtId.setText((String) tblCajas.getValueAt(tblCajas.getSelectedRow(), 0));
        txtMonto.setText((String) tblCajas.getValueAt(tblCajas.getSelectedRow(), 1));
        txtMonto.enable(false);
        btnRealizarDep.setEnabled(true); txtRealizarDep.setEnabled(true);
    }//GEN-LAST:event_tblCajasMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      guardarCaja(); 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblCajas.getSelectedRow() >= 0){
            int id = Integer.parseInt((String) tblCajas.getValueAt(tblCajas.getSelectedRow(), 0));
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas borrar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (respuesta == JOptionPane.YES_OPTION){
                eliminarCaja(id);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRealizarDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarDepActionPerformed
        float montoActual = Float.parseFloat(txtMonto.getText());
        float montoDepositar = Float.parseFloat(txtRealizarDep.getText());
        txtMonto.setText((montoActual+montoDepositar)+"");
        Caja caja = new Caja(Integer.parseInt(txtId.getText()), Float.parseFloat(txtMonto.getText())); 
        
        for (int i=0;i<listaCajas.size();i++) {
            if (listaCajas.get(i).getId() == caja.getId()) {
                listaCajas.set(i, caja);   
            }
        }
        cajaCrud.update(caja);
        tblCajas.setModel(poblarTabla());
        limpiarCampos();
    }//GEN-LAST:event_btnRealizarDepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRealizarDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblCajas;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtRealizarDep;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel poblarTabla() {
        DefaultTableModel dtm = new DefaultTableModel();
        String[] tituloColumnas = {"ID", "Monto"};
	for (String i : tituloColumnas)
	    dtm.addColumn(i);
        for(Caja c : listaCajas) {
            String[] datos = new String[2];
            datos[0] = c.getId() + "";
            datos[1] = c.getMonto()+"";
            dtm.addRow(datos);
        }
        return dtm;
    }

    private void limpiarCampos() {
        txtMonto.setEnabled(true);
        btnRealizarDep.setEnabled(false); txtRealizarDep.setEnabled(false);
        txtId.setText((listaCajas.size()+1)+"");
        txtMonto.setText("");
        txtRealizarDep.setText("");
        tblCajas.clearSelection();
    }

    private void guardarCaja() {
        Caja caja = new Caja(Integer.parseInt(txtId.getText()), Float.parseFloat(txtMonto.getText())); 
        listaCajas.add(caja);
        cajaCrud.create(caja);
        
        String[] datos = new String[2];
        datos[0] = caja.getId() + "";
        datos[1] = caja.getMonto() + "";
        tblCajas.setModel(poblarTabla());
        limpiarCampos();
    }

    private void eliminarCaja(int id) {
       Caja cajaEliminar = cajaCrud.buscarPorId(id);
       if (cajaEliminar != null) {
            for (int i = 0; i < listaCajas.size(); i++) {
                if (listaCajas.get(i).getId() == cajaEliminar.getId()) {
                    cajaCrud.delete(cajaEliminar);
                    listaCajas.remove(i); 
                    tblCajas.setModel(poblarTabla());
                    limpiarCampos();
                    return;
                }
            }
            tblCajas.setModel(poblarTabla());
            limpiarCampos();
       }
    }
}
