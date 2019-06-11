package dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Editable;

import com.example.bank_app.utilidades.Utilidades;

import dataAccess.database.Database;
import dataAccess.models.Account;

public class AccountRepository {

    public static void updateAccount(Context context, String accountid, int saldo){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_SALDO, Integer.toString(saldo));




        admin.update(Utilidades.TABLA_CUENTA, content, Utilidades.CAMPO_IDC + "=" + accountid, null);
    }

    public static void createAccount(Context context, String accountid, int saldo){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content1 = new ContentValues();
        content1.put(Utilidades.CAMPO_IDC, Integer.parseInt(accountid));
        content1.put(Utilidades.CAMPO_SALDO, saldo);

        admin.insert(Utilidades.TABLA_CUENTA, Utilidades.CAMPO_IDC, content1);
    }

    public static Account readAccount(Context context, int accountid){
        Database database = new Database(context,"bd_cuentas" , null,1);
        SQLiteDatabase admin = database.getReadableDatabase();

        Cursor cursor = admin.rawQuery("SELECT * FROM "+Utilidades.TABLA_CUENTA+" WHERE "+Utilidades.CAMPO_IDC+"=?" , new String[]{Integer.toString(accountid)});

        Account a1 = new Account(cursor.getInt(0),cursor.getInt(1));

        return a1;
    }

    public static void deleteAccount(Context context, int accountid){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_IDC, Integer.toString(accountid));

        admin.execSQL("DELETE FROM "+Utilidades.TABLA_CUENTA+" WHERE "+Utilidades.CAMPO_IDC+"="+content);
    }
}
