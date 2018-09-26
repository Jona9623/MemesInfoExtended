package com.outlook.gonzasosa.apps.memesinfo;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static com.outlook.gonzasosa.apps.memesinfo.MemesListAdapter.descripcion;
import static com.outlook.gonzasosa.apps.memesinfo.MemesListAdapter.memes;
import static com.outlook.gonzasosa.apps.memesinfo.MemesListAdapter.names;
import static com.outlook.gonzasosa.apps.memesinfo.MemesListAdapter.urls;


/**
 * A simple {@link Fragment} subclass.
 */
public class Info_momos_extend extends Fragment {
    private ImageView memeimage;
    private TextView name;
    private TextView description;
    private TextView url;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_momos_extend, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        Bundle dato= getArguments();
        int index = dato.getInt(MainActivity.clave);

        memeimage= activity.findViewById(R.id.meme_image);
        name= activity.findViewById(R.id.name);
        description=activity.findViewById(R.id.description);
        url=activity.findViewById(R.id.url);

        memeimage.setImageResource(memes.getResourceId(index,index));
        name.setText(names[index]);
        description.setText(descripcion[index]);
        url.setText(urls[index]);

    }
}


