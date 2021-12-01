package coolbox.model;

import coolbox.model.database.ICrud;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class DetalleVenta implements ICrud<DetalleVenta>{
    private Producto producto;
    private Venta venta;
    private int cantidad;
    
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public DetalleVenta(Producto producto, Venta venta, int cantidad) {
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
    }

    public DetalleVenta() {
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

    @Override
    public Boolean create(DetalleVenta detalleVenta) {
         try {
            ps = Conexion.getConexion().prepareStatement("insert into detalle_venta (productos_id, venta_id, cantidad) values (?, ?, ?)");
            ps.setInt(1, detalleVenta.getProducto().getId());
            ps.setInt(2, detalleVenta.getVenta().getId());
            ps.setInt(3, detalleVenta.getCantidad());
            
            int resultado = ps.executeUpdate();
            
            return resultado > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:\n" + ex);
        } finally {
            try {
                Conexion.getConexion().close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error:\n" + e);
            }
        }
        return false;
    }

    @Override
    public Boolean update(DetalleVenta detalleVenta) {
        try{
            ps = Conexion.getConexion().prepareStatement("update detalle_venta set cantidad=? where productos_id=? and venta_id=?");
            ps.setInt(1, detalleVenta.getCantidad());
            ps.setInt(2, detalleVenta.getProducto().getId());
            ps.setInt(3, detalleVenta.getVenta().getId());
            
            int resultado = ps.executeUpdate();
            
            return resultado > 0; //Ejecucion correcta
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:\n" + ex);
        } finally {
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return false;
    }

    @Override
    public Boolean delete(DetalleVenta detalleVenta) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from ventas where productos_id=? and venta_id=?");
            ps.setInt(1, detalleVenta.getProducto().getId());
            ps.setInt(2, detalleVenta.getVenta().getId());
            int result = ps.executeUpdate();
            return result > 0; //Ejecucion correcta
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error:\n" + ex);
        }finally{
            try{
                Conexion.getConexion().close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return false;
    }

    @Override
    public List<DetalleVenta> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
