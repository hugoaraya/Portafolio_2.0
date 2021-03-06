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
    private String estado_habitacion;
    private int capacidad;
    private int estado_habitacion_id;
    private String fecha_inicio,fecha_fin;
    private int id_fechas;
    private int total_dias;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, String tipo_cama, String accesorios, int precio_habitacion, String descripcion, 
            String nombre_habitacion, String estado_habitacion, int capacidad,
            int estado_habitacion_id,String fecha_inicio,String fecha_fin,int id_fechas,int total_dias) {
        this.id_habitacion = id_habitacion;
        this.tipo_cama = tipo_cama;
        this.accesorios = accesorios;
        this.precio_habitacion = precio_habitacion;
        this.descripcion = descripcion;
        this.nombre_habitacion = nombre_habitacion;
        this.estado_habitacion = estado_habitacion;
        this.capacidad = capacidad;
        this.estado_habitacion_id = estado_habitacion_id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.id_fechas = id_fechas;
        this.total_dias = total_dias;
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

    public String getEstado_habitacion() {
        return estado_habitacion;
    }

    public void setEstado_habitacion(String estado_habitacion) {
        this.estado_habitacion = estado_habitacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstado_habitacion_id() {
        return estado_habitacion_id;
    }

    public void setEstado_habitacion_id(int estado_habitacion_id) {
        this.estado_habitacion_id = estado_habitacion_id;
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

    public int getId_fechas() {
        return id_fechas;
    }

    public void setId_fechas(int id_fechas) {
        this.id_fechas = id_fechas;
    }

    public int getTotal_dias() {
        return total_dias;
    }

    public void setTotal_dias(int total_dias) {
        this.total_dias = total_dias;
    }
    
    
    
}
