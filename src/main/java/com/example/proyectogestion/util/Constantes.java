package com.example.proyectogestion.util;
public class Constantes {
    public static final String CODIGO_OK = "0000";
    public static final String CODIGO_ERROR = "9999";
    public static final String CODIGO_NO_SE_ENCONTRARON_DATOS = "0001";
    public static final String SP_LIST_CATEGORIAS = "PKG_PRUEBAS_GENERALES.SP_LIST_CATEGORIAS";
    public static final String SP_LIST_CLIENTES = "PKG_PRUEBAS_GENERALES.SP_LIST_CLIENTES";
    public static final String SP_LIST_PRODUCTOS = "PKG_PRUEBAS_GENERALES.SP_LIST_PRODUCTOS";

    public static final String SP_LIST_JUEGOS = "PKG_PRUEBAS_GENERALES.SP_LIST_JUEGOS";
    public static final String SP_LIST_ALMACEN = "PKG_PRUEBAS_GENERALES.SP_LIST_ALMACEN";
    public static final String SP_LIST_PROVEEDOR = "PKG_PRUEBAS_GENERALES.SP_LIST_PROVEEDORES";

    public static final String sp_usuario_exists = "PKG_PRUEBAS_GENERALES.sp_usuario_exists";
    public static final String sp_usuario_insert = "PKG_PRUEBAS_GENERALES.sp_ins_persona_usuario";
    public static final String sp_guardar_token = "PKG_PRUEBAS_GENERALES.sp_insup_confirmation_token";

    //10 segundos
    public static final int EXPIRATION_TIME = 10000;

    /*
    * #  datasource:
    #    url: jdbc:oracle:thin:@localhost:1521/xe
    #    username: gestion
    #    password: gestion
    #    url: jdbc:oracle:thin:@localhost:1521:orcl
#    url: jdbc:oracle:thin:@localhost:1521/ORCL
#    username: yalerolev1
#    password: yalerolev1
    #    username: gestion
    #    password: gestion

#    driver-class-name: oracle.jdbc.driver.OracleDriver
#  application:
#    name: ClientesBackend
*
* #    database-platform: org.hibernate.dialect.Oracle10gDialect
    * */
}
