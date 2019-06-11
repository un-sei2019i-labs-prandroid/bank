package presentation.activities;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bank_app.ConexionSQLiteHelper;
import com.example.bank_app.utilidades.Utilidades;

import businessLogic.controllers.SendMoneyController;
import dataAccess.database.Database;
import presentation.R;


public class SendMoneyActivity extends AppCompatActivity{

    public static int id_user_send;



    EditText id, amount;

    Database db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendmoney);

        id = (EditText) findViewById(R.id.id);
        amount =(EditText) findViewById(R.id.amount);

        db = new Database(getApplicationContext(), "bd_cuentas", null, 1);


    }

    public void onClick(View view){
        if(view.getId() == R.id.button) {
            SendMoneyController sm = new SendMoneyController(id_user_send, Integer.parseInt(id.getText().toString()), Integer.parseInt(amount.getText().toString()), db);
            sm.sendmoney();
            if (sm.getCS()) {
                Toast.makeText(getApplicationContext(), "MONEY SENT.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "PLEASE ENTER LESS MONEY.", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
