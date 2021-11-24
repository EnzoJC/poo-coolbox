/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.db;

import coolbox.model.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Enzo Carrión
 */
public class EmpleadoCrud implements ICrud<Empleado> {
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    @Override
    public Boolean create(Empleado empleado) {
        try {
            ps = Conexion.getConexion().prepareStatement("insert into empleados (nombres, apellidos, dni, usuario, contrasenia) values (?, ?, ?, ?, ?)");
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getDni());
            ps.setString(4, empleado.getUsuario());
            ps.setString(5, empleado.getContrasenia());
            
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
    public <T> List<T> read() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean update(Empleado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean delete(Empleado id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
