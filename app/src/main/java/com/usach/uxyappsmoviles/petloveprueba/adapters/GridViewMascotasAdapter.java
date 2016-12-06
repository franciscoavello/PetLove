package com.usach.uxyappsmoviles.petloveprueba.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Mascota;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Francisco Avello on 05-12-2016.
 */

public class GridViewMascotasAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<Mascota> datos;

    public GridViewMascotasAdapter(Context context, ArrayList<Mascota> datos)
    {
        //super(context, 0);
        this.ctx=context;
        this.datos= datos;

    }

    @Override
    public int getCount() {
        return datos.size();
    }

    @Override
    public Object getItem(int position) {
        return datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        //Cargo un Custom Edittext en cada celda
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        convertView = inflater.inflate(R.layout.grid_mascotas, parent, false);

        ImageView mascotaImagen = (ImageView) convertView.findViewById(R.id.mascota);

        Resources res = ctx.getResources();
        int resID = res.getIdentifier(datos.get(position).getFotosMascota().get(0), "drawable", ctx.getPackageName());
        Drawable drawable = res.getDrawable(resID );
        mascotaImagen.setImageDrawable(drawable );

        ImageButton eliminarBoton = (ImageButton) convertView.findViewById(R.id.eliminarMascotaPerfilBoton);

        eliminarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(ctx, R.style.AppTheme_Dark_Dialog));
                builder.setMessage("¿Estás seguro que quieres eliminar a esta mascota?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                datos.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return convertView;
    }

}
