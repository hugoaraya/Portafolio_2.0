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
import modelo.Proveedor;

/**
 *
 * @author 420NiggaBytes
 */
public class ProveedorDAO {

    public static ArrayList<Proveedor> listaProveedor(String usuario) throws SQLException {

        String sql1 = SQL_LISTAR_PROVEEDOR_USUARIO_METODO(usuario);
        Connection conexion = new Conexion().fabricarConexion();

        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Proveedor> arreglo = new ArrayList<>();

        while (rs.next()) {
            Proveedor pro = new Proveedor();
            pro.setIdProveedor(rs.getInt(1));
            pro.setRut(rs.getString(2));
            pro.setDv(rs.getString(3));
            pro.setNombre(rs.getString(4));
            pro.setDireccion(rs.getString(5));
            pro.setRubro(rs.getString(6));

            arreglo.add(pro);
        }

        rs.close();
        conexion.close();
        return arreglo;
    }
   

}
