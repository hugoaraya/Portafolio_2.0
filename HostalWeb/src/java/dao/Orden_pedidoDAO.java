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
import modelo.Orden_pedido;
/**
 *
 * @author 420NiggaBytes
 */
public class Orden_pedidoDAO {
    
    
     public static ArrayList<Orden_pedido> listaOrdenPedido(int id) throws SQLException{
        
        
        String sql1 = SQL_LISTAR_ORDEN_PEDIDO_POR_PROVEEDOR_METODO(id);
        Connection conexion = new Conexion().fabricarConexion();
      
        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Orden_pedido> arreglo = new ArrayList<>();       
        
        while(rs.next()){
        Orden_pedido or = new Orden_pedido();
        or.setNro_orden(rs.getInt(1));
        or.setNombre_empleado(rs.getString(2)+" "+rs.getString(3));
        or.setFecha(rs.getDate(4));
        or.setRut(rs.getString(5)+"-"+rs.getString(6));
        or.setEstado_orden(rs.getString(7));       
        
        arreglo.add(or);
        }
        
        rs.close();       
        conexion.close();
        return arreglo;
    }
}
