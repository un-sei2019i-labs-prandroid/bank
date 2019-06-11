package dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_app.ConexionSQLiteHelper;
import com.example.bank_app.utilidades.Utilidades;

public class Database extends ConexionSQLiteHelper {
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_CUENTA);
        db.execSQL(Utilidades.CREAR_TABLA_TRANSACCION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS cuenta");
        db.execSQL("DROP TABLE IF EXISTS transaccion");
        onCreate(db);
    }

}
