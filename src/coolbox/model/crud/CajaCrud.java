package coolbox.model.crud;

import coolbox.model.Caja;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CajaCrud implements ICrud<Caja>{
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    @Override
    public Boolean create(Caja caja) {
        try {
            ps = Conexion.getConexion().prepareStatement("insert into caja (monto) values (?)");
            ps.setFloat(1, caja.getMonto());
            ps.setInt(2, caja.getId());
            
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
    public Boolean update(Caja caja) {
        try{
            ps = Conexion.getConexion().prepareStatement("update caja set monto=? where id=?");
            ps.setFloat(1, caja.getMonto());
            ps.setInt(2, caja.getId());
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
    public Boolean delete(Caja caja) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from caja where id=?");
            ps.setInt(1, caja.getId());

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
    public List<Caja> read() {
        List<Caja> listaCajas = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from caja");

            rs = ps.executeQuery();
            
            while (rs.next()) {
                listaCajas.add(new Caja(rs.getInt("id"), rs.getFloat("monto")));
            }
            return listaCajas;
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
    
    public Caja buscarPorId(int id) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from caja where id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Caja(rs.getInt("id"), rs.getFloat("monto"));
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
