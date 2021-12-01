package coolbox.model;

import coolbox.model.database.ICrud;
import coolbox.model.database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AsistenciaEmpleado implements ICrud<AsistenciaEmpleado>{
    private int id;
    private Empleado empleado;
    private Timestamp entrada;
    private Timestamp salida;
    
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public AsistenciaEmpleado(int id, Empleado empleado, Timestamp entrada, Timestamp salida) {
        this.id = id;
        this.empleado = empleado;
        this.entrada = entrada;
        this.salida = salida;
    }

    public AsistenciaEmpleado() {
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

    public Timestamp getEntrada() {
        return entrada;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getSalida() {
        return salida;
    }

    public void setSalida(Timestamp salida) {
        this.salida = salida;
    }
    public void marcarEntrada(){
        Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        this.entrada = ts;
    }
    
    public void marcarSalida(){
        Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        this.salida = ts;
    }
    
    @Override
    public Boolean create(AsistenciaEmpleado asistenciaEmp) {
        try {
            ps = Conexion.getConexion().prepareStatement("insert into asistencia_empleado (id, empleados_id, entrada) values (?, ?, ?)");
            ps.setInt(1, asistenciaEmp.getId());
            ps.setInt(2, asistenciaEmp.getEmpleado().getId());
            ps.setTimestamp(3, asistenciaEmp.getEntrada());

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
            ps.setInt(4, asistenciaEmpleado.getId());
            
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
                Empleado empleadoCrud = new Empleado();
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
    
    public int ulitmoId(){
        if(read().isEmpty()){
            return 0;
        }
        return read().get(read().size()-1).getId();
    }
}
