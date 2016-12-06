package com.usach.uxyappsmoviles.petloveprueba;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.usach.uxyappsmoviles.petloveprueba.modelos.Mascota;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private Usuario user;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        android.support.v7.widget.AppCompatButton logear = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btn_login);
        logear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });
    }


    public void onLoginSuccess(final int id) {
        android.support.v7.widget.AppCompatButton logear = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btn_login);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("idUser",id);

        new android.os.Handler().post(
                new Runnable() {
                    public void run() {

                        try {
                            String json = "[\n" +
                                    "  {\n" +
                                    "    'id_user': 1,\n" +
                                    "    'datos': {\n" +
                                    "      'nombres': 'Francisco',\n" +
                                    "      'apellidos': 'Avello',\n" +
                                    "      'edad': 23,\n" +
                                    "      'correo': 'admin@admin.cl',\n" +
                                    "      'password': 'admin',\n" +
                                    "      'telefono': 56995045678,\n" +
                                    "      'numero': '931',\n" +
                                    "      'calle': 'Pasaje Cerro Huemul',\n" +
                                    "      'comuna': 'Maipu',\n" +
                                    "      'villa': 'Pehuen 1',\t\n" +
                                    "      'ciudad': 'Santiago',\n" +
                                    "      'pais': 'Chile'\n" +
                                    "    },\n" +
                                    "    'mascotas': [\n" +
                                    "      {\n" +
                                    "        'nombre': 'Cachupin', \n" +
                                    "        'tipo': 'Perro', \n" +
                                    "        'raza': 'Beagle', \n" +
                                    "        'edad': '4', \n" +
                                    "        'fotos': {\n" +
                                    "          'foto1': 'perro01',          \n" +
                                    "          'foto2': 'perro02'\n" +
                                    "        }\n" +
                                    "        ,\n" +
                                    "        'descripcion': 'Perro bastante jugueton y mañoso para comer. Le gusta dormir sobre los sillones.'\n" +
                                    "      },\n" +
                                    "      {\n" +
                            "        'nombre': 'Boby',\n" +
                                    "        'tipo': 'Perro',\n" +
                                    "        'raza': 'Pastor Aleman',\n" +
                                    "        'edad': '2',\n" +
                                    "        'fotos': {\n" +
                                    "          'foto1': 'perro03',\n" +
                                    "          'foto2': 'perro04'\n" +
                                    "        },\n" +
                                    "        'descripcion': 'Perro bastante docil y amante de los juguetes. Come sus comidas al dia y no es tan inquieto como parece.'\n" +
                                    "      },\n" +
                                    "      {\n" +
                                    "        'nombre': 'Alby',\n"   +
                                    "        'tipo': 'Perro',\n" +
                                    "        'raza': 'Cooker',\n" +
                                    "        'edad': '4',\n" +
                                    "        'fotos': {\n" +
                                    "          'foto1': 'perro06',\n" +
                                    "          'foto2': 'perro05'\n" +
                                    "        },\n" +
                                    "        'descripcion': 'Perro bastante docil y amante de los juguetes. Come sus comidas al dia y no es tan inquieto como parece.'\n" +
                                    "      }\n" +

                                    "    ]\n" +
                                    "  }\n" +
                                    "  ]";

                            JSONArray jsonArray= new JSONArray(json);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int id_user = jsonObject.getInt("id_user");
                                if(id_user == id){
                                    JSONObject datosUser = jsonObject.getJSONObject("datos");
                                    String nombreUser = datosUser.getString("nombres");
                                    String apellidosUser = datosUser.getString("apellidos");
                                    int edadUser = datosUser.getInt("edad");
                                    String correoUser = datosUser.getString("correo");
                                    String passwordUser = datosUser.getString("password");
                                    int telefonoUser = datosUser.getInt("telefono");
                                    String numeroCasaUser = datosUser.getString("numero");
                                    String calleUser = datosUser.getString("calle");
                                    String comunaUser = datosUser.getString("comuna");
                                    String villaUser = datosUser.getString("villa");
                                    String ciudadUser = datosUser.getString("ciudad");
                                    String paisUser = datosUser.getString("pais");
                                    JSONArray mascotasUser = jsonObject.getJSONArray("mascotas");
                                    ArrayList<Mascota> mascotasUsuario = new ArrayList<Mascota>();
                                    Mascota mascota;
                                    for (int j = 0; j < mascotasUser.length(); j++) {
                                        JSONObject mascotaObject = mascotasUser.getJSONObject(j);
                                        String nombreMascota = mascotaObject.getString("nombre");
                                        String tipoMascota = mascotaObject.getString("tipo");
                                        String razaMascota = mascotaObject.getString("raza");
                                        int edadMascota = mascotaObject.getInt("edad");
                                        String descripcionMascota = mascotaObject.getString("descripcion");
                                        JSONObject fotosMascota = mascotaObject.getJSONObject("fotos");
                                        ArrayList<String> fotos = new ArrayList<String>();
                                        String foto = fotosMascota.getString("foto1");
                                        String foto2 = fotosMascota.getString("foto1");
                                        fotos.add(foto);
                                        fotos.add(foto2);
                                        mascota = new Mascota(nombreMascota,tipoMascota,razaMascota,edadMascota,fotos,descripcionMascota);
                                        mascotasUsuario.add(mascota);
                                    }


                                    user = new Usuario(nombreUser,apellidosUser,edadUser,correoUser,passwordUser,telefonoUser,calleUser,numeroCasaUser,comunaUser,ciudadUser,paisUser,mascotasUsuario);
                                    ((MyApplication) getApplication()).setUserSesion(user);
                                    break;
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });
        startActivity(intent);
        progressDialog.dismiss();
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "¡Error! Correo y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
        android.support.v7.widget.AppCompatButton logear = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btn_login);
        logear.setEnabled(true);
        progressDialog.dismiss();
    }

    public void login() {

        if (!validate()) {
            onLoginFailed();
            return;
        }

        android.support.v7.widget.AppCompatButton logear = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btn_login);
        logear.setEnabled(false);

        progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Iniciando sesión...");
        progressDialog.show();

        EditText emailUsuarioET = (EditText) findViewById(R.id.emailUsuario);
        final String emailUsuarioIngresado = emailUsuarioET.getText().toString();
        EditText passUsuarioET = (EditText) findViewById(R.id.contrasenaUsuario);
        final String passwordUsuarioIngresado = passUsuarioET.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        try {
                            String json = "[{'id':'2','email':'admin@admin.cl','contrasena':'admin'},{'id':'1','email':'francisco.avello@usach.cl','contrasena':'admin'}]";
                            JSONArray jsonArray = new JSONArray(json);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String email = jsonObject.getString("email");
                                String contra = jsonObject.getString("contrasena");
                                if((emailUsuarioIngresado.contentEquals(email)) && passwordUsuarioIngresado.contentEquals(contra)){
                                    onLoginSuccess(id);
                                    break;
                                }
                                else if (i==jsonArray.length()-1){
                                    onLoginFailed();
                                    Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                                    v.vibrate(200);
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        }
                }, 3000);
    }

    public boolean validate() {
        boolean valid = true;

        EditText emailUsuarioET = (EditText) findViewById(R.id.emailUsuario);
        String emailUsuarioIngresado = emailUsuarioET.getText().toString();
        EditText passUsuarioET = (EditText) findViewById(R.id.contrasenaUsuario);
        String passwordUsuarioIngresado = passUsuarioET.getText().toString();

        if (emailUsuarioIngresado.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(emailUsuarioIngresado).matches()) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(200);
            emailUsuarioET.setError("Ingresa un nombre de usuario válido");
            valid = false;
        } else {
            emailUsuarioET.setError(null);
        }

        if (passwordUsuarioIngresado.isEmpty() || passwordUsuarioIngresado.length() < 4 || passwordUsuarioIngresado.length() > 12) {
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(200);
            passUsuarioET.setError("Tiene que ser de entre 4 a 12 caracteres");
            valid = false;
        } else {
            passUsuarioET.setError(null);
        }
        return valid;
    }
}
