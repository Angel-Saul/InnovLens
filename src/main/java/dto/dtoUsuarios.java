/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author jonhy
 */
public class dtoUsuarios {
    private Integer id_usuario;
    private String nombre;
    private String correo;
    private String contra;
    private Integer id_rol;
    
    public dtoUsuarios(int id_usuario, String nombre, String correo, String contra, Integer id_rol){
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo; 
        this.contra = contra;
        this.id_rol = id_rol;
    }
    public dtoUsuarios(){
        
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }
    
   
}
