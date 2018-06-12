/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import static consultas.Query.*;
import modelo.Orden_compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 420NiggaBytes
 */
public class Orden_CompraDAO {
    
    public static ArrayList<Orden_compra> listaOrdenCompra(int id) throws SQLException{
        
        
        String sql1 = SQL_LISTAR_ORDENES_COMPRA_EMPRESA_METODO(id);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Orden_compra> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Orden_compra oc = new Orden_compra();
        oc.setNro_orden(rs.getInt(1));
        oc.setNombre_empresa(rs.getString(2));       
        oc.setRut(rs.getString(3));
        oc.setDv(rs.getString(4));
         oc.setFecha(rs.getDate(5));
        
        arreglo.add(oc);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
    
            
       public static ArrayList<Orden_compra> listaHuespedHabitacion(String huesped_id,String habitacion_id) throws SQLException{
        
        
        String sql1 = SQL_HUESPED_HABITACION_ID_METODO(huesped_id,habitacion_id);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Orden_compra> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Orden_compra oc = new Orden_compra();
        oc.setHuesped_habitacion_id(rs.getString(1));
      
        
        arreglo.add(oc);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
         
       }
    
      public static void AgregarHuespedHabitacion(Orden_compra oc) throws SQLException {
        

        String sql = SQL_INSERTAR_HUESPED_HABITACION_METODO(oc.getHuesped_id(),oc.getHabitacion_id());
                
                Connection conexion = new Conexion().fabricarConexion();
           Statement st = conexion.createStatement();         

             st.executeUpdate(sql);

            st.close();
            conexion.close();  
       
    }  

   public static void AgregarOrdenCompra(Orden_compra oc) throws SQLException {
        

        String sql = SQL_INSERTAR_ORDEN_COMPRA_METODO(oc.getNro_orden(),oc.getEmpresa_id(),oc.getFecha_orden(),oc.getHuesped_habitacion_id());
                
                Connection conexion = new Conexion().fabricarConexion();
           Statement st = conexion.createStatement();         

             st.executeUpdate(sql);

            st.close();
            conexion.close();  
       
    }  
}
