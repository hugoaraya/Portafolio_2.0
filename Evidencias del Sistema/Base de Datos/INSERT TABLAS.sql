

--LIMPIEZA DE TABLAS...
--SELECT 'DROP TABLE '||table_name||' CASCADE CONSTRAINTS;' FROM user_tables


-----------TABLAS ESTADOS----------------------------------
--select * from TIPO_USUARIO;
INSERT INTO TIPO_USUARIO VALUES (1,'Administrador');
INSERT INTO TIPO_USUARIO VALUES (2,'Empresa');
INSERT INTO TIPO_USUARIO VALUES (3,'Proveedor');
INSERT INTO TIPO_USUARIO VALUES (4,'Empleado');
INSERT INTO TIPO_USUARIO VALUES (5,'Eliminado');
--select * from ESTADO_HABITACION;
INSERT INTO ESTADO_HABITACION VALUES (1,'Diponible');
INSERT INTO ESTADO_HABITACION VALUES (2,'Ocupada');
INSERT INTO ESTADO_HABITACION VALUES (3,'Mantencion');
INSERT INTO ESTADO_HABITACION VALUES (4,'Reservada');
--select * from ESTADO_RECEPCION;
INSERT INTO ESTADO_RECEPCION VALUES (1,'Pendiente');
INSERT INTO ESTADO_RECEPCION VALUES (2,'Cerrada');

--select * from ESTADO_ORDEN_PEDIDO;
INSERT INTO ESTADO_ORDEN_PEDIDO VALUES (1,'Pendiente');
INSERT INTO ESTADO_ORDEN_PEDIDO VALUES (2,'Aceptada');
INSERT INTO ESTADO_ORDEN_PEDIDO VALUES (3,'Rechazada');

--select * from ESTADO_HUESPED;
INSERT INTO ESTADO_HUESPED VALUES (1,'Hospedado');
INSERT INTO ESTADO_HUESPED VALUES (2,'Check Out');
INSERT INTO ESTADO_HUESPED VALUES (3,'No Aplica'); ---- no trabaja en la empresa -----
INSERT INTO ESTADO_HUESPED VALUES (4,'En Espera')

--select * from SERVICIO;
INSERT INTO rubro (idrubro,descripcion) VALUES (1,'Abarrotez');
INSERT INTO rubro (idrubro,descripcion) VALUES (2,'Frutas y Verduras');
INSERT INTO rubro (idrubro,descripcion) VALUES (3,'Limpieza');
INSERT INTO rubro (idrubro,descripcion) VALUES (4,'Licoreria');
INSERT INTO rubro (idrubro,descripcion) VALUES (5,'Panaderia y Pasteleria');

--select * from TIPO_PRODUCTO;
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (1,'Aceite 1LT');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (2,'Azucar 1KG');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (3,'Sal 1KG');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (4,'Arroz 1KG');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (5,'Spaghetti 400GR');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (6,'Cloro 1LT');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (7,'Bebiga 1LT');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (8,'Licor 1LT');
INSERT INTO tipo_producto ( idtipo_producto, descripcion) VALUES (9,'Shampoo 1LT');

--select * from FAMILIA PRODUCTO;
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (1,'Aceite');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (2,'Azucar');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (3,'Sal');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (4,'Arroz');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (5,'Spaghetti');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (6,'Cloro');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (7,'Bebida');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (8,'Licor');
INSERT INTO familia_producto (idfamilia_producto,descripcion) VALUES (9,'Shampoo');
--select * from MARCA;
INSERT INTO marca (idmarca,descripcion) VALUES (1,'Miraflores');
INSERT INTO marca (idmarca,descripcion) VALUES (2,'Iansa');
INSERT INTO marca (idmarca,descripcion) VALUES (3,'Iansa');
INSERT INTO marca (idmarca,descripcion) VALUES (4,'Tucapel');
INSERT INTO marca (idmarca,descripcion) VALUES (5,'Lucchetti');
INSERT INTO marca (idmarca,descripcion) VALUES (6,'Clorox');
INSERT INTO marca (idmarca,descripcion) VALUES (7,'Coca Cola');
INSERT INTO marca (idmarca,descripcion) VALUES (8,'Tucapel');
INSERT INTO marca (idmarca,descripcion) VALUES (9,'Fructis');
--select * from CODIGO_BARRA;
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (1,12345678);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (2,22222222);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (3,33333333);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (4,44444444);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (5,55555555);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (6,66666666);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (7,77777777);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (8,88888888);
INSERT INTO codigo_barra (idcodigo_barra,codigo) VALUES (9,99999999);
----------------------------TABLAS CENTRALES-------------------------
--select * from USUARIO;
INSERT INTO usuario (idusuario,nombre_usuario,contrasenia,tipo_usuario_id) VALUES (1,'admin','admin',1);
INSERT INTO usuario (idusuario,nombre_usuario,contrasenia,tipo_usuario_id) VALUES (2,'11111111','1234',2);
INSERT INTO usuario (idusuario,nombre_usuario,contrasenia,tipo_usuario_id) VALUES (3,'22222222','1234',3);
INSERT INTO usuario (idusuario,nombre_usuario,contrasenia,tipo_usuario_id) VALUES (4,'33333333','1234',4);
-------------------------------TABLAS MODULO HOSTAL PROVEEDOR----------------------------------
--Select * from PROVEEDOR;
INSERT INTO proveedor (idproveedor,rut,dv,nombre,direccion,usuario_id,rubro_id) VALUES 
(0,'22222222','2','Abarrotez San Juan','San Juan #3099',3,1);
---select * from Empleado
INSERT INTO empleado (idempleado,rut,dv,nombre,apellido,usuario_id)
VALUES (0,'33333333','3','Andres','Pinto',4);

