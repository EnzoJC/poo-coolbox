package coolbox.model;

public class DetalleVenta {
    private Producto producto;
    private Venta venta;
    private int cantidad;

    public DetalleVenta(Producto producto, Venta venta, int cantidad) {
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
    }

    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
}
