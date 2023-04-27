/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author kmave
 */
public class Usuarios {
    private String id;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String cargo;
    private String contraseña;
    private String contraseña2;
    
    public Usuarios (){
        
    }

    public Usuarios(String id, String nombre, String apellido_paterno, String apellido_materno, String cargo, String contraseña, String contraseña2) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.cargo = cargo;
        this.contraseña = contraseña;
        this.contraseña2 = contraseña2;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public String getCargo() {
        return cargo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getContraseña2() {
        return contraseña2;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setContraseña2(String contraseña2) {
        this.contraseña2 = contraseña2;
    }

   
    
    
    
}
