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

public class Empleado implements ICrud<Empleado>{
    private int id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String usuario;
    private String contrasenia;
    
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Empleado(int id, String nombres, String apellidos, String dni, String usuario, String contrasenia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    public Empleado(String nombres, String apellidos, String dni, String usuario, String contrasenia) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Empleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombre(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return false;
    }

    @Override
    public Boolean update(Empleado empleado) {
        try{
            ps = Conexion.getConexion().prepareStatement("update empleados set nombres=?, apellidos=?, dni=?, usuario=?, contrasenia=? where id=?");
            ps.setString(1, empleado.getNombres());
            ps.setString(2, empleado.getApellidos());
            ps.setString(3, empleado.getDni());
            ps.setString(4, empleado.getUsuario());
            ps.setString(5, empleado.getContrasenia());
            ps.setInt(6, empleado.getId());
            
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
    public Boolean delete(Empleado empleado) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from empleados where id=?");
            ps.setInt(1, empleado.getId());

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
    public List<Empleado> read() {
        List<Empleado> listaEmpleados = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from empleados");

            rs = ps.executeQuery();
            
            while (rs.next()) {
                listaEmpleados.add(new Empleado(rs.getInt("id"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("usuario"), rs.getString("contrasenia")));
            }
            return listaEmpleados;

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
    
    public Empleado buscarPorId(int id) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from empleados where id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Empleado(rs.getInt("id"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("usuario"), rs.getString("contrasenia"));
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
    
    public Empleado buscarPorDni(String dni) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from empleados where dni=?");
            ps.setString(1, dni);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Empleado(rs.getInt("id"), rs.getString("nombres"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("usuario"), rs.getString("contrasenia"));
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
    
    public boolean verificarCredenciales(String user, String password) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from empleados where usuario=? and contrasenia =?");
            ps.setString(1, user);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;
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
}
