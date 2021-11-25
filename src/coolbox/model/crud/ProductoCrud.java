
package coolbox.model.crud;

import coolbox.model.Producto;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ProductoCrud implements ICrud<Producto>{
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;

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
        System.out.println("id "+id);
        try {
            ps = Conexion.getConexion().prepareStatement("select * from productos where id=?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("1sda");
                return new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getFloat("precio_compra"), rs.getFloat("precio_venta"), rs.getInt("stock"));
            }
            
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
