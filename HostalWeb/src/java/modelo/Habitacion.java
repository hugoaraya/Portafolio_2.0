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
public class Habitacion {
    private int id_habitacion;
    private String tipo_cama;
    private String accesorios;
    private int precio_habitacion;
    private String descripcion;
    private String nombre_habitacion;
    private int estado_habitacion_id;
    private int capacidad;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, String tipo_cama, String accesorios, int precio_habitacion, String descripcion, String nombre_habitacion, int estado_habitacion_id, int capacidad) {
        this.id_habitacion = id_habitacion;
        this.tipo_cama = tipo_cama;
        this.accesorios = accesorios;
        this.precio_habitacion = precio_habitacion;
        this.descripcion = descripcion;
        this.nombre_habitacion = nombre_habitacion;
        this.estado_habitacion_id = estado_habitacion_id;
        this.capacidad = capacidad;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getTipo_cama() {
        return tipo_cama;
    }

    public void setTipo_cama(String tipo_cama) {
        this.tipo_cama = tipo_cama;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public int getPrecio_habitacion() {
        return precio_habitacion;
    }

    public void setPrecio_habitacion(int precio_habitacion) {
        this.precio_habitacion = precio_habitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_habitacion() {
        return nombre_habitacion;
    }

    public void setNombre_habitacion(String nombre_habitacion) {
        this.nombre_habitacion = nombre_habitacion;
    }

    public int getEstado_habitacion_id() {
        return estado_habitacion_id;
    }

    public void setEstado_habitacion_id(int estado_habitacion_id) {
        this.estado_habitacion_id = estado_habitacion_id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
