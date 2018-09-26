package com.outlook.gonzasosa.apps.memesinfo;

import android.content.Context;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MemesListFragment extends Fragment {
    private OnMemeTouchedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach (context);

        if (context instanceof OnMemeTouchedListener) {
            listener = (OnMemeTouchedListener) context;
        } else {
            throw new ClassCastException ("Must implement OnMemeTouchedListener first!");
        }
    }

    @Nullable
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_memes_list, container, false);
    }

    @Override
    public void onActivityCreated (@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        String [] namesArray = activity.getResources ().getStringArray (R.array.names);
        TypedArray memesArray = activity.getResources ().obtainTypedArray (R.array.images);
        String [] DescsArray = activity.getResources ().getStringArray (R.array.descriptions);
        String [] UrlesArray = activity.getResources ().getStringArray (R.array.urls);

        RecyclerView recyclerView = activity.findViewById (R.id.recview);
        recyclerView.setLayoutManager (new GridLayoutManager (getContext (), 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setAdapter (new MemesListAdapter (getContext (), namesArray, memesArray, listener, DescsArray, UrlesArray));
   }
}

class MemesListAdapter extends RecyclerView.Adapter<MemesViewHolder> {
    public static Context context;
    public static String [] names;
    public static TypedArray memes;
    public static String [] descripcion;
    public static String [] urls;
    public static OnMemeTouchedListener listener;

    MemesListAdapter (Context context, String [] names, TypedArray memes, OnMemeTouchedListener listener, String [] descripcion, String [] urls) {
        this.context = context;
        this.names = names;
        this.memes = memes;
        this.listener = listener;
        this.urls= urls;
        this.descripcion= descripcion;
    }


    @NonNull
    @Override
    public MemesViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from (context).inflate (R.layout.recycler_list_item, viewGroup, false);
        return new MemesViewHolder (view);
    }

    @Override
    public void onBindViewHolder (@NonNull MemesViewHolder memesViewHolder, int i) {
        memesViewHolder.bind (names [i], memes.getDrawable (i));

        //memesViewHolder.itemView.setOnClickListener();
        memesViewHolder.itemView.setOnClickListener (view -> {
            if (listener != null)

                listener.onMemeTouched (i);
        });
    }

    @Override
    public int getItemCount () {
        return names.length;
    }
}

class MemesViewHolder extends RecyclerView.ViewHolder {
    private ImageView memeImage;
    private TextView name;

    MemesViewHolder (@NonNull View itemView) {
        super (itemView);

        memeImage = itemView.findViewById (R.id.meme_image);
        name = itemView.findViewById (R.id.name);
    }

    void bind (String text, Drawable drawable) {
        memeImage.setImageDrawable (drawable);
        name.setText (text);
    }

}
