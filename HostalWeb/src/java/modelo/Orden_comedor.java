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
public class Orden_comedor {
    private String servicio_id;
    int id_orden_comedor;
    private int minuta_id,plato_id;

    public Orden_comedor() {
    }

    
    public Orden_comedor(int id_orden_comedor, String servicio_id, int minuta_id, int plato_id) {
        this.id_orden_comedor = id_orden_comedor;
        this.servicio_id = servicio_id;
        this.minuta_id = minuta_id;
        this.plato_id = plato_id;
    }

    public int getId_orden_comedor() {
        return id_orden_comedor;
    }

    public void setId_orden_comedor(int id_orden_comedor) {
        this.id_orden_comedor = id_orden_comedor;
    }

    public String getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(String servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getMinuta_id() {
        return minuta_id;
    }

    public void setMinuta_id(int minuta_id) {
        this.minuta_id = minuta_id;
    }

    public int getPlato_id() {
        return plato_id;
    }

    public void setPlato_id(int plato_id) {
        this.plato_id = plato_id;
    }

    
}
