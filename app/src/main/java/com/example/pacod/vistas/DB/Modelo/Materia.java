package com.example.pacod.vistas.DB.Modelo;

/**
 * Created by pacod on 18/10/2017.
 */

public class Materia {
    private int id_materia;
    private String nombre;
    private String descripcion;


    public Materia(int id_materia, String nombre, String descripcion) {
        this.id_materia = id_materia;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_materia() {
        return id_materia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
