/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model;

/**
 *
 * @author alexa
 */
public class Movimiento {
    private int id;
    private int empleadoId;
    private int cajaId;
    private float monto;
    private int operacionId;

    public Movimiento(int id, int empleadoId, int cajaId, float monto, int operacionId) {
        this.id = id;
        this.empleadoId = empleadoId;
        this.cajaId = cajaId;
        this.monto = monto;
        this.operacionId = operacionId;
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

    public int getCajaId() {
        return cajaId;
    }

    public void setCajaId(int cajaId) {
        this.cajaId = cajaId;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getOperacionId() {
        return operacionId;
    }

    public void setOperacionId(int operacionId) {
        this.operacionId = operacionId;
    }
    
    
    
}
