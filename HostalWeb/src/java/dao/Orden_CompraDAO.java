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
}
