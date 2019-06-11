package com.example.bank_app.entidades;

public class Transaccion {
    private int Id;
    private int Id_Cliente_Envia;
    private int Id_Cliente_Recibe;
    private int dia;
    private String mes;
    private int anho;
    private float Cantidad;

    public Transaccion(int id, int id_Cliente_Envia, int id_Cliente_Recibe, int dia, String mes, int anho, float cantidad) {
        Id = id;
        Id_Cliente_Envia = id_Cliente_Envia;
        Id_Cliente_Recibe = id_Cliente_Recibe;
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
        Cantidad = cantidad;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId_Cliente_Envia() {
        return Id_Cliente_Envia;
    }

    public void setId_Cliente_Envia(int id_Cliente_Envia) {
        Id_Cliente_Envia = id_Cliente_Envia;
    }

    public int getId_Cliente_Recibe() {
        return Id_Cliente_Recibe;
    }

    public void setId_Cliente_Recibe(int id_Cliente_Recibe) {
        Id_Cliente_Recibe = id_Cliente_Recibe;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public float getCantidad() {
        return Cantidad;
    }

    public void setCantidad(float cantidad) {
        Cantidad = cantidad;
    }
}
