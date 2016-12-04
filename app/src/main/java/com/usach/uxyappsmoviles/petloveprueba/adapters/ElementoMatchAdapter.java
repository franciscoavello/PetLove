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

/**
 * Created by Francisco Avello on 02-12-2016.
 */

public class ElementoMatchAdapter extends ArrayAdapter<ElementoMatch> {

    public ElementoMatchAdapter(Context context, List<ElementoMatch> datos) {
        super(context, 0, datos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ElementoMatch elementoMatch = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout, parent, false);
        }
        // Lookup view for data population
        ImageView matchImagen = (ImageView) convertView.findViewById(R.id.imagenElementoLista);
        TextView matchNombre = (TextView) convertView.findViewById(R.id.nombreMascotaMatch);
        TextView matchFecha = (TextView) convertView.findViewById(R.id.fechaMatch);
        TextView matchUbicacion = (TextView) convertView.findViewById(R.id.ubicacionMatch);

        // Populate the data into the template view using the data object
        matchImagen.setImageResource(elementoMatch.getImagenMascota());
        matchNombre.setText(elementoMatch.getNombreMascota());
        matchFecha.setText(elementoMatch.getFecha().toString());
        matchUbicacion.setText(elementoMatch.getUbicacion());

        // Return the completed view to render on screen
        return convertView;
    }

}
