-- INSERT, SEQUENCE y TRIGGER - Base de Datos HOSTALDB
--select * from TABS;

--LIMPIEZA DE TABLAS...
--SELECT 'DROP TABLE '||table_name||' CASCADE CONSTRAINTS;' FROM user_tables

--select * from TIPO_USUARIO;
INSERT INTO TIPO_USUARIO VALUES (1,'Administrador');
INSERT INTO TIPO_USUARIO VALUES (2,'Empleado');
INSERT INTO TIPO_USUARIO VALUES (3,'Empresa');
INSERT INTO TIPO_USUARIO VALUES (4,'Proveedor');

--select * from ESTADO_HABITACION;
INSERT INTO ESTADO_HABITACION VALUES (1,'Diponible');
INSERT INTO ESTADO_HABITACION VALUES (2,'Ocupada');

--select * from ESTADO_RECEPCION;
INSERT INTO ESTADO_RECEPCION VALUES (1,1,'Pendiente');
INSERT INTO ESTADO_RECEPCION VALUES (2,2,'Cerrada');



--LIMPIEZA DE BD SEQUENCES y TRIGGERS
---Ejecutar resultados...
--SELECT 'DROP SEQUENCE '||SEQUENCE_NAME||';' from ALL_SEQUENCES where SEQUENCE_OWNER='HOSTALDB';
--SELECT 'DROP TRIGGER '||TRIGGER_NAME||';' from ALL_TRIGGERS where OWNER='HOSTALDB';
--commit;


--AUTOINCREMENT USUARIO
CREATE SEQUENCE SEQ_USUARIO
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_USUARIO
BEFORE INSERT ON USUARIO
FOR EACH ROW
BEGIN
SELECT SEQ_USUARIO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT EMPRESA
CREATE SEQUENCE SEQ_EMPRESA
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_EMPRESA
BEFORE INSERT ON EMPRESA
FOR EACH ROW
BEGIN
SELECT SEQ_EMPRESA.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT EMPLEADO
CREATE SEQUENCE SEQ_EMPLEADO
START WITH 1
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRIG_EMPLEADO
BEFORE INSERT ON EMPLEADO
FOR EACH ROW
BEGIN
SELECT SEQ_EMPLEADO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT HUESPED
CREATE SEQUENCE SEQ_HUESPED
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_HUESPED
BEFORE INSERT ON HUESPED
FOR EACH ROW
BEGIN
SELECT SEQ_HUESPED.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT HUESPED_HABITACION
CREATE SEQUENCE SEQ_HUESP_HABIT
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_HUESP_HABIT
BEFORE INSERT ON HUESPED_HABITACION
FOR EACH ROW
BEGIN
SELECT SEQ_HUESP_HABIT.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT COMEDOR
CREATE SEQUENCE SEQ_COMEDOR
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_COMEDOR
BEFORE INSERT ON COMEDOR
FOR EACH ROW
BEGIN
SELECT SEQ_COMEDOR.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT FACTURA
CREATE SEQUENCE SEQ_FACTURA
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_FACTURA
BEFORE INSERT ON FACTURA
FOR EACH ROW
BEGIN
SELECT SEQ_FACTURA.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT HABITACION
CREATE SEQUENCE SEQ_HABITACION
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_HABITACION
BEFORE INSERT ON HABITACION
FOR EACH ROW
BEGIN
SELECT SEQ_HABITACION.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT MINUTA
CREATE SEQUENCE SEQ_MINUTA
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_MINUTA
BEFORE INSERT ON MINUTA
FOR EACH ROW
BEGIN
SELECT SEQ_MINUTA.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT ORDEN_COMPRA
CREATE SEQUENCE SEQ_ORDEN_COMPRA
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_ORDEN_COMPRA
BEFORE INSERT ON ORDEN_COMPRA
FOR EACH ROW
BEGIN
SELECT SEQ_ORDEN_COMPRA.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT ORDEN_HABITACION
CREATE SEQUENCE SEQ_ORDEN_HABITACION
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_ORDEN_HABITACION
BEFORE INSERT ON ORDEN_HABITACION
FOR EACH ROW
BEGIN
SELECT SEQ_ORDEN_HABITACION.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT ORDEN_PEDIDO
CREATE SEQUENCE SEQ_ORDEN_PEDIDO
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_ORDEN_PEDIDO
BEFORE INSERT ON ORDEN_PEDIDO
FOR EACH ROW
BEGIN
SELECT SEQ_ORDEN_PEDIDO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT PLATO
CREATE SEQUENCE SEQ_PLATO
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_PLATO
BEFORE INSERT ON PLATO
FOR EACH ROW
BEGIN
SELECT SEQ_PLATO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT PRODUCTO
CREATE SEQUENCE SEQ_PRODUCTO
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_PRODUCTO
BEFORE INSERT ON PRODUCTO
FOR EACH ROW
BEGIN
SELECT SEQ_PRODUCTO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT PROVEEDOR
CREATE SEQUENCE SEQ_PROVEEDOR
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_PROVEEDOR
BEFORE INSERT ON PROVEEDOR
FOR EACH ROW
BEGIN
SELECT SEQ_PROVEEDOR.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT RECEPCION_PRODUCTO
CREATE SEQUENCE SEQ_RECEPCION_PROD
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_RECEPCION_PROD
BEFORE INSERT ON RECEPCION_PRODUCTO
FOR EACH ROW
BEGIN
SELECT SEQ_RECEPCION_PROD.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/

--AUTOINCREMENT SERVICIO
CREATE SEQUENCE SEQ_SERVICIO
START WITH 1
INCREMENT BY 1;

CREATE TRIGGER TRIG_SERVICIO
BEFORE INSERT ON SERVICIO
FOR EACH ROW
BEGIN
SELECT SEQ_SERVICIO.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
/
commit;