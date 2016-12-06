package layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.usach.uxyappsmoviles.petloveprueba.AgregarMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.EditarMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.MyApplication;
import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.adapters.GridViewMascotasAdapter;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Mascota;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PerfilFragment extends Fragment{
    ArrayList<Mascota> mascotas;
    GridViewMascotasAdapter arrayAdapter;
    private final static int RESULTADO_INFORMACION = 0;
    private final static int RESULTADO_EDITAR = 0;

    boolean isImageFitToScreen;
    de.hdodenhof.circleimageview.CircleImageView imagenPerfil;

    public PerfilFragment() {
    }

    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_perfil,null,false);

        mascotas = new ArrayList<Mascota>();
        mascotas = ((MyApplication) getActivity().getApplication()).getUserSesion().getMascotasUsuario();

        arrayAdapter = new GridViewMascotasAdapter(getActivity(),mascotas);

        GridView flingContainer = (GridView) view.findViewById(R.id.grid);
        flingContainer.setAdapter(arrayAdapter);

        TextView nombrePerfil = (TextView) view.findViewById(R.id.nombrePerfil);
        String nombre = ((MyApplication) getActivity().getApplication()).getUserSesion().getNombreUsuario() + " " + ((MyApplication) getActivity().getApplication()).getUserSesion().getApellidoPaternoUsuario();
        nombrePerfil.setText(nombre);

        TextView ubicacionPerfil = (TextView) view.findViewById(R.id.ubicacionPerfil);
        String ubicacion = ((MyApplication) getActivity().getApplication()).getUserSesion().getCiudadUsuario() + ", " + ((MyApplication) getActivity().getApplication()).getUserSesion().getPaisUsuario();
        ubicacionPerfil.setText(ubicacion);



        FloatingActionButton agregarMascotaBoton = (FloatingActionButton ) view.findViewById(R.id.agregarMascotaBoton);
        agregarMascotaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AgregarMascotaActivity.class);
                startActivityForResult(intent, RESULTADO_INFORMACION);
            }
        });

        flingContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent i = new Intent(getActivity(),EditarMascotaActivity.class);
                i.putExtra("nombreEditarMascota", ((MyApplication) getActivity().getApplication()).getUserSesion().getMascotasUsuario().get(position).getNombreMascota());
                i.putExtra("razaEditarMascota", ((MyApplication) getActivity().getApplication()).getUserSesion().getMascotasUsuario().get(position).getRazaMascota());
                i.putExtra("edadEditarMascota", ((MyApplication) getActivity().getApplication()).getUserSesion().getMascotasUsuario().get(position).getEdadMascota());
                i.putExtra("descripcionEditarMascota", ((MyApplication) getActivity().getApplication()).getUserSesion().getMascotasUsuario().get(position).getDescripcionMascota());
                i.putExtra("posicion",position);
                startActivityForResult(i,RESULTADO_EDITAR);
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
                            arrayAdapter.notifyDataSetChanged();
                        }
                    }, 350);
                    break;
                case Activity.RESULT_CANCELED:
                    break;
            }
        }
        if (requestCode == RESULTADO_EDITAR){
            switch (resultCode) {
                case 1:
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            arrayAdapter.notifyDataSetChanged();
                        }
                    }, 350);
                    break;
                case Activity.RESULT_CANCELED:
                    break;
            }
        }
    }
}
