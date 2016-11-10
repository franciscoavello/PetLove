package com.usach.uxyappsmoviles.petloveprueba;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InformacionMascotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_mascota);
        String nombreMascota = getIntent().getStringExtra("nombreMascota");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(nombreMascota);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
