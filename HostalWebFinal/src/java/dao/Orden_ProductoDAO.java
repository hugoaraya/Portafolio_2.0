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
import modelo.Producto;

/**
 *
 * @author 420NiggaBytes
 */
public class Orden_ProductoDAO {
     public static ArrayList<Producto> listaProductos(int nro_orden) throws SQLException{
        
        
        String sql1 = SQL_LISTAR_DETALLE_ORDEN_METODO(nro_orden);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Producto> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Producto pro = new Producto();
        pro.setFamilia(rs.getString(1));
        pro.setTipo_producto(rs.getString(2));
        pro.setMarca(rs.getString(3));
        pro.setStock(rs.getInt(4));
        pro.setStock_critico(rs.getInt(5));
        pro.setPrecio(rs.getInt(6));      
        arreglo.add(pro);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
}