--select * from PRODUCTO;
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-05-31', 'YYYY-MM-DD'),1100,5,8,1,1,1,1);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-06-11', 'YYYY-MM-DD'),2100,3,4,2,2,2,2);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-02-21', 'YYYY-MM-DD'),3100,4,6,3,3,3,3);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-03-11', 'YYYY-MM-DD'),2100,4,7,4,4,4,4);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-04-12', 'YYYY-MM-DD'),3100,8,10,5,5,5,5);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-08-17', 'YYYY-MM-DD'),5100,9,11,6,6,6,6);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-07-22', 'YYYY-MM-DD'),6100,1,4,7,7,7,7);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-09-05', 'YYYY-MM-DD'),2200,3,9,8,8,8,8);
INSERT INTO producto (idproducto,fecha_vencimiento,precio,stock,stock_critico,tipo_producto_id,familia_producto_id,marca_id,codigo_barra_id)
VALUES (0,TO_DATE('2019-11-01', 'YYYY-MM-DD'),3300,7,12,9,9,9,9);
--select * from;
INSERT INTO orden_pedido (idorden_pedido,nro_orden,empleado_id,fecha,proveedor_id,estado_orden_pedido_id,comentario) 
VALUES (1,'123456',1,TO_DATE('2019-11-01', 'YYYY-MM-DD'),1,1,'Sin Comentarios');
--select * from RECEPCION_PRODUCTO;
INSERT INTO recepcion_producto (idrecepcion_producto, nro_recepcion, producto_id, estado_recepcion_id, orden_pedido_id,fecha)
VALUES (1,'123456',1,1,1,TO_DATE('2019-11-01', 'YYYY-MM-DD'));
INSERT INTO recepcion_producto (idrecepcion_producto, nro_recepcion, producto_id, estado_recepcion_id, orden_pedido_id, fecha)
VALUES (2,'123456',2,1,1,TO_DATE('2019-11-01', 'YYYY-MM-DD'));
INSERT INTO recepcion_producto (idrecepcion_producto, nro_recepcion, producto_id, estado_recepcion_id, orden_pedido_id, fecha)
VALUES (3,'123456',3,1,1,TO_DATE('2019-11-01', 'YYYY-MM-DD'));
INSERT INTO recepcion_producto (idrecepcion_producto, nro_recepcion,producto_id, estado_recepcion_id, orden_pedido_id, fecha)
VALUES (4,'123456',4,1,1,TO_DATE('2019-11-01', 'YYYY-MM-DD'));
----------------------------TABLAS MODULO HOSTAL EMPRESA----------------------------------------
--select * from EMPRESA;
INSERT INTO empresa (idempresa,rut,dv,nombre,direccion,telefono,usuario_id,correo) VALUES
(0,'11111111','1','Kumbieros S.A','Alameda #2121',22123456,2,'kumbieros@empresa.cl');
--select * from CARGO
INSERT INTO cargo ( idcargo,descripcion) VALUES (1,'Gerente');
INSERT INTO cargo ( idcargo,descripcion) VALUES (2,'Sub Gerente');
INSERT INTO cargo ( idcargo,descripcion) VALUES (3,'Jefe');
INSERT INTO cargo ( idcargo,descripcion) VALUES (4,'Supervisor');
INSERT INTO cargo ( idcargo,descripcion) VALUES (5,'Ejecutivo');
INSERT INTO cargo ( idcargo,descripcion) VALUES (6,'Contador');
INSERT INTO cargo ( idcargo,descripcion) VALUES (7,'RRHH');
INSERT INTO cargo ( idcargo,descripcion) VALUES (8,'Analista QA');
INSERT INTO cargo ( idcargo,descripcion) VALUES (9,'Programador');
INSERT INTO cargo ( idcargo,descripcion) VALUES (10,'Ingeniero');
--select * from HUESPED
INSERT INTO huesped (idhuesped,rut,dv,nombre,apellido,telefono,correo,empresa_id,estado_huesped_id,cargo_id) 
VALUES (1,'19283848','2','Hector','Fuentes',92837261,'hfuentes@kumbieros.cl',1,1,1);
INSERT INTO huesped (idhuesped,rut,dv,nombre,apellido,telefono,correo,empresa_id,estado_huesped_id,cargo_id) 
VALUES (2,'13789923','9','Jose','Mendez',94322123,'jmendez@kumbieros.cl',1,1,2);
--select * from FECHAS_RESERVAS
INSERT INTO fechas_reservas (idfecha_reservas,fecha_ingreso,fecha_salida)
VALUES (0,TO_DATE('2019-11-01', 'YYYY-MM-DD'),TO_DATE('2019-12-01', 'YYYY-MM-DD'));
INSERT INTO fechas_reservas (idfecha_reservas,fecha_ingreso,fecha_salida)
VALUES (0,TO_DATE('2019-10-11', 'YYYY-MM-DD'),TO_DATE('2019-11-01', 'YYYY-MM-DD'));
INSERT INTO fechas_reservas (idfecha_reservas,fecha_ingreso,fecha_salida)
VALUES (0,TO_DATE('2019-09-22', 'YYYY-MM-DD'),TO_DATE('2019-12-15', 'YYYY-MM-DD'));
--select * from HABITACION
INSERT INTO habitacion (idhabitacion,tipo_cama,accesorio,precio,descripcion,nombre,estado_habitacion_id,fechas_reservas_id,capacidad)
VALUES (1,'Doble','Tv,Wifi,Mesita',30000,'Habitación doble con tv,wifi y mesita','Habitación Arcoiris',1,1,2);
-- select * from HUESPED_HABITACION
INSERT INTO huesped_habitacion (idhuesped_habitacion,huesped_id,habitacion_id) VALUES (1,1,1);
INSERT INTO huesped_habitacion (idhuesped_habitacion,huesped_id,habitacion_id) VALUES (2,2,1);
-- select * from SERVICIO
INSERT INTO servicio (idservicio,descripcion,precio) VALUES (1,'Ejecutivo',15000);
INSERT INTO servicio (idservicio,descripcion,precio) VALUES (2,'Especial',20000);
INSERT INTO servicio (idservicio,descripcion,precio) VALUES (3,'General',10000);
-- select * from PLATO
INSERT INTO plato (idplato,nombre_plato) VALUES (1,'Arroz Con Carne');
INSERT INTO plato (idplato,nombre_plato) VALUES (2,'Ensalada Cesar');
-- select * from MINUTA
INSERT INTO minuta (idminuta,nombre_minuta,fecha_inicio,fecha_fin)
VALUES (1,'Flan de cafe',TO_DATE('2019-01-25', 'YYYY-MM-DD'),TO_DATE('2019-01-30', 'YYYY-MM-DD'));
VALUES (2,'Pastel de queso',TO_DATE('2019-03-25', 'YYYY-MM-DD'),TO_DATE('2019-04-30', 'YYYY-MM-DD'));
-- select * from ORDEN_COMEDOR
INSERT INTO orden_comedor (idorden_comedor,plato_id,minuta_id,servicio_id) 
VALUES (1,1,1,1);
INSERT INTO orden_comedor (idorden_comedor,plato_id,minuta_id,servicio_id)
VALUES (2,2,1,2);
-- select * from ORDEN_COMPRA
INSERT INTO orden_compra (idorden_compra,nro_orden,empresa_id,fecha,orden_comedor_id,huesped_habitacion_id) 
VALUES (1,'666',1,TO_DATE('2019-04-15', 'YYYY-MM-DD'),1,1);
INSERT INTO orden_compra (idorden_compra,nro_orden,empresa_id,fecha,orden_comedor_id,huesped_habitacion_id) 
VALUES (2,'666',1,TO_DATE('2019-04-15', 'YYYY-MM-DD'),2,2);
-- select * from FACTURA  
INSERT INTO factura (idfactura,nro_factura,orden_compra_id, fecha,precio_total)
VALUES (1,'6969',1,TO_DATE('2019-04-15', 'YYYY-MM-DD'),915000);
INSERT INTO factura (idfactura,nro_factura,orden_compra_id, fecha,precio_total)
VALUES (2,'6969',2,TO_DATE('2019-04-15', 'YYYY-MM-DD'),915000);



SELECT E.ESTADO AS ESTADO, U.RUT, U.DV, U.NOMBRE,U.APELLIDO,M.NOMBRE AS EMPRESA, O.NRO_ORDEN
FROM ORDEN_COMPRA O JOIN HUESPED_HABITACION H ON (O.HUESPED_HABITACION_ID = H.IDHUESPED_HABITACION) 
JOIN HUESPED U ON (H.HUESPED_ID = U.IDHUESPED) JOIN ESTADO_HUESPED E ON (U.ESTADO_HUESPED_ID = E.IDESTADO_HUESPED)
JOIN EMPRESA M ON (U.EMPRESA_ID = M.IDEMPRESA)
WHERE NRO_ORDEN = 1;




