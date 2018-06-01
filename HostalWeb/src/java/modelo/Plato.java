/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



/**
 *
 * @author 420NiggaBytes
 */
public class Plato {
    private int id;
    private String nombre_plato;
    private String descripcion;
    private int precio;  

    public Plato() {
    }
    
    public Plato(int id, String nombre_plato, String descripcion, int precio) {
        this.id = id;
        this.nombre_plato = nombre_plato;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre_plato;
    }

    public void setNombre(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
