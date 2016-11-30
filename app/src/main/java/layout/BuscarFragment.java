package layout;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.usach.uxyappsmoviles.petloveprueba.AgregarMascotaActivity;
import com.usach.uxyappsmoviles.petloveprueba.InformacionMascotaActivity;
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
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_buscar, container, false);


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

        RelativeLayout infoMascotaBoton = (RelativeLayout) view.findViewById(R.id.contenedorImagen);
        infoMascotaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InformacionMascotaActivity.class);
                TextView nombreMascotaIntent = (TextView) view.findViewById(R.id.nombreMascotaBuscar);
                TextView ubicacionMascotaIntent = (TextView) view.findViewById(R.id.descripcionMascota);
                com.github.siyamed.shapeimageview.RoundedImageView imagenMascotaIntent = (com.github.siyamed.shapeimageview.RoundedImageView) view.findViewById(R.id.imagenMascota);
                intent.putExtra("nombreMascota",nombreMascotaIntent.getText().toString());
                intent.putExtra("imagenMascota",(Integer) imagenMascotaIntent.getTag());
                intent.putExtra("ubicacionMascota", ubicacionMascotaIntent.getText());
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
