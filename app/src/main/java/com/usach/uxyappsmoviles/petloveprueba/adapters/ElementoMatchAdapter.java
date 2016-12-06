package com.usach.uxyappsmoviles.petloveprueba.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.modelos.ElementoMatch;

import java.util.List;

public class ElementoMatchAdapter extends ArrayAdapter<ElementoMatch> {

    public ElementoMatchAdapter(Context context, List<ElementoMatch> datos) {
        super(context, 0, datos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ElementoMatch elementoMatch = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        }
        ImageView matchImagen = (ImageView) convertView.findViewById(R.id.imagenElementoLista);
        TextView matchNombre = (TextView) convertView.findViewById(R.id.nombreMascotaMatch);
        TextView matchFecha = (TextView) convertView.findViewById(R.id.fechaMatch);
        TextView matchUbicacion = (TextView) convertView.findViewById(R.id.ubicacionMatch);

        matchImagen.setImageResource(elementoMatch.getImagenMascota());
        matchNombre.setText(elementoMatch.getNombreMascota());
        matchFecha.setText(elementoMatch.getFecha().toString());
        matchUbicacion.setText(elementoMatch.getUbicacion());

        return convertView;
    }

}
