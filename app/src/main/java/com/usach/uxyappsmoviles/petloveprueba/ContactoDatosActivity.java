package com.usach.uxyappsmoviles.petloveprueba;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ContactoDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_datos);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Datos de contacto");
        actionBar.setDisplayHomeAsUpEnabled(true);

        String nombreMascota = getIntent().getStringExtra("nombreMascota");
        int imagenMascota = getIntent().getIntExtra("imagenMascota",0);
        String emailMascota = getIntent().getStringExtra("emailMascota");
        String dueñoMascota = getIntent().getStringExtra("dueñoMascota");
        String telefonoMascota = getIntent().getStringExtra("telefonoMascota");
        String ubicacionMascota = getIntent().getStringExtra("ubicacionMascota");

        TextView nombreMascotatv = (TextView) findViewById(R.id.nombrePerfilMascota);
        nombreMascotatv.setText(nombreMascota);

        TextView emailMascotatv = (TextView) findViewById(R.id.email1Contacto);
        emailMascotatv.setText(emailMascota);

        TextView dueñoMascotatv = (TextView) findViewById(R.id.dueño);
        dueñoMascotatv.setText(dueñoMascota);

        TextView telefonoMascotatv = (TextView) findViewById(R.id.telefono1);
        telefonoMascotatv.setText(PhoneNumberUtils.formatNumber(telefonoMascota));

        TextView ubicacionMascotatv = (TextView) findViewById(R.id.dueñoUbicacion);
        ubicacionMascotatv.setText(ubicacionMascota);

        ImageView imagenPerfil = (ImageView) findViewById(R.id.imagenPerfilContacto);
        imagenPerfil.setImageResource(imagenMascota);

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
