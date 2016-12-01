package com.usach.uxyappsmoviles.petloveprueba;

import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Animatable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class InformacionMascotaActivity extends AppCompatActivity {

    Integer[] imagenesPrueba = {R.drawable.perro01,R.drawable.perro02, R.drawable.perro03, R.drawable.perro04, R.drawable.perro06};
    ImageSwitcher imageSwitcherFotos;
    int i=0;
    int image_link = 0;
    int curIndex=0;
    int downX,upX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_mascota);
        String nombreMascota = getIntent().getStringExtra("nombreMascota");
        String ubicacionMascota = getIntent().getStringExtra("ubicacionMascota");
        image_link = getIntent().getIntExtra("imagenMascota", 0);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(nombreMascota);
        actionBar.setDisplayHomeAsUpEnabled(true);


        String[] descripciones = getResources().getStringArray(R.array.descripcionesPerros);

        TextView nombreMascotaInfo = (TextView) findViewById(R.id.nombreInfoMascota);
        nombreMascotaInfo.setText(nombreMascota);
        TextView ubicacionMascotaInfo = (TextView) findViewById(R.id.ubicacionInfo);
        ubicacionMascotaInfo.setText(ubicacionMascota);
        TextView descripcionMascotaInfo = (TextView) findViewById(R.id.descripcionMascotaInfo);
        descripcionMascotaInfo.setText(descripciones[0] + " \ud83d\ude01 \uD83D\uDE01 \uD83D\uDE01");


        CarouselView carouselView;


            carouselView = (CarouselView) findViewById(R.id.carouselView);
            carouselView.setPageCount(imagenesPrueba.length);

            carouselView.setImageListener(imageListener);


        final ImageButton likeButon = (ImageButton) findViewById(R.id.infoLikeMascotaBoton);

        likeButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(e.getAction() == MotionEvent.ACTION_UP){
                    finish();
                }

                return false;
            }
        });

        final ImageButton sigButon = (ImageButton) findViewById(R.id.infoSiguienteMascotaBoton);

        sigButon.setOnTouchListener(new ImageButton.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent e) {

                if(e.getAction() == MotionEvent.ACTION_UP){
                    finish();
                }

                return false;
            }
        });

    }



    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imagenesPrueba[position]);
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
