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

public class Movimiento implements ICrud<Movimiento>{
    private int id;
    private Empleado empleado;
    private Caja caja;
    private float monto;
    private Operacion operacion;
    
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Movimiento(int id, Empleado empleado, Caja caja, float monto, Operacion operacion) {
        this.id = id;
        this.empleado = empleado;
        this.caja = caja;
        this.monto = monto;
        this.operacion = operacion;
    }

    public Movimiento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }
    
    @Override
    public Boolean create(Movimiento movimiento) {
        try {
            ps = Conexion.getConexion().prepareStatement("insert into movimientos (empleados_id, caja_id, monto, operaciones_id) values (?, ?, ?, ?)");
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
                Empleado empleadoCrud = new Empleado();
                Caja cajaCrud = new Caja();
                Operacion operacionCrud = new Operacion();
                
                listaMovimientos.add(new Movimiento(rs.getInt("id"), empleadoCrud.buscarPorId(rs.getInt("empleados_id")), 
                cajaCrud.buscarPorId(rs.getInt("caja_id")), rs.getFloat("monto"), operacionCrud.buscarPorId(rs.getInt("operaciones_id"))));
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
