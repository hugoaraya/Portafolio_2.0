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
public class Orden_compra {
    private int nro_orden;
    private String nombre_empresa,rut,dv;
    private Date fecha;
    private String huesped_id,habitacion_id,huesped_habitacion_id;
    private int empresa_id;
    private String fecha_orden;

    public Orden_compra() {
    }

    public Orden_compra(int nro_orden, String nombre_empresa, String rut, String dv, Date fecha, 
            String huesped_id, String habitacion_id, String huesped_habitacion_id,int empresa_id,String fecha_orden) {
        this.nro_orden = nro_orden;
        this.nombre_empresa = nombre_empresa;
        this.rut = rut;
        this.dv = dv;
        this.fecha = fecha;
        this.huesped_id = huesped_id;
        this.habitacion_id = habitacion_id;
        this.huesped_habitacion_id = huesped_habitacion_id;
        this.empresa_id = empresa_id;
        this.fecha_orden = fecha_orden;
    }

    public int getNro_orden() {
        return nro_orden;
    }

    public void setNro_orden(int nro_orden) {
        this.nro_orden = nro_orden;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHuesped_id() {
        return huesped_id;
    }

    public void setHuesped_id(String huesped_id) {
        this.huesped_id = huesped_id;
    }

    public String getHabitacion_id() {
        return habitacion_id;
    }

    public void setHabitacion_id(String habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public String getHuesped_habitacion_id() {
        return huesped_habitacion_id;
    }

    public void setHuesped_habitacion_id(String huesped_habitacion_id) {
        this.huesped_habitacion_id = huesped_habitacion_id;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(String fecha_orden) {
        this.fecha_orden = fecha_orden;
    }
    
    
    
}
