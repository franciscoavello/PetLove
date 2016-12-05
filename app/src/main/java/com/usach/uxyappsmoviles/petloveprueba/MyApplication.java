package com.usach.uxyappsmoviles.petloveprueba;

import android.app.Application;

import com.usach.uxyappsmoviles.petloveprueba.modelos.Usuario;

/**
 * Created by Francisco Avello on 05-12-2016.
 */

public class MyApplication extends Application {

    private Usuario userSesion;

    public Usuario getUserSesion() {
        return userSesion;
    }

    public void setUserSesion(Usuario userSesion) {
        this.userSesion = userSesion;
    }
}