package com.outlook.gonzasosa.apps.memesinfo;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnMemeTouchedListener {
    public final static String clave ="indice";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView (R.layout.activity_main);

        getSupportFragmentManager ()
                .beginTransaction ()
                .replace (R.id.rootContainer, new MemesListFragment ())
                .setTransition (FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit ();
    }

    @Override
    public void onMemeTouched (int indice) {
        //Snackbar.make (findViewById (R.id.rootContainer), name, Snackbar.LENGTH_LONG).show ();
        Intent intent= new Intent(this, SeconMainActivity.class);
        intent.putExtra(clave,indice);
        startActivity(intent);
    }
}
