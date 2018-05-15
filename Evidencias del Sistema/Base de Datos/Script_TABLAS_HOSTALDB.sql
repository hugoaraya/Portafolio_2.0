-- Generado por Oracle SQL Developer Data Modeler 17.4.0.355.2131
--   en:        2018-05-11 15:05:40 CLST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g


--LIMPIEZA DE AMBIENTE...
--SELECT 'DROP TABLE '||table_name||' CASCADE CONSTRAINTS;' FROM user_tables




CREATE TABLE comedor (
    idComedor            INTEGER NOT NULL,
    plato_id      INTEGER,
    minuta_id     INTEGER,
    servicio_id   INTEGER
);

ALTER TABLE comedor ADD CONSTRAINT comedor_pk PRIMARY KEY ( idComedor );

CREATE TABLE empleado (
    idEmpleado           INTEGER NOT NULL,
    rut          INTEGER NOT NULL,
    dv           CHAR(1) NOT NULL,
    nombre       VARCHAR2(50) NOT NULL,
    apellido     VARCHAR2(50) NOT NULL,
    usuario_id   INTEGER
);

ALTER TABLE empleado ADD CONSTRAINT empleado_pk PRIMARY KEY ( idEmpleado );

CREATE TABLE empresa (
    idEmpresa          INTEGER NOT NULL,
    rut          INTEGER NOT NULL,
    dv           CHAR(1) NOT NULL,
    nombre       VARCHAR2(50) NOT NULL,
    direccion    VARCHAR2(50) NOT NULL,
    telefono     INTEGER NOT NULL,
    usuario_id   INTEGER,
    correo       VARCHAR2(50) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( idEmpresa );

CREATE TABLE estado_habitacion (
    idEstado_Habitacion     INTEGER NOT NULL,
    descripcion   VARCHAR2(255) NOT NULL
);

ALTER TABLE estado_habitacion ADD CONSTRAINT estado_habitacion_pk PRIMARY KEY ( idEstado_Habitacion );

CREATE TABLE estado_recepcion (
    idEstado_Recepcion            INTEGER NOT NULL,
    descripcion   VARCHAR2(255) NOT NULL
);

ALTER TABLE estado_recepcion ADD CONSTRAINT estado_recepcion_pk PRIMARY KEY ( idEstado_Recepcion );

CREATE TABLE factura (
    idFactura         INTEGER NOT NULL,
    nro_factura       INTEGER NOT NULL,
    orden_compra_id   INTEGER,
    fecha             DATE NOT NULL
);

ALTER TABLE factura ADD CONSTRAINT factura_pk PRIMARY KEY ( idFactura );

CREATE TABLE habitacion (
    idHabitacion           INTEGER NOT NULL,
    tipo_cama              VARCHAR2(255) NOT NULL,
    accesorio              VARCHAR2(255) NOT NULL,
    precio                 INTEGER NOT NULL,
    descripcion            VARCHAR2(255) NOT NULL,
    nombre                 VARCHAR2(50) NOT NULL,
    estado_habitacion_id   INTEGER
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( idHabitacion );

CREATE TABLE huesped (
    idHuesped           INTEGER NOT NULL,
    rut          INTEGER NOT NULL,
    dv           CHAR(1) NOT NULL,
    nombre       VARCHAR2(50) NOT NULL,
    apellido     VARCHAR2(50) NOT NULL,
    telefono     INTEGER NOT NULL,
    correo       VARCHAR2(255) NOT NULL,
    cargo        VARCHAR2(50) NOT NULL,
    empresa_id   INTEGER
);

ALTER TABLE huesped ADD CONSTRAINT huesped_pk PRIMARY KEY ( idHuesped );

CREATE TABLE huesped_habitacion (
    idHuesped_Habitacion   INTEGER NOT NULL,
    huesped_id      INTEGER,
    habitacion_id   INTEGER
);

ALTER TABLE huesped_habitacion ADD CONSTRAINT huesped_habitacion_pk PRIMARY KEY ( idHuesped_Habitacion );

CREATE TABLE minuta (
    idMinuta             INTEGER NOT NULL,
    nombre_minuta   VARCHAR2(50) NOT NULL,
    descipcion      VARCHAR2(255) NOT NULL,
    fecha_inicio    DATE NOT NULL,
    fecha_fin       DATE NOT NULL
);

ALTER TABLE minuta ADD CONSTRAINT minuta_pk PRIMARY KEY ( idMinuta );

CREATE TABLE orden_comedor (
    idOrden_Comedor                INTEGER NOT NULL,
    comedor_id        INTEGER,
    orden_compra_id   INTEGER
);

ALTER TABLE orden_comedor ADD CONSTRAINT orden_comedor_pk PRIMARY KEY ( idOrden_Comedor );

CREATE TABLE orden_compra (
    idOrden_Compra           INTEGER NOT NULL,
    nro_orden    INTEGER NOT NULL,
    empresa_id   INTEGER,
    fecha        DATE NOT NULL
);

ALTER TABLE orden_compra ADD CONSTRAINT orden_compra_pk PRIMARY KEY ( idOrden_Compra );

CREATE TABLE orden_habitacion (
    idOrden_Habitacion               INTEGER NOT NULL,
    habitacion_id     INTEGER,
    orden_compra_id   INTEGER
);

ALTER TABLE orden_habitacion ADD CONSTRAINT orden_habitacion_pk PRIMARY KEY ( idOrden_Habitacion );

CREATE TABLE orden_pedido (
    idOrden_Pedido             INTEGER NOT NULL,
    nro_orden      INTEGER NOT NULL,
    empleado_id    INTEGER,
    fecha          DATE NOT NULL,
    proveedor_id   INTEGER,
	estado_orden_id INTEGER
);

ALTER TABLE orden_pedido ADD CONSTRAINT orden_pedido_pk PRIMARY KEY ( idOrden_Pedido );

CREATE TABLE plato (
    idPlato            INTEGER NOT NULL,
    nombre_plato   VARCHAR2(50) NOT NULL,
    descripcion    VARCHAR2(255) NOT NULL,
    precio         INTEGER NOT NULL
);

ALTER TABLE plato ADD CONSTRAINT plato_pk PRIMARY KEY ( idPlato );

CREATE TABLE producto (
    idProducto                 INTEGER NOT NULL,
    nombre              VARCHAR2(50) NOT NULL,
    fecha_vencimiento   DATE NOT NULL,
    precio              INTEGER NOT NULL,
    familia             VARCHAR2(50) NOT NULL,
    tipo_producto       VARCHAR2(50) NOT NULL,
    descripcion         VARCHAR2(50) NOT NULL,
    stock               INTEGER NOT NULL,
    stock_critico       INTEGER NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( idProducto );

CREATE TABLE proveedor (
    idProveedor          INTEGER NOT NULL,
    rut         INTEGER NOT NULL,
    dv          CHAR(1) NOT NULL,
    nombre      VARCHAR2(50) NOT NULL,
    direccion   VARCHAR2(50) NOT NULL,
    rubro       VARCHAR2(50) NOT NULL
);

ALTER TABLE proveedor ADD CONSTRAINT proveedor_pk PRIMARY KEY ( idProveedor );

CREATE TABLE estado_orden_pedido(
	idEstado_Orden_pedido INTEGER NOT NULL,
	descipcion VARCHAR2(255) NOT NULL
);

ALTER TABLE estado_orden_pedido ADD CONSTRAINT estado_orden_pedido_pk PRIMARY KEY ( idEstado_Orden_pedido );


CREATE TABLE recepcion_producto (
    idRecepcion_Producto  INTEGER NOT NULL,
    nro_recepcion         INTEGER NOT NULL,
    codigo_barra          INTEGER NOT NULL,
    producto_id           INTEGER,
    estado_recepcion_id   INTEGER,
    orden_pedido_id       INTEGER,
    fecha                 DATE NOT NULL
);

ALTER TABLE recepcion_producto ADD CONSTRAINT recepcion_producto_pk PRIMARY KEY ( idRecepcion_Producto );

CREATE TABLE servicio (
    idServicio    INTEGER NOT NULL,
    descripcion   VARCHAR2(50) NOT NULL
);

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( idServicio );

CREATE TABLE tipo_usuario (
    idTipo_Usuario   INTEGER NOT NULL,
    descripcion   VARCHAR2(50) NOT NULL
);

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( idTipo_Usuario );

CREATE TABLE usuario (
    idUsuario                INTEGER NOT NULL,
    nombre_usuario    VARCHAR2(50) NOT NULL,
    contrasenia       VARCHAR2(255) NOT NULL,
    tipo_usuario_id   INTEGER
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idUsuario );

ALTER TABLE comedor
    ADD CONSTRAINT comedor_minuta_fk FOREIGN KEY ( minuta_id )
        REFERENCES minuta ( idMinuta );

ALTER TABLE comedor
    ADD CONSTRAINT comedor_plato_fk FOREIGN KEY ( plato_id )
        REFERENCES plato ( idPlato );

ALTER TABLE comedor
    ADD CONSTRAINT comedor_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( idServicio );

ALTER TABLE empleado
    ADD CONSTRAINT empleado_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( idUsuario );

ALTER TABLE empresa
    ADD CONSTRAINT empresa_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( idUsuario );

ALTER TABLE factura
    ADD CONSTRAINT factura_orden_fk FOREIGN KEY ( orden_compra_id )
        REFERENCES orden_compra ( idOrden_Compra );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_estado_fk FOREIGN KEY ( estado_habitacion_id )
        REFERENCES estado_habitacion ( idEstado_Habitacion );

ALTER TABLE huesped_habitacion
    ADD CONSTRAINT habitacion_huesped_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( idHabitacion );

ALTER TABLE huesped
    ADD CONSTRAINT huesped_empresa_fk FOREIGN KEY ( empresa_id )
        REFERENCES empresa ( idEmpresa );

ALTER TABLE huesped_habitacion
    ADD CONSTRAINT huesped_habitacion_fk FOREIGN KEY ( huesped_id )
        REFERENCES huesped ( idHuesped );

ALTER TABLE orden_comedor
    ADD CONSTRAINT comedor_orden_fk FOREIGN KEY ( comedor_id )
        REFERENCES comedor ( idComedor );

ALTER TABLE orden_comedor
    ADD CONSTRAINT orden_comedor_fk FOREIGN KEY ( orden_compra_id )
        REFERENCES orden_compra ( idOrden_Compra );

ALTER TABLE orden_compra
    ADD CONSTRAINT orden_compra_empresa_fk FOREIGN KEY ( empresa_id )
        REFERENCES empresa ( idEmpresa );

ALTER TABLE orden_pedido
    ADD CONSTRAINT orden_empleado_fk FOREIGN KEY ( empleado_id )
        REFERENCES empleado ( idEmpleado );

ALTER TABLE orden_habitacion
    ADD CONSTRAINT orden_hab_compra_fk FOREIGN KEY ( orden_compra_id )
        REFERENCES orden_compra ( idOrden_Compra );

ALTER TABLE orden_habitacion
    ADD CONSTRAINT orden_habitacion_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( idHabitacion );

ALTER TABLE orden_pedido
    ADD CONSTRAINT orden_proveedor_fk FOREIGN KEY ( proveedor_id )
        REFERENCES proveedor ( idProveedor );
		
ALTER TABLE orden_pedido
    ADD CONSTRAINT estado_orden_fk FOREIGN KEY ( estado_orden_id )
        REFERENCES estado_orden_pedido ( idEstado_Orden_pedido );		

ALTER TABLE recepcion_producto
    ADD CONSTRAINT recepcion_estado_fk FOREIGN KEY ( estado_recepcion_id )
        REFERENCES estado_recepcion ( idEstado_Recepcion );

ALTER TABLE recepcion_producto
    ADD CONSTRAINT recepcion_orden_fk FOREIGN KEY ( orden_pedido_id )
        REFERENCES orden_pedido ( idOrden_Pedido );

ALTER TABLE recepcion_producto
    ADD CONSTRAINT recepcion_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( idProducto );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipo_fk FOREIGN KEY ( tipo_usuario_id )
        REFERENCES tipo_usuario ( idTipo_Usuario );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            21
-- CREATE INDEX                             0
-- ALTER TABLE                             42
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
