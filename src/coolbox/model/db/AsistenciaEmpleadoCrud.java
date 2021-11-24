/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.db;

import coolbox.model.AsistenciaEmpleado;
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
public class AsistenciaEmpleadoCrud implements ICrud<AsistenciaEmpleado>{
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    @Override
    public Boolean create(AsistenciaEmpleado asistenciaEmp) {
       try {
            ps = Conexion.getConexion().prepareStatement("insert into asistencia_empleado (empleados_id, entrada, salida) values (?, ?, ?)");
            ps.setInt(1, asistenciaEmp.getEmpleado().getId());
            ps.setTimestamp(2, asistenciaEmp.getEntrada());
            ps.setTimestamp(3, asistenciaEmp.getSalida());
            
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
    public Boolean update(AsistenciaEmpleado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(AsistenciaEmpleado id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AsistenciaEmpleado> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
