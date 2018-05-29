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

    public Orden_compra() {
    }

    public Orden_compra(int nro_orden, String nombre_empresa, String rut, String dv, Date fecha) {
        this.nro_orden = nro_orden;
        this.nombre_empresa = nombre_empresa;
        this.rut = rut;
        this.dv = dv;
        this.fecha = fecha;
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
    
    
}
