-- Generado por Oracle SQL Developer Data Modeler 17.4.0.355.2131
--   en:        2018-06-06 16:20:57 CLT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



--LIMPIEZA DE AMBIENTE...
--SELECT 'DROP TABLE '||table_name||' CASCADE CONSTRAINTS;' FROM user_tables



CREATE TABLE cargo (
    idcargo       INTEGER NOT NULL,
    descripcion   VARCHAR2(50) NOT NULL
);

ALTER TABLE cargo ADD CONSTRAINT cargo_pk PRIMARY KEY ( idcargo );

CREATE TABLE empleado (
    idempleado   INTEGER NOT NULL,
    rut          INTEGER NOT NULL,
    dv           CHAR(1) NOT NULL,
    nombre       VARCHAR2(50) NOT NULL,
    apellido     VARCHAR2(50) NOT NULL,
    usuario_id   INTEGER
);

ALTER TABLE empleado ADD CONSTRAINT empleado_pk PRIMARY KEY ( idempleado );

CREATE TABLE empresa (
    idempresa    INTEGER NOT NULL,
    rut          INTEGER NOT NULL,
    dv           CHAR(1) NOT NULL,
    nombre       VARCHAR2(50) NOT NULL,
    direccion    VARCHAR2(50) NOT NULL,
    telefono     INTEGER NOT NULL,
    usuario_id   INTEGER,
    correo       VARCHAR2(50) NOT NULL
);

ALTER TABLE empresa ADD CONSTRAINT empresa_pk PRIMARY KEY ( idempresa );

CREATE TABLE estado_habitacion (
    idestado_habitacion   INTEGER NOT NULL,
    descripcion           VARCHAR2(255) NOT NULL
);

ALTER TABLE estado_habitacion ADD CONSTRAINT estado_habitacion_pk PRIMARY KEY ( idestado_habitacion );

CREATE TABLE estado_huesped (
    idestado_huesped   INTEGER NOT NULL,
    estado             VARCHAR2(10) NOT NULL
);

ALTER TABLE estado_huesped ADD CONSTRAINT estado_huesped_pk PRIMARY KEY ( idestado_huesped );

CREATE TABLE estado_orden_pedido (
    idestado_orden_pedido   INTEGER NOT NULL,
    descripcion             VARCHAR2(255) NOT NULL
);

ALTER TABLE estado_orden_pedido ADD CONSTRAINT estado_orden_pedido_pk PRIMARY KEY ( idestado_orden_pedido );

CREATE TABLE estado_recepcion (
    idestado_recepcion   INTEGER NOT NULL,
    descripcion          VARCHAR2(255) NOT NULL
);

ALTER TABLE estado_recepcion ADD CONSTRAINT estado_recepcion_pk PRIMARY KEY ( idestado_recepcion );

CREATE TABLE factura (
    idfactura         INTEGER NOT NULL,
    nro_factura       INTEGER NOT NULL,
    orden_compra_id   INTEGER ,
    fecha             DATE NOT NULL,
    precio_total      INTEGER NOT NULL
);

ALTER TABLE factura ADD CONSTRAINT factura_pk PRIMARY KEY ( idfactura );

CREATE TABLE familia_producto (
    idfamilia_producto   INTEGER NOT NULL,
    descripcion          VARCHAR2(255) NOT NULL
);

ALTER TABLE familia_producto ADD CONSTRAINT familia_producto_pk PRIMARY KEY ( idfamilia_producto );

CREATE TABLE fechas_reservas (
    idfecha_reservas   INTEGER NOT NULL,
    fecha_ingreso      DATE NOT NULL,
    fecha_salida       DATE NOT NULL
);

ALTER TABLE fechas_reservas ADD CONSTRAINT fechas_reservas_pk PRIMARY KEY ( idfecha_reservas );

CREATE TABLE habitacion (
    idhabitacion           INTEGER NOT NULL,
    tipo_cama              VARCHAR2(255) NOT NULL,
    accesorio              VARCHAR2(255) NOT NULL,
    precio                 INTEGER NOT NULL,
    descripcion            VARCHAR2(255) NOT NULL,
    nombre                 VARCHAR2(50) NOT NULL,
    estado_habitacion_id   INTEGER,
    fechas_reservas_id     INTEGER,
	capacidad			   INTEGER NOT NULL
);

