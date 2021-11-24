/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model;

import java.sql.Timestamp;

/**
 *
 * @author alexa
 */
public class AsistenciaEmpleado {
    private int id;
    private int empleadoId;
    private Timestamp entrada;
    private Timestamp salida;

    public AsistenciaEmpleado(int id, int empleadoId, Timestamp entrada, Timestamp salida) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.entrada = entrada;
        this.salida = salida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
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
    
    
}
