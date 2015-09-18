package com.emjorge.brunaniver;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.emjorge.brunaniver.persistencia.LoginDAO;

public class LoginActivity extends Activity {
    protected EditText textEditSenha =null;
    protected TextView textViewLogin = null;
    protected LoginDAO loginDAO=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginDAO = new LoginDAO(this);
        setContentView(R.layout.activity_loginv1);
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textEditSenha = (EditText) findViewById(R.id.editTextSenha);

        if (loginDAO.getSenha()!=null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("senha", textEditSenha.getText().toString());




                    if (textEditSenha.getText().toString().equals("1515")) {
                        loginDAO.salvar("1515");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        textViewLogin.setText("Senha Inválida");
                    }


            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        textViewLogin.setText("");
    }


}
