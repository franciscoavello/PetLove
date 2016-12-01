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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.usach.uxyappsmoviles.petloveprueba.AgregarMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.ContactoDatosActivity;
import com.usach.uxyappsmoviles.petloveprueba.R;

public class MatchsFragment extends Fragment {

    private ListView list;

    public MatchsFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment

        final View view = inflater.inflate(R.layout.fragment_matchs, container, false);
        list = (ListView) view.findViewById(R.id.lvMatchs);
        String[] nombres = getResources().getStringArray(R.array.nombresPerros);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getActivity(), R.layout.row_layout, R.id.label, nombres);
        list.setAdapter(adaptador);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Toast.makeText(getContext(), "Has pulsado a " + arg0.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), ContactoDatosActivity.class);
                startActivity(intent);

            }

        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
