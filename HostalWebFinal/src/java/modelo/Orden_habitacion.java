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
public class Orden_habitacion {
    private String nombre_huesped,apellido_huesped,rut_huesped,dv_huesped,
            correo_huesped,cargo_huesped;
    private int telefono_huesped;
    private String descripcion_habitacion;
    private int precio_habitacion;

    public Orden_habitacion() {
    }

    public Orden_habitacion(String nombre_huesped, String apellido_huesped, String rut_huesped, String dv_huesped, String correo_huesped, String cargo_huesped, int telefono_huesped, String descripcion_habitacion, int precio_habitacion) {
        this.nombre_huesped = nombre_huesped;
        this.apellido_huesped = apellido_huesped;
        this.rut_huesped = rut_huesped;
        this.dv_huesped = dv_huesped;
        this.correo_huesped = correo_huesped;
        this.cargo_huesped = cargo_huesped;
        this.telefono_huesped = telefono_huesped;
        this.descripcion_habitacion = descripcion_habitacion;
        this.precio_habitacion = precio_habitacion;
    }

    public String getNombre_huesped() {
        return nombre_huesped;
    }

    public void setNombre_huesped(String nombre_huesped) {
        this.nombre_huesped = nombre_huesped;
    }

    public String getApellido_huesped() {
        return apellido_huesped;
    }

    public void setApellido_huesped(String apellido_huesped) {
        this.apellido_huesped = apellido_huesped;
    }

    public String getRut_huesped() {
        return rut_huesped;
    }

    public void setRut_huesped(String rut_huesped) {
        this.rut_huesped = rut_huesped;
    }

    public String getDv_huesped() {
        return dv_huesped;
    }

    public void setDv_huesped(String dv_huesped) {
        this.dv_huesped = dv_huesped;
    }

    public String getCorreo_huesped() {
        return correo_huesped;
    }

    public void setCorreo_huesped(String correo_huesped) {
        this.correo_huesped = correo_huesped;
    }

    public String getCargo_huesped() {
        return cargo_huesped;
    }

    public void setCargo_huesped(String cargo_huesped) {
        this.cargo_huesped = cargo_huesped;
    }

    public int getTelefono_huesped() {
        return telefono_huesped;
    }

    public void setTelefono_huesped(int telefono_huesped) {
        this.telefono_huesped = telefono_huesped;
    }

    public String getDescripcion_habitacion() {
        return descripcion_habitacion;
    }

    public void setDescripcion_habitacion(String descripcion_habitacion) {
        this.descripcion_habitacion = descripcion_habitacion;
    }

    public int getPrecio_habitacion() {
        return precio_habitacion;
    }

    public void setPrecio_habitacion(int precio_habitacion) {
        this.precio_habitacion = precio_habitacion;
    }
    
    
    
    
}
