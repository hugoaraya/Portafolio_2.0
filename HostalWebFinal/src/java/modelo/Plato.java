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

    public Plato() {
    }

    public Plato(int id, String nombre_plato) {
        this.id = id;
        this.nombre_plato = nombre_plato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }
    
    
    
}
