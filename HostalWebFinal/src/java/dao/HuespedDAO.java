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
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Huesped;

/**
 *
 * @author 420NiggaBytes
 */
public class HuespedDAO {
    
    public static void AgregarHuesped(Huesped hues) throws SQLException {
        

        String sql = SQL_AGREGAR_HUESPED_METODO(hues.getRut(),hues.getDv(),hues.getNombre(),hues.getApellido()
                ,hues.getNumero_tefono(),hues.getCorreo(),hues.getCargo_id(),hues.getId_empresa(),hues.getId_estado_huesped());
        
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();    
       
    }  
    
     public static ArrayList<Huesped> listarHuesped(int id_empresa) throws SQLException{
        
        
        String sql1 = SQL_LISTAR_HUESPED_METODO(id_empresa);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Huesped> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Huesped hues = new Huesped();
        hues.setId_huesped(rs.getInt(1));
        hues.setRut(rs.getString(2));
        hues.setDv(rs.getString(3));
        hues.setNombre(rs.getString(4));
        hues.setApellido(rs.getString(5));
        hues.setCargo(rs.getString(6));
        hues.setCorreo(rs.getString(7));
        hues.setNumero_tefono(rs.getInt(8));
        hues.setEstado_huesped(rs.getString(9));
        
        
        arreglo.add(hues);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
     
     public static ArrayList<Huesped> listarHuespedNoHospedado(int id_empresa) throws SQLException{
        
        
        String sql1 = SQL_LISTAR_HUESPED_NO_HOSPEDADO_METODO(id_empresa);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Huesped> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Huesped hues = new Huesped();
        hues.setId_huesped(rs.getInt(1));
        hues.setRut(rs.getString(2));
        hues.setDv(rs.getString(3));
        hues.setNombre(rs.getString(4));
        hues.setApellido(rs.getString(5));
        hues.setCargo(rs.getString(6));
        hues.setCorreo(rs.getString(7));
        hues.setNumero_tefono(rs.getInt(8));
        hues.setEstado_huesped(rs.getString(9));
        
        
        arreglo.add(hues);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
     
     public static Huesped getHuespedPorId(int id_huesped) throws SQLException {
        Huesped hues = null;
        
            Connection cn = new Conexion().fabricarConexion();
            Statement st = cn.createStatement();
            String sql = SQL_LISTAR_HUESPED_ID_METODO(id_huesped);            
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                hues = new Huesped();
                hues.setId_huesped(id_huesped);
                hues.setId_empresa(rs.getInt(2));
                hues.setRut(rs.getString(3));
                hues.setDv(rs.getString(4));
                hues.setNombre(rs.getString(5));
                hues.setApellido(rs.getString(6));
                hues.setCargo_id(rs.getInt(7));
                hues.setCorreo(rs.getString(8));
                hues.setNumero_tefono(rs.getInt(9));
                hues.setId_estado_huesped(rs.getInt(10));                      
    }
             rs.close();
            st.close();
            cn.close();
       return hues;
  }
       public static void modificarHuesped(int id_huesped, String nombre, String apellido, int numero_tefono, String correo, int cargo_id, int id_empresa, int id_estado_huesped) throws SQLException {
        
        String sql = SQL_MODIFICAR_HUESPED_METODO(id_huesped, nombre, apellido, numero_tefono, correo, cargo_id , id_empresa, id_estado_huesped);
         
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();      
    }
       
       public static void modificarEstadoHuesped(int id_huesped) throws SQLException {
        
        String sql = SQL_MODIFICAR_ESTADO_HUESPED_METODO(id_huesped);
         
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();      
    }
}
