package coolbox.gui;

import coolbox.model.Empleado;

public class FrmPanelPrincipal extends javax.swing.JFrame {
    private Empleado empleado;
    
    public FrmPanelPrincipal(Empleado empleado) {
        initComponents();
        this.setLocationRelativeTo(null);
	this.setResizable(false);
        this.empleado = empleado;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAsistencia = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnCaja = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAsistencia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAsistencia.setText("Asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        btnVenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnCaja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCaja.setText("Caja");
        btnCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCajaActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(890, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVenta)
                .addGap(19, 19, 19)
                .addComponent(btnCaja)
                .addGap(19, 19, 19)
                .addComponent(btnProductos)
                .addGap(19, 19, 19)
                .addComponent(btnEmpleados)
                .addGap(19, 19, 19)
                .addComponent(btnAsistencia)
                .addContainerGap(369, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        FrmVenta frmVenta= new FrmVenta(empleado);
        frmVenta.setVisible(true);
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCajaActionPerformed
        FrmCaja frmCaja= new FrmCaja();
        frmCaja.setVisible(true);
    }//GEN-LAST:event_btnCajaActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        FrmProductos frmProductos= new FrmProductos();
        frmProductos.setVisible(true);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        FrmEmpleados frmEmpleados= new FrmEmpleados();
        frmEmpleados.setVisible(true);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        FrmAsistencia frmAsistencia = new FrmAsistencia(empleado);
        frmAsistencia.setVisible(true);
    }//GEN-LAST:event_btnAsistenciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnCaja;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVenta;
    // End of variables declaration//GEN-END:variables
}
