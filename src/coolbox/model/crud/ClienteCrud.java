package coolbox.model.crud;

import coolbox.model.Cliente;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteCrud implements ICrud<Cliente>{

    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
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
