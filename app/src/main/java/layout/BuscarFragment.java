package layout;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.usach.uxyappsmoviles.petloveprueba.AgregarMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.R;

import static android.R.style.Animation;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * Use the {@link BuscarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuscarFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_buscar, container, false);

        /*
        final Button likeButon = (Button) view.findViewById(R.id.boton_like);

        likeButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                android.view.ViewGroup.LayoutParams layoutParams = likeButon.getLayoutParams();


                //Code to convert height and width in dp.
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

                if(e.getAction() == MotionEvent.ACTION_DOWN){
                    layoutParams.width = width - 20;
                    layoutParams.height = height - 20;
                    likeButon.setLayoutParams(layoutParams);
                }
                if(e.getAction() == MotionEvent.ACTION_UP){
                    layoutParams.width = width;
                    layoutParams.height = height;
                    likeButon.setLayoutParams(layoutParams);
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("Le has dado like a esta mascota, te notificaremos cuando el dueño acepte")
                            .setTitle("Compatible");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

                return false;
            }
        });
        */

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
