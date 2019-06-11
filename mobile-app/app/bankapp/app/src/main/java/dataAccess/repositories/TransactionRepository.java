package dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.utilidades.Utilidades;

import dataAccess.database.Database;
import dataAccess.models.Account;

public class TransactionRepository {

    public static void createTransaction(Context context, int idt, String idue, String idur, int dia, int mes, int anho, int cantidad, Database db){
        SQLiteDatabase admin = db.getWritableDatabase();

        ContentValues content1 = new ContentValues();
        content1.put(Utilidades.CAMPO_IDT, Integer.toString(idt));
        content1.put(Utilidades.CAMPO_IDCE, idue);
        content1.put(Utilidades.CAMPO_IDCR, idur);
        content1.put(Utilidades.CAMPO_DIA,  Integer.toString(dia));
        content1.put(Utilidades.CAMPO_MES, Integer.toString(mes));
        content1.put(Utilidades.CAMPO_ANHO, Integer.toString(anho));
        content1.put(Utilidades.CAMPO_CANTIDAD, Integer.toString(cantidad));


        admin.insert(Utilidades.TABLA_TRANSACCIONES, Utilidades.CAMPO_IDT, content1);
}

    public static void readTransaction(Context context, int usert){
        Database database = new Database(context,"bd_transacciones" ,null,1);
        SQLiteDatabase admin = database.getReadableDatabase();

        ContentValues content1 = new ContentValues();
        content1.put(Utilidades.CAMPO_ID, Integer.toString(usert));

        admin.execSQL("SELECT * FROM "+Utilidades.TABLA_TRANSACCIONES+" WHERE "+Utilidades.CAMPO_IDT+"="+content1);
    }

    public static void deleteTransaction(Context context, int usert){
        Database database = new Database(context,"bd_transacciones" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_IDC, Integer.toString(usert));

        admin.execSQL("DELETE FROM "+Utilidades.TABLA_TRANSACCIONES+" WHERE "+Utilidades.CAMPO_IDT+"="+content);
    }
}
