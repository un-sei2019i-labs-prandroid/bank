package dataAccess.models;

public class Account {
    private int Id;
    private float saldo;

    public Account(int id, String email, int saldo) {
        Id = id;
        this.saldo = saldo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
