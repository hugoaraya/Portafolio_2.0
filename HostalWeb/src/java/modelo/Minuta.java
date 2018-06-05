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
public class Minuta {
    private int id_minuta;
    private String nombre_minuta;
    private String fecha_inicio;
    private String fecha_fin;

    public Minuta() {
    }

    public Minuta(int id_minuta, String nombre_minuta, String fecha_inicio, String fecha_fin) {
        this.id_minuta = id_minuta;
        this.nombre_minuta = nombre_minuta;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId_minuta() {
        return id_minuta;
    }

    public void setId_minuta(int id_minuta) {
        this.id_minuta = id_minuta;
    }

    public String getNombre_minuta() {
        return nombre_minuta;
    }

    public void setNombre_minuta(String nombre_minuta) {
        this.nombre_minuta = nombre_minuta;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

  
    
}
