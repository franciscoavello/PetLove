package com.usach.uxyappsmoviles.petloveprueba;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        android.support.v7.widget.AppCompatButton logear = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btn_login);
        logear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.AppTheme_Dark_Dialog);
                progressDialog.setMessage("Iniciando sesión");
                progressDialog.show(); */
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
