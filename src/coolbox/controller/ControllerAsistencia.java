package coolbox.controller;

import coolbox.model.AsistenciaEmpleado;
import coolbox.model.Empleado;
import coolbox.model.crud.AsistenciaEmpleadoCrud;
import coolbox.model.crud.EmpleadoCrud;
import coolbox.view.FrmAsistencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ControllerAsistencia implements ActionListener{
    private FrmAsistencia frmAsistencia;
    private EmpleadoCrud empleadoCrud = new EmpleadoCrud();
    private Empleado empleado;
    private AsistenciaEmpleadoCrud asistenciaEmpleadoCrud = new AsistenciaEmpleadoCrud();
    private AsistenciaEmpleado asistenciaEmpleado = new AsistenciaEmpleado();
    
    public ControllerAsistencia(FrmAsistencia frmAsistencia, Empleado empleado) {
        this.frmAsistencia = frmAsistencia;
        this.empleado = empleado;
        this.frmAsistencia.btnRegistrarEntrada.addActionListener(this);
        this.frmAsistencia.btnRegistrarSalida.addActionListener(this);
        this.frmAsistencia.btnRegistrarSalida.setEnabled(false);
        mostrarHora();
    }
    
    private void mostrarHora() {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        frmAsistencia.lblTiempo.setText(formateador.format(LocalDateTime.now()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frmAsistencia.btnRegistrarEntrada) {
            asistenciaEmpleado.setEmpleado(empleado);
            asistenciaEmpleado.setEntrada(new Timestamp(System.currentTimeMillis()));
            asistenciaEmpleado.setId(asistenciaEmpleadoCrud.ulitmoId() + 1);
            asistenciaEmpleadoCrud.create(asistenciaEmpleado);
            frmAsistencia.btnRegistrarEntrada.setEnabled(false);
            frmAsistencia.btnRegistrarSalida.setEnabled(true);
        }
        if (e.getSource() == frmAsistencia.btnRegistrarSalida) {
            asistenciaEmpleado.setSalida(new Timestamp(System.currentTimeMillis()));
            asistenciaEmpleadoCrud.update(asistenciaEmpleado);
            frmAsistencia.btnRegistrarSalida.setEnabled(false);
            frmAsistencia.btnRegistrarEntrada.setEnabled(true);
            asistenciaEmpleado = new AsistenciaEmpleado();
        }
    }
    
}
