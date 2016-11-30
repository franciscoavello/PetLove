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

        TextView ubicacionMascotaInfo = (TextView) findViewById(R.id.ubicacionInfo);
        ubicacionMascotaInfo.setText(ubicacionMascota);
        TextView descripcionMascotaInfo = (TextView) findViewById(R.id.descripcionMascotaInfo);
        descripcionMascotaInfo.setText(descripciones[0] + " \ud83d\ude01 \uD83D\uDE01 \uD83D\uDE01");

        imageSwitcherFotos = (ImageSwitcher) findViewById(R.id.imageSwitcherInfo);
        imageSwitcherFotos.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int width = size.x;
                int height = size.y;
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) height * 4 / 10));
                imageView.setImageResource(image_link);
                return imageView;
            }
        });

        Animation in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        imageSwitcherFotos.setInAnimation(in);
        imageSwitcherFotos.setOutAnimation(out);

        imageSwitcherFotos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    downX = (int) event.getX();
                    Log.i("event.getX()", " downX " + downX);
                    return true;
                }

                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    upX = (int) event.getX();
                    Log.i("event.getX()", " upX " + downX);
                    if (upX - downX > 100) {

                        //curIndex  current image index in array viewed by user
                        curIndex--;
                        if (curIndex < 0) {
                            curIndex = imagenesPrueba.length-1;
                        }

                        imageSwitcherFotos.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_left));
                        imageSwitcherFotos.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right));

                        imageSwitcherFotos.setImageResource(imagenesPrueba[curIndex]);
                    }

                    else if (downX - upX > -100) {

                        curIndex++;
                        if (curIndex > 4) {
                            curIndex = 0;
                        }

                        imageSwitcherFotos.setInAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right));
                        imageSwitcherFotos.setOutAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_left));

                        imageSwitcherFotos.setImageResource(imagenesPrueba[curIndex]);
                    }
                    return true;
                }
                return false;
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
