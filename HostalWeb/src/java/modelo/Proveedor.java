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
public class Proveedor {
    private int idProveedor;
    private String rut;
    private String dv;
    private String nombre;
    private String direccion;
    private String rubro;
    private String usuario_id;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String rut, String dv, String nombre, String direccion, String rubro,String usuario_id) {
        this.idProveedor = idProveedor;
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rubro = rubro;
        this.usuario_id = usuario_id;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    
}
