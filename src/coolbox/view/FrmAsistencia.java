package coolbox.view;

import coolbox.model.AsistenciaEmpleado;
import coolbox.model.Empleado;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FrmAsistencia extends javax.swing.JFrame {
    private Empleado empleado;
    private AsistenciaEmpleado asistenciaEmpleado = new AsistenciaEmpleado();
    
    public FrmAsistencia(Empleado empleado) {
        initComponents();
        this.setLocationRelativeTo(null);
	this.setResizable(false);
        this.empleado = empleado;
        mostrarHora();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarEntrada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        btnRegistrarSalida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegistrarEntrada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrarEntrada.setText("Registrar entrada");
        btnRegistrarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEntradaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASISTENCIA DE PERSONAL");

        lblTiempo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnRegistrarSalida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnRegistrarSalida.setText("Registrar salida");
        btnRegistrarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSalidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnRegistrarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnRegistrarSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarEntrada)
                    .addComponent(btnRegistrarSalida))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEntradaActionPerformed
        registrarEntrada();
    }//GEN-LAST:event_btnRegistrarEntradaActionPerformed

    private void btnRegistrarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalidaActionPerformed
        registrarSalida();
    }//GEN-LAST:event_btnRegistrarSalidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarEntrada;
    private javax.swing.JButton btnRegistrarSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTiempo;
    // End of variables declaration//GEN-END:variables
    
    private void mostrarHora() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        lblTiempo.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

    private void registrarEntrada() {
        asistenciaEmpleado.setEmpleado(empleado);
        asistenciaEmpleado.setEntrada(new Timestamp(System.currentTimeMillis()));
        asistenciaEmpleado.setId(asistenciaEmpleado.ulitmoId() + 1);
        asistenciaEmpleado.create(asistenciaEmpleado);
        btnRegistrarEntrada.setEnabled(false);
        btnRegistrarSalida.setEnabled(true);
    }

    private void registrarSalida() {
        asistenciaEmpleado.setSalida(new Timestamp(System.currentTimeMillis()));
        asistenciaEmpleado.update(asistenciaEmpleado);
        btnRegistrarSalida.setEnabled(false);
        btnRegistrarEntrada.setEnabled(true);
        asistenciaEmpleado = new AsistenciaEmpleado();
    }
    
}
