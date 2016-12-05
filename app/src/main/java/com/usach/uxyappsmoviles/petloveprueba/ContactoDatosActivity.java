package com.usach.uxyappsmoviles.petloveprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.usach.uxyappsmoviles.petloveprueba.adapters.TarjetaAdapter;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Tarjeta;

import java.util.ArrayList;

import in.arjsna.swipecardlib.SwipeCardView;

public class ContactoDatosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_datos);

    }
}
