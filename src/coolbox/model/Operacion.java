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

public class Operacion implements ICrud<Operacion>{
    private int id;
    private String nombre;
    
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Operacion(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Operacion() {
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
    
    @Override
    public Boolean create(Operacion operacion) {
       try {
            ps = Conexion.getConexion().prepareStatement("insert into operaciones (nombre) values (?)");
            ps.setString(1, operacion.getNombre());
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
    public Boolean update(Operacion operacion) {
        try{
            ps = Conexion.getConexion().prepareStatement("update operaciones set nombre=? where id=?");
            ps.setString(1, operacion.getNombre());
            
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
    public Boolean delete(Operacion operacion) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from operaciones where id=?");
            ps.setInt(1, operacion.getId());

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
    public List<Operacion> read() {
        List<Operacion> listaOperaciones = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from operaciones");

            rs = ps.executeQuery();
            
            while (rs.next()) {
                listaOperaciones.add(new Operacion(rs.getInt("id"), rs.getString("nombre")));
            }
            return listaOperaciones;

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
    
    public Operacion buscarPorId(int id) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from operaciones where id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Operacion(rs.getInt("id"), rs.getString("nombre"));
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
