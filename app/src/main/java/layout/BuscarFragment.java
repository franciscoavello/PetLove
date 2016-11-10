package layout;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Point;
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


        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        com.github.siyamed.shapeimageview.RoundedImageView imagenBuscar = (com.github.siyamed.shapeimageview.RoundedImageView) view.findViewById(R.id.imagenMascota);
        RelativeLayout imagenLayout = (RelativeLayout) view.findViewById(R.id.imagenLayout);
        android.view.ViewGroup.LayoutParams layoutParams = imagenBuscar.getLayoutParams();
        layoutParams.height = (int) height * 6/10;
        android.view.ViewGroup.LayoutParams imagenLayoutParams = imagenLayout.getLayoutParams();
        imagenLayoutParams.height = (int) height * 6/10;



        final ImageButton likeButon = (ImageButton) view.findViewById(R.id.likeMascotaBoton);

        likeButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                android.view.ViewGroup.LayoutParams layoutParams = likeButon.getLayoutParams();
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
/*

                if(e.getAction() == MotionEvent.ACTION_DOWN){
                    layoutParams.width = width - 20;
                    layoutParams.height = height - 20;
                    likeButon.setLayoutParams(layoutParams);
                }*/
                if(e.getAction() == MotionEvent.ACTION_UP){
                    layoutParams.width = width;
                    layoutParams.height = height;
                    likeButon.setLayoutParams(layoutParams);

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
                            nombreMasco.setText(nombres[random]);
                            lugarMasco.setText(lugares[random]);
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

                android.view.ViewGroup.LayoutParams layoutParams = siguienteBoton.getLayoutParams();
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());
/*

                if(e.getAction() == MotionEvent.ACTION_DOWN){
                    layoutParams.width = width - 20;
                    layoutParams.height = height - 20;
                    likeButon.setLayoutParams(layoutParams);
                }*/
                if(e.getAction() == MotionEvent.ACTION_UP){
                    layoutParams.width = width;
                    layoutParams.height = height;
                    siguienteBoton.setLayoutParams(layoutParams);

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
                            nombreMasco.setText(nombres[random]);
                            lugarMasco.setText(lugares[random]);
                        }
                        @Override
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });

                }

                return false;
            }
        });

        ImageButton infoMascotaBoton = (ImageButton) view.findViewById(R.id.iconoInformacion);
        infoMascotaBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), InformacionMascotaActivity.class);
                TextView nombreMascotaIntent = (TextView) view.findViewById(R.id.nombreMascotaBuscar);
                intent.putExtra("nombreMascota",nombreMascotaIntent.getText().toString());
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
