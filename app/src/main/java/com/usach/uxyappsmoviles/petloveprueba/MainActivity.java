package com.usach.uxyappsmoviles.petloveprueba;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.Toast;

import layout.BuscarFragment;
import layout.MatchsFragment;
import layout.PerfilFragment;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUsuario = getIntent().getIntExtra("idUser",0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(3);
        
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if(i==0){
                tabLayout.getTabAt(i).setIcon(R.drawable.ic_buscar);
            }
            else if(i==1){
                tabLayout.getTabAt(i).setIcon(R.drawable.ic_matchs);
            }
            else if(i==2){
                tabLayout.getTabAt(i).setIcon(R.drawable.ic_perfil);
            }
        }

    }

    boolean atrasPresionadoDosVeces = false;
    @Override
    public void onBackPressed(){
        if (atrasPresionadoDosVeces){
            super.onBackPressed();
            return;
        }
        this.atrasPresionadoDosVeces = true;
        Toast.makeText(this, "Pulsa nuevamente ATRÁS para salir de PetLove", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                atrasPresionadoDosVeces=false;
            }
        },2000);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    Bundle args = new Bundle();
                    args.putInt("idUser",idUsuario);
                    BuscarFragment fragmentBuscar = new BuscarFragment();
                    fragmentBuscar.setArguments(args);
                    return fragmentBuscar;
                case 1:
                    args = new Bundle();
                    args.putInt("idUser",idUsuario);
                    MatchsFragment fragmentMatch = new MatchsFragment();
                    fragmentMatch.setArguments(args);
                    return fragmentMatch;
                case 2:
                    args = new Bundle();
                    args.putInt("idUser",idUsuario);
                    PerfilFragment fragmentPerfil = new PerfilFragment();
                    fragmentPerfil.setArguments(args);
                    return fragmentPerfil;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}
