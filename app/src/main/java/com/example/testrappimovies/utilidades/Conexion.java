package com.example.testrappimovies.utilidades;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Conexion {

    public static ArrayList<Pelicula> enviarPeticion(String url) throws IOException {
        ArrayList<Pelicula> movies = new ArrayList<Pelicula>();
        try {
            URL new_url = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) new_url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            String results = IOUtils.toString(inputStream);
            parseJson(results, movies);
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public static void parseJson(String data, ArrayList<Pelicula> list) {

        try {
            JSONObject mainObject = new JSONObject(data);

            JSONArray resArray = mainObject.getJSONArray("results");
            for (int i = 0; i < resArray.length(); i++) {
                JSONObject jsonObject = resArray.getJSONObject(i);
                Pelicula pelicula = new Pelicula(); //New Movie object
                pelicula.setId(jsonObject.getInt("id"));
                pelicula.setPuntuacion(jsonObject.getInt("vote_average"));
                pelicula.setContadorVotos(jsonObject.getInt("vote_count"));
                pelicula.setTituloOriginal(jsonObject.getString("original_title"));
                pelicula.setTitulo(jsonObject.getString("title"));
                pelicula.setPopularidad(jsonObject.getDouble("popularity"));
                pelicula.setRutaImagen(jsonObject.getString("backdrop_path"));
                pelicula.setResumen(jsonObject.getString("overview"));
                pelicula.setFechaLanzamiento(jsonObject.getString("release_date"));
                pelicula.setRutaPoster(jsonObject.getString("poster_path"));
                list.add(pelicula);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Conexion", "Error durante la conversion del JSON", e);
        }

    }

    public static Boolean networkStatus(Context context){
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            return true;
        }
        return false;
    }
}
