package com.usach.uxyappsmoviles.petloveprueba.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Mascota;

import java.util.ArrayList;

public class GridViewMascotasAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<Mascota> datos;
    private final static int RESULTADO_EDITAR= 0;


    public GridViewMascotasAdapter(Context context, ArrayList<Mascota> datos)
    {
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater inflater = ((Activity) ctx).getLayoutInflater();
        convertView = inflater.inflate(R.layout.grid_mascotas, parent, false);

        TextView mascotaNombre = (TextView) convertView.findViewById(R.id.nombreMascotaPerfil);
        mascotaNombre.setText(datos.get(position).getNombreMascota());

        ImageView mascotaImagen = (ImageView) convertView.findViewById(R.id.mascota);

        Resources res = ctx.getResources();
        int resID = res.getIdentifier(datos.get(position).getFotosMascota().get(0), "drawable", ctx.getPackageName());
        Drawable drawable = res.getDrawable(resID );
        mascotaImagen.setImageDrawable(drawable );

        ImageButton eliminarBoton = (ImageButton) convertView.findViewById(R.id.eliminarMascotaPerfilBoton);

        eliminarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrar = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);
                vibrar.vibrate(100);
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
