CREATE TABLE INVERSIONESAPP.INV_ACTIVOS
(
    idActivo NUMBER,
    Desc_nombre VARCHAR2(50)
)TABLESPACE TS_INVERSIONES

--Creaci�n del sin�nimo de la tabla para consultas
CREATE SYNONYM ACTIVS FOR INVERSIONESAPP.INV_ACTIVOS;

--Creaci�n de constraints
ALTER TABLE INVERSIONESAPP.INV_ACTIVOS ADD CONSTRAINT PK_ACTIVS PRIMARY KEY (idActivo);


COMMENT ON TABLE INVERSIONESAPP.INV_ACTIVOS IS 'Almacena los activos econ�micos en los que se pueden realizar inversiones';