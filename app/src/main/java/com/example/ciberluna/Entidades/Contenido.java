package com.example.ciberluna.Entidades;

import java.io.Serializable;

public class Contenido implements Serializable {
    private String titulo;
    private String descripcion;
    private int imagenid;

    public Contenido() {
    }

    public Contenido(String titulo, String descripcion, int imagenid) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenid = imagenid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
