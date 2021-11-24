package coolbox.model.crud;

import coolbox.model.Movimiento;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MovimientoCrud implements ICrud<Movimiento>{
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    @Override
    public Boolean create(Movimiento movimiento) {
        try {
            ps = Conexion.getConexion().prepareStatement("insert into movimientos (empleados_id, caja_id, monto,operaciones_id) values (?, ?, ?, ?)");
            ps.setInt(1, movimiento.getEmpleado().getId());
            ps.setInt(2, movimiento.getCaja().getId());
            ps.setFloat(3, movimiento.getMonto());
            ps.setInt(4, movimiento.getOperacion().getId());
            
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
    public Boolean update(Movimiento movimiento) {
        try{
            ps = Conexion.getConexion().prepareStatement("update movimientos set empleados_id=?, caja_id=?, monto=?, operaciones_id=? where id=?");
            ps.setInt(1, movimiento.getEmpleado().getId());
            ps.setInt(2, movimiento.getCaja().getId());
            ps.setFloat(3, movimiento.getMonto());
            ps.setInt(4, movimiento.getOperacion().getId());
            
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
    public Boolean delete(Movimiento movimiento) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from movimientos where id=?");
            ps.setInt(1, movimiento.getId());

            int resultado = ps.executeUpdate();
            
            return resultado > 0;
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
    public List<Movimiento> read() {
        List<Movimiento> listaMovimientos = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from movimientos");

            rs = ps.executeQuery();
            
            while (rs.next()) {
                EmpleadoCrud empleadoCrud = new EmpleadoCrud();
                CajaCrud cajaCrud = new CajaCrud();
                OperacionCrud operacionCrud = new OperacionCrud();
                
                listaMovimientos.add(new Movimiento(rs.getInt("id"), empleadoCrud.buscar(rs.getInt("empleados_id")), cajaCrud.buscar(rs.getInt("caja_id")), rs.getFloat("monto"), operacionCrud.buscar(rs.getInt("operaciones_id"))));
            }
            return listaMovimientos;

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
