/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author jonhy
 */
public class dtoExpediente {

    private Integer id;
    private String nombre;
    private String telefono;
    private String historial;

    public dtoExpediente( Integer id,String nombre, String telefono, String historial) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.historial = historial;
    }
    
    public dtoExpediente(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }
}
