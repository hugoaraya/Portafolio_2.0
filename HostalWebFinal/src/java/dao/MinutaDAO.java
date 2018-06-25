/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Minuta;
import static consultas.Query.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 420NiggaBytes
 */
public class MinutaDAO {
    
    public static void AgregarMinuta(Minuta min) throws SQLException {
        

        String sql = SQL_INSERTAR_MINUTA_METODO(min.getNombre_minuta(),min.getFecha_inicio(),min.getFecha_fin());
        
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();    
       
    }  
    
    public static ArrayList<Minuta> listarMinuta() throws SQLException{
        
        
        String sql1 = SQL_LISTAR_MINUTA_METODO();
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Minuta> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Minuta min = new Minuta();
        min.setId_minuta(rs.getInt(1));
        min.setNombre_minuta(rs.getString(2));
        min.setFecha_inicio(rs.getString(3));
        min.setFecha_fin(rs.getString(4));

        arreglo.add(min);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
    
     public static Minuta getMinutaPorId(int id) throws SQLException {
        Minuta min = null;
        
            Connection cn = new Conexion().fabricarConexion();
            Statement st = cn.createStatement();
            String sql = SQL_LISTAR_MINUTA_ID_METODO(id);            
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                min = new Minuta();
                min.setId_minuta(id);
                min.setNombre_minuta(rs.getString(2));
                min.setFecha_inicio(rs.getString(3));
                min.setFecha_fin(rs.getString(4));
                      
    }
             rs.close();
            st.close();
            cn.close();
       return min;
  }
     
     public static void modificarMinuta(int id,String nombre_minuta,String fecha_inicio,String fecha_fin) throws SQLException {
        
        String sql = SQL_MODIFICAR_MINUTA_METODO(id, nombre_minuta,fecha_inicio,fecha_fin);
         
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();      
    }
    
}
