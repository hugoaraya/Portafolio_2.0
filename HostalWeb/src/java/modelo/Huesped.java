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
public class Huesped {
    private int id_huesped;
    private String rut,dv;
    private String nombre,apellido;
    private int numero_tefono;
    private String correo;
    private String cargo;
    private int id_empresa;
    private String estado_huesped;
    private int id_estado_huesped;
    private int cargo_id;

    public Huesped() {
    }

    public Huesped(int id_huesped, String rut, String dv, String nombre, String apellido, int numero_tefono, String correo, String cargo, int id_empresa,String estado_huesped, int id_estado_huesped,int cargo_id) {
        this.id_huesped = id_huesped;
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero_tefono = numero_tefono;
        this.correo = correo;
        this.cargo = cargo;
        this.id_empresa = id_empresa;
        this.estado_huesped = estado_huesped;
        this.id_estado_huesped = id_estado_huesped;
        this.cargo_id = cargo_id;
        
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumero_tefono() {
        return numero_tefono;
    }

    public void setNumero_tefono(int numero_tefono) {
        this.numero_tefono = numero_tefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getEstado_huesped() {
        return estado_huesped;
    }

    public void setEstado_huesped(String estado_huesped) {
        this.estado_huesped = estado_huesped;
    }   
    
    
    public int getId_estado_huesped() {
        return id_estado_huesped;
    }

    public void setId_estado_huesped(int id_estado_huesped) {
        this.id_estado_huesped = id_estado_huesped;
    }

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }
    
    
}
