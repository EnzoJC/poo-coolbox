package coolbox.model.crud;

import coolbox.model.Venta;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VentaCrud implements ICrud<Venta> {
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public Boolean create(Venta venta) {
         try {
            ps = Conexion.getConexion().prepareStatement("insert into ventas (empleados_id,clientes_id,total) values (?,?,?)");
            ps.setInt(1, venta.getEmpleado().getId());
            ps.setInt(2, venta.getCliente().getId());
            ps.setFloat(3, venta.getTotal());
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
    public Boolean update(Venta venta) {
        try{
            ps = Conexion.getConexion().prepareStatement("update ventas set empleados_id=?, clientes_id=?, total=? where id=?");
            ps.setInt(1, venta.getEmpleado().getId());
            ps.setInt(2, venta.getCliente().getId());
            ps.setFloat(3, venta.getTotal());
            
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
    public Boolean delete(Venta venta) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from ventas where id=?");
            ps.setInt(1, venta.getId());
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
    public List<Venta> read() {
        List<Venta> listaVentas = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from ventas");
            rs= ps.executeQuery();
            
            while(rs.next()){
                EmpleadoCrud empleadoCrud = new EmpleadoCrud();
                ClienteCrud clienteCrud = new ClienteCrud();
                listaVentas.add(new Venta(rs.getInt("id"), empleadoCrud.buscarPorId(rs.getInt("empleados_id")), clienteCrud.buscarPorId(rs.getInt("clientes_id")), rs.getFloat("total")));
            }
            return listaVentas;
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
    
    public int ulitmoId(){
        return read().get(read().size() - 1).getId();
    }
    
}
