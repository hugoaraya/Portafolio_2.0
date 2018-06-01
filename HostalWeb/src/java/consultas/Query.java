/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import modelo.Habitacion;

/**
 *
 * @author 420NiggaBytes
 */
public class Query {

    //USUARIO   
    public static String SQL_USUARIO_POR_NIVEL = "";

    public static String SQL_LISTAR_PROVEEDOR_USUARIO_METODO(String user, String pass) {
        SQL_USUARIO_POR_NIVEL = "select tipo_usuario_id from usuario where nombre_usuario = '"
                + user + "'and contrasenia = '" + pass + "'";
        return SQL_USUARIO_POR_NIVEL;
    }
    //PLATO  
    public static String SQL_PLATODAO_READ = "Select nombre_plato,descripcion, precio from plato where idplato = ? ";
    //PROVEEDOR
    public static String SQL_LISTAR_DETALLE_ORDEN = "";
    public static String SQL_LISTAR_ORDEN_PEDIDO = "";
    public static String SQL_LISTAR_PROVEEDOR_USUARIO = "";
    public static String SQL_PEDIR_ID_PROVEEDOR = "";
    public static String SQL_PRECIO_STOCK_TOTAL = "";
    public static String SQL_CODIGO_BARRA = "";

    //
    //LISTAR PROVEEDORES SEGUN SU USUARIO = RUT
    public static String SQL_LISTAR_PROVEEDOR_USUARIO_METODO(String usuario) {
        SQL_LISTAR_PROVEEDOR_USUARIO = "SELECT P.IDPROVEEDOR,P.RUT,P.DV,P.NOMBRE,P.DIRECCION,P.RUBRO,U.NOMBRE_USUARIO FROM PROVEEDOR"
                + " P INNER JOIN USUARIO U "
                + "ON(P.USUARIO_ID = U.IDUSUARIO) "
                + "WHERE P.RUT = '" + usuario + "'";
        return SQL_LISTAR_PROVEEDOR_USUARIO;
    }

    //LISTAR LAS ORDENES DE PEDIDO POR ID PROVEEDOR
    public static String SQL_LISTAR_ORDEN_PEDIDO_POR_PROVEEDOR_METODO(int id) {
        SQL_LISTAR_ORDEN_PEDIDO = "SELECT O.NRO_ORDEN,E.NOMBRE,E.APELLIDO,O.FECHA,P.RUT,P.DV,T.DESCRIPCION FROM ORDEN_PEDIDO O"
                + " INNER JOIN EMPLEADO E "
                + "ON(O.EMPLEADO_ID = E.IDEMPLEADO) "
                + "INNER JOIN PROVEEDOR P "
                + "ON(O.PROVEEDOR_ID = P.IDPROVEEDOR) "
                + "INNER JOIN ESTADO_ORDEN_PEDIDO T ON(O.ESTADO_ORDEN_PEDIDO_ID = T.IDESTADO_ORDEN_PEDIDO) "
                + "WHERE O.PROVEEDOR_ID = '" + id + "'";
        return SQL_LISTAR_ORDEN_PEDIDO;
    }

    //LISTAR EL DETALLE DE LOS PRODUCTOS DE UNA ORDEN DE PEDIDO SEGUN PROVEEDOR  
    public static String SQL_LISTAR_DETALLE_ORDEN_METODO(int nro_orden) {
        SQL_LISTAR_DETALLE_ORDEN = " select p.nombre,"
                + " p.familia,p.tipo_producto,p.descripcion,p.stock,p.stock_critico,p.precio"
                + " from orden_pedido o inner join recepcion_producto r on(o.idorden_pedido = r.orden_pedido_id)"
                + " inner join producto p on(r.producto_id = p.idproducto) where o.nro_orden = '" + nro_orden + "'";
        return SQL_LISTAR_DETALLE_ORDEN;
    }

    //CANTIDAD STOCK Y PRECIO TOTAL
    public static String SQL_PRECIO_STOCK_TOTAL_METODO(int nro_orden) {
        SQL_PRECIO_STOCK_TOTAL = " select sum(p.stock * p.precio),sum(p.stock) "
                + " from orden_pedido o inner join recepcion_producto r on(o.idorden_pedido = r.orden_pedido_id)"
                + " inner join producto p on(r.producto_id = p.idproducto) where o.nro_orden = '" + nro_orden + "'";
        return SQL_PRECIO_STOCK_TOTAL;
    }
    //CODIGO BARRA

    //EMPRESA
    public static String SQL_LISTAR_EMPRESA_USUARIO = "";
    public static String SQL_LISTAR_ORDENES_COMPRA_EMPRESA = "";
    public static String SQL_LISTAR_DETALLE_ORDEN_COMPRA = "";
    public static String  SQL_PRECIO_TOTAL_ORDEN_COMPRA = "";
    //DATOS PERFIL EMPRESA

    public static String SQL_LISTAR_EMPRESA_USUARIO_METODO(String usuario) {
        SQL_LISTAR_EMPRESA_USUARIO = "SELECT E.IDEMPRESA,E.RUT,E.DV,E.NOMBRE,E.DIRECCION,E.TELEFONO,E.CORREO,U.NOMBRE_USUARIO FROM EMPRESA"
                + " E INNER JOIN USUARIO U "
                + "ON(E.USUARIO_ID = U.IDUSUARIO) "
                + "WHERE E.RUT = '" + usuario + "'";
        return SQL_LISTAR_EMPRESA_USUARIO;
    }

