package com.outlook.gonzasosa.apps.memesinfo;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class SeconMainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.secon_activity_main);


        Bundle ident = getIntent().getExtras();
        //int valorRecibido=getIntent().getIntExtra("indice");
        Info_momos_extend fragment_info= new Info_momos_extend();

        fragment_info.setArguments(ident);

        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.SeconRootContainer, fragment_info)
                .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit ();
    }

    }

