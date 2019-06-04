package dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.bank_app.utilidades.Utilidades;

import dataAccess.database.Database;

public class AccountRepository {
    public static void updateAccount(Context context, String accountid, int saldo){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_SALDO, Integer.toString(saldo));




        admin.update(Utilidades.TABLA_CUENTA, content, Utilidades.CAMPO_IDC + "=" + accountid, null);

    }

    public static void createAccount(Context context, int accountid, int saldo){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content1 = new ContentValues();
        ContentValues content2 = new ContentValues();
        content1.put(Utilidades.CAMPO_IDC, accountid);
        content2.put(Utilidades.CAMPO_SALDO, saldo);

        admin.execSQL("INSERT INTO "+ Utilidades.TABLA_CUENTA+" VALUES (" +content1+", "+ content2+")");
    }

    public static int readAccount(Context context, int accountid){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getReadableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_IDC, Integer.toString(accountid));

        admin.execSQL("SELECT "+Utilidades.CAMPO_SALDO+" FROM "+Utilidades.TABLA_CUENTA+" WHERE "+Utilidades.CAMPO_IDC+"="+content);

        Cursor cursor = admin.rawQuery("SELECT "+Utilidades.CAMPO_SALDO+" FROM "+Utilidades.TABLA_CUENTA+" WHERE "+Utilidades.CAMPO_IDC+"=? ", new String[]{Integer.toString(accountid)});

        return cursor.getInt(1);

    }

    public static void deleteAccount(Context context, int accountid){
        Database database = new Database(context,"bd_cuentas" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_IDC, Integer.toString(accountid));

        admin.execSQL("DELETE FROM "+Utilidades.TABLA_CUENTA+" WHERE "+Utilidades.CAMPO_IDC+"="+content);
    }
}
