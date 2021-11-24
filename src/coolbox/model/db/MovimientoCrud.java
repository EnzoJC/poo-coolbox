/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.db;

import coolbox.model.Movimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
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
    public Boolean update(Movimiento objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Movimiento id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Movimiento> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
