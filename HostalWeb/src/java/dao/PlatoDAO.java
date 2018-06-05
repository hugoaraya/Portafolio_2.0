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
import modelo.Plato;

/**
 *
 * @author 420NiggaBytes
 */
public class PlatoDAO {
    public static void AgregarPlato(Plato plat) throws SQLException {
        

        String sql = SQL_INSERTAR_PLATO_METODO(plat.getNombre_plato());
        
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();    
       
    }  
    
    public static ArrayList<Plato> listarPlato() throws SQLException{
        
        
        String sql1 = SQL_LISTAR_PLATO_METODO();
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Plato> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Plato pla = new Plato();
        pla.setId(rs.getInt(1));
        pla.setNombre_plato(rs.getString(2));
        
        arreglo.add(pla);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
    
     public static Plato getPlatoPorId(int id) throws SQLException {
        Plato plat = null;
        
            Connection cn = new Conexion().fabricarConexion();
            Statement st = cn.createStatement();
            String sql = SQL_LISTAR_PLATO_ID_METODO(id);            
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                plat = new Plato();
                plat.setId(id);
                plat.setNombre_plato(rs.getString(2));
                      
    }
             rs.close();
            st.close();
            cn.close();
       return plat;
  }
     
     public static void modificarPlato(int id,String nombre_plato) throws SQLException {
        
        String sql = SQL_MODIFICAR_PLATO_METODO(id, nombre_plato);
         
        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();         

         st.executeUpdate(sql);

        st.close();
        conexion.close();      
    }
    
}
