package coolbox.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conexion;
   
    public Conexion() {
    }
    
    public static Connection getConexion() {
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String root= JOptionPane.showInputDialog("Ingresa el usuario de la Base de Datos");
            String pass= JOptionPane.showInputDialog("Ingresa la contraseña de la Base de Datos");
            String url="jdbc:mysql://localhost:3306/coolbox_db";
            
            Conexion.conexion=DriverManager.getConnection(url,root,pass);
            
//            JOptionPane.showMessageDialog(null, "Conexión Exitosa\n" );
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Conexión fallida\n" + ex);
        }
        return conexion;
    }
   
}
