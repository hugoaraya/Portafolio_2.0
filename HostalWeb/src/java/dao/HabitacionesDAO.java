/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import modelo.Habitacion;
import static consultas.Query.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 420NiggaBytes
 */
public class HabitacionesDAO {
    public static void AgregarHabitacion(Habitacion hab) throws SQLException {
        

        String sql = SQL_INSERTAR_HABITACIONES_METODO(hab.getTipo_cama(),hab.getAccesorios(),hab.getPrecio_habitacion(),
                hab.getDescripcion(),hab.getNombre_habitacion(),hab.getEstado_habitacion_id(),hab.getCapacidad());
        
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();    
       
    }
    
    public static ArrayList<Habitacion> listaHabitacion() throws SQLException {

        String sql1 = SQL_LISTAR_HABITACIONES_METODO();
        Connection conexion = new Conexion().fabricarConexion();

        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Habitacion> arreglo = new ArrayList<>();

        while (rs.next()) {
            Habitacion hab = new Habitacion();
            hab.setId_habitacion(rs.getInt(1));
            hab.setTipo_cama(rs.getString(2));
            hab.setAccesorios(rs.getString(3));            
            hab.setPrecio_habitacion(rs.getInt(4));
            hab.setDescripcion(rs.getString(5));           
            hab.setNombre_habitacion(rs.getString(6));
            hab.setEstado_habitacion(rs.getString(7));
            hab.setCapacidad(rs.getInt(8));
            arreglo.add(hab);
        }

        rs.close();
        conexion.close();
        return arreglo;
    }
    
      public static void modificarHabitaciones(int id,String tipo_cama, String accesorios, int precio_habitacion, String descripcion, String nombre_habitacion, int capacidad) throws SQLException {
        
        String sql = SQL_MODIFICAR_HABITACIONES_METODO(id, tipo_cama, accesorios, precio_habitacion, descripcion, nombre_habitacion, capacidad);
         
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();      
    }
      
      
      public static Habitacion getHabitacionPorId(int id) throws SQLException {
        Habitacion hab = null;
        
            Connection cn = new Conexion().fabricarConexion();
            Statement st = cn.createStatement();
            String sql = SQL_LISTAR_HABITACION_ID_METODO(id);            
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                hab = new Habitacion();
                hab.setId_habitacion(id);
                hab.setTipo_cama(rs.getString(2));
                hab.setAccesorios(rs.getString(3));            
                hab.setPrecio_habitacion(rs.getInt(4));
                hab.setDescripcion(rs.getString(5));           
                hab.setNombre_habitacion(rs.getString(6));
                hab.setEstado_habitacion_id(rs.getInt(7));
                hab.setCapacidad(rs.getInt(8));           
    }
             rs.close();
            st.close();
            cn.close();
       return hab;
  }
      
       public static ArrayList<Habitacion> listaHabitacionFechaCap(int capacidad,String fecha_inicio,String fecha_salida) throws SQLException {

        String sql1 = SQL_LISTAR_HABITACION_FECHA_CAP_METODO(capacidad, fecha_inicio, fecha_salida);
        Connection conexion = new Conexion().fabricarConexion();

        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Habitacion> arreglo = new ArrayList<>();

        while (rs.next()) {
            Habitacion hab = new Habitacion();
            hab.setId_habitacion(rs.getInt(1));
            hab.setTipo_cama(rs.getString(2));
            hab.setAccesorios(rs.getString(3));            
            hab.setPrecio_habitacion(rs.getInt(4));
            hab.setDescripcion(rs.getString(5));           
            hab.setNombre_habitacion(rs.getString(6));
            hab.setEstado_habitacion(rs.getString(7));
            hab.setCapacidad(rs.getInt(8));
            arreglo.add(hab);
        }

        rs.close();
        conexion.close();
        return arreglo;
    }
      
}
