package layout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.usach.uxyappsmoviles.petloveprueba.ContactoDatosActivity;
import com.usach.uxyappsmoviles.petloveprueba.R;
import com.usach.uxyappsmoviles.petloveprueba.adapters.ElementoMatchAdapter;
import com.usach.uxyappsmoviles.petloveprueba.modelos.ElementoMatch;

import java.util.ArrayList;
import java.util.Date;

public class MatchsFragment extends Fragment {

    private ListView list;
    private ArrayList<ElementoMatch> listaMatchs;
    ElementoMatchAdapter matchsAdapter;


    public MatchsFragment() {
    }

    public void llenarMatchs(){

        Date date = new Date();
        
        ElementoMatch elementoMatch = new ElementoMatch("Kiara","Juan Pérez",R.drawable.perro02,"Santiago","francisco.avello@usach.cl","56995039843",date);
        listaMatchs.add(elementoMatch);

        elementoMatch = new ElementoMatch("Goku","Ana Valencia",R.drawable.perro06,"Coquimbo","anita.linda@usach.cl","56989094567",date);
        listaMatchs.add(elementoMatch);
    }


    public static MatchsFragment newInstance(String param1, String param2) {
        MatchsFragment fragment = new MatchsFragment();
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

        final View view = inflater.inflate(R.layout.fragment_matchs, container, false);
        listaMatchs = new ArrayList<ElementoMatch>();
        llenarMatchs();
        matchsAdapter = new ElementoMatchAdapter(getActivity(), listaMatchs);
        list = (ListView) view.findViewById(R.id.lvMatchs);
        list.setAdapter(matchsAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                ElementoMatch seleccionado;
                seleccionado = (ElementoMatch) list.getItemAtPosition(position);
                Intent intent = new Intent(getActivity(), ContactoDatosActivity.class);
                intent.putExtra("nombreMascota",seleccionado.getNombreMascota());
                intent.putExtra("imagenMascota",seleccionado.getImagenMascota());
                intent.putExtra("emailMascota",seleccionado.getEmail());
                intent.putExtra("dueñoMascota",seleccionado.getNombreDueño());
                intent.putExtra("telefonoMascota",seleccionado.getTelefono());
                intent.putExtra("ubicacionMascota",seleccionado.getUbicacion());
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
