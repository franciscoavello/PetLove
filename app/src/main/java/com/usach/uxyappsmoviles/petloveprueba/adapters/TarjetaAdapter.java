package com.usach.uxyappsmoviles.petloveprueba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Tarjeta;
import java.util.List;

public class TarjetaAdapter extends ArrayAdapter<Tarjeta> {

    public TarjetaAdapter(Context context, List<Tarjeta> datos) {
        super(context, 0, datos);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Tarjeta tarjeta = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tarjetas_swipe, parent, false);
        }
        TextView tvNombre = (TextView) convertView.findViewById(R.id.labelMascota);
        TextView tvDescripcion = (TextView) convertView.findViewById(R.id.descripcionMascota);
        ImageView tvImagen = (ImageView) convertView.findViewById(R.id.imagenMascota);
        tvNombre.setText(tarjeta.getNombreMascota());
        tvDescripcion.setText(tarjeta.getDescripcionMascota());
        tvImagen.setImageResource(tarjeta.getImagenMascota());

        return convertView;
    }
}
