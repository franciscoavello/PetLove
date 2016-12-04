package com.usach.uxyappsmoviles.petloveprueba.modelos;

import java.util.Date;

/**
 * Created by Francisco Avello on 02-12-2016.
 */

public class ElementoMatch {

    private String nombreMascota;
    private String nombreDueño;
    private int imagenMascota;
    private String ubicacion;
    private String email;
    private String telefono;
    private Date fecha;


    public ElementoMatch(String nombreMascota, String nombreDueño, int imagenMascota, String ubicacion, String email, String telefono, Date fecha) {
        this.nombreMascota = nombreMascota;
        this.nombreDueño = nombreDueño;
        this.imagenMascota = imagenMascota;
        this.ubicacion = ubicacion;
        this.email = email;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public int getImagenMascota() {
        return imagenMascota;
    }

    public void setImagenMascota(int imagenMascota) {
        this.imagenMascota = imagenMascota;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
