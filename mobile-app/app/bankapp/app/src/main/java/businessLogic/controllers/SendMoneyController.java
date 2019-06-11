package businessLogic.controllers;


import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentValues;
import android.content.Intent;
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
import com.example.bank_app.ui.login.LoggedInUserView;
import com.example.bank_app.ui.login.LoginFormState;
import com.example.bank_app.ui.login.LoginResult;
import com.example.bank_app.ui.login.LoginViewModel;
import com.example.bank_app.ui.login.LoginViewModelFactory;
import com.example.bank_app.utilidades.Utilidades;

import java.util.Calendar;

import dataAccess.database.Database;
import presentation.R;

import static dataAccess.repositories.AccountRepository.createAccount;
import static dataAccess.repositories.UserRepository.createUsuario;

import dataAccess.models.Account;

import static dataAccess.repositories.AccountRepository.readAccount;
import static dataAccess.repositories.AccountRepository.updateAccount;
import static dataAccess.repositories.TransactionRepository.createTransaction;



public class SendMoneyController extends AppCompatActivity{
    private int idSend, idReceive, amount;

    private Account a1, a2;

    private boolean CanSend;

    public SendMoneyController(int idSend, int idReceive, int amount) {
        this.idSend = idSend;
        this.idReceive = idReceive;
        this.amount = amount;
    }

    public void sendmoney(){
        Calendar c1 = Calendar.getInstance();

        a1 = readAccount(this, idSend);

        if (a1.getSaldo() >= amount){
            a2 = readAccount(this, idReceive);
            updateAccount(this, Integer.toString(idSend), a1.getSaldo() - amount);
            updateAccount(this, Integer.toString(idReceive), a2.getSaldo() + amount);
            createTransaction(this, 1, Integer.toString(idSend), Integer.toString(idReceive),c1.get(Calendar.DATE), c1.get(Calendar.MONTH), c1.get(Calendar.YEAR),amount);
            CanSend = true;
        }
        else CanSend = false;
    }

    public boolean getCS(){
        return CanSend;
    }

}
