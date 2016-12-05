package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.usach.uxyappsmoviles.petloveprueba.AgregarMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.MyApplication;
import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Mascota;
import com.usach.uxyappsmoviles.petloveprueba.modelos.Usuario;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PerfilFragment extends Fragment{

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

        TextView nombrePerfil = (TextView) view.findViewById(R.id.nombrePerfil);
        String nombre = ((MyApplication) getActivity().getApplication()).getUserSesion().getNombreUsuario() + " " + ((MyApplication) getActivity().getApplication()).getUserSesion().getApellidoPaternoUsuario();
        nombrePerfil.setText(nombre);

        TextView ubicacionPerfil = (TextView) view.findViewById(R.id.ubicacionPerfil);
        String ubicacion = ((MyApplication) getActivity().getApplication()).getUserSesion().getCiudadUsuario() + ", " + ((MyApplication) getActivity().getApplication()).getUserSesion().getPaisUsuario();
        ubicacionPerfil.setText(ubicacion);



        ImageButton agregarMascotaBoton = (ImageButton) view.findViewById(R.id.agregarMascotaBoton);
        agregarMascotaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AgregarMascotaActivity.class);
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


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
}
