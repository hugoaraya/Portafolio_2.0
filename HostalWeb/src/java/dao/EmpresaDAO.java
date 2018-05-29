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
import modelo.Empresa;

/**
 *
 * @author 420NiggaBytes
 */
public class EmpresaDAO {
    public static ArrayList<Empresa> listaEmpresa(String usuario) throws SQLException {

        String sql1 = SQL_LISTAR_EMPRESA_USUARIO_METODO(usuario);
        Connection conexion = new Conexion().fabricarConexion();

        PreparedStatement ps = conexion.prepareStatement(sql1);
        ResultSet rs;
        rs = ps.executeQuery();
        ArrayList<Empresa> arreglo = new ArrayList<>();

        while (rs.next()) {
            Empresa emp = new Empresa();
            emp.setIdEmpresa(rs.getInt(1));
            emp.setRut(rs.getString(2));
            emp.setDv(rs.getString(3));
            emp.setNombre(rs.getString(4));           
            emp.setDireccion(rs.getString(5));
            emp.setTelefono(rs.getInt(6));
            emp.setCorreo(rs.getString(7));
            arreglo.add(emp);
        }

        rs.close();
        conexion.close();
        return arreglo;
    }
}
