/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dto.Registros;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kmave
 */
public class DaoRegistros {
    private String error;
    private boolean isError;
    
    // METODO INSERTAR REGISTRO A BASE DE DATOS
    
    public int insertar (Registros r){
        int resultado=0;
        clean();
        
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("INSERT INTO registros VALUE('"+r.getId()+"','"
                    +r.getNombre()+"','"
                    +r.getApellido_paterno()+"','"
                    +r.getApellido_materno()+"','"
                    +r.getFecha_nacimiento()+"','"
                    +r.getEmail()+"')");
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        return resultado;
    }
    
    
    //METODO PARA BUSCAR TABLA
    
    public void buscartabla (JTable tabla_registros){
        
        clean();
        
        DefaultTableModel model= (DefaultTableModel) tabla_registros.getModel();
        
       try{
            Connection con=DBConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM registros");
            
            Object row[]=new Object[6];
            
            while(rs.next()){
                row[0]=rs.getString("id");
                row[1]=rs.getString("nombre");
                row[2]=rs.getString("apellido_paterno");
                row[3]=rs.getString("apellido_materno");
                row[4]=rs.getString("fecha_nacimiento");
                row[5]=rs.getString("email");
                
                model.addRow(row);
            }
            
            tabla_registros.setModel(model);
            
        }catch (Exception ex){
            
           JOptionPane.showMessageDialog(null, "No se pudo mostrar");
            this.error=ex.getMessage();
            this.isError=true;
        }
        
    }
    
    //METODO PARA BUSCAR
    
    public Registros buscar (String id_registro){
        Registros r=null;
        clean();
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM registros WHERE id='"+id_registro+"';");
            rs.next();
            r = new Registros();
            r.setId(rs.getString("id"));
            r.setNombre(rs.getString("nombre"));
            r.setApellido_paterno(rs.getString("apellido_paterno"));
            r.setApellido_materno(rs.getString("apellido_materno"));
            r.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            r.setEmail(rs.getString("email"));            
            
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        return r;
    }
    
    
    //Metodo para filtrar busqueda 
    public void filtro (JTable tabla_registros, String d, String h){
        
        clean();
        
        DefaultTableModel model= (DefaultTableModel) tabla_registros.getModel();
        
       try{
            Connection con=DBConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM registros WHERE fecha_nacimiento BETWEEN '"+ d+"' AND '"+ h+"'");
            
            
            Object row[]=new Object[6];
            
            while(rs.next()){
                row[0]=rs.getString("id");
                row[1]=rs.getString("nombre");
                row[2]=rs.getString("apellido_paterno");
                row[3]=rs.getString("apellido_materno");
                row[4]=rs.getString("fecha_nacimiento");
                row[5]=rs.getString("email");
                model.addRow(row);
            }
            
            tabla_registros.setModel(model);
            
        }catch (Exception ex){
            
           JOptionPane.showMessageDialog(null, "No se pudo mostrar");
            this.error=ex.getMessage();
            this.isError=true;
        }
    }
    
    // METODO ELIMINAR UN REGISTRO
   
   public int eliminar (String id_registro){
        int resultado = 0;
        clean();
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("DELETE FROM registros WHERE id='"+id_registro+"';");
            
        }catch (Exception ex){
            this.error= ex.getMessage();
            this.isError=true;
        }
        
        
        return resultado;
    }
    
   
   // METODO ACTUALIZAR
    
   public int actualizar (Registros r){
        int resultado=0;
        clean();
        
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("UPDATE registros SET id='" +r.getId()+
                    "', nombre='"+ r.getNombre()+
                    "', nombre='"+ r.getNombre()+
                    "', apellido_paterno='"+ r.getApellido_paterno()+
                    "', apellido_materno='"+ r.getApellido_materno()+
                    "', fecha_nacimiento='"+ r.getFecha_nacimiento()+
                    "', email='" +r.getEmail()+
                    "' WHERE id='"+ r.getId()+"'");
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        return resultado;
    }
    
    
    
   
    
    
    // Metodo para limpiar 
    
    public void clean (){
        this.error="";
        this.isError=false;
    }
    
    // SET Y GET DE VARIABLES

    public String getError() {
        return error;
    }

    public boolean isIsError() {
        return isError;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setIsError(boolean isError) {
        this.isError = isError;
    }
    
    
}
