package coolbox.gui;

import coolbox.model.AsistenciaEmpleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FrmVerAsistencias extends javax.swing.JFrame {
    private List<AsistenciaEmpleado> listaAsistenciaEmpleado= new ArrayList<>();
    private final AsistenciaEmpleado asistenciEmpleadoCrud = new AsistenciaEmpleado();
    private DefaultTableModel dtmEmpleados;
    
    public FrmVerAsistencias() {
        initComponents();
        listaAsistenciaEmpleado = asistenciEmpleadoCrud.read();
        dtmEmpleados = poblarTabla();
        tblVerAsistecias.setModel(dtmEmpleados);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVerAsistecias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVerAsistecias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVerAsistecias);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Asistencia de Empleados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVerAsistecias;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel poblarTabla() {
        DefaultTableModel dtm = new DefaultTableModel();
        String[] tituloColumnas = {"ID", "Nombres", "Hora Entrada" , "Hora Salida"};
	for (String i : tituloColumnas)
	    dtm.addColumn(i);
        for(AsistenciaEmpleado ae : listaAsistenciaEmpleado) {
            String[] datos = new String[5];
            datos[0] = ae.getId() + "";
            datos[1] = ae.getEmpleado().getNombres();
            datos[2] = ae.getEntrada().toString();
            datos[3] = ae.getSalida().toString();
            dtm.addRow(datos);
        }
        return dtm;
    }
}
