/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static consultas.Query.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Orden_habitacion;

/**
 *
 * @author 420NiggaBytes
 */
public class Orden_HabitacionDAO {
    
     public static ArrayList<Orden_habitacion> listaOrdenHabitacion(int nro_orden) throws SQLException{
        
        
        String sql1 = SQL_LISTAR_DETALLE_ORDEN_METODO(nro_orden);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Orden_habitacion> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Orden_habitacion orden = new Orden_habitacion();
        orden.setNombre_huesped(rs.getString(1));
        orden.setApellido_huesped(rs.getString(2));
        orden.setRut_huesped(rs.getString(3));
        orden.setCargo_huesped(rs.getString(4));
        orden.setCorreo_huesped(rs.getString(5));      
        orden.setTelefono_huesped(rs.getInt(7));
        orden.setDescripcion_habitacion(rs.getString(8));
        orden.setPrecio_habitacion(rs.getInt(9));      
        arreglo.add(orden);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
}
