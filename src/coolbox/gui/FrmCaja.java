package coolbox.gui;

import coolbox.model.Caja;
import coolbox.model.Movimiento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FrmCaja extends javax.swing.JFrame {
    private Movimiento movimientoCrud= new Movimiento();
    private Caja cajaCrud= new Caja();
    private List<Movimiento> listaMovimientos = new ArrayList<>();
    
    public FrmCaja() {
        initComponents();
        this.setLocationRelativeTo(null);
	this.setResizable(false);
        listaMovimientos= movimientoCrud.read();
        tblMovimientos.setModel(poblarTabla());
        float monto = 0;
        for (Movimiento m : listaMovimientos) {
            monto += m.getMonto();
        }
        lblMontoTotal.setText(cajaCrud.buscarPorId(1).getMonto() + monto + "");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblMontoTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMovimientos);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Movimientos de Caja");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Monto en Caja:");

        lblMontoTotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMontoTotal.setText("S/ 00.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblMovimientos;
    // End of variables declaration//GEN-END:variables

    private DefaultTableModel poblarTabla() {
        DefaultTableModel TablaModelo =new DefaultTableModel();
        String[] headers = {"ID", "Empleado", "Caja", "Monto", "Operacion"};
	for (String i : headers) {
	    TablaModelo.addColumn(i);
	}    
        for(Movimiento mov : listaMovimientos){
            String[] datos= new String[5];
            datos[0] = mov.getId() + "";
            datos[1] = mov.getEmpleado().getNombres();
            datos[2] = mov.getCaja().getId() + "";
            datos[3] = mov.getMonto() + "";
            datos[4] = mov.getOperacion().getNombre();    
            TablaModelo.addRow(datos);
        }
        return TablaModelo;
    }
}
