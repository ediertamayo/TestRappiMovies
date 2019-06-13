package com.example.testrappimovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testrappimovies.utilidades.Pelicula;
import com.squareup.picasso.Picasso;

public class DetallesActivity extends AppCompatActivity {

    TextView tvTitulo;
    TextView tvResumen;
    ImageView ivImagen;
    public static final String PELICULA_URL="https://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        tvTitulo=(TextView) findViewById(R.id.tvTitulo);
        tvResumen=(TextView) findViewById(R.id.tvResumen);
        ivImagen=(ImageView) findViewById(R.id.ivImagen);

        Intent intent = getIntent();
        Pelicula peli = (Pelicula)  intent.getSerializableExtra("detail");

        tvTitulo.setText(peli.getTitulo());
        tvResumen.setText(peli.getResumen());

        Picasso.get()
                .load(PELICULA_URL + peli.getRutaPoster())
                .into(ivImagen);
    }
}
