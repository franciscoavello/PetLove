package com.usach.uxyappsmoviles.petloveprueba.modelos;

import java.util.ArrayList;

public class Usuario {
    private String nombreUsuario;
    private String apellidoPaternoUsuario;
    private int edadUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private int telefonoUsuario;
    private String calleUsuario;
    private String numeroCasaUsuario;
    private String comunaUsuario;
    private String ciudadUsuario;
    private String paisUsuario;
    private ArrayList<Mascota> mascotasUsuario;

    public Usuario(String nombreUsuario, String apellidoPaternoUsuario, int edadUsuario, String emailUsuario, String passwordUsuario, int telefonoUsuario, String calleUsuario, String numeroCasaUsuario, String comunaUsuario, String ciudadUsuario, String paisUsuario, ArrayList<Mascota> mascotasUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
        this.edadUsuario = edadUsuario;
        this.emailUsuario = emailUsuario;
        this.passwordUsuario = passwordUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.calleUsuario = calleUsuario;
        this.numeroCasaUsuario = numeroCasaUsuario;
        this.comunaUsuario = comunaUsuario;
        this.ciudadUsuario = ciudadUsuario;
        this.paisUsuario = paisUsuario;
        this.mascotasUsuario = mascotasUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaternoUsuario() {
        return apellidoPaternoUsuario;
    }

    public void setApellidoPaternoUsuario(String apellidoPaternoUsuario) {
        this.apellidoPaternoUsuario = apellidoPaternoUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCalleUsuario() {
        return calleUsuario;
    }

    public void setCalleUsuario(String calleUsuario) {
        this.calleUsuario = calleUsuario;
    }

    public String getNumeroCasaUsuario() {
        return numeroCasaUsuario;
    }

    public void setNumeroCasaUsuario(String numeroCasaUsuario) {
        this.numeroCasaUsuario = numeroCasaUsuario;
    }

    public String getComunaUsuario() {
        return comunaUsuario;
    }

    public void setComunaUsuario(String comunaUsuario) {
        this.comunaUsuario = comunaUsuario;
    }

    public String getCiudadUsuario() {
        return ciudadUsuario;
    }

    public void setCiudadUsuario(String ciudadUsuario) {
        this.ciudadUsuario = ciudadUsuario;
    }

    public String getPaisUsuario() {
        return paisUsuario;
    }

    public void setPaisUsuario(String paisUsuario) {
        this.paisUsuario = paisUsuario;
    }

    public ArrayList<Mascota> getMascotasUsuario() {
        return mascotasUsuario;
    }

    public void setMascotasUsuario(ArrayList<Mascota> mascotasUsuario) {
        this.mascotasUsuario = mascotasUsuario;
    }
}
