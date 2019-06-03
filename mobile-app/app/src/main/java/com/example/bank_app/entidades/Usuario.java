package com.example.bank_app.entidades;

public class Usuario {
    private int Id;
    private String email;
    private String password;

    public Usuario(int id, String email, String password) {
        this.Id = id;
        this.email = email;
        this.password = password;
    }

    public int getId(){
        return Id;
    }

    public void setId(int id){
        this.Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

