package com.example.bank_app.utilidades;

public class Utilidades {
    public static final String TABLA_USUARIO = "usuarios";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_PASSWORD = "password";

    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE "+ TABLA_USUARIO+" ("+CAMPO_ID+" INTEGER "+CAMPO_EMAIL+" TEXT, "+CAMPO_PASSWORD+" TEXT)";
}
