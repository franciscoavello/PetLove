package com.usach.uxyappsmoviles.petloveprueba.modelos;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Francisco Avello on 05-12-2016.
 */

public class Mascota {

    private String nombreMascota;
    private String tipoMascota;
    private String razaMascota;
    private int edadMascota;
    private ArrayList<String> fotosMascota;
    private String descripcionMascota;

    public Mascota(String nombreMascota, String tipoMascota, String razaMascota, int edadMascota, ArrayList<String> fotosMascota, String descripcionMascota) {
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.razaMascota = razaMascota;
        this.edadMascota = edadMascota;
        this.fotosMascota = fotosMascota;
        this.descripcionMascota = descripcionMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public int getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(int edadMascota) {
        this.edadMascota = edadMascota;
    }

    public ArrayList<String> getFotosMascota() {
        return fotosMascota;
    }

    public void setFotosMascota(ArrayList<String> fotosMascota) {
        this.fotosMascota = fotosMascota;
    }

    public String getDescripcionMascota() {
        return descripcionMascota;
    }

    public void setDescripcionMascota(String descripcionMascota) {
        this.descripcionMascota = descripcionMascota;
    }
}
