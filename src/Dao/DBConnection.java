/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author kmave
 */
public class DBConnection {
    private static Connection conexion;
    
 
    public DBConnection() {
    }
    
       public static Connection getConexion () throws SQLException {
        if (conexion == null){
            try{
                //Class.forName("org.gjt.mm.mysql.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/faceapp", "root","zRHLAnp5y7$");
                return conexion;
            }catch (ClassNotFoundException ex){
                JOptionPane.showConfirmDialog(null, "El error es: "+ ex.getMessage());
            }
        }else{
            return conexion;
        }
        return conexion;
    }
}
