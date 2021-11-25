package coolbox.model.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conexion;
   
    public Conexion() {
    }
    
    public static Connection getConexion() {
        try{
            String file = "src/credenciales.txt";
            Scanner scanner = new Scanner(new File(file));
            scanner.useDelimiter(";");
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String root= scanner.next();
            String pass= scanner.next();
            String url="jdbc:mysql://localhost:3306/coolbox_db";
            
            Conexion.conexion=DriverManager.getConnection(url,root,pass);
            
//            JOptionPane.showMessageDialog(null, "Conexión Exitosa\n" );
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Conexión fallida\n" + ex);
        }
        return conexion;
    }
   
}
