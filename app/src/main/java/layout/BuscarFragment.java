package layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import com.usach.uxyappsmoviles.petloveprueba.InformacionMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.adapters.TarjetaAdapter;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Tarjeta;

import java.util.ArrayList;

import in.arjsna.swipecardlib.SwipeCardView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link BuscarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuscarFragment extends Fragment {

    TarjetaAdapter arrayAdapter;
    private ArrayList<Tarjeta> listaTarjetas;
    private final static int RESULTADO_INFORMACION = 0;

    private ImageButton likeButon;
    private ImageButton unlikeButon;

    public void llenarTarjetas(){
        Tarjeta tarjeta = new Tarjeta("Kiara","Santiago",R.drawable.perro01);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("Annie","Las Condes",R.drawable.perro02);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("Bambi","Recoleta",R.drawable.perro03);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("Goku","La Cisterna",R.drawable.perro04);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("Toby","Arica",R.drawable.perro05);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("Doki","Punta Arenas",R.drawable.perro06);
        listaTarjetas.add(tarjeta);

        tarjeta = new Tarjeta("Bobby","Rancagua",R.drawable.perro_jugando);
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

        listaTarjetas = new ArrayList<Tarjeta>();
        llenarTarjetas();
        arrayAdapter = new TarjetaAdapter(getActivity(), listaTarjetas);

        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.frame);
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
                //Toast.makeText(getActivity(), "Siguiente", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                //Toast.makeText(getActivity(), "Like", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                Tarjeta tarjeta = new Tarjeta("ENSERUI","Probando",R.drawable.perro05);
                listaTarjetas.add(tarjeta);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScroll(float v) {

            }
        });

        likeButon = (ImageButton) view.findViewById(R.id.likeMascotaBoton);

        likeButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(e.getAction() == MotionEvent.ACTION_UP){
                    SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.frame);
                    flingContainer.getTopCardListener().selectRight();
                }

                return false;
            }
        });

        unlikeButon = (ImageButton) view.findViewById(R.id.siguienteMascotaBoton);

        unlikeButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(e.getAction() == MotionEvent.ACTION_UP){
                    SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) view.findViewById(R.id.frame);
                    flingContainer.getTopCardListener().selectLeft();

                }

                return false;
            }
        });




        // Optionally add an OnItemClickListener
        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                Intent intent = new Intent(getActivity(), InformacionMascotaActivity.class);
                TextView nombreMascotaIntent = (TextView) view.findViewById(R.id.labelMascota);
                TextView ubicacionMascotaIntent = (TextView) view.findViewById(R.id.descripcionMascota);
                ImageView imagenMascotaIntent = (ImageView) view.findViewById(R.id.imagenMascota);
                Tarjeta tarjeta = (Tarjeta) dataObject;
                intent.putExtra("nombreMascota",tarjeta.getNombreMascota());
                intent.putExtra("imagenMascota",tarjeta.getImagenMascota());
                intent.putExtra("ubicacionMascota", tarjeta.getDescripcionMascota());
                startActivityForResult(intent, RESULTADO_INFORMACION);
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULTADO_INFORMACION){
            switch (resultCode) {
                case 1:
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) getView().findViewById(R.id.frame);
                            flingContainer.getTopCardListener().selectRight();
                        }
                    }, 350);
                    break;
                case 2:
                    final Handler handler2 = new Handler();
                    handler2.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            SwipeFlingAdapterView flingContainer2 = (SwipeFlingAdapterView) getView().findViewById(R.id.frame);
                            flingContainer2 .getTopCardListener().selectLeft();
                        }
                    }, 350);
                    break;
                case Activity.RESULT_CANCELED:
                    break;
            }
        }
    }
}
