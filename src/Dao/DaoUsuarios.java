/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Dto.Usuarios;
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
public class DaoUsuarios {
    // VARIABLES
    private String error;
    private boolean isError;
    
    // METODO INSERTAR REGISTRO A BASE DE DATOS
    
    public int insertar (Usuarios u){
        int resultado=0;
        clean();
        
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("INSERT INTO usuarios VALUE('"+u.getId()+"','"
                    +u.getNombre()+"','"
                    +u.getApellido_paterno()+"','"
                    +u.getApellido_materno()+"','"
                    +u.getCargo()+"','"
                    +u.getContraseña()+"')");
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        return resultado;
    }
    
    //METODO PARA BUSCAR TABLA
    
    public void buscartabla (JTable tabla_usuarios){
        
        clean();
        
        DefaultTableModel model= (DefaultTableModel) tabla_usuarios.getModel();
        
       try{
            Connection con=DBConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            
            Object row[]=new Object[6];
            
            while(rs.next()){
                row[0]=rs.getString("id");
                row[1]=rs.getString("nombre");
                row[2]=rs.getString("apellido_paterno");
                row[3]=rs.getString("apellido_materno");
                row[4]=rs.getString("cargo");
                row[5]=rs.getString("contrasena");
                
                model.addRow(row);
            }
            
            tabla_usuarios.setModel(model);
            
        }catch (Exception ex){
            
           JOptionPane.showMessageDialog(null, "No se pudo mostrar");
            this.error=ex.getMessage();
            this.isError=true;
        }
        
    }
    
    // METODO INICIO DE SESION
    
    public int iniciarSesion (String id_usuario, String contraseña){
        int resultado = 0;
        clean();
        
        try{
            
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs= st.executeQuery("SELECT count(*) as login FROM usuarios where id='"+id_usuario+"'and contrasena='"+contraseña+"';");
            rs.next();
            resultado=rs.getInt("login");
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        
        return resultado;
    }
    
    //METODO PARA BUSCAR
    
    public Usuarios buscar (String id_usuario){
        Usuarios u=null;
        clean();
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE id='"+id_usuario+"';");
            rs.next();
            u = new Usuarios();
            u.setId(rs.getString("id"));
            u.setNombre(rs.getString("nombre"));
            u.setApellido_paterno(rs.getString("apellido_paterno"));
            u.setApellido_materno(rs.getString("apellido_materno"));
            u.setCargo(rs.getString("cargo"));
            u.setContraseña(rs.getString("contrasena"));            
            
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        return u;
    }
    
    // METODO ACTUALIZAR
    
   public int actualizar (Usuarios u){
        int resultado=0;
        clean();
        
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("UPDATE usuarios SET id='" +u.getId()+
                    "', nombre='"+ u.getNombre()+
                    "', nombre='"+ u.getNombre()+
                    "', apellido_paterno='"+ u.getApellido_paterno()+
                    "', apellido_materno='"+ u.getApellido_materno()+
                    "', cargo='"+ u.getCargo()+
                    "', contrasena='" +u.getContraseña()+
                    "' WHERE id='"+ u.getId()+"'");
            
        }catch (Exception ex){
            this.error=ex.getMessage();
            this.isError=true;
        }
        return resultado;
    }
   
   // METODO ELIMINAR UN REGISTRO
   
   public int eliminar (String id_usuario){
        int resultado = 0;
        clean();
        try{
            Connection con = DBConnection.getConexion();
            Statement st = con.createStatement();
            resultado = st.executeUpdate("DELETE FROM usuarios WHERE id='"+id_usuario+"';");
            
        }catch (Exception ex){
            this.error= ex.getMessage();
            this.isError=true;
        }
        
        
        return resultado;
    }
   
   
    
    
    
    
    // METODO LIMPIAR
    
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
