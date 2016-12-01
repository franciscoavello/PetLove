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
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Tarjeta tarjeta = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.tarjetas_swipe, parent, false);
        }
        // Lookup view for data population
        TextView tvNombre = (TextView) convertView.findViewById(R.id.labelMascota);
        TextView tvDescripcion = (TextView) convertView.findViewById(R.id.descripcionMascota);
        ImageView tvImagen = (ImageView) convertView.findViewById(R.id.imagenMascota);
        // Populate the data into the template view using the data object
        tvNombre.setText(tarjeta.getNombreMascota());
        tvDescripcion.setText(tarjeta.getDescripcionMascota());
        tvImagen.setImageResource(tarjeta.getImagenMascota());
        // Return the completed view to render on screen
        return convertView;
    }

    public class ViewHolder{
        public ImageView imageView;
        public TextView txtNombre;
        public TextView txtDescripcion;
    }
}
