package com.example.bank_app.utilidades;

public class Utilidades {
    public static final String TABLA_USUARIO = "usuarios";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_PASSWORD = "password";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ TABLA_USUARIO+" ("+CAMPO_ID+" INTEGER, "+CAMPO_EMAIL+" TEXT, "+CAMPO_PASSWORD+" TEXT)";

    public static final String TABLA_CUENTA = "cuentas";
    public static final String CAMPO_IDC = "id";
    public static final String CAMPO_SALDO = "saldo";

    public static final String CREAR_TABLA_CUENTA = "CREATE TABLE "+ TABLA_CUENTA+" ("+CAMPO_IDC+" INTEGER, "+CAMPO_SALDO+" INTEGER)";

    public static final String TABLA_TRANSACCIONES = "transacciones";
    public static final String CAMPO_IDT = "id";
    public static final String CAMPO_IDCE = "id_cliente_envia";
    public static final String CAMPO_IDCR = "id_cliente_recibe";
    public static final String CAMPO_DIA = "dia";
    public static final String CAMPO_MES = "mes";
    public static final String CAMPO_ANHO = "anho";
    public static final String CAMPO_CANTIDAD = "cantidad";

    public static final String CREAR_TABLA_TRANSACCION = "CREATE TABLE "+ TABLA_TRANSACCIONES+" ("+CAMPO_IDT+" INTEGER, "+CAMPO_IDCE+" INTEGER, "+CAMPO_IDCR+" INTEGER, "+CAMPO_DIA+" INTEGER, "+CAMPO_MES+" TEXT, "+CAMPO_ANHO+" INTEGER, "+CAMPO_CANTIDAD+" INTEGER)";
}
