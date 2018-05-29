/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import modelo.Habitacion;
import static consultas.Query.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author 420NiggaBytes
 */
public class HabitacionesDAO {
    public static int AgregarHabitacion(Habitacion hab) throws SQLException {
        int resultado = 0;

        String sql = SQL_INSERTAR_HABITACIONES_METODO(hab.getTipo_cama(),hab.getAccesorios(),hab.getPrecio_habitacion(),
                hab.getDescripcion(),hab.getNombre_habitacion(),hab.getEstado_habitacion_id(),hab.getId_habitacion());

        Connection conexion = new Conexion().fabricarConexion();
        Statement st = conexion.createStatement();

        resultado = st.executeUpdate(sql);

        st.close();
        conexion.close();

        return resultado;
    }
}
