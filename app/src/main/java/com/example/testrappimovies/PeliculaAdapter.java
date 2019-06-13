package com.example.testrappimovies;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.testrappimovies.utilidades.Pelicula;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PeliculaAdapter extends BaseAdapter{

    private Context mContext;
    ArrayList<Pelicula> list;
    public static final String PELICULA_URL="https://image.tmdb.org/t/p/w185";

    public PeliculaAdapter(Context context, ArrayList<Pelicula> movieList) {
        this.mContext = context;
        this.list = movieList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        Pelicula pelicula = list.get(position);
        RelativeLayout relativeLayout = new RelativeLayout(mContext);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(200, 300));
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);
            relativeLayout.addView(imageView);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.get().load(PELICULA_URL + pelicula.getRutaImagen())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);

        return imageView;
    }
}
