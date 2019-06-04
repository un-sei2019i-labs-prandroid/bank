package dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.utilidades.Utilidades;

import dataAccess.database.Database;
import dataAccess.models.Account;

public class TransactionRepository {

    public static void createTransaction(Context context, int idt, String idue, String idur, int dia, String mes, int anho, int cantidad){
        Database database = new Database(context,"bd_transacciones" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content1 = new ContentValues();
        ContentValues content2 = new ContentValues();
        ContentValues content3 = new ContentValues();
        ContentValues content4 = new ContentValues();
        ContentValues content5 = new ContentValues();
        ContentValues content6 = new ContentValues();
        ContentValues content7 = new ContentValues();
        content1.put(Utilidades.CAMPO_IDT, Integer.toString(idt));
        content2.put(Utilidades.CAMPO_IDCE, idue);
        content3.put(Utilidades.CAMPO_IDCR, idur);
        content4.put(Utilidades.CAMPO_DIA,  Integer.toString(dia));
        content5.put(Utilidades.CAMPO_MES, mes);
        content6.put(Utilidades.CAMPO_ANHO, Integer.toString(anho));
        content3.put(Utilidades.CAMPO_CANTIDAD, Integer.toString(cantidad));


        admin.execSQL("INSERT INTO "+ Utilidades.TABLA_TRANSACCIONES+" VALUES (" +content1+", "+ content2+", "+content3+", "+content4+", "+content5+", "+content6+", "+content7+")");
        AccountRepository.updateAccount(context,idue,AccountRepository.readAccount(context,Integer.parseInt(idue)-cantidad));
        AccountRepository.updateAccount(context,idur,AccountRepository.readAccount(context,Integer.parseInt(idur)+cantidad));
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