    public static String SQL_LISTAR_ORDENES_COMPRA_EMPRESA_METODO(int id) {
        SQL_LISTAR_ORDENES_COMPRA_EMPRESA = "select o.nro_orden,e.nombre,e.rut,e.dv,o.fecha from ORDEN_COMPRA o"
                + " inner join empresa e on(o.empresa_id = e.idempresa)"
                + " where o.empresa_id ='" + id + "'";
        return SQL_LISTAR_ORDENES_COMPRA_EMPRESA;
    }

    //LISTAR EL DETALLE DE LA ORDEN DE COMPRA DE UNA EMPRESA 
    public static String SQL_LISTAR_DETALLE_ORDEN_COMPRA_METODO(int nro_orden) {
        SQL_LISTAR_DETALLE_ORDEN_COMPRA = " select t.nombre,t.apellido,t.rut,t.dv,t.cargo,t.correo,t.telefono,h.descripcion,h.precio "
                + "from orden_compra o inner join huesped_habitacion p on(o.huesped_habitacion_id  = p.habitacion_id) "
                + "inner join habitacion h on(p.HABITACION_ID = h.idhabitacion) "
                + "inner join huesped t on(p.huesped_id = t.idhuesped) where o.nro_orden =  '" + nro_orden + "'";
        return SQL_LISTAR_DETALLE_ORDEN_COMPRA;
    }

    //PRECIO TOTAL
    public static String SQL_PRECIO_TOTAL_ORDEN_COMPRA_METODO(int nro_orden) {
         SQL_PRECIO_TOTAL_ORDEN_COMPRA = " select sum(h.precio)"
                + "from orden_compra o inner join huesped_habitacion p on(o.huesped_habitacion_id  = p.habitacion_id) "
                + "inner join habitacion h on(p.HABITACION_ID = h.idhabitacion) "
                + "inner join huesped t on(p.huesped_id = t.idhuesped) where o.nro_orden =  '" + nro_orden + "'";
        return  SQL_PRECIO_TOTAL_ORDEN_COMPRA;
    }
    
    ///MANTENEDOR HABITACIONES
     public static String SQL_LISTAR_HABITACIONES = "";
     public static String SQL_INSERTAR_HABITACIONES = "";
     public static String SQL_MODIFICAR_HABITACIONES = "";
     public static String SQL_MODIFICAR_ESTADO_HABITACIONES = "";
     public static String SQL_LISTAR_HABITACION_ID = "";
     //LISTAR
      public static String SQL_LISTAR_HABITACIONES_METODO() {
         SQL_LISTAR_HABITACIONES = "select h.idhabitacion,h.tipo_cama,h.accesorio,h.precio,h.descripcion,h.nombre,e.descripcion,h.capacidad"
                 + " from habitacion h inner join estado_habitacion e on(h.estado_habitacion_id = e.idestado_habitacion)" ;
        return  SQL_LISTAR_HABITACIONES;
      }
      public static String SQL_LISTAR_HABITACION_ID_METODO(int id) {
         SQL_LISTAR_HABITACION_ID = "select idhabitacion,tipo_cama,accesorio,precio,descripcion,nombre,estado_habitacion_id,capacidad"
                 + " from habitacion where idhabitacion =  '" + id + "'";
        return  SQL_LISTAR_HABITACION_ID;
      }
      
      //INSERTAR
      public static String SQL_INSERTAR_HABITACIONES_METODO(String tipo_cama, String accesorios, int precio_habitacion, String descripcion, String nombre_habitacion, int estado_habitacion_id, int capacidad) {
         SQL_INSERTAR_HABITACIONES = "INSERT INTO habitacion (idhabitacion,tipo_cama,accesorio,precio,descripcion,nombre,estado_habitacion_id,capacidad) VALUES(0,'"+tipo_cama+ "','"+accesorios+"','"+precio_habitacion+ "','"+descripcion+ "','"+nombre_habitacion+ "','"+estado_habitacion_id+ "','"+capacidad+"')";
        return  SQL_INSERTAR_HABITACIONES;
      }
      
      //MODIFICAR 
      public static String SQL_MODIFICAR_HABITACIONES_METODO(int id,String tipo_cama, String accesorios, int precio_habitacion, String descripcion, String nombre_habitacion, int capacidad) {
        SQL_MODIFICAR_HABITACIONES = "UPDATE habitacion SET tipo_cama = '" + tipo_cama
                + "', accesorio = '" + accesorios
                + "', precio = '" + precio_habitacion
                + "', descripcion = '" + descripcion
                + "', nombre = '" + nombre_habitacion
                + "', capacidad = '" + capacidad
                + "'  where idhabitacion =" + id;
        return SQL_MODIFICAR_HABITACIONES;
    }
      
      
      //CAMBIAR ESTADO
      public static String SQL_MODIFICAR_ESTADO_HABITACIONES_METODO() {
         SQL_MODIFICAR_ESTADO_HABITACIONES = "" ;
        return  SQL_MODIFICAR_ESTADO_HABITACIONES;
      }
      
     //MANTENEDOR COMEDOR
      public static String SQL_LISTAR_COMEDOR = "";
      
       public static String SQL_LISTAR_COMEDOR_METODO() {
         SQL_LISTAR_HABITACIONES = "select idplato,nombre_plato,descripcion,precio from plato";
        return  SQL_LISTAR_HABITACIONES;
      }
       
       
       
       
       
      
}

