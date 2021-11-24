/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author alexa
 */
public class AsistenciaEmpleado {
    private int id;
    private Empleado empleado;
    private Timestamp entrada;
    private Timestamp salida;

    public AsistenciaEmpleado(int id, Empleado empleado, Timestamp entrada, Timestamp salida) {
        this.id = id;
        this.empleado = empleado;
        this.entrada = entrada;
        this.salida = salida;
    }

    public AsistenciaEmpleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleadoId(Empleado empleado) {
        this.empleado = empleado;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getSalida() {
        return salida;
    }

    public void setSalida(Timestamp salida) {
        this.salida = salida;
    }
    public void marcarEntrada(){
        Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        this.entrada = ts;
    }
    
    public void marcarSalida(){
        Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        this.salida = ts;
    }
    
}