ALTER TABLE habitacion ADD CONSTRAINT habitacion_pk PRIMARY KEY ( idhabitacion );

CREATE TABLE huesped (
    idhuesped           INTEGER NOT NULL,
    rut                 INTEGER NOT NULL,
    dv                  CHAR(1) NOT NULL,
    nombre              VARCHAR2(50) NOT NULL,
    apellido            VARCHAR2(50) NOT NULL,
    telefono            INTEGER NOT NULL,
    correo              VARCHAR2(255) NOT NULL,
    empresa_id          INTEGER ,
    estado_huesped_id   INTEGER ,
    cargo_id            INTEGER 
);

ALTER TABLE huesped ADD CONSTRAINT huesped_pk PRIMARY KEY ( idhuesped );

CREATE TABLE huesped_habitacion (
    idhuesped_habitacion   INTEGER NOT NULL,
    huesped_id             INTEGER ,
    habitacion_id          INTEGER 
);

ALTER TABLE huesped_habitacion ADD CONSTRAINT huesped_habitacion_pk PRIMARY KEY ( idhuesped_habitacion );

CREATE TABLE minuta (
    idminuta        INTEGER NOT NULL,
    nombre_minuta   VARCHAR2(50) NOT NULL,
    fecha_inicio    DATE NOT NULL,
    fecha_fin       DATE NOT NULL
);

ALTER TABLE minuta ADD CONSTRAINT minuta_pk PRIMARY KEY ( idminuta );

CREATE TABLE orden_comedor (
    idorden_comedor   INTEGER NOT NULL,
    plato_id          INTEGER,
    minuta_id         INTEGER,
    servicio_id       INTEGER 
);

ALTER TABLE orden_comedor ADD CONSTRAINT orden_comedor_pk PRIMARY KEY ( idorden_comedor );

CREATE TABLE orden_compra (
    idorden_compra          INTEGER NOT NULL,
    nro_orden               INTEGER NOT NULL,
    empresa_id              INTEGER ,
    fecha                   DATE NOT NULL,
    orden_comedor_id        INTEGER ,
    huesped_habitacion_id   INTEGER
);

ALTER TABLE orden_compra ADD CONSTRAINT orden_compra_pk PRIMARY KEY ( idorden_compra );

CREATE TABLE orden_pedido (
    idorden_pedido           INTEGER NOT NULL,
    nro_orden                INTEGER NOT NULL,
    empleado_id              INTEGER ,
    fecha                    DATE NOT NULL,
    proveedor_id             INTEGER ,
    estado_orden_pedido_id   INTEGER,
	comentario              VARCHAR2(255) 
);

ALTER TABLE orden_pedido ADD CONSTRAINT orden_pedido_pk PRIMARY KEY ( idorden_pedido );

CREATE TABLE plato (
    idplato        INTEGER NOT NULL,
    nombre_plato   VARCHAR2(50) NOT NULL
);

ALTER TABLE plato ADD CONSTRAINT plato_pk PRIMARY KEY ( idplato );

