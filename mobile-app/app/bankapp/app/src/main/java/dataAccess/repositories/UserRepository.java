package dataAccess.repositories;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.utilidades.Utilidades;

import dataAccess.database.Database;
import dataAccess.models.Usuario;

public class UserRepository {
    public static void updateUser(Context context, String userid, String password){
        Database database = new Database(context,"bd_usuarios" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_PASSWORD, password);


        admin.update(Utilidades.TABLA_USUARIO, content, Utilidades.CAMPO_ID + "=" + userid, null);

    }

    public static void createUsuario(Context context, int userid, String email, String password){
        Database database = new Database(context,"bd_usuarios" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content1 = new ContentValues();
        content1.put(Utilidades.CAMPO_ID, Integer.toString(userid));
        content1.put(Utilidades.CAMPO_EMAIL, email);
        content1.put(Utilidades.CAMPO_PASSWORD,password);

        admin.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, content1);
    }

    public static void readUser(Context context, int userid){
        Database database = new Database(context,"bd_usuarios" ,null,1);
        SQLiteDatabase admin = database.getReadableDatabase();

        ContentValues content1 = new ContentValues();
        content1.put(Utilidades.CAMPO_ID, Integer.toString(userid));

        admin.execSQL("SELECT "+Utilidades.CAMPO_EMAIL+", "+ Utilidades.CAMPO_PASSWORD+" FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_ID+"="+content1);
    }

    public static void deleteAccount(Context context, int userid){
        Database database = new Database(context,"bd_usuarios" ,null,1);
        SQLiteDatabase admin = database.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(Utilidades.CAMPO_IDC, Integer.toString(userid));

        admin.execSQL("DELETE FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_ID+"="+content);
    }
}
