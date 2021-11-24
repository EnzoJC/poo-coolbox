/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coolbox.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Enzo Carrión
 */
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
            
            JOptionPane.showMessageDialog(null, "Conexión Exitosa\n" );
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Conexión fallida\n" + ex);
        }
        return conexion;
    }
   
}
