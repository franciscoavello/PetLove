package layout;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.usach.uxyappsmoviles.petloveprueba.InformacionMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.adapters.TarjetaAdapter;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Tarjeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.R.style.Animation;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link BuscarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuscarFragment extends Fragment {


    ArrayList<String> nombresArray;
    ArrayList<String> lugaresArray;
    ArrayList<String> imagenesArray;
    TarjetaAdapter arrayAdapter;
    private ArrayList<Tarjeta> listaTarjetas;

    int i=0;

    public void llenarTarjetas(){
        Tarjeta tarjeta = new Tarjeta("ENSERUI","Probando",R.drawable.perro01);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("ENSERfdfdUI","Prfdfdfobando",R.drawable.perro02);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("sdf","rerewrwe",R.drawable.perro03);
        listaTarjetas.add(tarjeta);


        tarjeta = new Tarjeta("er","erwww",R.drawable.perro04);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("sdqdwq","er",R.drawable.perro05);
        listaTarjetas.add(tarjeta);

    }

    public BuscarFragment() {
        // Required empty public constructor
    }


    public static BuscarFragment newInstance() {
        BuscarFragment fragment = new BuscarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_buscar, container, false);



/*
        com.github.siyamed.shapeimageview.RoundedImageView imagenBuscar = (com.github.siyamed.shapeimageview.RoundedImageView) view.findViewById(R.id.imagenMascota);
        imagenBuscar.setTag(R.drawable.perro_jugando);
        imagenBuscar.setImageResource(R.drawable.perro_jugando);



        final ImageButton likeButon = (ImageButton) view.findViewById(R.id.likeMascotaBoton);

        likeButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(e.getAction() == MotionEvent.ACTION_UP){

                    final ImageView imagenMasco = (ImageView) view.findViewById(R.id.imagenMascota);
                    final RelativeLayout relavImagen = (RelativeLayout) view.findViewById(R.id.imagenLayout);
                    final TextView nombreMasco = (TextView) view.findViewById(R.id.nombreMascotaBuscar);
                    final TextView lugarMasco = (TextView) view.findViewById(R.id.descripcionMascota);

                    Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                    imagenMasco.startAnimation(fadeOut);
                    relavImagen.startAnimation(fadeOut);

                    fadeOut.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            TypedArray images = getResources().obtainTypedArray(R.array.imagenesPrueba);
                            String[] nombres = getResources().getStringArray(R.array.nombresPerros);
                            String[] lugares = getResources().getStringArray(R.array.lugares);
                            int random = (int) (Math.random() * images.length());
                            imagenMasco.setImageResource(images.getResourceId(random, R.drawable.perro01));
                            imagenMasco.setTag(images.getResourceId(random, R.drawable.perro01));
                            nombreMasco.setText(nombres[random]);
                            lugarMasco.setText(lugares[random]);
                            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
                            imagenMasco.startAnimation(fadeIn);
                            relavImagen.startAnimation(fadeIn);
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });

                }

                return false;
            }
        });


        final ImageButton siguienteBoton = (ImageButton) view.findViewById(R.id.siguienteMascotaBoton);

        siguienteBoton.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(e.getAction() == MotionEvent.ACTION_UP){

                    final ImageView imagenMasco = (ImageView) view.findViewById(R.id.imagenMascota);
                    final RelativeLayout relavImagen = (RelativeLayout) view.findViewById(R.id.imagenLayout);
                    final TextView nombreMasco = (TextView) view.findViewById(R.id.nombreMascotaBuscar);
                    final TextView lugarMasco = (TextView) view.findViewById(R.id.descripcionMascota);

                    Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                    imagenMasco.startAnimation(fadeOut);
                    relavImagen.startAnimation(fadeOut);

                    fadeOut.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                        }
                        @Override
                        public void onAnimationEnd(Animation animation) {
                            TypedArray images = getResources().obtainTypedArray(R.array.imagenesPrueba);
                            String[] nombres = getResources().getStringArray(R.array.nombresPerros);
                            String[] lugares = getResources().getStringArray(R.array.lugares);
                            int random = (int) (Math.random() * images.length());
                            imagenMasco.setImageResource(images.getResourceId(random, R.drawable.perro01));
                            imagenMasco.setTag(images.getResourceId(random, R.drawable.perro01));
                            nombreMasco.setText(nombres[random]);
                            lugarMasco.setText(lugares[random]);
                            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
                            imagenMasco.startAnimation(fadeIn);
                            relavImagen.startAnimation(fadeIn);
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });

                }

                return false;
            }
        });

*/



        //add the view via xml or programmatically
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.frame);

        listaTarjetas = new ArrayList<Tarjeta>();
        llenarTarjetas();

        //choose your favorite adapter
        arrayAdapter = new TarjetaAdapter(getActivity(), listaTarjetas);

        //set the listener and the adapter
        //flingContainer.setAdapter(adapter);
        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                listaTarjetas.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                Toast.makeText(getActivity(), "Siguiente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(getActivity(), "Like", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                Tarjeta tarjeta = new Tarjeta("ENSERUI","Probando",R.drawable.perro05);
                listaTarjetas.add(tarjeta);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(float v) {

            }
        });

        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Intent intent = new Intent(getActivity(), InformacionMascotaActivity.class);
                TextView nombreMascotaIntent = (TextView) view.findViewById(R.id.labelMascota);
                TextView ubicacionMascotaIntent = (TextView) view.findViewById(R.id.descripcionMascota);
                com.github.siyamed.shapeimageview.RoundedImageView imagenMascotaIntent = (com.github.siyamed.shapeimageview.RoundedImageView) view.findViewById(R.id.imagenMascota);
                Tarjeta tarjeta = (Tarjeta) dataObject;
                intent.putExtra("nombreMascota",tarjeta.getNombreMascota());
                intent.putExtra("imagenMascota",tarjeta.getImagenMascota());
                intent.putExtra("ubicacionMascota", tarjeta.getDescripcionMascota());
                startActivity(intent);
            }
        });



        return view;
    }

    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
