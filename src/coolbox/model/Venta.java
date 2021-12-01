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

public class Venta implements ICrud<Venta>{
    private int id;
    private Empleado empleado;
    private Cliente cliente;
    private float total;
    private List<DetalleVenta> listaDetalleVenta;
            
    private PreparedStatement ps = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public Venta() {
    }
    
    public Venta(int id, Empleado empleado, Cliente cliente, float total) {
        this.id = id;
        this.empleado = empleado;
        this.cliente = cliente;
        this.total = total;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<DetalleVenta> getListaDetalleVenta() {
        return listaDetalleVenta;
    }

    public void setListaDetalleVenta(List<DetalleVenta> listaDetalleVenta) {
        this.listaDetalleVenta = listaDetalleVenta;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    @Override
    public Boolean create(Venta venta) {
         try {
            ps = Conexion.getConexion().prepareStatement("insert into ventas (empleados_id,clientes_id,total) values (?,?,?)");
            ps.setInt(1, venta.getEmpleado().getId());
            ps.setInt(2, venta.getCliente().getId());
            ps.setFloat(3, venta.getTotal());
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
    public Boolean update(Venta venta) {
        try{
            ps = Conexion.getConexion().prepareStatement("update ventas set empleados_id=?, clientes_id=?, total=? where id=?");
            ps.setInt(1, venta.getEmpleado().getId());
            ps.setInt(2, venta.getCliente().getId());
            ps.setFloat(3, venta.getTotal());
            
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
    public Boolean delete(Venta venta) {
        try {
            ps = Conexion.getConexion().prepareStatement("delete from ventas where id=?");
            ps.setInt(1, venta.getId());
            int result = ps.executeUpdate();
            return result > 0; //Ejecucion correcta
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error:\n" + ex);
        }finally{
            try{
                Conexion.getConexion().close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error:\n" + ex);
            }
        }
        return false;
    }

    @Override
    public List<Venta> read() {
        List<Venta> listaVentas = new ArrayList<>();
        try {
            ps = Conexion.getConexion().prepareStatement("select * from ventas");
            rs= ps.executeQuery();
            
            while(rs.next()){
                Empleado empleadoCrud = new Empleado();
                Cliente clienteCrud = new Cliente();
                listaVentas.add(new Venta(rs.getInt("id"), empleadoCrud.buscarPorId(rs.getInt("empleados_id")), clienteCrud.buscarPorId(rs.getInt("clientes_id")), rs.getFloat("total")));
            }
            return listaVentas;
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
        if(read().size()==0){
            return -1;
        }
        return read().get(read().size()-1).getId();
    }
    
    public float obtenerTotal() {
        float total = 0;
        for (DetalleVenta detalleVenta : listaDetalleVenta) {
            total += (detalleVenta.getCantidad() * detalleVenta.getProducto().getPrecioVenta());
        }
        return total;
    }
    
    public Venta buscarPorId(int id) {
        try {
            ps = Conexion.getConexion().prepareStatement("select * from ventas where id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                return new Venta(rs.getInt("id"), empleado.buscarPorId(rs.getInt("empleados_id")), cliente.buscarPorId(rs.getInt("clientes_id")), Float.parseFloat(rs.getString("total")));
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
