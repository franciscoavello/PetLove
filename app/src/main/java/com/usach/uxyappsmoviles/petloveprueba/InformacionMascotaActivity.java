package com.usach.uxyappsmoviles.petloveprueba;

import android.content.res.TypedArray;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InformacionMascotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_mascota);
        String nombreMascota = getIntent().getStringExtra("nombreMascota");
        String ubicacionMascota = getIntent().getStringExtra("ubicacionMascota");
        int image_link = getIntent().getIntExtra("imagenMascota",0);
        ImageView imagenMascotaIntent = (ImageView) findViewById(R.id.imagenMascotaInfo);
        imagenMascotaIntent.setImageResource(image_link);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(nombreMascota);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        android.view.ViewGroup.LayoutParams layoutParams = imagenMascotaIntent.getLayoutParams();
        layoutParams.height = (int) height * 4/10;

        String[] descripciones = getResources().getStringArray(R.array.descripcionesPerros);

        TextView ubicacionMascotaInfo = (TextView) findViewById(R.id.ubicacionInfo);
        ubicacionMascotaInfo.setText(ubicacionMascota);
        TextView descripcionMascotaInfo = (TextView) findViewById(R.id.descripcionMascotaInfo);
        descripcionMascotaInfo.setText(descripciones[0] + " \ud83d\ude01 \uD83D\uDE01 \uD83D\uDE01");
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
