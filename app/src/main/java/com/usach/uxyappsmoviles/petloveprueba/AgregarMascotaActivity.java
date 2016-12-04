package com.usach.uxyappsmoviles.petloveprueba;

import android.content.DialogInterface;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.FrameLayout;

public class AgregarMascotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Agregar mascota");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        FrameLayout layoutFotos = (FrameLayout) findViewById(R.id.frameLayoutFotosMascota);
        android.view.ViewGroup.LayoutParams layoutParams = layoutFotos.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = (int) width * 7/10;
    }


    @Override
    public boolean onSupportNavigateUp(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("No se han guardado los cambios. ¿Estás seguro que quieres salir?")
                .setTitle("Aviso");
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
            }
        });
        builder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogo1, int id) {
                finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        return true;
    }
}