CREATE TABLE producto (
    idproducto            INTEGER NOT NULL,   
    fecha_vencimiento     DATE NOT NULL,
    precio                INTEGER NOT NULL,   
    stock                 INTEGER NOT NULL,
    stock_critico         INTEGER NOT NULL,
    tipo_producto_id      INTEGER,
    familia_producto_id   INTEGER,
	marca_id			  INTEGER,
	codigo_barra_id       INTEGER
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( idproducto );

CREATE TABLE proveedor (
    idproveedor   INTEGER NOT NULL,
    rut           INTEGER NOT NULL,
    dv            CHAR(1) NOT NULL,
    nombre        VARCHAR2(50) NOT NULL,
    direccion     VARCHAR2(50) NOT NULL,
    usuario_id    INTEGER,
	rubro_id      INTEGER 
);

ALTER TABLE proveedor ADD CONSTRAINT proveedor_pk PRIMARY KEY ( idproveedor );

CREATE TABLE recepcion_producto (
    idrecepcion_producto   INTEGER NOT NULL,
    nro_recepcion          INTEGER NOT NULL,
    codigo_barra           INTEGER NOT NULL,
    producto_id            INTEGER ,
    estado_recepcion_id    INTEGER ,
    orden_pedido_id        INTEGER ,
    fecha                  DATE NOT NULL
);

ALTER TABLE recepcion_producto ADD CONSTRAINT recepcion_producto_pk PRIMARY KEY ( idrecepcion_producto );

CREATE TABLE rubro (
    idrubro       INTEGER NOT NULL,
    descripcion   VARCHAR2(255) NOT NULL    
);

ALTER TABLE rubro ADD CONSTRAINT rubro_pk PRIMARY KEY ( idrubro );

CREATE TABLE servicio (
    idservicio    INTEGER NOT NULL,
    descripcion   VARCHAR2(50) NOT NULL,
    precio        INTEGER NOT NULL
);

ALTER TABLE servicio ADD CONSTRAINT servicio_pk PRIMARY KEY ( idservicio );

CREATE TABLE tipo_producto (
    idtipo_producto   INTEGER NOT NULL,
    descripcion       VARCHAR2(255) NOT NULL
);

ALTER TABLE tipo_producto ADD CONSTRAINT tipo_producto_pk PRIMARY KEY ( idtipo_producto );

CREATE TABLE tipo_usuario (
    idtipo_usuario   INTEGER NOT NULL,
    descripcion      VARCHAR2(50) NOT NULL
);

ALTER TABLE tipo_usuario ADD CONSTRAINT tipo_usuario_pk PRIMARY KEY ( idtipo_usuario );

CREATE TABLE usuario (
    idusuario         INTEGER NOT NULL,
    nombre_usuario    VARCHAR2(50) NOT NULL,
    contrasenia       VARCHAR2(255) NOT NULL,
    tipo_usuario_id   INTEGER
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( idusuario );

CREATE TABLE marca (
	idmarca INTEGER NOT NULL,
	descripcion  VARCHAR2(50) NOT NULL
);

ALTER TABLE marca ADD CONSTRAINT marca_pk PRIMARY KEY ( idmarca );

CREATE TABLE codigo_barra (
    idcodigo_barra   INTEGER NOT NULL,
    codigo           INTEGER NOT NULL
);

ALTER TABLE codigo_barra ADD CONSTRAINT codigo_barra_pk PRIMARY KEY ( idcodigo_barra );

ALTER TABLE orden_compra
    ADD CONSTRAINT compra_huesped_habitacion_fk FOREIGN KEY ( huesped_habitacion_id )
        REFERENCES huesped_habitacion ( idhuesped_habitacion );

ALTER TABLE orden_compra
    ADD CONSTRAINT compra_orden_comedor_fk FOREIGN KEY ( orden_comedor_id )
        REFERENCES orden_comedor ( idorden_comedor );

ALTER TABLE empleado
    ADD CONSTRAINT empleado_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( idusuario );

ALTER TABLE empresa
    ADD CONSTRAINT empresa_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( idusuario );

ALTER TABLE orden_pedido
    ADD CONSTRAINT estado_orden_pedido_fk FOREIGN KEY ( estado_orden_pedido_id )
        REFERENCES estado_orden_pedido ( idestado_orden_pedido );

ALTER TABLE factura
    ADD CONSTRAINT factura_orden_fk FOREIGN KEY ( orden_compra_id )
        REFERENCES orden_compra ( idorden_compra );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_estado_fk FOREIGN KEY ( estado_habitacion_id )
        REFERENCES estado_habitacion ( idestado_habitacion );

ALTER TABLE habitacion
    ADD CONSTRAINT habitacion_fechas_reservas_fk FOREIGN KEY ( fechas_reservas_id )
        REFERENCES fechas_reservas ( idfecha_reservas );

ALTER TABLE huesped_habitacion
    ADD CONSTRAINT habitacion_huesped_fk FOREIGN KEY ( habitacion_id )
        REFERENCES habitacion ( idhabitacion );

ALTER TABLE huesped
    ADD CONSTRAINT huesped_cargo_fk FOREIGN KEY ( cargo_id )
        REFERENCES cargo ( idcargo );

ALTER TABLE huesped
    ADD CONSTRAINT huesped_empresa_fk FOREIGN KEY ( empresa_id )
        REFERENCES empresa ( idempresa );

ALTER TABLE huesped
    ADD CONSTRAINT huesped_estado_huesped_fk FOREIGN KEY ( estado_huesped_id )
        REFERENCES estado_huesped ( idestado_huesped );

ALTER TABLE huesped_habitacion
    ADD CONSTRAINT huesped_habitacion_fk FOREIGN KEY ( huesped_id )
        REFERENCES huesped ( idhuesped );

ALTER TABLE orden_comedor
    ADD CONSTRAINT orden_comedor_minuta_fk FOREIGN KEY ( minuta_id )
        REFERENCES minuta ( idminuta );

ALTER TABLE orden_comedor
    ADD CONSTRAINT orden_comedor_plato_fk FOREIGN KEY ( plato_id )
        REFERENCES plato ( idplato );

ALTER TABLE orden_comedor
    ADD CONSTRAINT orden_comedor_servicio_fk FOREIGN KEY ( servicio_id )
        REFERENCES servicio ( idservicio );

ALTER TABLE orden_compra
    ADD CONSTRAINT orden_compra_empresa_fk FOREIGN KEY ( empresa_id )
        REFERENCES empresa ( idempresa );

ALTER TABLE orden_pedido
    ADD CONSTRAINT orden_empleado_fk FOREIGN KEY ( empleado_id )
        REFERENCES empleado ( idempleado );

ALTER TABLE orden_pedido
    ADD CONSTRAINT orden_proveedor_fk FOREIGN KEY ( proveedor_id )
        REFERENCES proveedor ( idproveedor );

ALTER TABLE producto
    ADD CONSTRAINT producto_familia_producto_fk FOREIGN KEY ( familia_producto_id )
        REFERENCES familia_producto ( idfamilia_producto );

ALTER TABLE producto
    ADD CONSTRAINT producto_tipo_producto_fk FOREIGN KEY ( tipo_producto_id )
        REFERENCES tipo_producto ( idtipo_producto );
		
		ALTER TABLE producto
    ADD CONSTRAINT marca_producto_fk FOREIGN KEY ( marca_id )
        REFERENCES marca ( idmarca );
		
		ALTER TABLE producto
    ADD CONSTRAINT producto_codigo_barra_fk FOREIGN KEY ( codigo_barra_id )
        REFERENCES codigo_barra ( idcodigo_barra );


ALTER TABLE proveedor
    ADD CONSTRAINT proveedor_usuario_fk FOREIGN KEY ( usuario_id )
        REFERENCES usuario ( idusuario );
		
ALTER TABLE proveedor
    ADD CONSTRAINT proveedor_rubro_fk FOREIGN KEY ( rubro_id )
        REFERENCES rubro ( idrubro );

ALTER TABLE recepcion_producto
    ADD CONSTRAINT recepcion_estado_fk FOREIGN KEY ( estado_recepcion_id )
        REFERENCES estado_recepcion ( idestado_recepcion );

ALTER TABLE recepcion_producto
    ADD CONSTRAINT recepcion_orden_fk FOREIGN KEY ( orden_pedido_id )
        REFERENCES orden_pedido ( idorden_pedido );

ALTER TABLE recepcion_producto
    ADD CONSTRAINT recepcion_producto_fk FOREIGN KEY ( producto_id )
        REFERENCES producto ( idproducto );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_tipo_fk FOREIGN KEY ( tipo_usuario_id )
        REFERENCES tipo_usuario ( idtipo_usuario );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            26
-- CREATE INDEX                             0
-- ALTER TABLE                             53
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
