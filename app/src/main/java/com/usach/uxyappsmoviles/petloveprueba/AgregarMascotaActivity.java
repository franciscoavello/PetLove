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

import com.usach.uxyappsmoviles.petloveprueba.modelos.Mascota;

import java.util.ArrayList;
import java.util.Random;

public class AgregarMascotaActivity extends AppCompatActivity {


    public boolean validar() {
        boolean valid = true;

        EditText nombreNMascota = (EditText) findViewById(R.id.nombreNuevaMascota);
        String nombreNMascotaIngresado = nombreNMascota.getText().toString();
        EditText razaNMascota = (EditText) findViewById(R.id.razaNuevaMascota);
        String razaNMascotaIngresado = razaNMascota.getText().toString();
        EditText edadNMascota = (EditText) findViewById(R.id.edadNuevaMascota);
        String edadNMascotaIngresado = edadNMascota.getText().toString();
        EditText descripcionNMascota = (EditText) findViewById(R.id.descripcionNuevaMascota);
        String descripcionNMascotaIngresado = descripcionNMascota.getText().toString();

        if (nombreNMascotaIngresado.isEmpty()) {
            nombreNMascota.setError("Ingresa el nombre de su mascota");
            valid = false;
        } else {
            nombreNMascota.setError(null);
        }
        if (razaNMascotaIngresado.isEmpty()) {
            razaNMascota.setError("Ingresa la raza de su mascota");
            valid = false;
        } else {
            razaNMascota.setError(null);
        }
        if (edadNMascotaIngresado.isEmpty()) {
            edadNMascota.setError("Ingresa la edad de su mascota");
            valid = false;
        } else {
            edadNMascota.setError(null);
        }
        if (descripcionNMascotaIngresado.isEmpty()) {
            descripcionNMascota.setError("Ingresa la descripción de su mascota");
            valid = false;
        } else {
            descripcionNMascota.setError(null);
        }

        return valid;
    }


    public void agregar() {

        if (!validar()) {
            return;
        }

        EditText nombreNMascota = (EditText) findViewById(R.id.nombreNuevaMascota);
        String nombreNMascotaIngresado = nombreNMascota.getText().toString();
        EditText razaNMascota = (EditText) findViewById(R.id.razaNuevaMascota);
        String razaNMascotaIngresado = razaNMascota.getText().toString();
        EditText edadNMascota = (EditText) findViewById(R.id.edadNuevaMascota);
        String edadNMascotaIngresado = edadNMascota.getText().toString();
        EditText descripcionNMascota = (EditText) findViewById(R.id.descripcionNuevaMascota);
        String descripcionNMascotaIngresado = descripcionNMascota.getText().toString();

        ArrayList<String> fotosNueva = new ArrayList<>();

        Random rn = new Random();
        int range = 6 - 1 + 1;
        int randomNum =  rn.nextInt(range) + 1;
        fotosNueva.add("perro0"+randomNum);

        Mascota nueva = new Mascota(nombreNMascotaIngresado,"perro",razaNMascotaIngresado, Integer.parseInt(edadNMascotaIngresado),fotosNueva,descripcionNMascotaIngresado);

        ((MyApplication) getApplication()).getUserSesion().getMascotasUsuario().add(nueva);

        setResult(1);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_mascota);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Agregar mascota");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Button botonAgregar = (Button) findViewById(R.id.agregarMascotaButton);
        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregar();
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
