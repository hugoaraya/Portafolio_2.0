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

/**
 *
 * @author 420NiggaBytes
 */
public class UsuarioDAO {

    public int logear(String user, String pass) {
        int nivel = 0;
        try {
            //se crea la query
            String sql = SQL_USUARIO_POR_NIVEL_METODO(user, pass);
            //se crea la conexion
            Connection conexion = new Conexion().fabricarConexion();
            //se recibe los datos de la query
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs;
            //se ejecuta
            rs = ps.executeQuery();
            while (rs.next()) {
                nivel = rs.getInt(1);
            }
            //cerrar conexion
            conexion.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }

        return nivel;
    }
    
    
    
    
}
