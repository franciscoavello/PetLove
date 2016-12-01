package com.usach.uxyappsmoviles.petloveprueba.modelos;

/**
 * Created by Francisco Avello on 01-12-2016.
 */

public class Tarjeta {

    private String nombreMascota;
    private String descripcionMascota;
    private int imagenMascota;

    public Tarjeta(String nombreMascota, String descripcionMascota, int imagenMascota) {
        this.nombreMascota = nombreMascota;
        this.descripcionMascota = descripcionMascota;
        this.imagenMascota = imagenMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getDescripcionMascota() {
        return descripcionMascota;
    }

    public void setDescripcionMascota(String descripcionMascota) {
        this.descripcionMascota = descripcionMascota;
    }

    public int getImagenMascota() {
        return imagenMascota;
    }

    public void setImagenMascota(int imagenMascota) {
        this.imagenMascota = imagenMascota;
    }
}
