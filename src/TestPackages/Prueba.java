/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestPackages;

import Dao.DBConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author kmave
 */
public class Prueba {
    public static void main(String[] args){
        try {
            Connection con = DBConnection.getConexion();
            System.out.println("La conexion a la base de datos fue correcta.");
        } catch (SQLException ex) {
            System.out.println("No se conecto por"+ex.getMessage());
        }
    
    }
    
}
