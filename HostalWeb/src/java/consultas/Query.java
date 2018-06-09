/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

/**
 *
 * @author 420NiggaBytes
 */
public class Query {

    //USUARIO   
    public static String SQL_USUARIO_POR_NIVEL = "";
    public static String SQL_GET_CLAVE = "";

    public static String SQL_USUARIO_POR_NIVEL_METODO(String user, String pass) {
        SQL_USUARIO_POR_NIVEL = "select tipo_usuario_id from usuario where nombre_usuario = '"
                + user + "'and contrasenia = '" + pass + "'";
        return SQL_USUARIO_POR_NIVEL;
    }    
    //PLATO  
    public static String SQL_PLATODAO_READ = "Select nombre_plato,descripcion, precio from plato where idplato = ? ";
    //PROVEEDOR
    public static String SQL_LISTAR_DETALLE_ORDEN = "";
    public static String SQL_LISTAR_ORDEN_PEDIDO = "";
    public static String SQL_LISTAR_ORDEN_PEDIDO_ID = "";
    public static String SQL_ACEPTAR_O_RECHAZAR_ORDEN = "";
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
        SQL_LISTAR_ORDEN_PEDIDO = "SELECT O.NRO_ORDEN,E.NOMBRE,E.APELLIDO,O.FECHA,P.RUT,P.DV,T.DESCRIPCION,O.IDORDEN_PEDIDO FROM ORDEN_PEDIDO O"
                + " INNER JOIN EMPLEADO E "
                + "ON(O.EMPLEADO_ID = E.IDEMPLEADO) "
                + "INNER JOIN PROVEEDOR P "
                + "ON(O.PROVEEDOR_ID = P.IDPROVEEDOR) "
                + "INNER JOIN ESTADO_ORDEN_PEDIDO T ON(O.ESTADO_ORDEN_PEDIDO_ID = T.IDESTADO_ORDEN_PEDIDO) "
                + "WHERE O.PROVEEDOR_ID = '" + id + "' and T.DESCRIPCION = 'Pendiente' ";
        return SQL_LISTAR_ORDEN_PEDIDO;
    }
    //LISTAR ORDEN DE PEDIDO POR ID
     public static String SQL_LISTAR_ORDEN_PEDIDO_ID_METODO(int id) {
         SQL_LISTAR_ORDEN_PEDIDO_ID = "select idorden_pedido from orden_pedido where idorden_pedido =  '" + id + "'";
        return  SQL_LISTAR_ORDEN_PEDIDO_ID;
      }
     //MODIFICAR ESTADO ORDEN DE PEDIDO     
    public static String SQL_ACEPTAR_O_RECHAZAR_ORDEN_METODO(int id,int estado_orden_pedido_id,String comentarios) {
        SQL_ACEPTAR_O_RECHAZAR_ORDEN = "UPDATE orden_pedido SET estado_orden_pedido_id = '" + estado_orden_pedido_id +
                "', comentarios = '" + comentarios +            
                "'  where idorden_pedido ='" + id + "'";
        return SQL_ACEPTAR_O_RECHAZAR_ORDEN;
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
        SQL_LISTAR_EMPRESA_USUARIO = "SELECT E.IDEMPRESA,E.RUT,E.DV,E.NOMBRE,E.DIRECCION,E.TELEFONO,E.CORREO,U.NOMBRE_USUARIO,E.USUARIO_ID FROM EMPRESA"
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
                 + " from habitacion h inner join estado_habitacion e on(h.estado_habitacion_id = e.idestado_habitacion) order by h.idhabitacion asc" ;
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
                + "'  where idhabitacion ='" + id + "'";
        return SQL_MODIFICAR_HABITACIONES;
    }
      
            
     //MANTENEDOR COMEDOR
      public static String SQL_LISTAR_PLATO = "";
      public static String SQL_LISTAR_PLATO_ID = "";
      public static String SQL_AGREGAR_PLATO = "";
      public static String SQL_MODIFICAR_PLATO = "";
      public static String SQL_LISTAR_MINUTA = "";
      public static String SQL_LISTAR_MINUTA_ID = "";
      public static String SQL_AGREGAR_MINUTA = "";
      public static String SQL_MODIFICAR_MINUTA = "";
      
       public static String SQL_LISTAR_PLATO_METODO() {
         SQL_LISTAR_PLATO = "select idplato,nombre_plato from plato";
        return  SQL_LISTAR_PLATO;
      }
       
       public static String SQL_LISTAR_PLATO_ID_METODO(int id) {
         SQL_LISTAR_PLATO_ID = "select idplato,nombre_plato from plato where idplato =  '" + id + "'";
        return  SQL_LISTAR_PLATO_ID;
      }
      
      //INSERTAR
      public static String SQL_INSERTAR_PLATO_METODO(String nombre_plato) {
         SQL_AGREGAR_PLATO = "INSERT INTO plato(idplato,nombre_plato) VALUES(0,'"+nombre_plato+ "')";
        return  SQL_AGREGAR_PLATO;
      }
      
      //MODIFICAR 
      public static String SQL_MODIFICAR_PLATO_METODO(int id,String nombre_plato) {
        SQL_MODIFICAR_PLATO = "UPDATE plato SET nombre_plato = '" + nombre_plato + "'  where idplato ='" + id + "'";
        return SQL_MODIFICAR_PLATO;
    }
       
      //minuta
      
        public static String SQL_LISTAR_MINUTA_METODO() {
         SQL_LISTAR_MINUTA = "select idminuta,nombre_minuta,to_char(fecha_inicio,'dd/mm/yyyy'),to_char(fecha_fin,'dd/mm/yyyy') from minuta";
        return  SQL_LISTAR_MINUTA;
      }
       
       public static String SQL_LISTAR_MINUTA_ID_METODO(int id) {
         SQL_LISTAR_MINUTA_ID = "select idminuta,nombre_minuta,to_char(fecha_inicio,'dd/mm/yyyy'),to_char(fecha_fin,'dd/mm/yyyy') from minuta where idminuta =  '" + id + "'";
        return  SQL_LISTAR_MINUTA_ID;
      }
      
      //INSERTAR
      public static String SQL_INSERTAR_MINUTA_METODO(String nombre_minuta,String fecha_inicio,String fecha_fin) {
         SQL_AGREGAR_MINUTA = "INSERT INTO MINUTA(idminuta,nombre_minuta,fecha_inicio,fecha_fin) VALUES(0,'"+nombre_minuta+ "','"+fecha_inicio+ "','"+fecha_fin+"')";
        return  SQL_AGREGAR_MINUTA;
      }                                                                                                      
      
      //MODIFICAR 
      public static String SQL_MODIFICAR_MINUTA_METODO(int id,String nombre_minuta,String fecha_inicio,String fecha_fin) {
        SQL_MODIFICAR_MINUTA = "UPDATE minuta SET nombre_minuta = '" + nombre_minuta
                + "', fecha_inicio = '" + fecha_inicio
                + "', fecha_fin = '" + fecha_fin
                + "'  where idminuta ='" + id + "'";
        return SQL_MODIFICAR_MINUTA;
    }
       
       
      //HUESPED
      
      public static String SQL_LISTAR_HUESPED = "";
      public static String SQL_LISTAR_HUESPED_ID= "";
      public static String SQL_AGREGAR_HUESPED = "";
      public static String SQL_MODIFICAR_HUESPED = "";
       
       public static String SQL_LISTAR_HUESPED_METODO(int id_empresa) {
         SQL_LISTAR_HUESPED = "select h.idhuesped,h.rut,h.dv,h.nombre,h.apellido,h.cargo,h.correo,h.telefono,e.estado from huesped h "
                 + "inner join estado_huesped e on(h.estado_huesped_id = e.idestado_huesped) where empresa_id = '" + id_empresa + "' order by h.apellido asc";
        return  SQL_LISTAR_HUESPED;
      }
       
       public static String SQL_LISTAR_HUESPED_ID_METODO(int id_huesped) {
         SQL_LISTAR_HUESPED_ID = "select idhuesped,empresa_id,rut,dv,nombre,apellido,cargo,correo,telefono,estado_huesped_id from huesped where idhuesped = '" + id_huesped + "'";
        return  SQL_LISTAR_HUESPED_ID;
      }
       
          public static String SQL_MODIFICAR_HUESPED_METODO(int id_huesped, String nombre, String apellido, int numero_tefono, String correo, String cargo, int id_empresa, int id_estado_huesped) {
        SQL_MODIFICAR_HUESPED = "UPDATE huesped SET nombre = '" + nombre   
                  + "', apellido = '" + apellido
                  + "', telefono = '" + numero_tefono
                + "', correo = '" + correo
                + "', cargo = '" + cargo
                + "', empresa_id = '" + id_empresa
                + "', estado_huesped_id = '" + id_estado_huesped
                + "'  where idhuesped ='" + id_huesped+ "'";
        return SQL_MODIFICAR_HUESPED;
}
          public static String SQL_AGREGAR_HUESPED_METODO(String rut,String dv, String nombre, String apellido, int numero_tefono, String correo, String cargo, int id_empresa, int id_estado_huesped) {
         SQL_AGREGAR_HUESPED = "INSERT INTO huesped (idhuesped,rut, dv, nombre, apellido, telefono,correo,cargo,empresa_id, estado_huesped_id) VALUES (0,'"+rut+ "',"
                 + "'"+dv+ "',"
                 + "'"+nombre+ "',"
                 + "'"+apellido+ "',"
                 + "'"+numero_tefono+ "',"
                 + "'"+correo+ "',"
                 + "'"+cargo+ "',"
                 + "'"+id_empresa+ "',"
                 + "'"+id_estado_huesped+"')";
        return  SQL_AGREGAR_HUESPED;
      } 
          
      //CAMBIAR CONTRASEÑA EMPRESA
      public static String SQL_CAMBIAR_PASS_EMPRESA = "";
      
      //MODIFICAR 
      public static String SQL_CAMBIAR_PASS_EMPRESA_METODO(String id,String constrasenia) {
        SQL_CAMBIAR_PASS_EMPRESA = "UPDATE USUARIO SET contrasenia = '" + constrasenia + "' where idusuario ='" + id + "'";
        return SQL_CAMBIAR_PASS_EMPRESA;
    }

}

