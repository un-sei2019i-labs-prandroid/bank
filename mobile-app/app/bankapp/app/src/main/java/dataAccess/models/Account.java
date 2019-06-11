package dataAccess.models;

public class Account {
    private int Id;
    private int saldo;

    public Account(int id, int saldo) {
        Id = id;
        this.saldo = saldo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
