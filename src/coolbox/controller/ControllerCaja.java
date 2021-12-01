///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package coolbox.controller;
//
//import coolbox.model.Caja;
//import coolbox.model.Movimiento;
//import coolbox.model.crud.CajaCrud;
//import coolbox.model.crud.MovimientoCrud;
//import coolbox.view.FrmCaja;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.table.DefaultTableModel;
//
///**
// *
// * @author alexa
// */
//public class ControllerCaja {
//    FrmCaja frmCaja;
//    MovimientoCrud movimientoCrud= new MovimientoCrud();
//    CajaCrud cajaCrud= new CajaCrud();
//    List<Movimiento> movimientos= new ArrayList<>();
//    public ControllerCaja(FrmCaja frmCaja) {
//        this.frmCaja = frmCaja;
//        movimientos= movimientoCrud.read();
//        frmCaja.tblMovimientos.setModel(poblarTabla());
//        frmCaja.lblMontoTotal.setText(cajaCrud.buscarPorId(1).getMonto()+"");
//    } 
//    private DefaultTableModel poblarTabla() {
//        DefaultTableModel TablaModelo =new DefaultTableModel();
//        String[] headers = {"ID", "Empleado", "Caja", "Monto", "Operacion"};
//	for (String i : headers) {
//	    TablaModelo.addColumn(i);
//	}    
//        for(Movimiento mov:movimientos){
//            String[] datos= new String[5];
//            datos[0] = mov.getId()+"";
//            datos[1] = mov.getEmpleado().getNombres();
//            datos[2] = mov.getCaja().getId()+"";
//            datos[3] = mov.getMonto()+"";
//            datos[4] = mov.getOperacion().getNombre();    
//            TablaModelo.addRow(datos);
//        }
//        return TablaModelo;
//    }
//}
