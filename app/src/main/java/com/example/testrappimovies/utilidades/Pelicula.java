package com.example.testrappimovies.utilidades;

import java.io.Serializable;

public class Pelicula implements Serializable { //Defino la clase Pelicula con los atributos necesarios y creo los metodos de control
    private int id;
    private  int puntuacion;
    private int contadorVotos;
    private String tituloOriginal;
    private String titulo;
    private double popularidad;
    private String rutaImagen;
    private String resumen;
    private String fechaLanzamiento;
    private String rutaPoster;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getContadorVotos() {
        return contadorVotos;
    }

    public void setContadorVotos(int contadorVotos) {
        this.contadorVotos = contadorVotos;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(double popularidad) {
        this.popularidad = popularidad;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getRutaPoster() {
        return rutaPoster;
    }

    public void setRutaPoster(String rutaPoster) {
        this.rutaPoster = rutaPoster;
    }
}
