package com.usach.uxyappsmoviles.petloveprueba;

import android.app.Application;

import com.usach.uxyappsmoviles.petloveprueba.modelos.Usuario;

//Clase para tener los datos del usuario que inició sesión durante toda la ejecución

public class MyApplication extends Application {

    private Usuario userSesion;

    public Usuario getUserSesion() {
        return userSesion;
    }

    public void setUserSesion(Usuario userSesion) {
        this.userSesion = userSesion;
    }
}