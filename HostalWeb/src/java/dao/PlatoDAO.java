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
import modelo.Plato;

/**
 *
 * @author 420NiggaBytes
 */
public class PlatoDAO {
    public static ArrayList<Plato> listarPlato() throws SQLException{
        
        
        String sql1 = SQL_LISTAR_COMEDOR_METODO();
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Plato> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Plato pla = new Plato();
        pla.setId(rs.getInt(1));
        pla.setNombre(rs.getString(2));
        pla.setDescripcion(rs.getString(3));
        pla.setPrecio(rs.getInt(4));
             
        arreglo.add(pla);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
}
