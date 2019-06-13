package com.example.testrappimovies;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testrappimovies.utilidades.Conexion;
import com.example.testrappimovies.utilidades.Pelicula;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final String APIKEY="2de2daf92326f20b1cf62df600ccf30e";

    private ProgressBar mBarraProgreso;
    private String popular;
    private String topRated;
    private String upComing;


    private ArrayList<Pelicula> mPopularList;
    private ArrayList<Pelicula> mTopRatedList;
    private ArrayList<Pelicula> mUpComingList;

    private GridView gridPeliculas;
    private PeliculaAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBarraProgreso= (ProgressBar) findViewById(R.id.barraProgreso);
        mBarraProgreso.setVisibility(View.INVISIBLE);

        gridPeliculas= (GridView) findViewById(R.id.gridPeliculas);

        new FetchMovies().execute();

        gridPeliculas.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> view, View view1, int position, long l) {
                Pelicula pelicula = (Pelicula) view.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, DetallesActivity.class);
                intent.putExtra("detail", pelicula);
                startActivity(intent);
            }
        });
    }



    public class FetchMovies extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            popular = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key="+APIKEY;
            topRated = "http://api.themoviedb.org/3/discover/movie?sort_by=vote_average.desc&api_key="+APIKEY;
            upComing = "http://api.themoviedb.org/3/discover/movie?sort_by=upcoming&api_key="+APIKEY;

            mPopularList = new ArrayList<>();
            mTopRatedList = new ArrayList<>();
            mUpComingList = new ArrayList<>();

            try {
                if(Conexion.networkStatus(MainActivity.this)){
                    mPopularList = Conexion.enviarPeticion(popular);
                    mTopRatedList = Conexion.enviarPeticion(topRated);
                    mUpComingList = Conexion.enviarPeticion(upComing);
                }else{
                    Toast.makeText(MainActivity.this,"No Internet Connection",Toast.LENGTH_LONG).show();
                }

                adaptador = new PeliculaAdapter(MainActivity.this,mPopularList);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        gridPeliculas.setAdapter(adaptador);
                    }
                });


            } catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            mBarraProgreso.setVisibility(View.VISIBLE);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mBarraProgreso.setVisibility(View.INVISIBLE);
            super.onPostExecute(aVoid);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_popular) {
            refreshList(mPopularList);
        }
        if (id == R.id.item_topRated) {
            refreshList(mTopRatedList);
        }
        if (id == R.id.item_upComing) {
            refreshList(mUpComingList);
        }
        return super.onOptionsItemSelected(item);
    }

    private void refreshList(ArrayList<Pelicula> list) {
        PeliculaAdapter adapter = new PeliculaAdapter(MainActivity.this, list);
        adaptador = new PeliculaAdapter(MainActivity.this,list);
        gridPeliculas.invalidateViews();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                gridPeliculas.setAdapter(adaptador);
            }
        });
    }

}
