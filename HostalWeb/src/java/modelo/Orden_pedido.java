/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author 420NiggaBytes
 */
public class Orden_pedido {
    private int nro_orden;
    private String nombre_empleado;
    private Date fecha;
    private String rut;
    private String estado_orden;
    private int proveedor_id;

    public Orden_pedido() {
    }

    public Orden_pedido(int nro_orden, String nombre_empleado, Date fecha, String rut, int proveedor_id,String estado_orden) {
        this.nro_orden = nro_orden;
        this.nombre_empleado = nombre_empleado;
        this.fecha = fecha;
        this.rut = rut;
        this.proveedor_id = proveedor_id;
        this.estado_orden = estado_orden;
    }

    public int getNro_orden() {
        return nro_orden;
    }

    public void setNro_orden(int nro_orden) {
        this.nro_orden = nro_orden;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }
    
    
    
    
}
