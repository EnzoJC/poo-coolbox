package coolbox.model;

public class Venta {
    private int id;
    private Empleado empleado;
    private Cliente cliente;
    private float total;

    public Venta(int id, Empleado empleado, Cliente cliente, float total) {
        this.id = id;
        this.empleado = empleado;
        this.cliente = cliente;
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
}
