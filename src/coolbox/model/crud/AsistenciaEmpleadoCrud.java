package coolbox.model.crud;

import coolbox.model.AsistenciaEmpleado;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AsistenciaEmpleadoCrud implements ICrud<AsistenciaEmpleado> {
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return false;
    }

    @Override
    public Boolean update(AsistenciaEmpleado asistenciaEmpleado) {
        try{
            ps = Conexion.getConexion().prepareStatement("update asistencia_empleado set empleados_id=?, entrada=?, salida=? where id=?");
            ps.setInt(1, asistenciaEmpleado.getEmpleado().getId());
            ps.setTimestamp(2, asistenciaEmpleado.getEntrada());
            ps.setTimestamp(3, asistenciaEmpleado.getSalida());
            
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
    public Boolean delete(AsistenciaEmpleado asistenciaEmpleado) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from asistencia_empleado where id=?");
            ps.setInt(1, asistenciaEmpleado.getId());

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
    public List<AsistenciaEmpleado> read() {
        List<AsistenciaEmpleado> listaAsistenciaEmpleados = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from asistencia_empleado");

            rs = ps.executeQuery();

            while (rs.next()) {
                EmpleadoCrud empleadoCrud = new EmpleadoCrud();
                listaAsistenciaEmpleados.add(new AsistenciaEmpleado(rs.getInt("id"), empleadoCrud.buscarPorId(rs.getInt("empleados_id")), rs.getTimestamp("entrada"), rs.getTimestamp("salida")));
            }
            return listaAsistenciaEmpleados;

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
