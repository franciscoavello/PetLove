package com.usach.uxyappsmoviles.petloveprueba;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditarMascotaActivity extends AppCompatActivity {

    int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_mascota);
         ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Editar mascota");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        posicion = intent.getExtras().getInt("posicion");
        final String nombre = intent.getExtras().getString("nombreEditarMascota");
        String raza = intent.getExtras().getString("razaEditarMascota");
        int edad = intent.getExtras().getInt("edadEditarMascota");
        String descripcion = intent.getExtras().getString("descripcionEditarMascota");

        EditText nombreEditar = (EditText) findViewById(R.id.nombreEditarMascota);
        EditText razaEditar = (EditText) findViewById(R.id.razaEditarMascota);
        EditText edadEditar = (EditText) findViewById(R.id.edadEditarMascota);
        EditText descripcionEditar = (EditText) findViewById(R.id.descripcionEditarMascota);

        nombreEditar.setText(nombre);
        razaEditar.setText(raza);
        edadEditar.setText(Integer.toString(edad));
        descripcionEditar.setText(descripcion);

        Button guardarCambios = (Button) findViewById(R.id.editarMascotaButton);
        guardarCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nombreEditar = (EditText) findViewById(R.id.nombreEditarMascota);
                EditText razaEditar = (EditText) findViewById(R.id.razaEditarMascota);
                EditText edadEditar = (EditText) findViewById(R.id.edadEditarMascota);
                EditText descripcionEditar = (EditText) findViewById(R.id.descripcionEditarMascota);
                ((MyApplication) getApplication()).getUserSesion().getMascotasUsuario().get(posicion).setNombreMascota(nombreEditar.getText().toString());
                ((MyApplication) getApplication()).getUserSesion().getMascotasUsuario().get(posicion).setRazaMascota(razaEditar.getText().toString());
                ((MyApplication) getApplication()).getUserSesion().getMascotasUsuario().get(posicion).setEdadMascota(Integer.parseInt(edadEditar.getText().toString()));
                ((MyApplication) getApplication()).getUserSesion().getMascotasUsuario().get(posicion).setDescripcionMascota(descripcionEditar.getText().toString());
                setResult(1);
                finish();

            }
        });
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

    @Override
    public void onBackPressed() {
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
    }
}
