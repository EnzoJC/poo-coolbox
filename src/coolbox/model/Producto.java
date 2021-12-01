package coolbox.model;

import coolbox.model.database.ICrud;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Producto implements ICrud<Producto> {
    private int id;
    private String nombre;
    private float precioCompra;
    private float precioVenta;
    private int stock;
    
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Producto() {
    }

    public Producto(int id, String nombre, float precioCompra, float precioVenta, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }
    
    public Producto(String nombre, float precioCompra, float precioVenta, int stock) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public Boolean create(Producto producto) {
        try {
            ps = Conexion.getConexion().prepareStatement("insert into productos (nombre,precio_compra,precio_venta,stock) values (?,?,?,?)");
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecioCompra());
            ps.setFloat(3, producto.getPrecioVenta());
            ps.setInt(4, producto.getStock());
            int resultado = ps.executeUpdate();
            
            return resultado > 0;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la inserción:\n" + ex);
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
    public List<Producto> read() {
        List<Producto> listaProductos = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from productos");
            rs= ps.executeQuery();
            
            while(rs.next()){
                listaProductos.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio_compra"), rs.getFloat("precio_venta"), rs.getInt("stock")));
            }
            return listaProductos;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:\n" + ex);
        } finally {
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return null;
    }

    @Override
    public Boolean update(Producto producto) {
        try {
            ps = Conexion.getConexion().prepareStatement("update productos set nombre=?, precio_compra=?,precio_venta=?, stock=? where id=?");
            ps.setString(1, producto.getNombre());
            ps.setFloat(2, producto.getPrecioCompra());
            ps.setFloat(3, producto.getPrecioVenta());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());
            
            int result = ps.executeUpdate();
            
            return result > 0;
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
    public Boolean delete(Producto producto) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from productos where id=?");
            ps.setInt(1, producto.getId());
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
    
    public Producto buscarPorId(int id){
        try {
            ps = Conexion.getConexion().prepareStatement("select * from productos where id=?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio_compra"), rs.getFloat("precio_venta"), rs.getInt("stock"));
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:\n" + ex);
        } finally {
            try {
                Conexion.getConexion().close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return null;
    }
}
