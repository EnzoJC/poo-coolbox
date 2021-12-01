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

public class Cliente implements ICrud<Cliente>{
    private int id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String dni;
    private String telefono;
    private String correo;

    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Cliente(int id, String nombre, String apellidos, String direccion, String dni, String telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Cliente(String nombre, String apellidos, String direccion, String dni, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente() {
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Override
    public Boolean create(Cliente cliente) {
       try {
            ps = Conexion.getConexion().prepareStatement("insert into clientes (nombres, apellidos, direccion, dni, telefono,correo) values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getDni());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
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
    public Boolean update(Cliente cliente) {
        try{
            ps = Conexion.getConexion().prepareStatement("update clientes set nombres=?, apellidos=?, direccion=?, dni=?, telefono=?, correo=? where id=?");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getDni());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getCorreo());
            
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
    public Boolean delete(Cliente cliente) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from clientes where id=?");
            ps.setInt(1, cliente.getId());

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
    public List<Cliente> read() {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from clientes");

            rs = ps.executeQuery();
            
            while (rs.next()) {
                listaClientes.add(new Cliente(rs.getInt("id"), rs.getString("nombres"),rs.getString("apellidos"), rs.getString("direccion"), rs.getString("dni"),rs.getString("telefono"), rs.getString("correo")));
            }
            return listaClientes;
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
    
    public Cliente buscarPorDni(String dni){
        try {
            ps = Conexion.getConexion().prepareStatement("select * from clientes where dni=?");
            ps.setString(1, dni);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("nombres"), rs.getString("apellidos"), 
                rs.getString("direccion"), rs.getString("dni"), rs.getString("telefono"), rs.getString("correo"));
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
    public Cliente buscarPorId(int id) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from clientes where id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Cliente(rs.getInt("id"), rs.getString("nombres"), rs.getString("apellidos"), 
                rs.getString("direccion"), rs.getString("dni"), rs.getString("telefono"), rs.getString("correo"));
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
