/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.db;

import coolbox.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
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
        List<Producto> productos = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from productos");
            rs= ps.executeQuery();
            
            while(rs.next()){
                System.out.println("1");
                Producto producto= new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecioCompra(rs.getFloat("precio_compra"));
                producto.setPrecioVenta(rs.getFloat("precio_venta"));
                producto.setStock(rs.getInt("stock"));
                productos.add(producto);
            }
            
        } catch (SQLException ex) {
            System.err.println("Error, "+ex);
        }
	
        return productos;
    }

    @Override
    public Boolean update(Producto producto) {
        /*
        ps = Conexion.getConexion().prepareStatement("insert into productos (nombre,precio_compra,precio_venta,stock) values (?,?,?,?)");
        ps.setString(1, producto.getNombre());
        ps.setFloat(2, producto.getPrecioCompra());
        ps.setFloat(3, producto.getPrecioVenta());
        ps.setInt(4, producto.getStock());
        int resultado = ps.executeUpdate();*/
        return true;
    }

    @Override
    public Boolean delete(Producto producto) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from productos where id=?");
            ps.setInt(1, producto.getId());
            int result = ps.executeUpdate();
            if(result>0){ //Ejecucion correcta
                return true; 
            }
            else{
                return false;
            }
        } catch(Exception ex){
            System.err.println("Error, "+ex);
            return false;
        }finally{
            try{
                Conexion.getConexion().close();
            }catch(Exception ex){
                System.err.println("Error, "+ex);
            }
        }
    }
}
