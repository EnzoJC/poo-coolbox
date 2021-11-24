package coolbox.model;

public class Movimiento {
    private int id;
    private Empleado empleado;
    private Caja caja;
    private float monto;
    private Operacion operacion;

    public Movimiento(int id, Empleado empleado, Caja caja, float monto, Operacion operacion) {
        this.id = id;
        this.empleado = empleado;
        this.caja = caja;
        this.monto = monto;
        this.operacion = operacion;
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

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    
    
}
